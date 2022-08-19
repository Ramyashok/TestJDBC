package com.JDBC.PrepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.JDBC.DBinit;

public class SelectEmp {
public static void select() throws SQLException{
		
		Connection conn =null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		
		try {
			conn = DBinit.getConnection();
			if(conn!=null) {
				String query = "select * from emp";
				st = conn.prepareStatement(query);
				
				
				if(st!=null) {
					rs = st.executeQuery();
					
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

