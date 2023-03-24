package edu.pnu.DAO;

import java.sql.*;

public class MemberDAO {

		public Connection con;
		public Statement stmt;
		public PreparedStatement psmt;
		public ResultSet rs; 

		public MemberDAO() { // 기본 생성자
			try {
				// JDBC 드라이버 로드
				Class.forName("com.mysql.cj.jdbc.Driver");
				
//				 H2 DB 에 연결
				String url = "jdbc:h2:tcp://localhost/~/musthave";
				String id = "sa";
				String pwd = "";

				con = DriverManager.getConnection(url,id,pwd);
				
				System.out.println("DB 연결 성공 (기본 생성자)");
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}
