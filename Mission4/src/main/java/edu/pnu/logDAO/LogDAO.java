package edu.pnu.logDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Date;
import java.util.Map;


public class LogDAO implements LogInterface{

	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;

	public LogDAO() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("org.h2.Driver");

			String url = "jdbc:h2:tcp://localhost/~/springboot"; // 학교 pc
//		String url = "jdbc:h2:~/springboot"; // 노트북 
			String id = "sa";
			String pwd = "";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("LOGDAO 연결 성공 (기본 생성자)");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addLog(Map<String, Object> map) {
		
		String query = "INSERT INTO DBLOG(METHOD ,SQLSTRING ,REGIDATE ,SUCCESS )"
				+ " VALUES(?, ?, ?, ?)";
		try {
			psmt = con.prepareStatement(query); 
			psmt.setString(1, (String) map.get("method")); 
			psmt.setString(2, (String) map.get("sqlstring")); 
			psmt.setObject(3, new Date());
			psmt.setObject(4, (boolean) map.get("success")); 
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
