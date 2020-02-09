/*
 * Object Name : TdgOperationsMapper.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.mapper;

import java.util.List;

import com.tesda.model.DO.TdgDataConditionalDO;
import com.tesda.model.DO.TdgGeneratedRequestDO;
import com.tesda.model.DO.TdgRequestListDO;
import com.tesda.model.DO.TdgSchemaDO;
import com.tesda.model.DTO.TdgDataConditionDTO;
import com.tesda.model.DTO.TdgDynamicPageContentDTO;
import com.tesda.model.DTO.TdgRequestListDTO;
import com.tesda.model.DTO.TdgSchemaDTO;

public interface TdgOperationsMapper{
	TdgSchemaDO convertTdgSchemaDTOToTdgSchemaDO(TdgSchemaDTO tdgSchemaDTO);

	TdgRequestListDO convertTdgRequestListDTOToTdgRequestListDO(TdgRequestListDTO tdgRequestListDTO);

	TdgRequestListDTO convertTdgRequestListDOToTdgRequestListDTO(TdgRequestListDO tdgRequestListDO);

	List<TdgSchemaDO> convertTdgSchemaDTOToTdgSchemaDO(List<TdgSchemaDTO> listTdgSchemaDTO);

	List<TdgSchemaDTO> convertTdgSchemaDOToTdgSchemaDTO(List<TdgSchemaDO> listtdgSchemaDO);

	TdgRequestListDTO convertTdgRequestListDOToTdgRequestListDTO(
			List<TdgRequestListDO> listTdgRequestListDO);

	List<TdgDynamicPageContentDTO> convertTdgSchemaDOToTdgDynamicPageContentDTO(
			List<TdgSchemaDO> listTdgSchemaDO);

	TdgSchemaDTO convertTdgSchemaDOToTdgSchemaDTO(TdgSchemaDO tdgSchemaDO);

	TdgDynamicPageContentDTO convertTdgSchemaDOToTdgDynamicPageContentDTO(TdgSchemaDO tdgSchemaDO,
			List<String> listManualDictionaryValues);

	TdgRequestListDTO convertTdgRequestListDOToTdgRequestListDTO(TdgRequestListDO tdgRequestListDO,
			List<TdgGeneratedRequestDO> lstTdgGeneratedRequestDO);

	List<TdgDataConditionDTO> convertTdgDataConditionDOToTdgDataConditionDTO(
			List<TdgDataConditionalDO> fetchDataConditionalDetailsAll);

	TdgDataConditionDTO convertTdgDataConditionDOToTdgDataConditionDTO(
			TdgDataConditionalDO fetchDataConditionalById);
}
