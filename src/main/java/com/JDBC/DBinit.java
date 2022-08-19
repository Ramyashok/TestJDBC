package com.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBinit {
	
	public static Connection getConnection() throws ClassNotFoundException,SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_practice","root","Ramya@89");
		return conn;
		
	}

}
