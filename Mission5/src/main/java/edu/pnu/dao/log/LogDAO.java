package edu.pnu.dao.log;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class LogDAO {
	
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;

	// 생성자
	public LogDAO() {

		try {
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:tcp://localhost/~/springboot";
			String id = "sa";
			String pwd = "";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("LogDAO DB 연결");

		} catch (Exception e) {
			System.out.println("LogDAO DB 연결 실패");
		}
	}

	public void close() {
		// 자원 닫기
	}

	public void addlog(Map<String, Object> map) {
		String query = "insert into DBLOG(METHOD ,SQLSTRING ,REGIDATE ,SUCCESS) "
				+ "values(?,?,?,?)";
		try {
			psmt=con.prepareStatement(query);// 쿼리 준비
			psmt.setString(1, (String) map.get("method"));
			psmt.setString(2, (String) map.get("sqlstring"));
			psmt.setObject(3, map.get("regidate"));
			psmt.setObject(4, (boolean) map.get("success"));
			psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("addLOG 입력 실패");
		}
		
	}

}
