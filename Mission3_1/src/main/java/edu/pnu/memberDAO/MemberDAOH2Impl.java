package edu.pnu.memberDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDAOH2Impl implements MemberInterface {

	List<MemberVO> list; // = new ArrayList();

	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;

	public MemberDAOH2Impl() { // 기본 생성자
		try {
			// JDBC 드라이버 로드
			Class.forName("org.h2.Driver");

//				 H2 DB 에 연결
			String url = "jdbc:h2:tcp://localhost/~/springboot"; // 학교 pc
//			String url = "jdbc:h2:~/springboot"; // 노트북 
			String id = "sa";
			String pwd = "";
			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("DB 연결 성공 (기본 생성자)");

		} catch (Exception e) {
			e.printStackTrace();
		}
		String query = "SELECT * FROM member";
		list = new ArrayList<MemberVO>();
		try {

			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			rs = psmt.executeQuery();

			while (rs.next()) {
				list.add(new MemberVO(rs.getInt("id"), rs.getString("pass"), rs.getString("name"),
						rs.getDate("regidate")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				((Connection) stmt).close();
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

		try {

			// 쿼리 실행
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setInt(1, id); // 쿼리문 첫 번째 인파라미터 값 설정
			rs = psmt.executeQuery();

			if (rs.next()) {
				return new MemberVO(id, rs.getString(2), rs.getString(3), rs.getDate(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// 전체 출력
	@Override
	public List<MemberVO> getMembers() {
		return list;
	}

	// put방식 update
	@Override
	public MemberVO updateMember(MemberVO member) { // 멤버 객체를 받음

		if (member.getId() == 0) return null; // 아이디 없을때
		try {
			if (member.getName() == null && member.getPass() == null) {

			} else if (member.getName() == null) {
				// 쿼리 실행
				String query = "UPDATE MEMBER SET pass=? where id=?";
				psmt = con.prepareStatement(query); // 동적 쿼리문 준비
				psmt.setString(1, member.getPass()); // 쿼리문 첫 번째 인파라미터 값 설정
				psmt.setInt(2, member.getId());
				psmt.executeUpdate();
				
			} else if (member.getPass() == null) {
				// 쿼리 실행
				String query = "UPDATE MEMBER SET name=? where id=?";
				psmt = con.prepareStatement(query); // 동적 쿼리문 준비
				psmt.setString(1, member.getName());
				psmt.setInt(2, member.getId());
				psmt.executeUpdate();
			} else { // 둘다 있을 때
				String query = "UPDATE MEMBER SET pass=?, name=? where id=?";
				psmt = con.prepareStatement(query); // 동적 쿼리문 준비
				psmt.setString(1, member.getPass()); // 쿼리문 첫 번째 인파라미터 값 설정
				psmt.setString(2, member.getName());
				psmt.setInt(3, member.getId());
				psmt.executeUpdate();
			}
			return getMember(member.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * put과 post 차이?
	 */

	// post방식 add
	@Override
	public MemberVO addMember(MemberVO member) {

		if (member.getName() != null && member.getPass() != null) {
			if(member.getId()==0) { // 입력 아이디가 없으면
				member.setId(list.get(list.size()-1).getId() +1);
			}
			try {
				String query = "INSERT INTO MEMBER(pass, name) values(?,?)";

				psmt = con.prepareStatement(query); // 동적 쿼리문 준비
				psmt.setString(1, member.getPass());
				psmt.setString(2, member.getName());
				psmt.executeUpdate();

				list.add(member);
				return member;
//				List<MemberVO> l = this.getMembers(); // 쿼리 리스트 불러오기
//				return l.get(l.size() - 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public MemberVO deleteMember(Integer id) {

		String query = "DELETE FROM member " + " WHERE id =?";
		try {
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setInt(1, id); // 쿼리문 첫 번째 인파라미터 값 설정
			psmt.executeUpdate(); // 쿼리 실행

			for(MemberVO vo : list) {
				if(vo.getId() == id) {
					list.remove(vo);
					return vo;
				}
			}
//			return list.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
