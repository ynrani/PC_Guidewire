package com.tesda.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tesda.exception.ServiceException;

public interface RefreshService
{
	public boolean getPolicysummaryData(HttpServletRequest request, HttpServletResponse response)
			throws ServiceException;

	public boolean getPolicyCoverageData() throws ServiceException;

	public boolean getPolicyDerivedData() throws ServiceException;
}
