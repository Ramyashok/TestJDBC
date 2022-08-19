package com.JDBC.PrepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;

import com.JDBC.DBinit;

public class multipleRecordInsertion {
	
 public static void insert() throws SQLException{
		
		Connection conn =null;
		PreparedStatement pstmt=null;
	    Scanner sc=null;
		
		
		try {
			
			sc =new Scanner(System.in);
			int records=0;
			int empno=0;
			String ename=null;
			int sal=0;
			int result=0;
			
			if(sc!=null) {
				
				System.out.println("Enter no.of.records");
				records = sc.nextInt();
			}


			conn = DBinit.getConnection();
			if(conn!=null) {
				String query = "Insert into java_practice.emp(empno,ename,sal) values(?,?,?)";
				
				pstmt = conn.prepareStatement(query);
				
				
				if(sc!=null && pstmt!=null) {
					
					for(int i=0;i<records;i++) {
						
						System.out.println("Enter hte record "+(i+1)+ " values:");
						
						System.out.println("Enter employee number");
						empno = sc.nextInt();
						
						System.out.println("Enter employee name");
						ename = sc.next();

						System.out.println("Enter employee sal");
						sal = sc.nextInt();
						
						 pstmt.setInt(1, empno);
						 pstmt.setString(2, ename);
						 pstmt.setInt(3, sal);
						
						//result=pstmt.executeUpdate();
						
						 pstmt.addBatch();
						if(result==0) {
							System.out.println("records not inserted");
						}else {
							System.out.println(result+" record(s) inserted");
						}
						
					}
					
					pstmt.executeBatch();
				}
				
		
					
	}

}catch(Exception e) {
	e.getMessage();
}finally {
	if(conn!=null) {
		conn.close();
	}
	if(pstmt!=null) {
		pstmt.close();

	}
	
}
}
 
 public static void main(String[] args) throws SQLException{
	insert();
}
}