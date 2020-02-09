/*---------------------------------------------------------------------------------------
* Object Name: SearchSubscriberOutputListExcelView.Java
* 
 * Modification Block:
* --------------------------------------------------------------------------------------
* S.No. Name                Date      Bug Fix no. Desc
* --------------------------------------------------------------------------------------
* 1     Seshadri Chowdary   11/04/15  NA          Created
* --------------------------------------------------------------------------------------
*
* Copyright: 2015 <CapGemini>
*---------------------------------------------------------------------------------------*/


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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.tesda.constants.TDMConstants;
import com.tesda.model.DTO.TDMSubscSearchResultListDTO;

public class SearchSubscriberOutputListExcelView extends AbstractExcelView
{
	
	private static final Logger logger = LoggerFactory.getLogger(SearchSubscriberOutputListExcelView.class);

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HSSFSheet excelSheet = workbook.createSheet("Subsciber Search Reserve Record");

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
		List<TDMSubscSearchResultListDTO> searchSubscOutputList = (List<TDMSubscSearchResultListDTO>) model
				.get("tDMSubscSearchResultListDTOs");
		setExcelRows(excelSheet, searchSubscOutputList, style2);

	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle style)
	{
		HSSFRow excelHeader = excelSheet.createRow(2);

		excelSheet.setDisplayGridlines(false);
		excelHeader = excelSheet.createRow(2);
		excelHeader.createCell(0).setCellValue("User ID ");

		excelHeader = excelSheet.createRow(4);
		excelHeader.createCell(2).setCellValue("Subscriber ID");
		excelHeader.createCell(3).setCellValue("Dependent ID");
		excelHeader.createCell(4).setCellValue("SSN");
		excelHeader.createCell(5).setCellValue("First Name");
		excelHeader.createCell(6).setCellValue("Last Name");
		excelHeader.createCell(7).setCellValue("Gender");
		excelHeader.createCell(8).setCellValue("DOB");
		excelHeader.createCell(9).setCellValue("Status");
		excelHeader.createCell(10).setCellValue("Group");
		excelHeader.createCell(11).setCellValue("Effective Date");
		excelHeader.createCell(12).setCellValue("Subscriber Type");
		excelHeader.createCell(13).setCellValue("Address Line 1");
		excelHeader.createCell(14).setCellValue("Address Line 2");
		excelHeader.createCell(15).setCellValue("City");
		excelHeader.createCell(16).setCellValue("State");
		excelHeader.createCell(17).setCellValue("ZIP");
		excelHeader.createCell(18).setCellValue("Contract Code");
		excelHeader.createCell(19).setCellValue("LOB");
		excelHeader.createCell(20).setCellValue("Plan ID");
		excelHeader.createCell(21).setCellValue("Plan Name");
		excelHeader.createCell(22).setCellValue("PCP");

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
		excelHeader.getCell(15).setCellStyle(style);
		excelHeader.getCell(16).setCellStyle(style);
		excelHeader.getCell(17).setCellStyle(style);
		excelHeader.getCell(18).setCellStyle(style);
		excelHeader.getCell(19).setCellStyle(style);
		excelHeader.getCell(20).setCellStyle(style);
		excelHeader.getCell(21).setCellStyle(style);
		excelHeader.getCell(22).setCellStyle(style);

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
		excelSheet.autoSizeColumn(15);
		excelSheet.autoSizeColumn(16);
		excelSheet.autoSizeColumn(17);
		excelSheet.autoSizeColumn(18);
		excelSheet.autoSizeColumn(19);
		excelSheet.autoSizeColumn(20);
		excelSheet.autoSizeColumn(21);
		excelSheet.autoSizeColumn(22);

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
			logger.error(TDMConstants.TDMP_VIEW_ERROR_5, e);
		}

		return hssfColor;
	}

	public void setExcelRows(HSSFSheet excelSheet,
			List<TDMSubscSearchResultListDTO> searchSubscOutputList, HSSFCellStyle style)
	{
		int record = 5;

		for (TDMSubscSearchResultListDTO tdmSubscSearchResultListDTO : searchSubscOutputList)
		{

			HSSFRow excelRow = excelSheet.createRow(record++);

			excelRow.createCell(2).setCellValue(tdmSubscSearchResultListDTO.getSubscriberId());
			excelRow.createCell(3).setCellValue(tdmSubscSearchResultListDTO.getDependentId());
			excelRow.createCell(4).setCellValue(tdmSubscSearchResultListDTO.getSsn());
			excelRow.createCell(5).setCellValue(tdmSubscSearchResultListDTO.getFirstName());
			excelRow.createCell(6).setCellValue(tdmSubscSearchResultListDTO.getLastName());
			excelRow.createCell(7).setCellValue(tdmSubscSearchResultListDTO.getGender());
			excelRow.createCell(8).setCellValue(tdmSubscSearchResultListDTO.getBirthDate());
			excelRow.createCell(9).setCellValue(tdmSubscSearchResultListDTO.getSubcStatus());
			excelRow.createCell(10).setCellValue(tdmSubscSearchResultListDTO.getSubscriberNames());
			excelRow.createCell(11).setCellValue(tdmSubscSearchResultListDTO.getDateChanged());
			excelRow.createCell(12).setCellValue(tdmSubscSearchResultListDTO.getSubcType());
			excelRow.createCell(13).setCellValue(tdmSubscSearchResultListDTO.getSubcAddr1());
			excelRow.createCell(14).setCellValue(tdmSubscSearchResultListDTO.getSubcAddr2());
			excelRow.createCell(15).setCellValue(tdmSubscSearchResultListDTO.getSubcCity());
			excelRow.createCell(16).setCellValue(tdmSubscSearchResultListDTO.getSubcState());
			excelRow.createCell(17).setCellValue(tdmSubscSearchResultListDTO.getSubcZip());
			excelRow.createCell(18).setCellValue(tdmSubscSearchResultListDTO.getSubcContCode());
			excelRow.createCell(19).setCellValue(tdmSubscSearchResultListDTO.getLob());
			excelRow.createCell(20).setCellValue(tdmSubscSearchResultListDTO.getPlanId());
			excelRow.createCell(21).setCellValue(tdmSubscSearchResultListDTO.getPlanName());
			excelRow.createCell(22).setCellValue(tdmSubscSearchResultListDTO.getPcp());

			excelRow.createCell(0).setCellValue(tdmSubscSearchResultListDTO.getTestCaseId());
			excelRow.createCell(1).setCellValue(tdmSubscSearchResultListDTO.getTestCaseName());

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
			excelRow.getCell(15).setCellStyle(style);
			excelRow.getCell(16).setCellStyle(style);
			excelRow.getCell(17).setCellStyle(style);
			excelRow.getCell(18).setCellStyle(style);
			excelRow.getCell(19).setCellStyle(style);
			excelRow.getCell(20).setCellStyle(style);
			excelRow.getCell(21).setCellStyle(style);
			excelRow.getCell(22).setCellStyle(style);

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
			excelSheet.autoSizeColumn(15);
			excelSheet.autoSizeColumn(16);
			excelSheet.autoSizeColumn(17);
			excelSheet.autoSizeColumn(18);
			excelSheet.autoSizeColumn(19);
			excelSheet.autoSizeColumn(20);
			excelSheet.autoSizeColumn(21);
			excelSheet.autoSizeColumn(22);

		}
	}
}
