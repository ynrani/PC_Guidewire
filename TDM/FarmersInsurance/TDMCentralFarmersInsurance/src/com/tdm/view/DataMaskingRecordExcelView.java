/*---------------------------------------------------------------------------------------
 * Object Name: DataMaskingRecordExcelView.Java
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

import com.tdm.constant.MessageConstant;
import com.tdm.model.DTO.TdgDataMaskingDTO;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
public class DataMaskingRecordExcelView extends AbstractExcelView
{
	private static Logger logger = Logger.getLogger(DataMaskingDashBoardExcel.class);

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info(MessageConstant.TDM_EXCEL_DMASK + MessageConstant.TDM_EXCEL_BUILD
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		HSSFSheet excelSheet = workbook.createSheet(MessageConstant.TDM_EXCEL_DMASK_REC);
		HSSFCellStyle style1 = workbook.createCellStyle();
		style1.setFillForegroundColor(HSSFColor.LIME.index);
		style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style1.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style1.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style1.setWrapText(true);
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.AUTOMATIC.index);
		style1.setFont(font);
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setWrapText(true);
		HSSFCellStyle style3 = workbook.createCellStyle();
		style3.setWrapText(true);
		HSSFFont font2 = workbook.createFont();
		font2.setColor(HSSFColor.AUTOMATIC.index);
		font2.setBold(true);
		style3.setFont(font2);
		TdgDataMaskingDTO tdgDataMaskingDTO = (TdgDataMaskingDTO) model
				.get("tdgDataMaskingRecordDTO");
		setExcelRows(excelSheet, tdgDataMaskingDTO, style1, style2, style3);
	}

	public HSSFColor setColor(HSSFWorkbook workbook, byte r, byte g, byte b) {
		logger.info(MessageConstant.TDM_EXCEL_DMASK + MessageConstant.TDM_EXCEL_SET_COLOR
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
			logger.error(MessageConstant.TDM_EXCEL_DMASK + MessageConstant.TDM_EXCEL_SET_COLOR
					+ MessageConstant.LOG_INFO_PARAMS_NO + ex);
		}
		return hssfColor;
	}

	public void setExcelRows(HSSFSheet excelSheet, TdgDataMaskingDTO tdgDataMaskingDTO,
			HSSFCellStyle style1, HSSFCellStyle style2, HSSFCellStyle style3) {
		logger.info(MessageConstant.TDM_EXCEL_DMASK + MessageConstant.TDM_EXCEL_SET_ROWS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		HSSFRow excelRow = null;
		excelSheet.setDisplayGridlines(false);
		excelRow = excelSheet.createRow(2);
		excelRow.createCell(0).setCellValue("Data Masking Request Details");
		excelRow.getCell(0).setCellStyle(style3);

		excelRow = excelSheet.createRow(4);
		excelRow.createCell(0).setCellValue("User Id");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getUserId());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(5);
		excelRow.createCell(0).setCellValue("User Name");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getUserName());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(6);
		excelRow.createCell(0).setCellValue("Email Id");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getEmailId());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(7);
		excelRow.createCell(0).setCellValue("Phone No");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPhoneNo());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(8);
		excelRow.createCell(0).setCellValue("Department");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getDeptName());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(9);
		excelRow.createCell(0).setCellValue("Needed By");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getNeededBy());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(10);
		excelRow.createCell(0).setCellValue("Project Name");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getProjName());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(11);
		excelRow.createCell(0).setCellValue("Project Phase");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getProjPhase());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(12);
		excelRow.createCell(0).setCellValue("Environment");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getEnvType());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(13);
		excelRow.createCell(0)
				.setCellValue(
						"Please provide a brief overview of the application including high-level functionality description?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q1());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(14);
		excelRow.createCell(0).setCellValue(
				"What are the data storage mechanisms used by the application?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q2());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(15);
		excelRow.createCell(0).setCellValue(
				"Please notify if any other data storage mechanisms used by the applications?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q3());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(16);
		excelRow.createCell(0)
				.setCellValue(
						"Does the application receive any direct feeds from upstream systems to non-production systems?"
								+ "\n"
								+ "Are these feeds coming from production or non-production upstream environments?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q4());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(17);
		excelRow.createCell(0)
				.setCellValue(
						"Does the application handle any non-English language? If yes, does the application has defined set"
								+ "\n"
								+ "which help to differentiate between English & non English characters? ");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q5());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(18);
		excelRow.createCell(0)
				.setCellValue(
						"Are there defined upstream / downstream applications data flow and dependency chart available, Please specify?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q6());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(19);
		excelRow.createCell(0).setCellValue(
				"Does application have dependency on any other application or third party source?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q7());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(20);
		excelRow.createCell(0)
				.setCellValue(
						"Do you anticipate any data store addition/upgrade/de-commission in the application in next 6 months?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q8());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(21);
		excelRow.createCell(0).setCellValue(
				"Do you have the existing PII / MNPI elements identified in your application?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q9());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(22);
		excelRow.createCell(0)
				.setCellValue(
						"Is there any masking already applied by the application team in the non-production environments?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q10());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(23);
		excelRow.createCell(0)
				.setCellValue(
						"Test Data Management team requires application team to validate masked data and application"
								+ "\n"
								+ "functionality once the solution is unit tested. Who would perform these validations from the application team?"
								+ "\n"
								+ "Do you have dedicated QA team who would execute this test? How many testing iterations are required?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q11());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(24);
		excelRow.createCell(0).setCellValue(
				"Does the application?s non production environment contain sensitive elements?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage2Q12());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(25);
		excelRow.createCell(0)
				.setCellValue(
						"Does the application handle any non-English language? If yes, does the application"
								+ "\n"
								+ "has defined set which help to differentiate between English & non English characters?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage3Q1());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(26);
		excelRow.createCell(0).setCellValue("Please specify number of tables in each database(s)?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage3Q2());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(27);
		excelRow.createCell(0).setCellValue(
				"Please specify count of databases, unique flat file used by the application?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage3Q3());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(28);
		excelRow.createCell(0).setCellValue(
				"How often do you have schema changes to your data storage systems?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage3Q4());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(29);
		excelRow.createCell(0).setCellValue(
				"What is the approximate volume of data to be handled for masking?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage3Q5());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(30);
		excelRow.createCell(0)
				.setCellValue(
						"Do you want place masking for applications or using dedicated staging environments?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage3Q6());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(31);
		excelRow.createCell(0).setCellValue(
				"How many non-production environments need to be masked for your application?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage3Q7());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(32);
		excelRow.createCell(0).setCellValue("How would data be available for masking development?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage3Q8());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(33);
		excelRow.createCell(0)
				.setCellValue(
						"Who will take over data masking code developed by developer team for ongoing support?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage3Q9());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);
		excelRow = excelSheet.createRow(34);
		excelRow.createCell(0).setCellValue(
				"What are the required SLA's / SLO's for completing the data masking activity?");
		excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getPage3Q10());
		excelRow.getCell(0).setCellStyle(style1);
		excelRow.getCell(1).setCellStyle(style2);

		excelSheet.autoSizeColumn(0);
		excelSheet.autoSizeColumn(1);

	}
}
