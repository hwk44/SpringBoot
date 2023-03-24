package edu.pnu.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.TestVO;

public class TestDAO {

	List<TestVO> list; // = new ArrayList();

	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;

	public TestDAO() { // 기본 생성자
		try {
			// JDBC 드라이버 로드
			Class.forName("org.h2.Driver");

//				 H2 DB 에 연결
			String url = "jdbc:h2:tcp://localhost/~/springboot";
			String id = "sa";
			String pwd = "";
			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("DB 연결 성공 (기본 생성자)");

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
	public TestVO getTest(int id) {

		String query = "SELECT * FROM TEST WHERE id=?";

		try {
			// 쿼리 실행
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setInt(1, id); // 쿼리문 첫 번째 인파라미터 값 설정
			rs = psmt.executeQuery();

			if (rs.next()) {
				return new TestVO(id, rs.getString(2), rs.getString(3), rs.getDate(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// 전체 출력
	public List<TestVO> getTestlist() {
		String query = "SELECT * FROM TEST";
		list = new ArrayList();
		try {
			
			psmt = con.prepareStatement(query); // 동적 쿼리문 준비
			rs = psmt.executeQuery();

			while(rs.next()) {
				 list.add(new TestVO(rs.getInt("id"), rs.getString("pass"), rs.getString("name"), rs.getDate("regidate")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
