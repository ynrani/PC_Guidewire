/*
 * Object Name : TDMAdminServiceImpl.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TDMAdminDAO;
import com.tesda.dao.TdgCustomDao;
import com.tesda.dao.TdgOperationsDao;
import com.tesda.email.EmailNotificationService;
import com.tesda.model.DTO.TdgRequestListDTO;
import com.tesda.model.DTO.TdgSchemaDTO;
import com.tesda.model.DTO.TdmUserDTO;
import com.tesda.model.mapper.TDMUserMapper;
import com.tesda.model.mapper.TdgOperationsMapper;
import com.tesda.service.TDMAdminService;

@Component
@Service("tDMAdminService")
@Transactional(propagation = Propagation.REQUIRED)
public class TDMAdminServiceImpl extends TdgBaseServiceImpl implements TDMAdminService{
	@Autowired
	TDMAdminDAO tDMAdminDAO;
	@Autowired
	TDMUserMapper tdmUserMapper;
	@Autowired
	EmailNotificationService emailNotificationService;
	@Autowired
	TdgCustomDao tdgCustomDao;
	@Autowired
	TdgOperationsDao tdgOperationsDao;
	@Autowired
	TdgOperationsMapper tdgOperationsMapper;

	@Override
	public String saveUserDetails(TdmUserDTO userdo, boolean bEdit){
		return tDMAdminDAO.saveUserDetails(tdmUserMapper.converTdmUserDTOToUserDO(userdo), bEdit);
	}

	@Override
	public List<TdmUserDTO> getAllUser(TdmUserDTO userdo, int offSet, int recordsperpage, boolean b){
		return tdmUserMapper.converTdmUserDOToUserSearchResultListDTO(tDMAdminDAO.getAllUser(
				tdmUserMapper.converTdmUserDTOToUserDO(userdo), offSet, recordsperpage, b));
	}

	@Override
	public TdmUserDTO getEditUser(String userId){
		return tdmUserMapper.converTdmUserDOToUserSearchResultDTO(tDMAdminDAO.getEditUser(userId));
	}

	@Override
	public String deleteUserByUserId(String userId){
		return tDMAdminDAO.deleteUserByUserId(userId);
	}

	@Override
	public Long searchUserRecordsCount(TdmUserDTO userdo){
		return tDMAdminDAO.searchUserRecordsCount(tdmUserMapper.converTdmUserDTOToUserDO(userdo));
	}

	@Override
	public boolean validateUserId(String userid){
		return tDMAdminDAO.validateUserId(userid);
	}

	@Override
	public List<String> getAllCols(String strUrl, String strName, String strPass){
		return tdgCustomDao.getAllCols(strUrl, strName, strPass);
	}

	@Override
	public String saveTdgSchemaDetails(TdgSchemaDTO tdgSchemaDTO){
		String strResult = null;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				strResult = tdgOperationsDao.saveSchemaDetails(
						tdgOperationsMapper.convertTdgSchemaDTOToTdgSchemaDO(tdgSchemaDTO),
						managerentity);
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		return strResult;
	}

	@Override
	public List<TdgSchemaDTO> fetchAllTdgSchemaDetails(){
		List<TdgSchemaDTO> listResult = null;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				listResult = tdgOperationsMapper.convertTdgSchemaDOToTdgSchemaDTO(tdgOperationsDao
						.fetchSchemaDetailsAll(managerentity));
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		return listResult;
	}

	public TdgRequestListDTO fetchAllTdgRequestList(){
		TdgRequestListDTO tdgRequestListDTO = null;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				tdgRequestListDTO = tdgOperationsMapper
						.convertTdgRequestListDOToTdgRequestListDTO(tdgOperationsDao
								.fetchRequestListAll(managerentity));
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		return tdgRequestListDTO;
	}

	@Override
	public Long getTdgMasterDictionaryRecordsCount(){
		EntityManager managerentity = null;
		Long lResult = null;
		try {
			managerentity = openEntityManager();
			lResult = tdgOperationsDao.getTdgDataDictionaryRecordsCount(managerentity);
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		return lResult;
	}

	@Override
	public List<TdgSchemaDTO> getTdgMasterDictionaryRecordsForPagination(int offSet,
			int recordsperpage, boolean b){
		List<TdgSchemaDTO> listResult = null;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				listResult = tdgOperationsMapper.convertTdgSchemaDOToTdgSchemaDTO(tdgOperationsDao
						.getTdgMasterDictionaryRecordsForPagination(managerentity, offSet,
								recordsperpage, b));
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		return listResult;
	}

	@Override
	public void deleteTdgMasterDictionaryByReqSchemaId(String reqId, String manualDictionaryId){
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				tDMAdminDAO.deleteTdgMasterDictionaryByReqSchemaId(managerentity, reqId,
						manualDictionaryId);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
	}

	@Override
	public String saveManualDictionaryDetails(String strTabName,
			Map<String, List<String>> mapResult, String reqSchemaId){
		EntityManager managerentity = null;
		String strResponse = "";
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				strResponse = tdgOperationsDao.saveManualDictionaryDetails(strTabName, mapResult,
						managerentity, reqSchemaId);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		return strResponse;
	}

	@Override
	public List<String> getColsByTabs(String strUrl, String strName, String strPass,
			List<String> listPassedTabs){
		return tdgCustomDao.getColsByTabs(strUrl, strName, strPass, listPassedTabs);
	}
}
