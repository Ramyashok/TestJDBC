package com.JDBC.StoredProcedure;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.JDBC.DBinit;

public class InsertCus {
	
public static void insert() throws SQLException{
		
		Connection conn =null;
		CallableStatement st=null;
	    Scanner sc=null;
		
		
		try {
			
			sc =new Scanner(System.in);
			int empno=0;
			String ename=null;
			String sal=null;
			
			if(sc!=null) {
				
				System.out.println("Enter employee number");
				empno = sc.nextInt();
				
				System.out.println("Enter employee name");
				ename = sc.next();

				System.out.println("Enter employee sal");
				sal = sc.next();
				
			}


			conn = DBinit.getConnection();
			if(conn!=null) {
				
				String query = "Insert into emp(empno,ename,sal) values("+empno+",'"+ename+"','"+sal+"')";
				st=conn.prepareCall(query);
				
				int result=st.executeUpdate();
				
				if(result==0) {
					System.out.println("records not inserted");
				}else {
					System.out.println(result+"recor(s) inserted");
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
	
}
		
	}
	
	public static void main(String[] args) throws SQLException {
		insert();
	}
	
	
}


