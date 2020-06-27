package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.AccountBeans;
import com.beans.AccountDetailsBeans;

public class FetchBorrowerDao {
	
	static Connection con;
	
	public static ArrayList<AccountBeans> getBorrowerAccountDetails() {
		ArrayList<AccountBeans> list = new ArrayList<>();
		ResultSet rs;
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("Select * from account");
		
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				AccountBeans ab =new AccountBeans(rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9));
				ab.setId(rs.getInt(1));
				list.add(ab);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static ArrayList<String> getBorrowerName(String borrowerId) {
		ArrayList<String> list = new ArrayList<>();
		ResultSet rs;
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("Select * from borrower where id = ?");
			pstmt.setInt(1, Integer.parseInt(borrowerId	));
		

			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(rs.getString(2));
				list.add(rs.getString(3));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<String> getGauranteerName(String borrowerId) {
		ArrayList<String> list = new ArrayList<>();
		ResultSet rs;
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("Select * from gauranteer where borrower_id = ?");
			pstmt.setInt(1, Integer.parseInt(borrowerId	));
		

			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(rs.getString(3));
				list.add(rs.getString(4));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<AccountDetailsBeans> getBorrowerAccountDetails(String accountId) {
		ArrayList<AccountDetailsBeans> list = new ArrayList<>();
		ResultSet rs;
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("Select * from account_details where account_id = ?");
			pstmt.setString(1,accountId);
		

			rs = pstmt.executeQuery();
			while(rs.next()){
				AccountDetailsBeans adb = new AccountDetailsBeans(
						rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
				list.add(adb);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static AccountBeans getBorrowerAccountDetailsById(String accountId) {
		AccountBeans ab=null;
		ResultSet rs;
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("Select * from account where id = ?");

			pstmt.setInt(1, Integer.parseInt(accountId));

			rs = pstmt.executeQuery();
			while(rs.next()){
				 ab =new AccountBeans(rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9));
				ab.setId(rs.getInt(1));
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ab;
	}

	
	public static String getBorrowerAmount(String accountId,String date) {
		System.out.println(accountId+"  -   "+date);
		String amount="not paid";
		ResultSet rs;
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("Select amount from account_details where account_id = ? and date_of_payment=?");

			pstmt.setString(1, accountId);
			pstmt.setString(2, date);
			System.out.println(pstmt.toString());
			rs = pstmt.executeQuery();
			while(rs.next()){
				 amount = rs.getString(1);
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;
	}
	
	
	public static int getBorrowerPaidAmount(String accountId) {
		int amount=0;
		ResultSet rs;
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("Select amount from account_details where account_id = ?");

			pstmt.setString(1, accountId);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				 amount = amount + Integer.parseInt(rs.getString(1));
				
			}
			System.out.println("amount "+amount);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;
	}
	public static int getFinePaidAmount(String accountId) {
		int amount=0;
		ResultSet rs;
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("Select fine from account_details where account_id = ?");

			pstmt.setString(1, accountId);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				 amount = amount + Integer.parseInt(rs.getString(1));
				
			}
			System.out.println("fine amount "+amount);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;
	}
	
	
}
