/*---------------------------------------------------------------------------------------
 * Object Name: TDMNonstandardSearchResultExcelView.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Sridhar Gudipati   19/06/15  NA          Created
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
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.tesda.model.DTO.TDMNonStandReservationDTO;

public class TDMNonStandardSearchReservationsExcel extends AbstractExcelView
{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HSSFSheet excelSheet = workbook.createSheet("TDM Nonstandard Reservation Records");
		response.setHeader("Content-Disposition",
				"attachment; filename=\"Nonstandard_Reservation_Records.xls\"");
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.LIME.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setWrapText(true);

		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.DARK_TEAL.index);
		style.setFont(font);

		HSSFCellStyle style2 = workbook.createCellStyle();

		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setWrapText(true);
		setExcelHeader(excelSheet, style);

		@SuppressWarnings("unchecked")
		List<TDMNonStandReservationDTO> tdmNonStandSearchDTO = (List<TDMNonStandReservationDTO>) model
				.get("tdmNonStandResrvationDTOList");
		setExcelRows(excelSheet, tdmNonStandSearchDTO, style2);
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle style)
	{
		HSSFRow excelHeader = excelSheet.createRow(2);

		excelSheet.setDisplayGridlines(false);

		excelHeader = excelSheet.createRow(2);
		excelHeader = excelSheet.createRow(4);
		excelHeader.createCell(0).setCellValue("Subcriber ID");
		excelHeader.createCell(1).setCellValue("Member Type");
		excelHeader.createCell(2).setCellValue("First Name");
		excelHeader.createCell(3).setCellValue("Last Name");
		excelHeader.createCell(4).setCellValue("Date Of Birth");
		excelHeader.createCell(5).setCellValue("Home Zip Code");
		excelHeader.createCell(6).setCellValue("Reserve Date");
		excelHeader.createCell(7).setCellValue("Testcase ID");
		excelHeader.createCell(8).setCellValue("Testcase Name");
		excelHeader.createCell(9).setCellValue("Project ID");
		excelHeader.createCell(10).setCellValue("Coverage");
		excelHeader.createCell(11).setCellValue("Account Number");
		excelHeader.createCell(12).setCellValue("Account Name");
		excelHeader.createCell(13).setCellValue("Suppressed EOB?");
		excelHeader.createCell(14).setCellValue("Blended GOV");
		excelHeader.createCell(15).setCellValue("Blended Cat");
		excelHeader.createCell(16).setCellValue("Existing Claimtype");
		excelHeader.createCell(17).setCellValue("Group Number");

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
		}
		catch (Exception e)
		{
			logger.error(e);
		}
		return hssfColor;
	}

	public void setExcelRows(HSSFSheet excelSheet,
			List<TDMNonStandReservationDTO> tdmNonStandSearchDTO, HSSFCellStyle style)
	{
		int record = 5;
		if (null != tdmNonStandSearchDTO)
		{
			for (TDMNonStandReservationDTO tdgDataMaskingDTO : tdmNonStandSearchDTO)
			{
				HSSFRow excelRow = excelSheet.createRow(record++);
				excelRow.createCell(0).setCellValue(tdgDataMaskingDTO.getSubscrId());
				excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getMembrType());
				excelRow.createCell(2).setCellValue(tdgDataMaskingDTO.getFirstName());
				excelRow.createCell(3).setCellValue(tdgDataMaskingDTO.getLastName());
				excelRow.createCell(4).setCellValue(tdgDataMaskingDTO.getDob());
				excelRow.createCell(5).setCellValue(tdgDataMaskingDTO.getHomeZipCode());
				excelRow.createCell(6).setCellValue(tdgDataMaskingDTO.getReserveDate());
				excelRow.createCell(7).setCellValue(tdgDataMaskingDTO.getTestCaseId());
				excelRow.createCell(8).setCellValue(tdgDataMaskingDTO.getTestCaseName());
				excelRow.createCell(9).setCellValue(tdgDataMaskingDTO.getProjectId());
				excelRow.createCell(10).setCellValue(tdgDataMaskingDTO.getCoverage());
				excelRow.createCell(11).setCellValue(tdgDataMaskingDTO.getAccountNum());
				excelRow.createCell(12).setCellValue(tdgDataMaskingDTO.getAccountName());
				excelRow.createCell(13).setCellValue(tdgDataMaskingDTO.getSuppressEOBInd());
				excelRow.createCell(14).setCellValue(tdgDataMaskingDTO.getBlendedGov());
				excelRow.createCell(15).setCellValue(tdgDataMaskingDTO.getBlendedCat());
				excelRow.createCell(16).setCellValue(tdgDataMaskingDTO.getExtClaimType());
				excelRow.createCell(17).setCellValue(tdgDataMaskingDTO.getGroupNum());

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
			}
		}
	}
}
