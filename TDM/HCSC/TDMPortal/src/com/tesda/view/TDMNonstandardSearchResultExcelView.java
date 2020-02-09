/*---------------------------------------------------------------------------------------
 * Object Name: TDMNonstandardSearchResultExcelView.Java
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
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.tesda.model.DTO.TdmNonStandardSearchResultListDTO;

public class TDMNonstandardSearchResultExcelView extends AbstractExcelView
{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HSSFSheet excelSheet = workbook.createSheet("Nonstandard Search Records");
		response.setHeader("Content-Disposition",
				"attachment; filename=\"Nonstandard_Search_Records.xls\"");
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
		List<TdmNonStandardSearchResultListDTO> tdmNonStandSearchDTO = (List<TdmNonStandardSearchResultListDTO>) model
				.get("tdmNonStandSearchDTOList");
		setExcelRows(excelSheet, tdmNonStandSearchDTO, style2);
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle style)
	{
		HSSFRow excelHeader = excelSheet.createRow(2);

		excelSheet.setDisplayGridlines(false);

		excelHeader = excelSheet.createRow(2);
		excelHeader = excelSheet.createRow(4);
		excelHeader.createCell(0).setCellValue("Member ID");
		excelHeader.createCell(1).setCellValue("Member Type");
		excelHeader.createCell(2).setCellValue("First Name");
		excelHeader.createCell(3).setCellValue("Last Name");
		excelHeader.createCell(4).setCellValue("Date Of Birth");
		excelHeader.createCell(5).setCellValue("Home Zip Code");
		excelHeader.createCell(6).setCellValue("A/C Number");
		excelHeader.createCell(7).setCellValue("A/C Name");
		excelHeader.createCell(8).setCellValue("EOB Suppressed?");
		excelHeader.createCell(9).setCellValue("Blend Government");
		excelHeader.createCell(10).setCellValue("Blend Group");
		excelHeader.createCell(11).setCellValue("Blend Retail");
		excelHeader.createCell(12).setCellValue("Coverage");
		excelHeader.createCell(13).setCellValue("Existing Claim");

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
			List<TdmNonStandardSearchResultListDTO> tdmNonStandSearchDTO, HSSFCellStyle style)
	{
		int record = 5;
		if (null != tdmNonStandSearchDTO)
		{
			for (TdmNonStandardSearchResultListDTO tdgDataMaskingDTO : tdmNonStandSearchDTO)
			{
				HSSFRow excelRow = excelSheet.createRow(record++);
				excelRow.createCell(0).setCellValue(tdgDataMaskingDTO.getMemId());
				excelRow.createCell(1).setCellValue(tdgDataMaskingDTO.getMemType());
				excelRow.createCell(2).setCellValue(tdgDataMaskingDTO.getFirstName());
				excelRow.createCell(3).setCellValue(tdgDataMaskingDTO.getLastName());
				excelRow.createCell(4).setCellValue(tdgDataMaskingDTO.getDob());
				excelRow.createCell(5).setCellValue(tdgDataMaskingDTO.getHomeZipCode());
				excelRow.createCell(6).setCellValue(tdgDataMaskingDTO.getAcNum());
				excelRow.createCell(7).setCellValue(tdgDataMaskingDTO.getAcName());
				excelRow.createCell(8).setCellValue(tdgDataMaskingDTO.getEobSuppressed());
				excelRow.createCell(9).setCellValue(tdgDataMaskingDTO.getBlendGov());
				excelRow.createCell(10).setCellValue(tdgDataMaskingDTO.getBlendGroup());
				excelRow.createCell(11).setCellValue(tdgDataMaskingDTO.getBlendRetail());
				excelRow.createCell(12).setCellValue(tdgDataMaskingDTO.getCoverageCode());
				excelRow.createCell(13).setCellValue(tdgDataMaskingDTO.getExtClaim());

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
			}
		}
	}
}
