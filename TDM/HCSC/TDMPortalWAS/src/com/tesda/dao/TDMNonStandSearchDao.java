package com.tesda.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.tesda.exception.DAOException;
import com.tesda.model.DO.TdmLookupDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DO.TdmSubscriberDetailsDO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;

public interface TDMNonStandSearchDao
{

	public List<TdmLookupDO> getTDMSearchFields(Map<String, List<String>> map,
			EntityManager managerLookup) throws DAOException;

	public List<TdmSubscriberDetailsDO> getTDMNonStandSearchRecords(
			TDMNonStandardSearchDTO tdmNonStandDTO, EntityManager managerLookup)
			throws DAOException;

	public List<TdmReservationDO> saveReserveData(List<TdmReservationDO> tdmResrveList,
			String testCaseName, String testCaseid, EntityManager managerUsr) throws DAOException;
}
