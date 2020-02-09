package com.datacon.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;

/**
 * 
 * @author Seshadri Chowdary
 * 
 */
public class CSVCreateStmt
{

	private static final String TABLE_REGEX = "\\$\\{table\\}";
	private static final String KEYS_REGEX = "\\$\\{keys\\}";

	private static final String SQL_CREATE = "CREATE TABLE ${table} (${keys})";

	private char seprator;

	/**
	 * Public constructor to build CSVLoader object with Connection details.
	 * 
	 * @param seprator
	 */
	public CSVCreateStmt(char seprator)
	{
		this.seprator = seprator;
	}

	/**
	 * Parse CSV file using OpenCSV library and creates create Stmt.
	 * 
	 * @param multipartFile
	 * @param tableName
	 * @param missingColumns
	 * @throws Exception
	 */
	public String createStmt(MultipartFile multipartFile, String tableName,
			List<Integer> missingColumns) throws Exception {
		CSVReader csvReader = null;
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
		String query = SQL_CREATE.replaceFirst(TABLE_REGEX, tableName);
		query = query.replaceFirst(KEYS_REGEX, StringUtils.join(headerRow, " VARCHAR(50),"));
		StringBuffer buf = new StringBuffer(query);
		buf.replace(query.lastIndexOf(")"), query.length(), " VARCHAR2(50))");

		csvReader.close();

		return buf.toString();
	}

	public char getSeprator() {
		return seprator;
	}

	public void setSeprator(char seprator) {
		this.seprator = seprator;
	}
}
