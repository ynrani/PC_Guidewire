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
import com.tdm.model.DTO.TDMBankReservationDTO;

public class MyReservationDashBoardBankExcelView extends AbstractExcelView
{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		logger.info(MessageConstant.TDM_EXCEL_DASHBOARD + MessageConstant.TDM_EXCEL_BUILD
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		HSSFSheet excelSheet = workbook.createSheet(MessageConstant.TDM_EXCEL_DASHBOARD_REC);
		response.setHeader("Content-Disposition",
				"attachment; filename=\"MyReservasion_Records.xls\"");
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
		List<TDMBankReservationDTO> reservationDTos = (List<TDMBankReservationDTO>) model
				.get("reservationDtosList");
		setExcelRows(excelSheet, reservationDTos, style2);
	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle style)
	{
		logger.info(MessageConstant.TDM_EXCEL_DASHBOARD + MessageConstant.TDM_EXCEL_SET_HEADER
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		HSSFRow excelHeader = excelSheet.createRow(2);
		excelSheet.setDisplayGridlines(false);
		excelHeader = excelSheet.createRow(2);
		excelHeader = excelSheet.createRow(4);
		excelHeader.createCell(0).setCellValue("Account Number");
		excelHeader.createCell(1).setCellValue("Customer ID");
		excelHeader.createCell(2).setCellValue("First Name");
		excelHeader.createCell(3).setCellValue("Last Surname");
		excelHeader.createCell(4).setCellValue("Branch");
		excelHeader.createCell(5).setCellValue("Account Status");
		excelHeader.createCell(6).setCellValue("Accoutn Balance");
		excelHeader.createCell(7).setCellValue("Testcase ID");
		excelHeader.createCell(8).setCellValue("Testcase Name");
		excelHeader.createCell(9).setCellValue("City");
		excelHeader.createCell(10).setCellValue("Country");
		excelHeader.createCell(11).setCellValue("Zip Code ");
		excelHeader.createCell(12).setCellValue("Reserve Date");
		excelHeader.createCell(13).setCellValue("Creditcard Number");
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

	public void setExcelRows(HSSFSheet excelSheet, List<TDMBankReservationDTO> accountDTOs,
			HSSFCellStyle style)
	{
		logger.info(MessageConstant.TDM_EXCEL_DASHBOARD + MessageConstant.TDM_EXCEL_SET_ROWS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		int record = 5;
		for (TDMBankReservationDTO accountDTo : accountDTOs)
		{
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(accountDTo.getAccNum());
			excelRow.createCell(1).setCellValue(accountDTo.getCustNum());
			excelRow.createCell(2).setCellValue(accountDTo.getCustName());
			excelRow.createCell(3).setCellValue(accountDTo.getCustSurName());
			excelRow.createCell(4).setCellValue(accountDTo.getBranchCode());
			excelRow.createCell(5).setCellValue(accountDTo.getAccStatus());
			excelRow.createCell(6).setCellValue(accountDTo.getAccBal());
			excelRow.createCell(7).setCellValue(accountDTo.getTestCaseId());
			excelRow.createCell(8).setCellValue(accountDTo.getTestCaseName());
			excelRow.createCell(9).setCellValue(accountDTo.getCity());
			excelRow.createCell(10).setCellValue(accountDTo.getCountry());
			excelRow.createCell(11).setCellValue(accountDTo.getZipCode());
			excelRow.createCell(12).setCellValue(accountDTo.getReserveDate());
			excelRow.createCell(13).setCellValue(accountDTo.getCreditCardNum());
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
