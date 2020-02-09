/*
\ * Object Name : TdgOperationsServiceImpl.java
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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TdgCustomDao;
import com.tesda.dao.TdgOperationsDao;
import com.tesda.model.DTO.TdgDataConditionDTO;
import com.tesda.model.mapper.TdgOperationsMapper;

@Component
@Service("tdgDataConditionService")
@Transactional(propagation = Propagation.REQUIRED)
public class TdgDataConditionServiceImpl extends TdgBaseServiceImpl implements
		TdgDataConditionService{
	private static Logger logger = Logger.getLogger(TdgBaseServiceImpl.class);
	private static String strClassName = " [ TdgDataConditionServiceImpl ] ";
	@Autowired
	TdgCustomDao tdgCustomDao;
	@Autowired
	TdgOperationsDao tdgOperationsDao;
	@Autowired
	TdgOperationsMapper tdgOperationsMapper;

	@Override
	public String saveDataConditionData(TdgDataConditionDTO tdgDataConditionDTO){
		String strMethodName = "  [ saveDataConditionData() ] ";
		logger.info(strClassName + strMethodName + " inside saveDataConditionData method");
		String strResult = null;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				strResult = tdgOperationsDao.saveDataConditionalDetails(tdgDataConditionDTO,
						managerentity);
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return saveDataConditionData method");
		return strResult;
	}

	@Override
	public Map<String, List<String>> retrieveManualDictionaryValues(String strDictionaryName){
		String strMethodName = "  [ retrieveManualDictionaryValues() ] ";
		logger.info(strClassName + strMethodName + " inside retrieveManualDictionaryValues method");
		EntityManager managerentity = null;
		Map<String, List<String>> mapResult = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				mapResult = tdgOperationsDao.retrieveManualDictionaryValues(strDictionaryName,
						managerentity);
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return retrieveManualDictionaryValues method");
		return mapResult;
	}

	@Override
	public Long totalDataConditionalDetailsAll(){
		String strMethodName = "  [ totalDataConditionalDetailsAll() ] ";
		logger.info(strClassName + strMethodName + " inside totalDataConditionalDetailsAll method");
		EntityManager managerentity = null;
		long lResult = 0L;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				lResult = tdgOperationsDao.totalDataConditionalDetailsAll(managerentity);
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return totalDataConditionalDetailsAll method");
		return lResult;
	}

	@Override
	public List<TdgDataConditionDTO> fetchDataConditionalDetailsAll(int offSet, int recordsperpage,
			boolean b){
		String strMethodName = "  [ fetchDataConditionalDetailsAll() ] ";
		logger.info(strClassName + strMethodName + " inside fetchDataConditionalDetailsAll method");
		List<TdgDataConditionDTO> listResult = null;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				listResult = tdgOperationsMapper
						.convertTdgDataConditionDOToTdgDataConditionDTO(tdgOperationsDao
								.fetchDataConditionalDetailsAll(0, offSet, recordsperpage, b,
										managerentity));
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return fetchDataConditionalDetailsAll method");
		return listResult;
	}

	@Override
	public void deleteTdgDataConditionalDetails(String id){
		String strMethodName = "  [ deleteTdgDataConditionalDetails() ] ";
		logger.info(strClassName + strMethodName + " inside deleteTdgDataConditionalDetails method");
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				tdgOperationsDao.deleteTdgDataConditionalDetails(id, managerentity);
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return deleteTdgDataConditionalDetails method");
	}

	@Override
	public TdgDataConditionDTO fetchDataConditionalById(String id){
		String strMethodName = "  [ TdgDataConditionDTO() ] ";
		logger.info(strClassName + strMethodName + " inside TdgDataConditionDTO method");
		EntityManager managerentity = null;
		TdgDataConditionDTO tdgDataConditionDTO = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				tdgDataConditionDTO = tdgOperationsMapper
						.convertTdgDataConditionDOToTdgDataConditionDTO(tdgOperationsDao
								.fetchDataConditionalById(Long.parseLong(id), managerentity));
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return TdgDataConditionDTO method");
		return tdgDataConditionDTO;
	}
}
