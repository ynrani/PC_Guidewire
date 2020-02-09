/*---------------------------------------------------------------------------------------
 * Object Name: TDGDataMaskingDAO.Java
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
import java.util.Map;

import javax.persistence.EntityManager;

import com.tesda.exception.DAOException;
import com.tesda.model.DO.ReqChDO;
import com.tesda.model.DO.RequestorDO;
import com.tesda.model.DO.TdmOnboardReqDO;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdmOnBoardReqDTO;

public interface TDMDataMaskingDAO
{
	public String saveMaskingData(RequestorDO requestorDO, EntityManager managerDtmask)
			throws DAOException;

	public List<RequestorDO> getAllDtMaskRequestedRecord(String userId, EntityManager managerDtmask)
			throws DAOException;

	public Map<RequestorDO, List<ReqChDO>> getDtMaskRequestedRecord(EntityManager managerDtmask,
			String userId, String reqId) throws DAOException;

	public List<RequestorDO> searchDataMaskingRecords(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userId, String type, EntityManager managerDtmask)
			throws DAOException;

	public Long getDataMaskingRecordsCount(String userId, String type, EntityManager managerDtmask)
			throws DAOException;

	public TdgDataMaskingDTO getUserDetails(EntityManager managerDtmask, String userId)
			throws DAOException;

	public TdmOnBoardReqDTO getUserDetailsOnboard(String userId, EntityManager managerUser,
			TdmOnBoardReqDTO tdmOnBoardReqDTO) throws DAOException;

	public TdmOnboardReqDO getSaveOnboardingReq(EntityManager managerDtmask,
			TdmOnboardReqDO tdmOnboardReqDO) throws DAOException;;

	public TdmOnboardReqDO getEditableDetails(EntityManager managerDtmask, String reqId)
			throws DAOException;

	public List<String> getReqIdList(String userId, EntityManager managerDtmask, String reqIdtoken)
			throws DAOException;

	public Long getOnBoardingRecordsCount(String userId, String type, EntityManager managerDtmask)
			throws DAOException;

	public List<TdmOnboardReqDO> searchOnBoardingRecords(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userId, String type, EntityManager managerDtmask)
			throws DAOException;

	public String onBoardingRecId(EntityManager managerDtmask);

	public String maskingRecId(EntityManager managerDtmask);

	public boolean cancelOnBoardingReq(EntityManager managerDtmask, String reqId)
			throws DAOException;

	public boolean cancelMaskingReq(EntityManager managerDtmask, String reqId) throws DAOException;

	public List<RequestorDO> getSavedDtlsforExport(String userId, String type,
			EntityManager managerDtmask) throws DAOException;

	public RequestorDO getSavedDtls(String id, EntityManager managerDtmask) throws DAOException;

	public RequestorDO getSaveReqDtls(RequestorDO requestorDO, EntityManager managerUser)
			throws DAOException;
}
