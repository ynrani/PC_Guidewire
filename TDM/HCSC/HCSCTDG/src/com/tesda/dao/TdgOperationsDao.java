/*
 * Object Name : TdgOperationsDao.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.tesda.model.DO.TdgDataConditionalDO;
import com.tesda.model.DO.TdgGeneratedRequestDO;
import com.tesda.model.DO.TdgRequestListDO;
import com.tesda.model.DO.TdgSchemaDO;
import com.tesda.model.DTO.TdgDataConditionDTO;

public interface TdgOperationsDao{
	String saveSchemaDetails(TdgSchemaDO tdgSchemaDO, EntityManager managerEntity);

	List<TdgSchemaDO> fetchSchemaDetailsAll(EntityManager managerentity);

	List<TdgSchemaDO> fetchSchemaDetailsById(Long schemaId, EntityManager managerEntity);

	List<TdgRequestListDO> fetchRequestListAll(EntityManager managerEntity);

	List<TdgRequestListDO> fetchDashBoardListDetails(long lRequestId, EntityManager managerEntity);

	List<TdgRequestListDO> fetchDashBoardListDetails(EntityManager managerEntity);

	String saveDashBoardDetails(TdgRequestListDO tdgRequestListDO,
			Map<String, List<String>> mapConditionValues, EntityManager managerEntity);

	Long getDashBoardRecordsCount(long lRequestId, EntityManager managerEntity);

	List<TdgRequestListDO> getDashBoardDetails(long requestid, int offSet, int recordsperpage,
			boolean b, EntityManager managerentity);

	String getDynamicDependentValues(long lSelectedSchemaId, String strComponentName,
			String strConditionvalue, EntityManager managerentity);

	TdgRequestListDO getDashBoardRequestedRecords(long lRequestId, EntityManager managerEntity);

	Long getTdgDataDictionaryRecordsCount(EntityManager managerentity);

	List<TdgSchemaDO> getTdgMasterDictionaryRecordsForPagination(EntityManager managerentity,
			int offSet, int recordsperpage, boolean b);

	String saveManualDictionaryDetails(String strTabName, Map<String, List<String>> mapExcelValues,
			EntityManager managerEntity, String schemaId);

	String dropManualDictionaryDetails(String strTabName, EntityManager managerEntity);

	void doDumpManualDictionaryValues(String strTabName, Map<String, List<String>> mapExcelValues,
			EntityManager managerEntity);

	List<String> retrieveManualDictionaryColumns(String strTabName, EntityManager entityManager);

	Map<String, List<String>> retrieveManualDictionaryValues(String strTabName,
			EntityManager entityManager);

	String saveDataConditionalDetails(TdgDataConditionDTO tdgDataConditionDTO,
			EntityManager managerEntity);

	List<TdgDataConditionalDO> fetchDataConditionalDetailsAll(EntityManager managerEntity);

	List<TdgGeneratedRequestDO> getGeneratedRequestData(Long lRequestId, EntityManager managerentity);

	List<TdgDataConditionalDO> fetchDataConditionalDetailsAll(long requestid, int offSet,
			int recordsperpage, boolean b, EntityManager managerentity);

	Long totalDataConditionalDetailsAll(EntityManager managerEntity);

	TdgDataConditionalDO fetchDataConditionalById(Long id, EntityManager managerEntity);

	void deleteTdgDataConditionalDetails(String id, EntityManager managerentity);

	void doDeleteDataConditionalValues(List<String> lstTabName, long iRownum,
			EntityManager entityManager);
}
