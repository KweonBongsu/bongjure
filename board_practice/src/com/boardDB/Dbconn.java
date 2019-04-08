package com.boardDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Dbconn {
	
public static Connection dbconn;
	
	
	public static Connection getConnection() {
		
		Connection conn= null;
		try {
		String url ="jdbc:oracle:thin:@localhost:1521:orcl";
		String id ="scott";
		String pw ="kbs10605!";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection(url, id, pw);
		
		System.out.println("Database에 연결 되었습니다.");
		
		}catch(ClassNotFoundException e) {
			System.out.println("DB드라이버 로딩 실패  :" + e.toString());
		}catch(SQLException e) {
			System.out.println("DB 접속 실패 : " + e.toString());
		}catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return conn;
		
	
	
		
		
	}

		
		
	}