/*
 * Object Name : TdgOperationsService.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.service;

import java.util.List;
import java.util.Map;

import com.tesda.model.DTO.TdgDynamicPageContentDTO;
import com.tesda.model.DTO.TdgRequestListDTO;
import com.tesda.model.DTO.TdgSchemaDTO;
import com.tesda.model.DTO.TestDataGenerateDTO;

public interface TdgOperationsService{
	/**
	 * This method is used to fetch all schema details which is being in.
	 * @return list of TdgSchemaDTO
	 */
	List<TdgSchemaDTO> getAllSchemaDetails();

	/**
	 * This method is used to generate the DTO in front end pages understand format for dynamic
	 * pages
	 * based on fetch details of schema details
	 * @return list of TdgDynamicPageContentDTO
	 */
	List<TdgDynamicPageContentDTO> getAllSchemaDetailsForDynamicPage();

	/**
	 * This method is used to generate the data in respective databases.
	 * @param testDataGenenarteDTO
	 * @return success or failure message
	 */
	String generateTestData(TestDataGenerateDTO testDataGenenarteDTO);

	/**
	 * Used to fetch TdgSchemaDTO details based on schema id's
	 * @param lSelectedSchemaId
	 * @return TdgSchemaDTO
	 */
	TdgSchemaDTO getSchemaDetailsById(long lSelectedSchemaId);

	/**
	 * This method is used to fetch all the data which is being process for generate the data
	 * @param requestid
	 * @param offSet
	 * @param recordsperpage
	 * @param b
	 * @return TdgRequestListDTO object
	 */
	TdgRequestListDTO getDashBoardDetails(long requestid, int offSet, int recordsperpage, boolean b);

	/**
	 * This method used to fetch all records count from server which is being under dash board for
	 * pagination purpose
	 * @param l
	 * @return Long object
	 */
	Long getReservedRecordsForRequestGeneratedCount(long l);

	/**
	 * This method is used to fetch dependent values of respective columns for dynamic values on
	 * front end
	 * @param lSelectedSchemaId
	 * @param strComponentName
	 * @param strConditionvalue
	 * @return String object which specific format which is being understand by front end
	 */
	String getDynamicDependentValues(long lSelectedSchemaId, String strComponentName,
			String strConditionvalue);

	/**
	 * This method is used to fetch specific request id related dash board records.
	 * @param valueOf
	 * @return
	 */
	TdgRequestListDTO getDashBoardRequestedRecords(Long valueOf);

	/**
	 * This method is used to fetch all the dictionary related column values
	 * @param strDictionaryName
	 * @return
	 */
	Map<String, List<String>> retrieveManualDictionaryValues(String strDictionaryName);

	Map<String, Map<String, List<Object[]>>> generateFlatTestData(
			TestDataGenerateDTO testDataGenenarteDTO);
}
