package com.JDBC.StoredProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.JDBC.DBinit;

public class selectEmp {
	
public static void select() throws SQLException{
		
		Connection conn =null;
		CallableStatement st=null;
		ResultSet rs=null;
		
		
		try {
			conn = DBinit.getConnection();
			
				String query = "call java_practice.InsertEmployee()";
				st = conn.prepareCall(query);
			    rs = st.executeQuery();
				System.out.println("Inserted");
					
					
				
			
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




