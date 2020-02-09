/*
 * Object Name : PaginationUtil.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class PaginationUtil{
	int startPage;
	int lastPage;

	public int getStartPage(){
		return this.startPage;
	}

	public int getLastPage(){
		return this.lastPage;
	}

	/**
	 * Pagination Method to handle the pagination. It works on number of pages
	 * and number of records to be shown.
	 * 
	 * @param currentPage
	 * @param noOfPages
	 * @param request
	 */
	public void paginate(Long totalRecords, HttpServletRequest request,
			Double defaultPagesToBeShown, int recordsPerPage){
		int currentPage = (int) request.getAttribute("currentPage");
		Double totalPages = Math.ceil(totalRecords.doubleValue() / recordsPerPage);
		request.setAttribute("noOfPages", totalPages.intValue());
		if (totalPages < defaultPagesToBeShown) {
			defaultPagesToBeShown = totalPages;
		}
		int startPage = 1;
		int lastPage = defaultPagesToBeShown.intValue();
		if (lastPage > currentPage) {
			lastPage = currentPage;
		}
		Double totalBlocks = totalPages / defaultPagesToBeShown;
		totalBlocks = Math.ceil(totalBlocks);
		Map<Integer, Integer> pageBlock = new HashMap<Integer, Integer>();
		if (totalBlocks > 0) {
			for (int i = 0; i < totalBlocks; i++) {
				lastPage = startPage + defaultPagesToBeShown.intValue() - 1;
				if (lastPage > totalPages) {
					lastPage = totalPages.intValue();
				}
				pageBlock.put(startPage, lastPage);
				startPage = lastPage + 1;
			}
		}
		if (pageBlock != null && !pageBlock.isEmpty()) {
			for (Map.Entry<Integer, Integer> entry : pageBlock.entrySet()) {
				Integer startPageTemp = entry.getKey();
				Integer endPageTemp = entry.getValue();
				if (currentPage >= startPageTemp && currentPage <= endPageTemp) {
					startPage = startPageTemp;
					lastPage = endPageTemp;
					break;
				}
			}
		}
		request.setAttribute("startPage", startPage);
		request.setAttribute("lastPage", lastPage);
	}

	public int getOffset(HttpServletRequest request, int recordsPerPage){
		// offset = Starting point to fetch records
		// e.g. if we want records from 11-20, offset should be 10.
		int offset = 0;
		int currentPage = 1;
		if ((request.getParameter("page") != null)
				&& (Integer.parseInt(request.getParameter("page")) != 1)) {
			// Get current Page from request
			currentPage = Integer.parseInt(request.getParameter("page"));
			// Calculate offset value from current Page
			offset = (currentPage - 1) * recordsPerPage;
		}
		request.setAttribute("currentPage", currentPage);
		return offset;
	}
}
