package edu.pnu.memberDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDAO implements MemberInterface {

	public Connection con;
	public PreparedStatement psmt;
	public ResultSet rs;
	List<MemberVO> list;
	Map<String, Object> map; // = new HashMap<>();

	public MemberDAO() {

		// db 연결
		try {
			Class.forName("org.h2.Driver"); // 드라이버 로드
			String url = "jdbc:h2:tcp://localhost/~/springboot";
			String id = "sa";
			String pwd = "";

			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공 (기본 생성자)");

		} catch (Exception e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		
		try {
			String query = "SELECT * FROM member";
			list = new ArrayList<MemberVO>();
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new MemberVO(rs.getInt("id"), rs.getString("pass"), rs.getString("name"),
						rs.getDate("regidate")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DAO list 생성 실패");
		}

	}

	@Override
	public Map<String, Object> getMap() {
		return map;
	}

	// 전체 리스트 출력
	@Override
	public List<MemberVO> getMembers() {
		String query = "SELECT * FROM member";
		list = new ArrayList<MemberVO>();
		map = new HashMap<>();
		map.put("method", "get");
		map.put("regidate", new Date());
		try {
			map.put("sqlstring", query);
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new MemberVO(rs.getInt("id"), rs.getString("pass"), rs.getString("name"),
						rs.getDate("regidate")));
			}
			map.put("success", true);
			return list;
		} catch (Exception e) {
			map.put("sqlstring", e.getMessage());
			map.put("success", false);
			e.printStackTrace();
			System.out.println("DAO list 생성 실패");

			return null;
		}
	}

	// member 추가
	@Override
	public MemberVO addMember(MemberVO member) {
		if (member.getName() != null && member.getPass() != null) {
			if (member.getId() == 0) { // 입력 아이디가 없으면
				member.setId(list.get(list.size() - 1).getId() + 1); // 마지막 친구의 아이디 + 1
			}
			map = new HashMap<>();
			map.put("method", "post");
			map.put("regidate", new Date());
			try {
				String query = "INSERT INTO MEMBER(pass, name) values(?,?)";
				String querylog = "INSERT INTO MEMBER(pass, name) values(+"
						+ member.getPass() + "," +member.getName()+")";
				
				psmt = con.prepareStatement(query); // 동적 쿼리문 준비
				psmt.setString(1, member.getPass());
				psmt.setString(2, member.getName());
				psmt.executeUpdate();

				map.put("success", true);
				map.put("sqlstring", querylog);
				
				member.setRegidate(new Date());
				list.add(member);
				return member;
			} catch (Exception e) {
				map.put("sqlstring", e.getMessage());
				map.put("success", false);
				e.printStackTrace();
			}
		}
		return null;
	}

	// 자원 닫기
	@Override
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (con != null)
				con.close();
			System.out.println("JDBC 자원 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 특정 아이디만 받아 출력
	@Override
	public MemberVO getMember(int id) {
		String query = "SELECT * FROM MEMBER WHERE id=?";

		String querylog = query.replace("?", "").concat(String.valueOf(id));
		map = new HashMap<>();
		map.put("method", "get");
		map.put("regidate", new Date());
		map.put("sqlstring", querylog);
		
		map.put("success", false);
		try {
			
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			
			querylog.concat(String.valueOf(id));
			
			
			if (rs.next()) {
				map.put("sqlstring", querylog);
				map.put("success", true);
				return new MemberVO(rs.getInt("id"), rs.getString("pass"), rs.getString("name"),
						rs.getDate("regidate"));
			}
		} catch (Exception e) {
			map.put("sqlstring", e.getMessage());
			map.put("success", false);
			e.printStackTrace();
		}
		return null;

	}

	// update
	@Override
	public MemberVO updateMember(MemberVO member) { // 멤버 객체를 받음
		String querylog = "UPDATE MEMBER SET pass="+member.getPass()+
				", name =" + member.getName() + " where id=" +member.getId();
		map = new HashMap<>();
		if (member.getId() == 0) {
			map.put("method", "put");
			map.put("regidate", new Date());
			map.put("sqlstring", querylog);
			map.put("success", false);
			return null; // 아이디 없을때
		}
		try {

			map.put("method", "put");
			map.put("regidate", new Date());

			if (member.getName() == null && member.getPass() == null) { // 이름 패스 둘다 없음
				map.put("sqlstring", querylog);
				map.put("success", false);
				return null;
			} else if (member.getName() == null) { // 이름만 없음
				// 쿼리 실행
				String query = "UPDATE MEMBER SET pass=?, name=? where id=?";
				psmt = con.prepareStatement(query); // 동적 쿼리문 준비
				psmt.setString(1, member.getPass()); // 쿼리문 첫 번째 인파라미터 값 설정
				psmt.setString(2, member.getName()); // 쿼리문 첫 번째 인파라미터 값 설정
				psmt.setInt(3, member.getId());
				psmt.executeUpdate();

				map.put("sqlstring", querylog);
				map.put("success", true);
			} else if (member.getPass() == null) {// 패스만 없음
				// 쿼리 실행
				String query = "UPDATE MEMBER SET name=? where id=?";
				psmt = con.prepareStatement(query); // 동적 쿼리문 준비
				psmt.setString(1, member.getName());
				psmt.setInt(2, member.getId());
				psmt.executeUpdate();

				map.put("sqlstring", querylog);
				map.put("success", true);
			} else { // 둘다 있을 때
				String query = "UPDATE MEMBER SET pass=?, name=? where id=?";
				psmt = con.prepareStatement(query); // 동적 쿼리문 준비
				psmt.setString(1, member.getPass()); // 쿼리문 첫 번째 인파라미터 값 설정
				psmt.setString(2, member.getName());
				psmt.setInt(3, member.getId());
				psmt.executeUpdate();
				map.put("sqlstring", querylog);
				map.put("success", true);
			}
			return member;

		} catch (Exception e) {
			map.put("sqlstring", e.getMessage());
			map.put("success", false);
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public MemberVO deleteMember(Integer id) {

		map = new HashMap<>();
		map.put("method", "delete");
		map.put("regidate", new Date());
		map.put("success", true);

		String query = "DELETE FROM member " + " WHERE id =?";
		String querylog = query.replace("?", "").concat(String.valueOf(id));
		map.put("sqlstring", querylog);
		try {
			
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setInt(1, id); // 쿼리문 첫 번째 인파라미터 값 설정
			psmt.executeUpdate(); // 쿼리 실행
			
			for (MemberVO vo : list) {
				if (vo.getId() == id) {
					list.remove(vo);
					map.put("success", true);
					return vo;
				}
				return null;
			}
//			return list.get(id);
		} catch (Exception e) {
			map.put("sqlstring", e.getMessage());
			map.put("success", false);
			e.printStackTrace();
		}
		return null;
	}

}
