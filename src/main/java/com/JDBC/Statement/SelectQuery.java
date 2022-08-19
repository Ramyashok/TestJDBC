package com.JDBC.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.JDBC.DBinit;

public class SelectQuery {
	
	public static void select() throws SQLException{
		
		Connection conn =null;
		Statement st=null;
		ResultSet rs=null;
		
		
		try {
			conn = DBinit.getConnection();
			if(conn!=null) {
				st = conn.createStatement();
				String query = "select * from emp";
				
				if(st!=null) {
					rs = st.executeQuery(query);
					
					boolean isEmpty=true;
					while(rs.next()) {
						isEmpty=false;
						System.out.println(rs.getInt("empno")+ " "+rs.getString("ename"));
					}
					if(isEmpty) {
						System.out.println("records not selected");
					}else {
						System.out.println("records selected ");
					}
				}
			}
		}catch(Exception e) {
			e.getMessage();
		}finally {
			if(conn!=null) {
				conn.close();
			}
			if(st!=null) {
				st.close();

			}
			if(rs!=null) {
				rs.close();
			}
		}
	}
	
	public static void main(String[] args) throws SQLException {
		select();
	}

}
