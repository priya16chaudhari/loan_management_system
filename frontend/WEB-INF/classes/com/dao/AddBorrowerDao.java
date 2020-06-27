package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.BorrowerBeans;
import com.beans.GauranterBeans;



public class AddBorrowerDao {
	
	static Connection con;

	public static int getBorrowerId() {
		int result = 0;
		ResultSet rs;
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("Select id from borrower");
		

			rs = pstmt.executeQuery();
			while(rs.next()){
				result = rs.getInt(1);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result+1;
	}

	public static int addBorrower(BorrowerBeans bb) {
		int result = 0;
		
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("insert into borrower ("
							+ "name,"
							+ "mobile,"
							+ "vehicle_number,"
							+ "address,"
							+ "created_date) values(?,?,?,?,?)");
			
			pstmt.setString(1, bb.getName());
			pstmt.setString(2, bb.getMobile());
			pstmt.setString(3, bb.getVehicleNumber());
			pstmt.setString(4, bb.getAddress());
			pstmt.setString(5, bb.getCreatedDate());

			result = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static int addGauranter(GauranterBeans gb) {
		int result = 0;
		
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("insert into gauranteer ("
							+ "borrower_id,"
							+ "name,"
							+ "phone,"
							+ "address,"
							+ "created_date) values(?,?,?,?,?)");
		
			pstmt.setString(1, gb.getId());
			pstmt.setString(2, gb.getName());
			pstmt.setString(3, gb.getMobile());
			pstmt.setString(4, gb.getAddress());
			pstmt.setString(5, gb.getCreatedDate());
			
			result = pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	public static ArrayList<String> getBorrowerIds() {
		ArrayList<String> list = new ArrayList<>();
		ResultSet rs;
		try {
			con = DbConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("Select id from borrower");
		

			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(String.valueOf(rs.getInt(1)));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(getBorrowerId());
	}

}
