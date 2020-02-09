package com.tesda.service;

import java.util.List;
import java.util.Map;

import com.tesda.exception.ServiceException;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;

public interface TDMNonStandSearchService
{
	public Map<String, List<String>> getSearchFields() throws ServiceException;

	public TDMNonStandardSearchDTO getNonStandSearchRecords(TDMNonStandardSearchDTO tdm)
			throws ServiceException;

	public int saveReservedData(TDMNonStandardSearchDTO tdmNonSrchDTO, String userName)
			throws ServiceException;
}
