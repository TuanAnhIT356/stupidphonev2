package com.dhl.blahblah.test;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJDBC {

	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/stupidphone?userSSL=false";
		String user = "dhl140295";
		String password = "newdawn1402";

		try{
			@SuppressWarnings("unused")
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Success");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
