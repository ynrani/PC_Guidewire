package com.datacon.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 @author Seshadri chowdary
 */
public class RunSqlScript
{
	/**
	 * @param args
	 *            the command line arguments
	 */

	private boolean stopOnError;
	private boolean autoCommit;
	private PrintWriter logWriter = new PrintWriter(System.out);
	private PrintWriter errorLogWriter = new PrintWriter(System.err);

	public static final String USER_DS = "java:jboss/datasources/tdmCsaaUserDS";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// String aSQLScriptFilePath = "D://Script_folder//CSAA_SCRIPT.sql";

		// String aSQLScriptFilePath =
		// "D://Users//sechowda//Chowdary//Zurich//Script//zurich_master2015-08-18 12-13-18.sql";
		String aSQLScriptFilePath = "D://Users//sechowda//Chowdary//Zurich//Script//zurich_reservation2015-08-18 12-14-56.sql";

		try {

			/*
			 * JndiTemplate jndiTemplate = new JndiTemplate(); DataSource dataSourceCsaa =
			 * (DataSource) jndiTemplate.lookup(USER_DS); Connection conCsaaUser =
			 * dataSourceCsaa.getConnection();
			 */

			// Class.forName("oracle.jdbc.OracleDriver");
			// Connection conCsaaUser = DriverManager.getConnection(
			// "jdbc:oracle:thin:@IN-PNQ-COE07:1521:xe", "csaa_user", "csaa_user");

			Class.forName("com.mysql.jdbc.Driver");
			Connection conCsaaUser = DriverManager
					.getConnection("jdbc:mysql://DIN52003703.corp.capgemini.com:3306/test",
							"testuser", "testuser");

			// Create Connection

			// Initialize object for ScripRunner

			// Give the input file to Reader
			Reader reader = new BufferedReader(new FileReader(aSQLScriptFilePath));

			// Exctute script
			RunSqlScript ps = new RunSqlScript();

			ps.runScript(conCsaaUser, reader);

		} catch (Exception e) {

			System.err.println("Failed to Execute " + aSQLScriptFilePath + " The error is "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	private void runScript(Connection conn, Reader reader) throws IOException, SQLException {
		StringBuffer command = null;
		try {
			LineNumberReader lineReader = new LineNumberReader(reader);
			String line = null;
			while ((line = lineReader.readLine()) != null) {
				if (command == null) {
					command = new StringBuffer();
				}
				String trimmedLine = line.trim();
				if (trimmedLine.startsWith("--"))
					println(trimmedLine);
				else if ((trimmedLine.length() >= 1) && (!trimmedLine.startsWith("//"))) {
					if ((trimmedLine.length() >= 1) && (!trimmedLine.startsWith("--"))) {
						if (trimmedLine.endsWith(";")) {
							command.append(line.substring(0, line.lastIndexOf(";")));
							command.append(" ");
							Statement statement = conn.createStatement();

							println(command);

							boolean hasResults = false;
							if (this.stopOnError)
								hasResults = statement.execute(command.toString());
							else {
								try {
									statement.execute(command.toString());
								} catch (SQLException e) {
									e.fillInStackTrace();
									printlnError("Error executing: " + command);
									printlnError(e);
								}
							}

							if ((this.autoCommit) && (!conn.getAutoCommit())) {
								conn.commit();
							}

							ResultSet rs = statement.getResultSet();
							if ((hasResults) && (rs != null)) {
								ResultSetMetaData md = rs.getMetaData();
								int cols = md.getColumnCount();
								for (int i = 0; i < cols; i++) {
									String name = md.getColumnName(i);
									print(name + "\t");
								}
								println("");
								while (rs.next()) {
									for (int i = 0; i < cols; i++) {
										String value = rs.getString(i);
										print(value + "\t");
									}
									println("");
								}
							}

							command = null;
							try {
								statement.close();
							} catch (Exception e) {
							}
							Thread.yield();
						} else {
							command.append(line);
							command.append(" ");
						}
					}
				}
			}
			if (!this.autoCommit)
				conn.commit();
		} catch (SQLException e) {
			e.fillInStackTrace();
			printlnError("Error executing: " + command);
			printlnError(e);
			throw e;
		} catch (IOException e) {
			e.fillInStackTrace();
			printlnError("Error executing: " + command);
			printlnError(e);
			throw e;
		} finally {
			conn.rollback();
			flush();
			flush();
		}

	}

	private void print(Object o) {
		if (this.logWriter != null)
			System.out.print(o);
	}

	private void println(Object o) {
		if (this.logWriter != null)
			this.logWriter.println(o);
	}

	private void printlnError(Object o) {
		if (this.errorLogWriter != null)
			this.errorLogWriter.println(o);
	}

	private void flush() {
		if (this.logWriter != null) {
			this.logWriter.flush();
		}
		if (this.errorLogWriter != null)
			this.errorLogWriter.flush();
	}

}