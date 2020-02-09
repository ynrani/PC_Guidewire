package com.tdm.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.ServiceException;

public class PaginationUtil
{
	private static Logger logger = Logger.getLogger(PaginationUtil.class);
	int startPage;
	int lastPage;

	public int getStartPage() {
		return this.startPage;
	}

	public int getLastPage() {
		return this.lastPage;
	}

	/**
	 * Pagination Method to handle the pagination. It works on number of pages and number of records
	 * to be shown.
	 * 
	 * @param totalRecords
	 * @param request
	 * @param defaultPagesToBeShown
	 * @param recordsPerPage
	 * @throws ServiceException
	 */
	public void paginate(Long totalRecords, HttpServletRequest request,
			Double defaultPagesToBeShown, int recordsPerPage) throws ServiceException {
		logger.info(MessageConstant.TDM_PAGENATION_UTIL + MessageConstant.PAGENATE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			int currentPage = Integer.parseInt((request.getAttribute(AppConstant.CURRENT_PAGE))
					.toString());
			Double totalPages = Math.ceil(totalRecords.doubleValue() / recordsPerPage);
			request.setAttribute(AppConstant.NO_OF_PAGES, totalPages.intValue());
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
			request.setAttribute(AppConstant.START_PAGE, startPage);
			request.setAttribute(AppConstant.LAST_PAGE, lastPage);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_PAGENATION_UTIL + MessageConstant.PAGENATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_PAGENATION_UTIL + MessageConstant.PAGENATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
		logger.info(MessageConstant.TDM_PAGENATION_UTIL + MessageConstant.PAGENATE
				+ MessageConstant.LOG_INFO_RETURN);
	}

	public int getOffset(HttpServletRequest request, int recordsPerPage) throws ServiceException {
		// offset = Starting point to fetch records
		// e.g. if we want records from 11-20, offset should be 10.
		logger.info(MessageConstant.TDM_PAGENATION_UTIL + MessageConstant.GET_OFF_SET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		int offset = 0;
		int currentPage = 1;
		try {
			if ((request.getParameter(AppConstant.PAGE) != null)
					&& (Integer.parseInt(request.getParameter(AppConstant.PAGE)) != 1)) {
				// Get current Page from request
				currentPage = Integer.parseInt(request.getParameter(AppConstant.PAGE));

				// Calculate offset value from current Page
				offset = (currentPage - 1) * recordsPerPage;
			}
			request.setAttribute(AppConstant.CURRENT_PAGE, currentPage);
			logger.info(MessageConstant.TDM_PAGENATION_UTIL + MessageConstant.GET_OFF_SET
					+ MessageConstant.LOG_INFO_RETURN);
			return offset;
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_PAGENATION_UTIL + MessageConstant.GET_OFF_SET
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_PAGENATION_UTIL + MessageConstant.GET_OFF_SET
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}
