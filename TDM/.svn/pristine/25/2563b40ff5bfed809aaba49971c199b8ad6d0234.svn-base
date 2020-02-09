package com.tdm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tdm.exception.DAOException;
import com.tdm.model.DO.RequestorDO;
import com.tdm.model.DO.TdmOnboardReqDO;
import com.tdm.model.DO.TdmUserDO;
import com.tdm.model.DTO.TdmOnBoardReqDTO;

public interface TDMDataMaskingDAO
{

	public TdmUserDO getUserDetails(EntityManager managerDtmask, String userId) throws DAOException;

	public RequestorDO getSaveReqDtls(RequestorDO requestorDO, EntityManager managerUser)
			throws DAOException;

	public String maskingRecId(EntityManager managerDtmask) throws DAOException;

	public RequestorDO getSavedDtls(String id, EntityManager managerDtmask) throws DAOException;

	public Long getDataMaskingRecordsCount(String userId, String type, EntityManager managerDtmask)
			throws DAOException;

	public List<RequestorDO> searchDataMaskingRecords(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userId, String type, EntityManager managerDtmask)
			throws DAOException;

	public List<RequestorDO> getSavedDtlsforExport(String userId, String type,
			EntityManager managerDtmask) throws DAOException;

	public List<String> getReqIdList(String userId, EntityManager managerDtmask, String reqIdtoken)
			throws DAOException;

	public TdmOnboardReqDO getEditableDetails(EntityManager managerDtmask, String reqId)
			throws DAOException;

	public TdmOnBoardReqDTO getUserDetailsOnboard(String userId, EntityManager managerUser,
			TdmOnBoardReqDTO tdmOnBoardReqDTO) throws DAOException;

	public String onBoardingRecId(EntityManager managerDtmask) throws DAOException;

	public TdmOnboardReqDO getSaveOnboardingReq(EntityManager managerDtmask,
			TdmOnboardReqDO tdmOnboardReqDO) throws DAOException;

	public Long getOnBoardingRecordsCount(String userId, String type, EntityManager managerDtmask)
			throws DAOException;

	public List<TdmOnboardReqDO> searchOnBoardingRecords(int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userId, String type, EntityManager managerDtmask)
			throws DAOException;

	public boolean getCheckExistingReqYesNo(String userId, EntityManager managerDtmask)
			throws DAOException;

	public boolean dtMaskCancelReq(String reqId, EntityManager managerDtmask) throws DAOException;

	public boolean cancelOnBoardingReq(EntityManager managerDtmask, String reqId)
			throws DAOException;

	public boolean cancelMaskingReq(EntityManager managerDtmask, String reqId) throws DAOException;

}
