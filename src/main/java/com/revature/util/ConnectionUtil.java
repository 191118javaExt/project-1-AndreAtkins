package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class ConnectionUtil {
	

	public static Connection getConnection() {
	
		
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "Basketball13";
		
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			
			System.out.println("Unable to obtain connection to  thee database");
			//logger.warn("Unable to obtain connection to database", e);
		}
		System.out.println(conn);
		return conn;
			
			
		
		
		
		
		
	}	
		
		
		
		
		

}