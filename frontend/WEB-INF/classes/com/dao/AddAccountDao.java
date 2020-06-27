package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.beans.AccountBeans;

public class AddAccountDao {
	
	static Connection con;
	
	public static int addAccount(AccountBeans ab) {
		int result = 0;
		
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("insert into account ("
							+ "borrower_id,"
							+ "loan_amount,"
							+ "instant_deduction,"
							+ "emi,"
							+ "duration,"
							+ "start_date,"
							+ "end_date,"
							+ "status) values(?,?,?,?,?,?,?,?)");
			
			
			pstmt.setString(1, ab.getBorrowerId());
			pstmt.setString(2, ab.getLoanAmount());
			pstmt.setString(3, ab.getInstantDeduction());
			pstmt.setString(4, ab.getEmi());
			pstmt.setString(5, ab.getDuration());
			pstmt.setString(6, ab.getStartDate());
			pstmt.setString(7, ab.getEndDate());
			pstmt.setString(8, ab.getStatus());
			
			System.out.println(pstmt.toString());
			
			result = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
