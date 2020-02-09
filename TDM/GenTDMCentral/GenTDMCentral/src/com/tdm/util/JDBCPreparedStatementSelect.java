package com.tdm.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tdm.constant.AppConstant;


public class JDBCPreparedStatementSelect {
	
	public String selectRecordsFromTable(String userId) throws SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		String userrole = "",usermnameandrole="";

		String selectSQL = "SELECT U1.USER_ID,U2.ROLE,U1.USERNAME FROM TDM_USERS U1, TDM_USERS_AUTH U2 WHERE U1.USER_ID = U2.USER_ID AND U1.USER_ID =?";

		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, userId); 

			// execute select SQL statement
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				String userid = rs.getString("USER_ID");
				String username = rs.getString("USERNAME");
				userrole = rs.getString("ROLE");
				usermnameandrole = username+"-"+userrole;
				
				return usermnameandrole;
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		
		return usermnameandrole;

	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(AppConstant.DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(
					AppConstant.DB_CONNECTION, AppConstant.DB_USER,AppConstant.DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}


}
