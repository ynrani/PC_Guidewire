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

import com.tesda.model.DTO.TDMClaimSearchResultListDTO;

public class SearchClaimOutputListExcelView extends AbstractExcelView
{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HSSFSheet excelSheet = workbook.createSheet("Claim Search Reserve Record");

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
		List<TDMClaimSearchResultListDTO> searchClaimOutputList = (List<TDMClaimSearchResultListDTO>) model
				.get("tDMClaimSearchResultListDTOs");
		setExcelRows(excelSheet, searchClaimOutputList, style2);

	}

	public void setExcelHeader(HSSFSheet excelSheet, HSSFCellStyle style)
	{
		HSSFRow excelHeader = excelSheet.createRow(2);

		excelSheet.setDisplayGridlines(false);

		excelHeader = excelSheet.createRow(2);
		excelHeader.createCell(0).setCellValue("User ID ");

		excelHeader = excelSheet.createRow(4);
		excelHeader.createCell(2).setCellValue("Claim ID");
		excelHeader.createCell(3).setCellValue("Claim Type");
		excelHeader.createCell(4).setCellValue("Patient First Name");
		excelHeader.createCell(5).setCellValue("Patient Last Name");
		excelHeader.createCell(6).setCellValue("Patient Id");
		excelHeader.createCell(7).setCellValue("Claim Status");
		excelHeader.createCell(8).setCellValue("Diagnosis Code");
		excelHeader.createCell(9).setCellValue("Proc Code");
		excelHeader.createCell(10).setCellValue("Modifier Code");
		excelHeader.createCell(11).setCellValue("Revenue Code");
		excelHeader.createCell(12).setCellValue("Claim Source");

		excelHeader.createCell(13).setCellValue("POS");
		excelHeader.createCell(14).setCellValue("Type of Service");
		excelHeader.createCell(15).setCellValue("Provider TIN");
		excelHeader.createCell(16).setCellValue("Provider NPI");
		excelHeader.createCell(17).setCellValue("Receipt Date");
		excelHeader.createCell(18).setCellValue("Gender");
		excelHeader.createCell(19).setCellValue("Claim Status Code");
		excelHeader.createCell(20).setCellValue("Group ID");

		excelHeader.createCell(21).setCellValue("Total Charge");
		excelHeader.createCell(22).setCellValue("Total Allowed");
		excelHeader.createCell(23).setCellValue("Total Paid");
		excelHeader.createCell(24).setCellValue("Deductible");
		excelHeader.createCell(25).setCellValue("Copay");
		excelHeader.createCell(26).setCellValue("Co-ins");
		excelHeader.createCell(27).setCellValue("Admission Date");
		excelHeader.createCell(28).setCellValue("Discharge Date");
		excelHeader.createCell(29).setCellValue("Type of Bill");

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
		excelHeader.getCell(23).setCellStyle(style);
		excelHeader.getCell(24).setCellStyle(style);
		excelHeader.getCell(25).setCellStyle(style);
		excelHeader.getCell(26).setCellStyle(style);
		excelHeader.getCell(27).setCellStyle(style);
		excelHeader.getCell(28).setCellStyle(style);
		excelHeader.getCell(29).setCellStyle(style);

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
		excelSheet.autoSizeColumn(23);
		excelSheet.autoSizeColumn(24);
		excelSheet.autoSizeColumn(25);
		excelSheet.autoSizeColumn(26);
		excelSheet.autoSizeColumn(27);
		excelSheet.autoSizeColumn(28);
		excelSheet.autoSizeColumn(29);

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
			List<TDMClaimSearchResultListDTO> searchClaimOutputList, HSSFCellStyle style)
	{
		int record = 5;

		for (TDMClaimSearchResultListDTO ftdClaimSearchResultListDTO : searchClaimOutputList)
		{
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(2).setCellValue(ftdClaimSearchResultListDTO.getClaimId());
			excelRow.createCell(3).setCellValue(ftdClaimSearchResultListDTO.getClaimType());
			excelRow.createCell(4).setCellValue(ftdClaimSearchResultListDTO.getPatientFirstName());
			excelRow.createCell(5).setCellValue(ftdClaimSearchResultListDTO.getPatientLastName());
			excelRow.createCell(6).setCellValue(ftdClaimSearchResultListDTO.getPatientId());
			excelRow.createCell(7).setCellValue(ftdClaimSearchResultListDTO.getClaimStatus());
			excelRow.createCell(8).setCellValue(ftdClaimSearchResultListDTO.getClaimDXCode());
			excelRow.createCell(9).setCellValue(ftdClaimSearchResultListDTO.getClaimProcCode());
			excelRow.createCell(10).setCellValue(ftdClaimSearchResultListDTO.getClaimModifier());
			excelRow.createCell(11).setCellValue(ftdClaimSearchResultListDTO.getClaimRevCode());
			excelRow.createCell(12).setCellValue(ftdClaimSearchResultListDTO.getClaimSource());
			excelRow.createCell(13).setCellValue(ftdClaimSearchResultListDTO.getClaimPOS());
			excelRow.createCell(14).setCellValue(ftdClaimSearchResultListDTO.getClaimServiceType());
			excelRow.createCell(15).setCellValue(ftdClaimSearchResultListDTO.getClaimProviderTIN());
			excelRow.createCell(16).setCellValue(ftdClaimSearchResultListDTO.getClaimProviderNPI());
			excelRow.createCell(17).setCellValue(ftdClaimSearchResultListDTO.getClaimReceiptDate());
			excelRow.createCell(18).setCellValue(
					ftdClaimSearchResultListDTO.getClaimPatientGender());
			excelRow.createCell(19).setCellValue(ftdClaimSearchResultListDTO.getClaimStatusCode());
			excelRow.createCell(20).setCellValue(ftdClaimSearchResultListDTO.getClaimGrpNum());

			excelRow.createCell(21).setCellValue(ftdClaimSearchResultListDTO.getTotalCharge());
			excelRow.createCell(22).setCellValue(ftdClaimSearchResultListDTO.getTotalAllowed());
			excelRow.createCell(23).setCellValue(ftdClaimSearchResultListDTO.getTotalPaid());
			excelRow.createCell(24).setCellValue(ftdClaimSearchResultListDTO.getDeductible());
			excelRow.createCell(25).setCellValue(ftdClaimSearchResultListDTO.getCopay());
			excelRow.createCell(26).setCellValue(ftdClaimSearchResultListDTO.getCoins());
			excelRow.createCell(27).setCellValue(ftdClaimSearchResultListDTO.getAdmissionDate());
			excelRow.createCell(28).setCellValue(ftdClaimSearchResultListDTO.getDischargeDate());
			excelRow.createCell(29).setCellValue(ftdClaimSearchResultListDTO.getTypeofBill());

			excelRow.createCell(0).setCellValue(ftdClaimSearchResultListDTO.getTestCaseId());
			excelRow.createCell(1).setCellValue(ftdClaimSearchResultListDTO.getTestCaseName());

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
			excelRow.getCell(23).setCellStyle(style);
			excelRow.getCell(24).setCellStyle(style);
			excelRow.getCell(25).setCellStyle(style);
			excelRow.getCell(26).setCellStyle(style);
			excelRow.getCell(27).setCellStyle(style);
			excelRow.getCell(28).setCellStyle(style);
			excelRow.getCell(29).setCellStyle(style);

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
			excelSheet.autoSizeColumn(23);
			excelSheet.autoSizeColumn(24);
			excelSheet.autoSizeColumn(25);
			excelSheet.autoSizeColumn(26);
			excelSheet.autoSizeColumn(27);
			excelSheet.autoSizeColumn(28);
			excelSheet.autoSizeColumn(29);
		}
	}
}
