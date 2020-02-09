package com.tesda.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.tesda.model.DTO.TdmPolicyAutoSearchResultDTO;

public class SearchPolicyAutoListExcelView extends AbstractExcelView
{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HSSFSheet excelSheet = workbook.createSheet("Policy Auto Search Reserve Record");

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

		// cell.setCellStyle(style);
		setExcelHeader(excelSheet, style);

		@SuppressWarnings("unchecked")
		List<TdmPolicyAutoSearchResultDTO> searchPolicyAutoOutputList = (List<TdmPolicyAutoSearchResultDTO>) model
				.get("tdmPolicyAutoSearchResultDTOs");
		setExcelRows(excelSheet, searchPolicyAutoOutputList, style2);

	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle style)
	{
		HSSFRow excelHeader = excelSheet.createRow(2);

		excelSheet.setDisplayGridlines(false);

		excelHeader = excelSheet.createRow(2);
		excelHeader.createCell(0).setCellValue("User ID ");

		excelHeader = excelSheet.createRow(4);
		excelHeader.createCell(2).setCellValue("Policy Number");
		excelHeader.createCell(3).setCellValue("Policy Stage");
		excelHeader.createCell(4).setCellValue("Policy State");
		excelHeader.createCell(5).setCellValue("Policy Term");
		excelHeader.createCell(6).setCellValue("Effective date");
		excelHeader.createCell(7).setCellValue("Expiration date");
		excelHeader.createCell(8).setCellValue("Policy Coverage");
		excelHeader.createCell(9).setCellValue("No of Drivers");
		excelHeader.createCell(10).setCellValue("No of Vehicles");
		excelHeader.createCell(11).setCellValue("No of Violations");
		excelHeader.createCell(12).setCellValue("Available Payments");
		excelHeader.createCell(13).setCellValue("Available Document");
		excelHeader.createCell(14).setCellValue("Search Scenario");

		/*
		 * 
		 * excelHeader.createCell(14).setCellValue("EFT");
		 * excelHeader.createCell(15).setCellValue("Gender");
		 * excelHeader.createCell(16).setCellValue("Term Date");
		 * excelHeader.createCell(17).setCellValue("Address Line 1");
		 * excelHeader.createCell(18).setCellValue("Address Line 2");
		 * excelHeader.createCell(19).setCellValue("City");
		 * excelHeader.createCell(20).setCellValue("State");s
		 */

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
		excelHeader.getCell(11).setCellStyle(style);
		excelHeader.getCell(12).setCellStyle(style);
		excelHeader.getCell(13).setCellStyle(style);
		excelHeader.getCell(14).setCellStyle(style);
		/*
		 * 
		 * excelHeader.getCell(14).setCellStyle(style);
		 * excelHeader.getCell(15).setCellStyle(style);
		 * excelHeader.getCell(16).setCellStyle(style);
		 * excelHeader.getCell(17).setCellStyle(style);
		 * excelHeader.getCell(18).setCellStyle(style);
		 * excelHeader.getCell(19).setCellStyle(style);
		 * excelHeader.getCell(20).setCellStyle(style);
		 */

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
		excelSheet.autoSizeColumn(11);
		excelSheet.autoSizeColumn(12);
		excelSheet.autoSizeColumn(13);
		excelSheet.autoSizeColumn(14);
		/*
		 * 
		 * excelSheet.autoSizeColumn(14);
		 * excelSheet.autoSizeColumn(15);
		 * excelSheet.autoSizeColumn(16);
		 * excelSheet.autoSizeColumn(17);
		 * excelSheet.autoSizeColumn(18);
		 * excelSheet.autoSizeColumn(20);
		 */

	}

	public HSSFColor setColor(HSSFWorkbook workbook, byte r, byte g, byte b)
	{
		HSSFPalette palette = workbook.getCustomPalette();
		HSSFColor hssfColor = null;
		try
		{
			hssfColor = palette.findColor(r, g, b);
			if (hssfColor == null)
			{
				palette.setColorAtIndex(HSSFColor.LAVENDER.index, r, g, b);
				hssfColor = palette.getColor(HSSFColor.LAVENDER.index);
			}
		} catch (Exception e)
		{
			logger.error(e);
		}

		return hssfColor;
	}

	public void setExcelRows(HSSFSheet excelSheet,
			List<TdmPolicyAutoSearchResultDTO> searchPolicyAutoOutputList, HSSFCellStyle style)
	{
		int record = 5;

		for (TdmPolicyAutoSearchResultDTO tdmPolicyAutoSearchResultDTO : searchPolicyAutoOutputList)
		{
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(2).setCellValue(tdmPolicyAutoSearchResultDTO.getPolicynumber());
			excelRow.createCell(3).setCellValue(tdmPolicyAutoSearchResultDTO.getPolicyStage());
			excelRow.createCell(4).setCellValue(tdmPolicyAutoSearchResultDTO.getPolicyState());
			excelRow.createCell(5).setCellValue(tdmPolicyAutoSearchResultDTO.getPolicyTerm());
			excelRow.createCell(6).setCellValue(tdmPolicyAutoSearchResultDTO.getPolicyEffectDt());
			excelRow.createCell(7).setCellValue(tdmPolicyAutoSearchResultDTO.getPolicyExpDt());

			excelRow.createCell(8).setCellValue(tdmPolicyAutoSearchResultDTO.getPolicyCovge());
			excelRow.createCell(9).setCellValue(tdmPolicyAutoSearchResultDTO.getNoOfDrivers());
			excelRow.createCell(10).setCellValue(tdmPolicyAutoSearchResultDTO.getNoOfVehi());
			excelRow.createCell(11).setCellValue(tdmPolicyAutoSearchResultDTO.getNoOfViola());
			excelRow.createCell(12).setCellValue(tdmPolicyAutoSearchResultDTO.getAssoPayReq());
			excelRow.createCell(13).setCellValue(tdmPolicyAutoSearchResultDTO.getAssoDocReq());
			excelRow.createCell(14).setCellValue(tdmPolicyAutoSearchResultDTO.getScenario());

			/*
			 * 
			 * excelRow.createCell(14).setCellValue(tdmPolicyAutoSearchResultDTO.getProvFET());
			 * excelRow.createCell(15).setCellValue(tdmPolicyAutoSearchResultDTO.getProvGender())
			 * ;
			 * excelRow.createCell(16).setCellValue(
			 * tdmPolicyAutoSearchResultDTO.getTerminationDate());
			 * excelRow.createCell(17).setCellValue(tdmPolicyAutoSearchResultDTO.getProvAddr1());
			 * excelRow.createCell(18).setCellValue(tdmPolicyAutoSearchResultDTO.getProvAddr2());
			 * excelRow.createCell(19).setCellValue(tdmPolicyAutoSearchResultDTO.getProvCity());
			 * excelRow.createCell(20).setCellValue(tdmPolicyAutoSearchResultDTO.getProvState());
			 */

			excelRow.createCell(0).setCellValue(tdmPolicyAutoSearchResultDTO.getTestCaseId());
			excelRow.createCell(1).setCellValue(tdmPolicyAutoSearchResultDTO.getTestCaseName());

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
			excelRow.getCell(11).setCellStyle(style);
			excelRow.getCell(12).setCellStyle(style);
			excelRow.getCell(13).setCellStyle(style);
			excelRow.getCell(14).setCellStyle(style);
			/*
			 * 
			 * excelRow.getCell(14).setCellStyle(style);
			 * excelRow.getCell(15).setCellStyle(style);
			 * excelRow.getCell(16).setCellStyle(style);
			 * excelRow.getCell(17).setCellStyle(style);
			 * excelRow.getCell(18).setCellStyle(style);
			 * excelRow.getCell(19).setCellStyle(style);
			 * excelRow.getCell(20).setCellStyle(style);
			 */

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
			excelSheet.autoSizeColumn(11);
			excelSheet.autoSizeColumn(12);
			excelSheet.autoSizeColumn(13);
			excelSheet.autoSizeColumn(14);
			/*
			 * 
			 * excelSheet.autoSizeColumn(14);
			 * excelSheet.autoSizeColumn(15);
			 * excelSheet.autoSizeColumn(16);
			 * excelSheet.autoSizeColumn(17);
			 * excelSheet.autoSizeColumn(18);
			 * excelSheet.autoSizeColumn(19);
			 * excelSheet.autoSizeColumn(20);
			 */

		}
	}
}
