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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TdgCustomDao;
import com.tesda.dao.TdgOperationsDao;
import com.tesda.model.DO.TdgGeneratedRequestDO;
import com.tesda.model.DO.TdgRequestListDO;
import com.tesda.model.DO.TdgSchemaDO;
import com.tesda.model.DTO.TdgDynamicPageContentDTO;
import com.tesda.model.DTO.TdgRequestListDTO;
import com.tesda.model.DTO.TdgSchemaDTO;
import com.tesda.model.DTO.TestDataGenerateDTO;
import com.tesda.model.mapper.TdgOperationsMapper;
import com.tesda.service.TdgOperationsService;

@Component
@Service("tdgOperationsService")
@Transactional(propagation = Propagation.REQUIRED)
public class TdgOperationsServiceImpl extends TdgBaseServiceImpl implements TdgOperationsService{
	private static Logger logger = Logger.getLogger(TdgBaseServiceImpl.class);
	private static String strClassName = " [ TdgOperationsServiceImpl ] ";
	@Autowired
	TdgCustomDao tdgCustomDao;
	@Autowired
	TdgOperationsDao tdgOperationsDao;
	@Autowired
	TdgOperationsMapper tdgOperationsMapper;

	@Override
	public List<TdgSchemaDTO> getAllSchemaDetails(){
		String strMethodName = "  [ getAllSchemaDetails() ] ";
		logger.info(strClassName + strMethodName + " inside getAllSchemaDetails method");
		List<TdgSchemaDTO> listResult = null;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				listResult = tdgOperationsMapper.convertTdgSchemaDOToTdgSchemaDTO(tdgOperationsDao
						.fetchSchemaDetailsAll(managerentity));
				logger.info(strClassName + strMethodName
						+ " got the all schema details. The size of the object is : "
						+ listResult.size());
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return from getAllSchemaDetails method");
		return listResult;
	}

	@Override
	public List<TdgDynamicPageContentDTO> getAllSchemaDetailsForDynamicPage(){
		String strMethodName = "  [ getAllSchemaDetailsForDynamicPage() ] ";
		logger.info(strClassName + strMethodName
				+ " inside getAllSchemaDetailsForDynamicPage method");
		List<TdgDynamicPageContentDTO> listResult = new ArrayList<TdgDynamicPageContentDTO>();
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				List<TdgSchemaDO> lstTdgSchemaDO = tdgOperationsDao
						.fetchSchemaDetailsAll(managerentity);
				if (listResult != null) {
					for (TdgSchemaDO tdgSchemaDO : lstTdgSchemaDO) {
						List<String> lstColumnsNames = null;
						if (!StringUtils.isEmpty(tdgSchemaDO.getManualdictionary())) {
							lstColumnsNames = tdgOperationsDao.retrieveManualDictionaryColumns(
									tdgSchemaDO.getManualdictionary(), managerentity);
						}
						listResult.add(tdgOperationsMapper
								.convertTdgSchemaDOToTdgDynamicPageContentDTO(tdgSchemaDO,
										lstColumnsNames));
					}
				}
			}
			logger.info(strClassName + strMethodName
					+ " got the all schema details. The size of the object is : "
					+ listResult.size());
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return from getAllSchemaDetails method");
		return listResult;
	}

	@Override
	public String generateTestData(TestDataGenerateDTO testDataGenenarteDTO){
		String strMethodName = "  [ generateTestData() ] ";
		logger.info(strClassName + strMethodName + " inside generateTestData method");
		String strResult = null;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				strResult = tdgCustomDao.generateTestData(testDataGenenarteDTO, managerentity);
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return generateTestData method");
		return strResult;
	}

	@Override
	public TdgSchemaDTO getSchemaDetailsById(long lSelectedSchemaId){
		String strMethodName = "  [ getSchemaDetailsById() ] ";
		logger.info(strClassName + strMethodName + " inside getSchemaDetailsById method");
		TdgSchemaDTO tdgSchemaDTO = null;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				tdgSchemaDTO = tdgOperationsMapper
						.convertTdgSchemaDOToTdgSchemaDTO(tdgOperationsDao.fetchSchemaDetailsById(
								lSelectedSchemaId, managerentity).get(0));
				if (logger.isDebugEnabled())
					logger.debug(strClassName + strMethodName
							+ " got the schema related data is : " + tdgSchemaDTO);
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return from getSchemaDetailsById method");
		return tdgSchemaDTO;
	}

	@Override
	public TdgRequestListDTO getDashBoardDetails(long requestid, int offSet, int recordsperpage,
			boolean b){
		String strMethodName = "  [ getDashBoardDetails() ] ";
		logger.info(strClassName + strMethodName + " inside getDashBoardDetails method");
		TdgRequestListDTO tdgRequestListDTO = null;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				tdgRequestListDTO = tdgOperationsMapper
						.convertTdgRequestListDOToTdgRequestListDTO(tdgOperationsDao
								.getDashBoardDetails(requestid, offSet, recordsperpage, b,
										managerentity));
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return getDashBoardDetails method");
		return tdgRequestListDTO;
	}

	@Override
	public Long getReservedRecordsForRequestGeneratedCount(long lRequestId){
		String strMethodName = "  [ getReservedRecordsForRequestGeneratedCount() ] ";
		logger.info(strClassName + strMethodName
				+ " inside getReservedRecordsForRequestGeneratedCount method");
		long lResult = 0;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				lResult = tdgOperationsDao.getDashBoardRecordsCount(lRequestId, managerentity);
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName
				+ " return getReservedRecordsForRequestGeneratedCount method");
		return lResult;
	}

	@Override
	public String getDynamicDependentValues(long lSelectedSchemaId, String strComponentName,
			String strConditionvalue){
		String strMethodName = "  [ getReservedRecordsForRequestGeneratedCount() ] ";
		logger.info(strClassName + strMethodName
				+ " inside getReservedRecordsForRequestGeneratedCount method");
		String strResult = "";
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				strResult = tdgOperationsDao.getDynamicDependentValues(lSelectedSchemaId,
						strComponentName, strConditionvalue, managerentity);
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName
				+ " return getReservedRecordsForRequestGeneratedCount method");
		return strResult;
	}

	@Override
	public TdgRequestListDTO getDashBoardRequestedRecords(Long lRequestId){
		String strMethodName = "  [ getDashBoardRequestedRecords() ] ";
		logger.info(strClassName + strMethodName + " inside getDashBoardRequestedRecords method");
		EntityManager managerentity = null;
		TdgRequestListDTO tdgRequestListDTO = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				TdgRequestListDO tdgRequestListDO = tdgOperationsDao.getDashBoardRequestedRecords(
						lRequestId, managerentity);
				List<TdgGeneratedRequestDO> lstTdgGeneratedRequestDO = tdgOperationsDao
						.getGeneratedRequestData(lRequestId, managerentity);
				tdgRequestListDTO = tdgOperationsMapper.convertTdgRequestListDOToTdgRequestListDTO(
						tdgRequestListDO, lstTdgGeneratedRequestDO);
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName
				+ " return getReservedRecordsForRequestGeneratedCount method");
		return tdgRequestListDTO;
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
	public Map<String, Map<String, List<Object[]>>> generateFlatTestData(
			TestDataGenerateDTO testDataGenenarteDTO) {
		String strMethodName = "  [ generateFlatTestData() ] ";
		logger.info(strClassName + strMethodName + " inside generateFlatTestData method");
		Map<String, Map<String, List<Object[]>>> strResult = null;
		EntityManager managerentity = null;
		try {
			managerentity = openEntityManager();
			if (managerentity != null) {
				strResult = tdgCustomDao.generateFlatTestData(testDataGenenarteDTO, managerentity);
			}
		} finally {
			if (managerentity != null) {
				closeEntityManager(managerentity);
			}
		}
		logger.info(strClassName + strMethodName + " return generateFlatTestData method");
		return strResult;
	
	}
}
