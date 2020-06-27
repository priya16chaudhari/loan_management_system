package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddPaymentDao {
	
	static Connection con;
	
	public static int doPayment(String id,String pay,String currDate, String time,String fineCharge){
		int result=0;
		
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("insert into account_details ("
							+ "account_id,"
							+ "date_of_payment,"
							+ "time_of_payment,"
							+ "amount,"
							+ "fine"
							+") values(?,?,?,?,?)");
			
			
			pstmt.setString(1, id);
			pstmt.setString(2, currDate);
			pstmt.setString(3, time);
			pstmt.setString(4, pay);
			pstmt.setString(5, fineCharge);
			
			System.out.println(pstmt.toString());
			
			result = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
