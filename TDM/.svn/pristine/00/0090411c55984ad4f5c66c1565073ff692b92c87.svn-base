package com.datacon.util;

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

public class ImportData
{

	public static List<Object[]> convertToListFromExcel(InputStream inp) {

		Object[] obj = null;
		List<Object[]> display = null;
		try {
			Workbook wb = new XSSFWorkbook(inp); // Declare XSSF WorkBook
			Sheet sheet = wb.getSheetAt(0); // sheet can be used as common for XSSF and HSSF
			display = new ArrayList<Object[]>();
			Iterator<Row> rows = sheet.rowIterator();
			while (rows.hasNext()) {
				Row row = rows.next();
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
								obj[cell.getColumnIndex()] = String.valueOf(Double.valueOf(
										cell.getNumericCellValue()).intValue());
							}
							break;
						default:
					}
				}
				if (display.size() < 10) {
					display.add(obj);
				} else {
					break;
				}
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