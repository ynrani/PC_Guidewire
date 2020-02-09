/*
 * Object Name : TdgExcelSearchResultListView.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.tesda.model.DTO.TdgRequestListDTO;

public class TdgExcelSearchResultListView extends AbstractExcelView{
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		HSSFSheet excelSheet = workbook.createSheet("TestData Generator Request Record");
		HSSFCellStyle style1 = workbook.createCellStyle();
		style1.setFillForegroundColor(HSSFColor.LIME.index);
		style1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style1.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style1.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.DARK_TEAL.index);
		style1.setFont(font);
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		HSSFCellStyle style3 = workbook.createCellStyle();
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		HSSFFont font1 = workbook.createFont();
		font1.setBold(true);
		style3.setFont(font1);
		TdgRequestListDTO tdgRequestListDTO = (TdgRequestListDTO) model
				.get("tdgExcelSearchResultListDTOs");
		Map<String, String> colvalMap = new HashMap<String, String>();
		if (tdgRequestListDTO.getConditions() != null
				&& tdgRequestListDTO.getConditions().contains("#")) {
			String[] colvalue = tdgRequestListDTO.getConditions().split("\\#");
			for (int i = 0; i < colvalue.length; i++) {
				colvalMap.putAll(getResult(colvalue[i]));
			}
		} else {
			colvalMap.putAll(getResult(tdgRequestListDTO.getConditions()));
		}
		setExcelHeader(excelSheet, colvalMap, style1, style3);
		setExcelRows(excelSheet, tdgRequestListDTO.getListGeneratedData().size(),
				tdgRequestListDTO.getListGeneratedData(), style2);
	}

	private Map<String, String> getResult(String strValue){
		Map<String, String> colvalMap = new HashMap<String, String>();
		if (strValue.contains(":")) {
			String[] strChildSplit = strValue.split(":");
			if (strChildSplit.length > 1) {
				if (strChildSplit[0] != null && strChildSplit[1] != null) {
					colvalMap.put(strChildSplit[0], strChildSplit[1]);
				}
			} else if (strChildSplit.length == 1) {
				colvalMap.put(strChildSplit[0], null);
			}
		} else {
			colvalMap.put(strValue, null);
		}
		return colvalMap;
	}

	public void setExcelHeader(HSSFSheet excelSheet, Map<String, String> map, HSSFCellStyle style1,
			HSSFCellStyle style3){
		excelSheet.setDisplayGridlines(false);
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(1).setCellValue("TDG Request Details");
		excelHeader.getCell(1).setCellStyle(style3);
		excelSheet.autoSizeColumn(1);
		excelHeader = excelSheet.createRow(2);
		int k = 1;
		for (Entry<String, String> key : map.entrySet()) {
			excelHeader.createCell(k).setCellValue(key.getKey());
			excelHeader.getCell(k).setCellStyle(style1);
			excelSheet.autoSizeColumn(k);
			k++;
		}
	}

	public HSSFColor setColor(HSSFWorkbook workbook, byte r, byte g, byte b){
		HSSFPalette palette = workbook.getCustomPalette();
		HSSFColor hssfColor = null;
		try {
			hssfColor = palette.findColor(r, g, b);
			if (hssfColor == null) {
				palette.setColorAtIndex(HSSFColor.LAVENDER.index, r, g, b);
				hssfColor = palette.getColor(HSSFColor.LAVENDER.index);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return hssfColor;
	}

	public void setExcelRows(HSSFSheet excelSheet, int count, List<List<String>> lstValues,
			HSSFCellStyle style){
		int j = 3;
		for (int i = 0; i < count; i++) {
			HSSFRow excelRow = excelSheet.createRow(j);
			int k = 1;
			/* for (Entry<String, String> key : map.entrySet()) {
			 * excelRow.createCell(k).setCellValue(key.getValue());
			 * excelRow.getCell(k).setCellStyle(style);
			 * excelSheet.autoSizeColumn(k);
			 * k++;
			 * } */
			for (String strValue : lstValues.get(i)) {
				if (!StringUtils.isEmpty(strValue)) {
					excelRow.createCell(k).setCellValue(strValue);
					excelRow.getCell(k).setCellStyle(style);
					excelSheet.autoSizeColumn(k);
					k++;
				}
			}
			j++;
		}
	}
}
