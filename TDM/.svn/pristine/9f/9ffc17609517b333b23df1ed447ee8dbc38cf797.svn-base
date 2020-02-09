/**
 * Object Name : TdgExcelOpertionsUtil.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TdgExcelOperationsUtil{
	private static Logger logger = Logger.getLogger(TdgExcelOperationsUtil.class);
	private static String strClassName = " [ TdgExcelOperationsUtil ] ";
	private String fqnName;

	public TdgExcelOperationsUtil() {
	}

	public TdgExcelOperationsUtil(String strFile) {
		this.setFqnName(strFile);
	}

	public Map<String, List<String>> readFile(){
		InputStream excelFileToRead = null;
		Map<String, List<String>> mapColumnsvalues = null;
		try {
			if (!StringUtils.isEmpty(getFqnName())) {
				if (getFqnName().endsWith(".xlsx")) {
					excelFileToRead = new FileInputStream(getFqnName());
					mapColumnsvalues = readXLSXFile(excelFileToRead);
				} else if (getFqnName().endsWith(".xls")) {
					mapColumnsvalues = readXLSFile(excelFileToRead);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("File is not exist.... ", e);
		}
		return mapColumnsvalues;
	}

	public Map<String, List<String>> readXLSFile(InputStream excelFileToRead){
		String strMethodName = " [ readXLSFile() ]";
		List<Map<String, List<String>>> listIndexBased = new ArrayList<Map<String, List<String>>>();
		try {
			if (excelFileToRead != null) {
				@SuppressWarnings("resource")
				HSSFWorkbook wb = new HSSFWorkbook(excelFileToRead);
				HSSFSheet sheet = wb.getSheetAt(0);
				HSSFRow row;
				HSSFCell cell;
				for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {
					row = sheet.getRow(j);
					for (int k = 0; k < row.getLastCellNum() + 1; k++) {
						cell = row.getCell(k);
						if (null != cell) {
							if (j == 0) {
								Map<String, List<String>> mapHeadWithValues = new HashMap<String, List<String>>();
								List<String> listColumnValues = new ArrayList<String>();
								mapHeadWithValues.put(cell.getStringCellValue().toUpperCase(),
										listColumnValues);
								listIndexBased.add(mapHeadWithValues);
							} else {
								List<String> listColumnValues = listIndexBased.get(k).entrySet()
										.iterator().next().getValue();
								// listColumnValues.add(cell.getStringCellValue());
								switch (cell.getCellType()) {
								case Cell.CELL_TYPE_STRING:
									listColumnValues.add(cell.getStringCellValue());
									break;
								case Cell.CELL_TYPE_NUMERIC:
									listColumnValues.add(cell.getNumericCellValue() + "");
									break;
								case Cell.CELL_TYPE_BOOLEAN:
									listColumnValues.add(cell.getBooleanCellValue() + "");
									break;
								default:
									listColumnValues.add(cell.getStringCellValue());
									break;
								}
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (excelFileToRead != null) {
				try {
					excelFileToRead.close();
				} catch (IOException e) {
					logger.error("Error occured while close the file ", e);
				}
			}
		}
		Map<String, List<String>> mapColumnsvalues = new HashMap<String, List<String>>();
		for (Map<String, List<String>> map : listIndexBased) {
			mapColumnsvalues.putAll(map);
		}
		logger.info(strClassName + strMethodName + " return from readXLSFile method ");
		return mapColumnsvalues;
	}

	public Map<String, List<String>> readXLSXFile(InputStream excelFileToRead){
		String strMethodName = " [ readXLSXFile() ]";
		List<Map<String, List<String>>> listIndexBased = new ArrayList<Map<String, List<String>>>();
		logger.info(strClassName + strMethodName + " inside of readXLSXFile get method ");
		try {
			if (excelFileToRead != null) {
				@SuppressWarnings("resource")
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(excelFileToRead);
				XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
				XSSFRow row;
				XSSFCell cell;
				for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {
					row = sheet.getRow(j);
					for (int k = 0; k < row.getLastCellNum() + 1; k++) {
						cell = row.getCell(k);
						if (null != cell) {
							if (j == 0) {
								Map<String, List<String>> mapHeadWithValues = new HashMap<String, List<String>>();
								List<String> listColumnValues = new ArrayList<String>();
								mapHeadWithValues.put(cell.getStringCellValue().toUpperCase(),
										listColumnValues);
								listIndexBased.add(mapHeadWithValues);
							} else {
								List<String> listColumnValues = listIndexBased.get(k).entrySet()
										.iterator().next().getValue();
								// check the cell type and process accordingly
								switch (cell.getCellType()) {
								case Cell.CELL_TYPE_STRING:
									listColumnValues.add(cell.getStringCellValue());
									break;
								case Cell.CELL_TYPE_NUMERIC:
									if(HSSFDateUtil.isCellDateFormatted(cell)){
										Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
										String dateFmt = cell.getCellStyle().getDataFormatString();
									    /* strValue = new SimpleDateFormat(dateFmt).format(date); - won't work as 
									    Java fmt differs from Excel fmt. If Excel date format is mm/dd/yyyy, Java 
									    will always be 00 for date since "m" is minutes of the hour.*/

									    /*strValue = ;
									    String dateFmt = cell.getCellStyle().getDataFormatString();*/
										String strValue = new CellDateFormatter(dateFmt).format(date);
										listColumnValues.add(strValue.substring(strValue.indexOf("]")+1, strValue.indexOf(";")));
									}else{
									listColumnValues.add((cell.getNumericCellValue() + "").contains(".0") ? (cell.getNumericCellValue() + "").replaceAll("\\.0","").trim() : cell.getNumericCellValue() + "");
									}
									break;
								case Cell.CELL_TYPE_BOOLEAN:
									listColumnValues.add(cell.getBooleanCellValue() + "");
									break;
								default:
									listColumnValues.add(cell.getStringCellValue()+"");
									break;
								}
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (excelFileToRead != null) {
				try {
					excelFileToRead.close();
				} catch (IOException e) {
					logger.error("Error occured while close the file ", e);
				}
			}
		}
		Map<String, List<String>> mapColumnsvalues = new HashMap<String, List<String>>();
		for (Map<String, List<String>> map : listIndexBased) {
			mapColumnsvalues.putAll(map);
		}
		logger.info(strClassName + strMethodName + " return from readXLSXFile method ");
		return mapColumnsvalues;
	}

	public String getFqnName(){
		return fqnName;
	}

	public void setFqnName(String fqnName){
		this.fqnName = fqnName;
	}

	public Map<String, List<String>> readFile(String originalFilename, InputStream inputStream){
		Map<String, List<String>> mapColumnsvalues = null;
		if (!StringUtils.isEmpty(originalFilename)) {
			if (originalFilename.endsWith(".xlsx") || originalFilename.endsWith(".XLSX")) {
				mapColumnsvalues = readXLSXFile(inputStream);
			} else if (originalFilename.endsWith(".xls") || originalFilename.endsWith(".XLS")) {
				mapColumnsvalues = readXLSFile(inputStream);
			} else if (originalFilename.endsWith(".csv") || originalFilename.endsWith(".CSV")) {
				mapColumnsvalues = readCSVFile(inputStream);
			}
		}
		return mapColumnsvalues;
	}

	private Map<String, List<String>> readCSVFile(InputStream inputStream){
		String strMethodName = " [ readCSVFile() ]";
		Map<String, List<String>> mapColumnsvalues = new HashMap<String, List<String>>();
		List<Map<String, List<String>>> listIndexBased = new ArrayList<Map<String, List<String>>>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		try {
			br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			int iCount = 1;
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] strArrayVals = line.split(cvsSplitBy);
				for (int i = 0; i < strArrayVals.length; i++) {
					if (iCount == 1) {
						Map<String, List<String>> mapHeadWithValues = new HashMap<String, List<String>>();
						List<String> lstString = new ArrayList<String>();
						mapHeadWithValues.put(strArrayVals[i].toUpperCase(), lstString);
						listIndexBased.add(mapHeadWithValues);
					} else {
						List<String> listColumnValues = listIndexBased.get(i).entrySet().iterator()
								.next().getValue();
						listColumnValues.add(strArrayVals[i]);
					}
				}
				iCount++;
			}
			for (Map<String, List<String>> map : listIndexBased) {
				mapColumnsvalues.putAll(map);
			}
		} catch (FileNotFoundException e) {
			logger.error(strClassName + strMethodName + " file not found .... ", e);
		} catch (IOException e) {
			logger.error(strClassName + strMethodName + " IO error occured .... ", e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error(strClassName + strMethodName + " IO error occured .... ", e);
				}
			}
		}
		logger.info(strClassName + strMethodName + " return from readCSVFile method ");
		return mapColumnsvalues;
	}
}
