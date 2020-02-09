package com.datacon.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class excel
{

	@SuppressWarnings({ "unchecked", "unchecked" })
	static void main(String[] args) throws Exception {

		String filename = "C:\\Users\\Efi\\Documents\\test5.xls";

		List sheetData = new ArrayList();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filename);
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			HSSFSheet sheet = workbook.getSheetAt(0);

			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				Iterator cells = row.cellIterator();

				List data = new ArrayList();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();
					data.add(cell);
				}
				sheetData.add(data);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}

		showExcelData(sheetData);

		@SuppressWarnings("unused")
		HashMap<String, String> tableFields = new HashMap();
		for (int i = 0; i < sheetData.size(); i++) {
			List list = (List) sheetData.get(i);
			for (int j = 0; j < list.size(); j++) {
				Cell cell = (Cell) list.get(j);
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					System.out.print(cell.getNumericCellValue());
				} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					System.out.print(cell.getRichStringCellValue());
				} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
					System.out.print(cell.getBooleanCellValue());
				}
				if (j < list.size() - 1) {
					System.out.print(", ");
				}
			}
		}
	}

	private static void showExcelData(List sheetData) {

	}

	@SuppressWarnings("unchecked")
	private HashMap parseExcelData(List sheetData) {
		HashMap<String, Integer> tableFields = new HashMap();
		List list = (List) sheetData.get(0);
		for (int j = 0; j < list.size(); j++) {
			Cell cell = (Cell) list.get(j);
			tableFields.put(cell.getStringCellValue(), cell.getCellType());
		}

		return tableFields;
	}

	@SuppressWarnings({ "unchecked", "unchecked", "unchecked", "unchecked" })
	public String getCreateTable(String tablename, HashMap<String, Integer> tableFields) {
		Iterator iter = tableFields.keySet().iterator();
		String str = "";
		String[] allFields = new String[tableFields.size()];
		int i = 0;
		while (iter.hasNext()) {
			String fieldName = (String) iter.next();
			Integer fieldType = tableFields.get(fieldName);

			switch (fieldType) {
				case Cell.CELL_TYPE_NUMERIC:
					str = fieldName + "INTEGER";
					break;
				case Cell.CELL_TYPE_STRING:
					str = fieldName + "VARCHAR(255)";
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					str = fieldName + "INTEGER";
					break;
			}
			allFields[i++] = str;
		}

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kainourgia",
					"root", "root");

			Statement stmt = con.createStatement();

			try {
				System.out.println("Use the new database...");
				stmt.executeUpdate("USE kainourgia;");
			} catch (SQLException e) {
				System.out.println("SQLException: " + e.getMessage());
				System.out.println("SQLState:     " + e.getSQLState());
				System.out.println("VendorError:  " + e.getErrorCode());
			}

			try {
				String createTableStr = null;
				createTableStr = "CREATE TABLE" + createTableStr + "("
						+ StringUtils.join(allFields, ",") + ")";

				System.out.println("Create a new table in the database");
				stmt.executeUpdate(createTableStr);
			} catch (SQLException e) {
				System.out.println("SQLException: " + e.getMessage());
				System.out.println("SQLState:     " + e.getSQLState());
				System.out.println("VendorError:  " + e.getErrorCode());
			}
		} catch (Exception e) {
			System.out.println(((SQLException) e).getSQLState());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return null;
	}
}
