package com.datacon.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String url = "jdbc:sqlserver://IN-PNQ-COE08\\SQLEXPRESS:50987;integratedSecurity=true";
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url);// here
			// put
			// the
			// new
			// simple
			// url.

			if (null != conn) {
				System.out.println("Success");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}