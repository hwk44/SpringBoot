package edu.pnu.dao.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository
public class MemberDAO {

	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	List<MemberVO> list = new ArrayList<>();
	Map<String, Object> map;

	public MemberDAO() throws ClassNotFoundException, SQLException { // 기본생성자

		try {
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:tcp://localhost/~/springboot";
			String id = "sa";
			String pwd = "";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결");

		} catch (Exception e) {
			System.out.println("DB 연결 실패");
		}
	}

	public MemberVO getMember(int id) {

		map = new HashMap<>();
		map.put("method", "get");
		map.put("regidate", new Date());
		try {

			String query = "select * from member where id=?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) { // 결과 있으면
				map.put("success", true);
				map.put("sqlstring", query.replace("?", "").concat(String.valueOf(rs.getInt("id"))));
				return new MemberVO(rs.getInt("id"), rs.getString("pass"), rs.getString("name"),
						rs.getDate("regidate"));
			} else { // 결과 없으면 0 찍힘
				map.put("sqlstring", query.replace("?", "").concat(String.valueOf(id)));
				map.put("success", true);
			}
		} catch (Exception e) {
			System.out.println("getMember 호출 실패");
			map.put("sqlstring", e.getMessage());
			map.put("success", false);
		}

		return null;
	}

	// map 호출
	public Map<String, Object> getMap() {
		return map;
	}

	public List<MemberVO> getMembers() {
		String query = "select * from member";

		list = new ArrayList<>();
		map = new HashMap<>();
		map.put("method", "get");
		map.put("regidate", new Date());
		map.put("sqlstring", query);
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new MemberVO(rs.getInt("id"), rs.getString("pass"), rs.getString("name"),
						rs.getDate("regidate")));
			}
			map.put("success", true);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("sqlstring", e.getMessage());
			map.put("success", false);
		}
		return null;
	}

	// add member
	public MemberVO addMember(MemberVO member) {
		map = new HashMap<>();
		map.put("method", "post");
		map.put("regidate", new Date());
		
		if (member.getId() == 0) {
			try {
				String query = "insert into member(pass, name) values(?,?)";
				
				if (member.getName() != null && member.getPass() != null) { // 둘다 있을때
					psmt = con.prepareStatement(query);
					psmt.setString(1, member.getPass());
					psmt.setString(2, member.getName());
					map.put("sqlstring", query);
					map.put("success", true);
					psmt.executeUpdate();
					
					return new MemberVO(member.getId(), member.getPass(), member.getName(), member.getRegidate());
				} 
			} catch (Exception e) {
				// TODO: handle exception
				map.put("sqlstring", e.getMessage());
				map.put("success", false);
				
			}

		}
		return null;
	}

	public MemberVO updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	public MemberVO deleteMember(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
