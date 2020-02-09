/*---------------------------------------------------------------------------------------
 * Object Name: SearchProviderOutputListExcelView.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          12/06/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/
package com.tdm.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.model.DTO.TdmClaimSearchResultDTO;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
public class SearchClaimSearchRecordOutputListExcel extends AbstractExcelView
{
	private static Logger logger = Logger.getLogger(SearchClaimSearchRecordOutputListExcel.class);

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info(MessageConstant.TDM_EXCEL_POLICY + MessageConstant.TDM_EXCEL_BUILD
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		HSSFSheet excelSheet = workbook.createSheet(MessageConstant.TDM_EXCEL_POLICY_REC);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.LIME.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.DARK_TEAL.index);
		style.setFont(font);
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		setExcelHeader(excelSheet, style);
		@SuppressWarnings(AppConstant.UNCHECKED)
		List<TdmClaimSearchResultDTO> searchProviderOutputList = (List<TdmClaimSearchResultDTO>) model
				.get(MessageConstant.TDM_CLAIM_RESULT_EXPO_DTOS);
		setExcelRows(excelSheet, searchProviderOutputList, style2);
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle style) {
		logger.info(MessageConstant.TDM_EXCEL_POLICY + MessageConstant.TDM_EXCEL_SET_HEADER
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		HSSFRow excelHeader = excelSheet.createRow(2);
		excelSheet.setDisplayGridlines(false);
		excelHeader = excelSheet.createRow(2);
		excelHeader.createCell(0).setCellValue("User ID ");
		excelHeader = excelSheet.createRow(4);
		excelHeader.createCell(2).setCellValue("Claim Number");
		excelHeader.createCell(3).setCellValue("Policy Number");
		excelHeader.createCell(4).setCellValue("Insured Person");
		excelHeader.createCell(5).setCellValue("Claim Status");
		excelHeader.createCell(6).setCellValue("Source System");
		excelHeader.createCell(7).setCellValue("Loss Date");
		excelHeader.createCell(8).setCellValue("Amount Total Paid");
		excelHeader.createCell(9).setCellValue("Amount Net Incurred");
		excelHeader.createCell(10).setCellValue("LOB");

		excelHeader.createCell(0).setCellValue("Test Case Id");
		excelHeader.createCell(1).setCellValue("Test Case Name");
		excelHeader.getCell(0).setCellStyle(style);
		excelHeader.getCell(1).setCellStyle(style);
		excelHeader.getCell(2).setCellStyle(style);
		excelHeader.getCell(3).setCellStyle(style);
		excelHeader.getCell(4).setCellStyle(style);
		excelHeader.getCell(5).setCellStyle(style);
		excelHeader.getCell(6).setCellStyle(style);
		excelHeader.getCell(7).setCellStyle(style);
		excelHeader.getCell(8).setCellStyle(style);
		excelHeader.getCell(9).setCellStyle(style);
		excelHeader.getCell(10).setCellStyle(style);

		excelSheet.autoSizeColumn(0);
		excelSheet.autoSizeColumn(1);
		excelSheet.autoSizeColumn(2);
		excelSheet.autoSizeColumn(3);
		excelSheet.autoSizeColumn(4);
		excelSheet.autoSizeColumn(5);
		excelSheet.autoSizeColumn(6);
		excelSheet.autoSizeColumn(7);
		excelSheet.autoSizeColumn(8);
		excelSheet.autoSizeColumn(9);
		excelSheet.autoSizeColumn(10);
	}

	public HSSFColor setColor(HSSFWorkbook workbook, byte r, byte g, byte b) {
		logger.info(MessageConstant.TDM_EXCEL_POLICY + MessageConstant.TDM_EXCEL_SET_COLOR
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		HSSFPalette palette = workbook.getCustomPalette();
		HSSFColor hssfColor = null;
		try {
			hssfColor = palette.findColor(r, g, b);
			if (hssfColor == null) {
				palette.setColorAtIndex(HSSFColor.LAVENDER.index, r, g, b);
				hssfColor = palette.getColor(HSSFColor.LAVENDER.index);
			}
		} catch (Exception ex) {
			logger.error(MessageConstant.TDM_EXCEL_POLICY + MessageConstant.TDM_EXCEL_SET_COLOR
					+ MessageConstant.LOG_INFO_PARAMS_NO + ex);
		}
		return hssfColor;
	}

	public void setExcelRows(HSSFSheet excelSheet,
			List<TdmClaimSearchResultDTO> searchProviderOutputList, HSSFCellStyle style) {
		logger.info(MessageConstant.TDM_EXCEL_POLICY + MessageConstant.TDM_EXCEL_SET_ROWS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		int record = 5;
		for (TdmClaimSearchResultDTO tdmClaimSearchResultDTO : searchProviderOutputList) {
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(2).setCellValue(tdmClaimSearchResultDTO.getClaimNo());
			excelRow.createCell(3).setCellValue(tdmClaimSearchResultDTO.getPolicyNo());
			excelRow.createCell(4).setCellValue(tdmClaimSearchResultDTO.getPrimInsuPerson());
			excelRow.createCell(5).setCellValue(tdmClaimSearchResultDTO.getClaimStats());
			excelRow.createCell(6).setCellValue(tdmClaimSearchResultDTO.getSourceSystem());
			excelRow.createCell(7).setCellValue(tdmClaimSearchResultDTO.getLossDate());
			excelRow.createCell(8).setCellValue(tdmClaimSearchResultDTO.getAmtTotPaid());
			excelRow.createCell(9).setCellValue(tdmClaimSearchResultDTO.getAmtNetInc());
			excelRow.createCell(10).setCellValue(tdmClaimSearchResultDTO.getLob());

			excelRow.createCell(0).setCellValue(tdmClaimSearchResultDTO.getTestCaseId());
			excelRow.createCell(1).setCellValue(tdmClaimSearchResultDTO.getTestCaseName());
			excelRow.getCell(0).setCellStyle(style);
			excelRow.getCell(1).setCellStyle(style);
			excelRow.getCell(2).setCellStyle(style);
			excelRow.getCell(3).setCellStyle(style);
			excelRow.getCell(4).setCellStyle(style);
			excelRow.getCell(5).setCellStyle(style);
			excelRow.getCell(6).setCellStyle(style);
			excelRow.getCell(7).setCellStyle(style);
			excelRow.getCell(8).setCellStyle(style);
			excelRow.getCell(9).setCellStyle(style);
			excelRow.getCell(10).setCellStyle(style);

			excelSheet.autoSizeColumn(0);
			excelSheet.autoSizeColumn(1);
			excelSheet.autoSizeColumn(2);
			excelSheet.autoSizeColumn(3);
			excelSheet.autoSizeColumn(4);
			excelSheet.autoSizeColumn(5);
			excelSheet.autoSizeColumn(6);
			excelSheet.autoSizeColumn(7);
			excelSheet.autoSizeColumn(8);
			excelSheet.autoSizeColumn(9);
			excelSheet.autoSizeColumn(10);

		}
	}
}
