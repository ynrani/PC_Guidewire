package com.tdm.view;

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

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.model.DTO.POLOSearchResultDTO;

public class PoloSearchOutPutListExcelView extends AbstractExcelView
{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		logger.info(MessageConstant.TDM_EXCEL_DASHBOARD + MessageConstant.TDM_EXCEL_BUILD
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		HSSFSheet excelSheet = workbook.createSheet(MessageConstant.TDM_EXCEL_DASHBOARD_REC);
		response.setHeader("Content-Disposition", "attachment; filename=\"DataSearch_Records.xls\"");
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
		@SuppressWarnings(AppConstant.UNCHECKED)
		List<POLOSearchResultDTO> DTos = (List<POLOSearchResultDTO>) model
				.get("poloSearchDtosList");
		setExcelRows(excelSheet, DTos, style2);
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle style)
	{
		logger.info(MessageConstant.TDM_EXCEL_DASHBOARD + MessageConstant.TDM_EXCEL_SET_HEADER
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		HSSFRow excelHeader = excelSheet.createRow(2);
		int count = 0;
		excelSheet.setDisplayGridlines(false);
		excelHeader = excelSheet.createRow(2);
		excelHeader = excelSheet.createRow(4);
		excelHeader.createCell(count++).setCellValue("Insurance Policy ID");
		excelHeader.createCell(count++).setCellValue("Policy Holder ID");
		excelHeader.createCell(count++).setCellValue("First Name");
		excelHeader.createCell(count++).setCellValue("Last Surname");
		excelHeader.createCell(count++).setCellValue("Address1");
		excelHeader.createCell(count++).setCellValue("Address2");
		excelHeader.createCell(count++).setCellValue("Address3");
		excelHeader.createCell(count++).setCellValue("City");
		excelHeader.createCell(count++).setCellValue("Region");
		excelHeader.createCell(count++).setCellValue("Country ");
		excelHeader.createCell(count++).setCellValue("Postal Code");

		for (int i = 0; i < count; i++)
		{
			excelHeader.getCell(i).setCellStyle(style);
			excelSheet.autoSizeColumn(i);
		}

	}

	public HSSFColor setColor(HSSFWorkbook workbook, byte r, byte g, byte b)
	{
		logger.info(MessageConstant.TDM_EXCEL_DASHBOARD + MessageConstant.TDM_EXCEL_SET_COLOR
				+ MessageConstant.LOG_INFO_PARAMS_NO);
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
		catch (Exception ex)
		{
			logger.error(MessageConstant.TDM_EXCEL_DASHBOARD + MessageConstant.TDM_EXCEL_SET_COLOR
					+ MessageConstant.LOG_INFO_PARAMS_NO + ex);
		}
		return hssfColor;
	}

	public void setExcelRows(HSSFSheet excelSheet, List<POLOSearchResultDTO> poloDTOs,
			HSSFCellStyle style)
	{
		logger.info(MessageConstant.TDM_EXCEL_DASHBOARD + MessageConstant.TDM_EXCEL_SET_ROWS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		int record = 5;

		for (POLOSearchResultDTO poloDTo : poloDTOs)
		{
			int count = 0;
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(count++).setCellValue(poloDTo.getInsPolId());
			excelRow.createCell(count++).setCellValue(poloDTo.getPolicyHolderId());
			excelRow.createCell(count++).setCellValue(poloDTo.getFirstName());
			excelRow.createCell(count++).setCellValue(poloDTo.getLastName());
			excelRow.createCell(count++).setCellValue(poloDTo.getAddress1());
			excelRow.createCell(count++).setCellValue(poloDTo.getAddress2());
			excelRow.createCell(count++).setCellValue(poloDTo.getAddress3());
			excelRow.createCell(count++).setCellValue(poloDTo.getCity());
			excelRow.createCell(count++).setCellValue(poloDTo.getRegion());
			excelRow.createCell(count++).setCellValue(poloDTo.getCountry());
			excelRow.createCell(count++).setCellValue(poloDTo.getPostalCode());

			for (int i = 0; i < count; i++)
			{
				excelRow.getCell(i).setCellStyle(style);
				excelSheet.autoSizeColumn(i);
			}
		}
	}
}
