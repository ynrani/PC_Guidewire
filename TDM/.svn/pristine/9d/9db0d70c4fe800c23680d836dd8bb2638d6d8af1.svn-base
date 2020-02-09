/*
 * Object Name : TdgPdfSearchResultListView.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.view;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tesda.model.DTO.TdgRequestListDTO;

public class TdgPdfSearchResultListView extends AbstractPdfView{
	@SuppressWarnings({ "rawtypes" })
	@Override
	protected void buildPdfDocument(Map model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		TdgRequestListDTO tdgRequestListDTO = (TdgRequestListDTO) model
				.get("tdgPdfSearchResultListDTOs");
		Map<String, String> colvalMap = new HashMap<String, String>();
		if (tdgRequestListDTO.getConditions() != null
				&& tdgRequestListDTO.getConditions().contains("#")) {
			String[] colvalue = tdgRequestListDTO.getConditions().split("\\#");
			for (int i = 0; i < colvalue.length; i++) {
				if (colvalue[i].contains(":")) {
					String[] strChildSplit = colvalue[i].split(":");
					if (strChildSplit.length > 1) {
						if (strChildSplit[0] != null && strChildSplit[1] != null) {
							colvalMap.put(strChildSplit[0], strChildSplit[1]);
						}
					} else if (strChildSplit.length == 1) {
						colvalMap.put(strChildSplit[0], null);
					}
				} else {
					colvalMap.put(colvalue[i], null);
				}
			}
		} else if (tdgRequestListDTO.getConditions() != null
				&& tdgRequestListDTO.getConditions().contains(":")) {
			String[] colvalue = tdgRequestListDTO.getConditions().split(":");
			if (colvalue.length > 1) {
				if (colvalue[0] != null && colvalue[1] != null) {
					colvalMap.put(colvalue[0], colvalue[1]);
				}
			} else if (colvalue.length == 1) {
				colvalMap.put(colvalue[0], null);
			}
		} else {
			colvalMap.put(tdgRequestListDTO.getConditions(), null);
		}
		PdfPTable table = null;
		Set<Entry<String, String>> keyset = null;
		Font font = null;
		PdfPCell cell = null;
		document.add(new Paragraph("TDG Request Details"));
		if (colvalMap != null && colvalMap.size() > 0) {
			keyset = colvalMap.entrySet();
			table = new PdfPTable(keyset.size());
			table.setWidthPercentage(100.0f);
			table.setSpacingBefore(10);
			// define font for table header row
			font = FontFactory.getFont(FontFactory.HELVETICA);
			font.setColor(Color.WHITE);
			// define table header cell
			cell = new PdfPCell();
			cell.setBackgroundColor(Color.BLUE);
			cell.setPadding(tdgRequestListDTO.getListGeneratedData().size());
			for (Entry<String, String> key : keyset) {
				cell.setPhrase(new Phrase(key.getKey(), font));
				table.addCell(cell);
			}
			for (int i = 0; i < tdgRequestListDTO.getRequestCount(); i++) {
				for (String strValue : tdgRequestListDTO.getListGeneratedData().get(i)) {
					table.addCell(strValue);
				}
			}
		}
		document.add(table);
	}
}
