package com.tdm.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdm.exception.DAOException;

public interface RefreshDAO
{

	public boolean getPolicysummaryData() throws DAOException;

	boolean getPolicyCoverageData() throws DAOException;

	boolean getPolicyDerivedData() throws DAOException;

	public boolean getRunScript(HttpServletRequest request, HttpServletResponse response)
			throws DAOException;

	boolean getPolicyRiskCoverage() throws DAOException;

	boolean getPolicyAllCoverages() throws DAOException;
}
