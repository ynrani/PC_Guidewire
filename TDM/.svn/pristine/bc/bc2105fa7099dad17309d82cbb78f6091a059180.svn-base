package com.datacon.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestImportData
{
	public static void main(String[] args) throws Exception {

		convertToListFromExcel();

	}

	public static List<Object[]> convertToListFromExcel() {

		String fname = "D:\\Users\\sechowda\\Chowdary\\DataCon\\Script\\Reserv.xlsx";
		Object[] obj = null;
		List<Object[]> display = null;
		try {
			InputStream inp = new FileInputStream(fname);
			Workbook wb = new XSSFWorkbook(inp); // Declare XSSF WorkBook
			Sheet sheet = wb.getSheetAt(0); // sheet can be used as common for XSSF and HSSF

			display = new ArrayList<Object[]>();

			Iterator<Row> rows = sheet.rowIterator();
			if (!rows.hasNext()) {
				inp.close();
				wb.close();
				throw new FileNotFoundException("No columns defined in given XLS(X) file."
						+ "Please check the XLS(X) file format.");
			}

			while (rows.hasNext()) {
				Row row = rows.next();
				System.out.println("row#= " + row.getRowNum() + "");

				Iterator<?> cells = row.cellIterator();
				obj = new Object[row.getLastCellNum()];
				while (cells.hasNext()) {
					Cell cell = (Cell) cells.next();

					switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							obj[cell.getColumnIndex()] = cell.getRichStringCellValue().getString();
							break;
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								obj[cell.getColumnIndex()] = cell.getDateCellValue().toString();
							} else {
								obj[cell.getColumnIndex()] = String.valueOf(cell
										.getNumericCellValue());
							}
							break;
						default:
					}
				}
				display.add(obj);
				System.out.println("Size " + display.size());
				System.out.println("Size " + display.get(0));
			}

			inp.close();
			wb.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return display;
	}
}