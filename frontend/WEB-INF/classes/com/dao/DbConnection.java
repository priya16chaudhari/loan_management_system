package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {


	public static Connection connect = null;
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					//"jdbc:mysql://localhost:3306/loan", "root", "root");
					"jdbc:mysql://aa1g8ed99c0uvem.cyl36xqayirc.ap-south-1.rds.amazonaws.com:3306/loan", "admin", "admin1234");
			//System.out.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return connect;	
	}

	
}
