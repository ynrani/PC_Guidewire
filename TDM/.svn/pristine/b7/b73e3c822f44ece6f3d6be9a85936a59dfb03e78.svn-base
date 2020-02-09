package com.tesda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataDumpUtils
{
	public DataDumpUtils()
	{
	}

	public static void main(String[] args) throws Exception {
		String dbUrl1 = "jdbc:oracle:thin:@DIN55000955.corp.capgemini.com:1521:xe";
		String dbUrl2 = "jdbc:oracle:thin:@IN-PNQ-COE07:1521:xe";

		String dbUrlFL = "jdbc:oracle:thin:@IN-PNQ-COE07:1521:xe";
		Connection con2 = null;
		Connection con1 = null;
		Connection conFL = null;
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement psIns = null;
		PreparedStatement psSel = null;
		PreparedStatement psDel = null;
		PreparedStatement pstFast = null;
		int fetchSize = 500;

		try {
			Class.forName("oracle.jdbc.OracleDriver");

			con1 = DriverManager.getConnection(dbUrl1, "dtmask", "dtmask");
			con2 = DriverManager.getConnection(dbUrl2, "csaa_user", "csaa_user");

			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					"classpath:/META-INF/spring-config.xml");
			DataSource datasource = (DataSource) applicationContext.getBean("tdmCsaaUserDS");
			// DataSource datasource2 = (DataSource) applicationContext.getBean("tdmDB2DS");
			connection = datasource.getConnection();

			psSel = connection
					.prepareStatement("SELECT POLICYNUMBER, LOB, POLICYSTATUSCD, POLICYFORMCD, TIMEDPOLICYSTATUSCD, TXTYPE, CONTRACTTERMTYPECD, PRODUCTCD, RISKSTATECD,   POLICYDETAIL_ID, CURRENTREVISIONIND FROM POLICY_SUMMARY_STG ");
			// psDel = con2.prepareStatement("DELETE FROM POLICY_SUMMARY_STG");

			psIns = connection
					.prepareStatement("INSERT INTO POLICY_SUMMARY_STG(POLICYNUMBER, LOB, POLICYSTATUSCD, POLICYFORMCD, TIMEDPOLICYSTATUSCD, TXTYPE, CONTRACTTERMTYPECD, PRODUCTCD, RISKSTATECD,  POLICYDETAIL_ID, CURRENTREVISIONIND) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?)");

			// rs = psDel.executeQuery();

			rs = psSel.executeQuery();
			rs.setFetchSize(fetchSize);

			System.out.println("  With Setting Fetch Size value ->" + fetchSize);

			System.out.println(System.currentTimeMillis());
			long t1 = System.currentTimeMillis();
			int cnt = 0;
			while (rs.next()) {
				cnt++;
				psIns.setString(1, rs.getString(1));
				psIns.setString(2, rs.getString(2));
				psIns.setString(3, rs.getString(3));
				psIns.setString(4, rs.getString(4));
				psIns.setString(5, rs.getString(5));
				psIns.setString(6, rs.getString(6));
				psIns.setString(7, rs.getString(7));
				psIns.setString(8, rs.getString(8));
				psIns.setString(9, rs.getString(9));
				psIns.setString(10, rs.getString(10));
				psIns.setString(11, rs.getString(11));

				psIns.addBatch();
				if (cnt % 1000 == 0) {
					psIns.executeBatch();
					cnt = 0;
				}
			}

			if (cnt <= 1000) {
				psIns.executeBatch();
			}
			System.out.println("Time to iterate ResultSet -> " + (System.currentTimeMillis() - t1));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}

			if (con1 != null) {
				con1.close();
			}

			if (con2 != null) {
				con2.close();
			}

			if (psIns != null) {
				psIns.close();
			}

			if (psSel != null) {
				psSel.close();
			}
		}
	}

	public static Connection doInjectRecords() {
		Connection connection = null;
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					"spring-config.xml");
			DataSource datasource = (DataSource) applicationContext.getBean("tdmCsaaUserDS");
			// DataSource datasource2 = (DataSource) applicationContext.getBean("tdmDB2DS");
			connection = datasource.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
