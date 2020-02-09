package com.datacon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class StroreDB2Date
{
	public static void main(String[] argv) {

		try {
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Please check the Classpath to include DB2 Driver location");
			return;
		}

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection("jdbc:db2:sales");

			Scanner sc = new Scanner(System.in);
			System.out
					.println("Enter ItemCode, Medicine Name, Packed on (dd/mm/yyyy) , Expiry Date (dd/mm/yyyy) , Quantity , Category Code one by one");
			String itemCode = sc.next();
			String medName = sc.next();
			String pkdOn = sc.next();
			String expDate = sc.next();
			int qty = sc.nextInt();
			String catCode = sc.next();

			Date today = new Date();
			java.util.Date _today = today;
			Timestamp createdon = new Timestamp(_today.getTime());
			SimpleDateFormat in = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
			String _expDate = "";
			String _pkdOn = "";
			try {
				Date date = in.parse(expDate);
				Date date1 = in.parse(pkdOn);
				_expDate = out.format(date);
				_pkdOn = out.format(date1);
			} catch (Exception e) {
				System.out.println("Exception is :" + e);
			}

			String todayDate = "";
			try {
				todayDate = out.format(_today);
			} catch (Exception e) {
				System.out.println("Exception is :" + e);
			}

			String strQueryInsert = "Insert into MED_MASTER (MED_CODE, MED_NAME, STOCK, EXPIRY_DATE, STOCK_UPDATE, CREATED_ON, MODIFIED_ON, CAT_CODE,PACKED_ON) values(?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(strQueryInsert);
			pstmt.setString(1, itemCode);
			pstmt.setString(2, medName);
			pstmt.setInt(3, qty);
			pstmt.setString(4, _expDate);
			pstmt.setDate(5, new java.sql.Date(_today.getTime())); // OR
																	// java.sql.Date.valueOf(todayDate));
			pstmt.setTimestamp(6, createdon);
			pstmt.setTimestamp(7, createdon);
			pstmt.setString(8, catCode);
			pstmt.setDate(9, java.sql.Date.valueOf(_pkdOn));
			int success = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error Storing data");
		}
	}
}
