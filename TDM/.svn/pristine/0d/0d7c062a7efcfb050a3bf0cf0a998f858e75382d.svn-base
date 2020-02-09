/*---------------------------------------------------------------------------------------
 * Object Name: TDMNonStandSearchDao.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. 		Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary   11/04/15  NA          		Created* 
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tesda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tesda.exception.DAOException;
import com.tesda.model.DO.TdmLookupDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DO.TdmSubscriberDetailsDO;
import com.tesda.model.DTO.TDMNonStandardSearchDTO;

public interface TDMNonStandSearchDao
{

	public List<TdmLookupDO> getTDMSearchFields(EntityManager managerLookup) throws DAOException;

	public List<TdmSubscriberDetailsDO> getTDMNonStandSearchRecords(
			TDMNonStandardSearchDTO tdmNonStandDTO, int offSet, int recordsperpage,
			EntityManager managerSubscr) throws DAOException;

	public List<TdmReservationDO> saveReserveData(List<TdmReservationDO> tdmResrveList,
			String testCaseName, String testCaseid, EntityManager managerUsr) throws DAOException;

	public List<TdmReservationDO> getReservedRecords(String userId, EntityManager managerUsr)
			throws DAOException;

	public void unReserveResrvedRecords(List<TdmReservationDO> tdmUnResrveList, String userId,
			EntityManager managerUsr) throws DAOException;

	public List<String> getSubscriberAcNameNumDetails(String type, String token,
			EntityManager managerSubscrbr) throws DAOException;

	public long getNonStandardSearchRecordCount(TDMNonStandardSearchDTO tdmNonStandDTO,
			EntityManager managerSubscr) throws DAOException;
}
