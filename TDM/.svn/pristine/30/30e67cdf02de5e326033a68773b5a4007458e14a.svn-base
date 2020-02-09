package com.datacon.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;

/**
 * 
 * @author Seshadri Chowdary
 * 
 */
public class CSVLoader
{

	private static final String SQL_INSERT = "INSERT INTO ${table}(${keys}) VALUES(${values})";
	private static final String TABLE_REGEX = "\\$\\{table\\}";
	private static final String KEYS_REGEX = "\\$\\{keys\\}";
	private static final String VALUES_REGEX = "\\$\\{values\\}";

	private JdbcTemplate template;
	private char seprator;

	/**
	 * Public constructor to build CSVLoader object with Connection details. The connection is
	 * closed on success or failure.
	 * 
	 * @param connection
	 */
	public CSVLoader(JdbcTemplate template, char seprator)
	{
		this.template = template;
		// Set default separator
		this.seprator = seprator;
	}

	/**
	 * Parse CSV file using OpenCSV library and load in given database table.
	 * 
	 * @param csvFile
	 *            Input CSV file
	 * @param tableName
	 *            Database table name to import data
	 * @param truncateBeforeLoad
	 *            Truncate the table before inserting new records.
	 * @param missingColumns
	 * @throws Exception
	 */
	public void loadCSV(MultipartFile multipartFile, String tableName, boolean truncateBeforeLoad,
			List<Integer> missingColumns) throws Exception {

		CSVReader csvReader = null;
		if (null == this.template) {
			throw new Exception("Not a valid connection.");
		}
		try {

			csvReader = new CSVReader(new BufferedReader(new InputStreamReader(
					multipartFile.getInputStream(), "UTF-8")), this.seprator);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occured while executing file. " + e.getMessage());
		}

		String[] headerRow = csvReader.readNext();

		// removing header
		if (null != missingColumns) {
			for (Integer inter : missingColumns) {
				headerRow = (String[]) ArrayUtils.remove(headerRow, inter);
			}
		}

		if (null == headerRow) {
			csvReader.close();
			throw new FileNotFoundException("No columns defined in given CSV file."
					+ "Please check the CSV file format.");

		}

		String questionmarks = StringUtils.repeat("?,", headerRow.length);
		questionmarks = (String) questionmarks.subSequence(0, questionmarks.length() - 1);

		String query = SQL_INSERT.replaceFirst(TABLE_REGEX, tableName);
		query = query.replaceFirst(KEYS_REGEX, StringUtils.join(headerRow, ","));
		query = query.replaceFirst(VALUES_REGEX, questionmarks);

		System.out.println("Query: " + query);

		String[] nextLine;
		Connection con = null;
		PreparedStatement ps = null;
		DataSource ds = null;
		try {
			ds = this.template.getDataSource();
			con = ds.getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);

			if (truncateBeforeLoad) {
				// delete data from table before loading csv
				con.createStatement().execute("DELETE FROM " + tableName);
			}

			final int batchSize = 1000;
			int count = 0;
			Date date = null;
			while ((nextLine = csvReader.readNext()) != null) {

				if (null != nextLine) {

					// removing data
					if (null != missingColumns) {
						for (Integer inter : missingColumns) {
							nextLine = (String[]) ArrayUtils.remove(nextLine, inter);
						}
					}

					int index = 1;
					for (String string : nextLine) {
						date = DateUtil.convertToDate(string);
						if (null != date) {
							ps.setDate(index++, new java.sql.Date(date.getTime()));
						} else {
							ps.setString(index++, string);
						}
					}
					ps.addBatch();
				}
				if (++count % batchSize == 0) {
					ps.executeBatch();
				}
			}
			ps.executeBatch(); // insert remaining records
			con.commit();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw new Exception("Error occured while loading data from file to database."
					+ e.getMessage());
		} finally {
			if (null != ps)
				ps.close();
			if (null != con)
				con.close();

			csvReader.close();
		}
	}

	public char getSeprator() {
		return seprator;
	}

	public void setSeprator(char seprator) {
		this.seprator = seprator;
	}

}
