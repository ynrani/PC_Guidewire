package com.tesda.service;

import com.tesda.exception.ServiceException;

public interface RefreshService
{

	public boolean policyRefresh() throws ServiceException;

	public boolean getPolicysummaryData() throws ServiceException;

}
