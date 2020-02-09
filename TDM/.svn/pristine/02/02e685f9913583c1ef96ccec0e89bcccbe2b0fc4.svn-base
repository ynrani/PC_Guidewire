package com.tesda.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static void doGenerateExcelXLSXFile(List<Object[]> lstInputParams,
			String strFileName, int iTotalColumns) {
		// Blank workbook
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Generated_Data");

		//for (int irownum = 0; irownum < lstInputParams.size(); irownum++) {
		
		//change for excel prefix as per IDFC requirement values
		Object[] objHeaders = lstInputParams.get(0);
		for (int irownum = 0; irownum < lstInputParams.size(); irownum++) {
			Row row = sheet.createRow(irownum-1);
			Object[] objArr = lstInputParams.get(irownum);
			for (int iColumnLength = 0; iColumnLength < iTotalColumns; iColumnLength++) {
				Cell cell = row.createCell(iColumnLength);
				//if (objArr[iColumnLength] instanceof String)
					cell.setCellValue((String)objHeaders[iColumnLength]+"_"+(String) objArr[iColumnLength]);
				/*else if (objArr[iColumnLength] instanceof Integer)
					cell.setCellValue((Integer) objArr[iColumnLength]);
				else if (objArr[iColumnLength] instanceof Date)
					cell.setCellValue((Date) objArr[iColumnLength]);*/
			}
		}
		FileOutputStream out = null;
		try {
			// Write the workbook in file system
		/*	String home = System.getProperty("user.home");
			File file = new File(home+"/Downloads");
			if(file.exists()){*/
				out = new FileOutputStream(new File(strFileName));
			/*}else{
				if(file.mkdir()){
					out = new FileOutputStream(new File(home+"/Downloads/"+strFileName));
				}
			}*/
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				/*if (workbook != null)
					workbook.close();*/

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	public static void doGenerateExcelXLSFile(List<Object[]> lstInputParams,
			String strFileName, int iTotalColumns,Map<Integer,String> mapPositions,List<String> lstRequiredColumnsSequence,boolean isAddedFlag) {
		HSSFWorkbook workbook = null;
		HSSFSheet sheet = null;
		FileOutputStream out = null;
		int iTotalRecordExist = 0;
		try {
			if (!isAddedFlag) {
				// Blank workbook
				workbook = new HSSFWorkbook();
				// Create a blank sheet
				sheet = workbook.createSheet("Generated_Data");
			} else {
				workbook = new HSSFWorkbook(new FileInputStream(new File(strFileName)));
			    sheet = workbook.getSheet("Generated_Data");
			    iTotalRecordExist= sheet.getLastRowNum()+1;
			}
		if(lstRequiredColumnsSequence != null && !lstRequiredColumnsSequence.isEmpty()){
			//changed to list for sequence order
			List listSequence = Arrays.asList(lstInputParams.get(0));
					//change for excel prefix as per IDFC requirement values
			for (int irownum = 1; irownum < lstInputParams.size(); irownum++) {
				HSSFRow row = sheet.createRow(irownum-1);
				//Object[] objArr = lstInputParams.get(irownum);
				List objArr = Arrays.asList(lstInputParams.get(irownum));
				for (int iColumnLength = 0; iColumnLength < iTotalColumns; iColumnLength++) {
					HSSFCell cell = row.createCell(iColumnLength);
					//follwoing code is added for sequence arrangement
					if(listSequence.contains(lstRequiredColumnsSequence.get(iColumnLength))){
						cell.setCellValue((String)lstRequiredColumnsSequence.get(iColumnLength)+"_"+(String) objArr.get(listSequence.indexOf(lstRequiredColumnsSequence.get(iColumnLength))));
					}
					
				}
			}
			} else {
				// Object[] objHeaders = lstInputParams.get(0);
				// for (int irownum = 0; irownum < lstInputParams.size(); irownum++) {
				// change for excel prefix as per IDFC requirement values
				// for (int irownum = 1; irownum < lstInputParams.size(); irownum++) {
				for (int irownum = 0; irownum < lstInputParams.size(); irownum++) {
					HSSFRow row = sheet.createRow(iTotalRecordExist+irownum);
					Object[] objArr = lstInputParams.get(irownum);
					for (int iColumnLength = 0; iColumnLength < iTotalColumns; iColumnLength++) {
						HSSFCell cell = row.createCell(iColumnLength);
						// cell.setCellValue((String)objHeaders[iColumnLength]+"_"+(String)
						// objArr[iColumnLength]);
						cell.setCellValue((String) objArr[iColumnLength]);
					}
				}
			}
		
		
			// Write the workbook in file system
			//String home = System.getProperty("user.home");
			//File file = new File(home + "/Downloads");
			//File file = new File(strFileName);
			//if (file.exists()) {
				out = new FileOutputStream(new File(strFileName));
			/*} else {
				if (file.mkdir()) {
					out = new FileOutputStream(new File(home+"/Downloads/"+strFileName));
				}
			}*/
			workbook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (workbook != null)
					workbook.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
