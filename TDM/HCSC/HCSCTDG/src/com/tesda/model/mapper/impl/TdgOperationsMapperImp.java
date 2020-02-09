/*
 * Object Name : TdgOperationsMapperImp.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.mapper.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tesda.model.DO.TdgDataConditionalDO;
import com.tesda.model.DO.TdgGeneratedRequestDO;
import com.tesda.model.DO.TdgGuiDetailsDO;
import com.tesda.model.DO.TdgRequestListDO;
import com.tesda.model.DO.TdgSchemaDO;
import com.tesda.model.DTO.TdgDataConditionDTO;
import com.tesda.model.DTO.TdgDynamicGuiDTO;
import com.tesda.model.DTO.TdgDynamicPageContentDTO;
import com.tesda.model.DTO.TdgGuiDetailsDTO;
import com.tesda.model.DTO.TdgRequestListDTO;
import com.tesda.model.DTO.TdgSchemaDTO;
import com.tesda.model.mapper.TdgOperationsMapper;
import com.tesda.util.TdgCentralConstant;

@Component
@Service("tdgOperationsMapper")
public class TdgOperationsMapperImp implements TdgOperationsMapper{
	@Override
	public TdgSchemaDTO convertTdgSchemaDOToTdgSchemaDTO(TdgSchemaDO tdgSchemaDO){
		TdgSchemaDTO tdgSchemaDTO = new TdgSchemaDTO();
		Set<TdgGuiDetailsDTO> setTdgGuiDetailsDTO = new HashSet<TdgGuiDetailsDTO>();
		if (tdgSchemaDO != null) {
			tdgSchemaDTO.setPassword(tdgSchemaDO.getPassword());
			tdgSchemaDTO.setReqschemaid(tdgSchemaDO.getReqschemaid());
			tdgSchemaDTO.setSchemamastertables(tdgSchemaDO.getSchemamastertables());
			tdgSchemaDTO.setSeqtableprefix(tdgSchemaDO.getSeqtableprefix());
			tdgSchemaDTO.setUrl(tdgSchemaDO.getUrl());
			tdgSchemaDTO.setUsername(tdgSchemaDO.getUsername());
			tdgSchemaDTO.setUserid(tdgSchemaDO.getUserid());
			tdgSchemaDTO.setSchemaname(tdgSchemaDO.getSchemaname());
			tdgSchemaDTO.setColumnsdepends(tdgSchemaDO.getColumnsdepends());
			tdgSchemaDTO.setManualdictionary(tdgSchemaDO.getManualdictionary());
			tdgSchemaDTO.setSchemapasstabs(tdgSchemaDO.getSchemapasstabs());
			tdgSchemaDTO.setDateformate(tdgSchemaDO.getDateformate());
			tdgSchemaDTO.setBusinessrules(tdgSchemaDO.getBusinessrules());
			tdgSchemaDTO.setRequiredcolumns(tdgSchemaDO.getRequiredcolumns());
			Set<TdgGuiDetailsDO> setTdgGuiDetailsDO = tdgSchemaDO.getTdgGuiDetailsDOs();
			for (TdgGuiDetailsDO tdgGuiDetailsDO : setTdgGuiDetailsDO) {
				TdgGuiDetailsDTO tdgGuiDetailsDTO = new TdgGuiDetailsDTO();
				tdgGuiDetailsDTO.setColumnLabel(tdgGuiDetailsDO.getColumnLabel());
				tdgGuiDetailsDTO.setColumnname(tdgGuiDetailsDO.getColumnname());
				tdgGuiDetailsDTO.setColumnType(tdgGuiDetailsDO.getColumnType());
				tdgGuiDetailsDTO.setColumnValues(tdgGuiDetailsDO.getColumnValues());
				tdgGuiDetailsDTO.setTdgSchemaDTO(tdgSchemaDTO);
				tdgGuiDetailsDTO.setReqguiid(tdgGuiDetailsDO.getReqguiid());
				setTdgGuiDetailsDTO.add(tdgGuiDetailsDTO);
			}
			tdgSchemaDTO.setTdgGuiDetailsDTOs(setTdgGuiDetailsDTO);
		}
		return tdgSchemaDTO;
	}

	@Override
	public List<TdgSchemaDTO> convertTdgSchemaDOToTdgSchemaDTO(List<TdgSchemaDO> listtdgSchemaDO){
		List<TdgSchemaDTO> listTdgSchemaDTO = new ArrayList<TdgSchemaDTO>();
		for (TdgSchemaDO tdgSchemaDO : listtdgSchemaDO) {
			TdgSchemaDTO tdgSchemaDTO = new TdgSchemaDTO();
			Set<TdgGuiDetailsDTO> setTdgGuiDetailsDTO = new HashSet<TdgGuiDetailsDTO>();
			if (tdgSchemaDO != null) {
				tdgSchemaDTO.setPassword(tdgSchemaDO.getPassword());
				tdgSchemaDTO.setReqschemaid(tdgSchemaDO.getReqschemaid());
				tdgSchemaDTO.setSchemamastertables(tdgSchemaDO.getSchemamastertables());
				tdgSchemaDTO.setSeqtableprefix(tdgSchemaDO.getSeqtableprefix());
				tdgSchemaDTO.setUrl(tdgSchemaDO.getUrl());
				tdgSchemaDTO.setUsername(tdgSchemaDO.getUsername());
				tdgSchemaDTO.setUserid(tdgSchemaDO.getUserid());
				tdgSchemaDTO.setSchemaname(tdgSchemaDO.getSchemaname());
				tdgSchemaDTO.setColumnsdepends(tdgSchemaDO.getColumnsdepends());
				tdgSchemaDTO.setManualdictionary(tdgSchemaDO.getManualdictionary());
				tdgSchemaDTO.setSchemapasstabs(tdgSchemaDO.getSchemapasstabs());
				tdgSchemaDTO.setDateformate(tdgSchemaDO.getDateformate());
				tdgSchemaDTO.setBusinessrules(tdgSchemaDO.getBusinessrules());
				tdgSchemaDTO.setRequiredcolumns(tdgSchemaDO.getRequiredcolumns());
				Set<TdgGuiDetailsDO> setTdgGuiDetailsDO = tdgSchemaDO.getTdgGuiDetailsDOs();
				for (TdgGuiDetailsDO tdgGuiDetailsDO : setTdgGuiDetailsDO) {
					TdgGuiDetailsDTO tdgGuiDetailsDTO = new TdgGuiDetailsDTO();
					tdgGuiDetailsDTO.setColumnLabel(tdgGuiDetailsDO.getColumnLabel());
					tdgGuiDetailsDTO.setColumnname(tdgGuiDetailsDO.getColumnname());
					tdgGuiDetailsDTO.setColumnType(tdgGuiDetailsDO.getColumnType());
					tdgGuiDetailsDTO.setTdgSchemaDTO(tdgSchemaDTO);
					tdgGuiDetailsDTO.setReqguiid(tdgGuiDetailsDO.getReqguiid());
					tdgGuiDetailsDTO.setColumnValues(tdgGuiDetailsDO.getColumnValues());
					setTdgGuiDetailsDTO.add(tdgGuiDetailsDTO);
				}
				tdgSchemaDTO.setTdgGuiDetailsDTOs(setTdgGuiDetailsDTO);
			}
			listTdgSchemaDTO.add(tdgSchemaDTO);
		}
		return listTdgSchemaDTO;
	}

	@Override
	public TdgSchemaDO convertTdgSchemaDTOToTdgSchemaDO(TdgSchemaDTO tdgSchemaDTO){
		TdgSchemaDO tdgSchemaDO = new TdgSchemaDO();
		Set<TdgGuiDetailsDO> setTdgGuiDetailsDO = new HashSet<TdgGuiDetailsDO>();
		if (tdgSchemaDTO != null) {
			tdgSchemaDO.setPassword(tdgSchemaDTO.getPassword());
			tdgSchemaDO.setReqschemaid(tdgSchemaDTO.getReqschemaid());
			tdgSchemaDO.setSchemamastertables(tdgSchemaDTO.getSchemamastertables());
			tdgSchemaDO.setSeqtableprefix(tdgSchemaDTO.getSeqtableprefix());
			tdgSchemaDO.setUrl(tdgSchemaDTO.getUrl());
			tdgSchemaDO.setUsername(tdgSchemaDTO.getUsername());
			tdgSchemaDO.setUserid(tdgSchemaDTO.getUserid());
			tdgSchemaDO.setSchemaname(tdgSchemaDTO.getSchemaname());
			tdgSchemaDO.setColumnsdepends(tdgSchemaDTO.getColumnsdepends());
			tdgSchemaDO.setManualdictionary(tdgSchemaDTO.getManualdictionary());
			tdgSchemaDO.setSchemapasstabs(tdgSchemaDTO.getSchemapasstabs());
			tdgSchemaDO.setDateformate(tdgSchemaDTO.getDateformate());
			tdgSchemaDO.setBusinessrules(tdgSchemaDTO.getBusinessrules());
			tdgSchemaDO.setRequiredcolumns(tdgSchemaDTO.getRequiredcolumns());
			Set<TdgGuiDetailsDTO> setTdgGuiDetailsDTO = tdgSchemaDTO.getTdgGuiDetailsDTOs();
			for (TdgGuiDetailsDTO tdgGuiDetailsDTO : setTdgGuiDetailsDTO) {
				TdgGuiDetailsDO tdgGuiDetailsDO = new TdgGuiDetailsDO();
				tdgGuiDetailsDO.setColumnLabel(tdgGuiDetailsDTO.getColumnLabel());
				tdgGuiDetailsDO.setColumnname(tdgGuiDetailsDTO.getColumnname());
				tdgGuiDetailsDO.setColumnType(tdgGuiDetailsDTO.getColumnType());
				tdgGuiDetailsDO.setColumnValues(tdgGuiDetailsDTO.getColumnValues());
				tdgGuiDetailsDO.setTdgSchemaDO(tdgSchemaDO);
				tdgGuiDetailsDO.setReqguiid(tdgGuiDetailsDO.getReqguiid());
				setTdgGuiDetailsDO.add(tdgGuiDetailsDO);
			}
			tdgSchemaDO.setTdgGuiDetailsDOs(setTdgGuiDetailsDO);
		}
		return tdgSchemaDO;
	}

	@Override
	public List<TdgSchemaDO> convertTdgSchemaDTOToTdgSchemaDO(List<TdgSchemaDTO> listTdgSchemaDTO){
		List<TdgSchemaDO> listTdgSchemaDo = new ArrayList<TdgSchemaDO>();
		for (TdgSchemaDTO tdgSchemaDTO : listTdgSchemaDTO) {
			TdgSchemaDO tdgSchemaDO = new TdgSchemaDO();
			Set<TdgGuiDetailsDO> setTdgGuiDetailsDO = new HashSet<TdgGuiDetailsDO>();
			if (tdgSchemaDTO != null) {
				tdgSchemaDO.setPassword(tdgSchemaDTO.getPassword());
				tdgSchemaDO.setReqschemaid(tdgSchemaDTO.getReqschemaid());
				tdgSchemaDO.setSchemamastertables(tdgSchemaDTO.getSchemamastertables());
				tdgSchemaDO.setSeqtableprefix(tdgSchemaDTO.getSeqtableprefix());
				tdgSchemaDO.setUrl(tdgSchemaDTO.getUrl());
				tdgSchemaDO.setUsername(tdgSchemaDTO.getUsername());
				tdgSchemaDO.setUserid(tdgSchemaDTO.getUserid());
				tdgSchemaDO.setSchemaname(tdgSchemaDTO.getSchemaname());
				tdgSchemaDO.setColumnsdepends(tdgSchemaDTO.getColumnsdepends());
				tdgSchemaDO.setManualdictionary(tdgSchemaDTO.getManualdictionary());
				tdgSchemaDO.setSchemapasstabs(tdgSchemaDTO.getSchemapasstabs());
				tdgSchemaDO.setDateformate(tdgSchemaDTO.getDateformate());
				tdgSchemaDO.setBusinessrules(tdgSchemaDTO.getBusinessrules());
				tdgSchemaDO.setRequiredcolumns(tdgSchemaDTO.getRequiredcolumns());
				Set<TdgGuiDetailsDTO> setTdgGuiDetailsDTO = tdgSchemaDTO.getTdgGuiDetailsDTOs();
				for (TdgGuiDetailsDTO tdgGuiDetailsDTO : setTdgGuiDetailsDTO) {
					TdgGuiDetailsDO tdgGuiDetailsDO = new TdgGuiDetailsDO();
					tdgGuiDetailsDO.setColumnLabel(tdgGuiDetailsDTO.getColumnLabel());
					tdgGuiDetailsDO.setColumnname(tdgGuiDetailsDTO.getColumnname());
					tdgGuiDetailsDO.setColumnType(tdgGuiDetailsDTO.getColumnType());
					tdgGuiDetailsDO.setColumnValues(tdgGuiDetailsDTO.getColumnValues());
					tdgGuiDetailsDO.setTdgSchemaDO(tdgSchemaDO);
					tdgGuiDetailsDO.setReqguiid(tdgGuiDetailsDO.getReqguiid());
					setTdgGuiDetailsDO.add(tdgGuiDetailsDO);
				}
				tdgSchemaDO.setTdgGuiDetailsDOs(setTdgGuiDetailsDO);
			}
			listTdgSchemaDo.add(tdgSchemaDO);
		}
		return listTdgSchemaDo;
	}

	@Override
	public TdgRequestListDO convertTdgRequestListDTOToTdgRequestListDO(
			TdgRequestListDTO tdgRequestListDTO){
		TdgRequestListDO tdgRequestListDO = new TdgRequestListDO();
		if (tdgRequestListDTO != null) {
			tdgRequestListDO.setConditions(tdgRequestListDTO.getConditions());
			tdgRequestListDO.setReqschemaid(tdgRequestListDTO.getReqschemaid());
			tdgRequestListDO.setRequestCount(tdgRequestListDTO.getRequestCount());
			tdgRequestListDO.setRequestid(tdgRequestListDTO.getRequestid());
			tdgRequestListDO.setUserid(tdgRequestListDTO.getUserid());
			tdgRequestListDO.setSchemaname(tdgRequestListDTO.getSchemaname());
			tdgRequestListDO.setStatus(tdgRequestListDTO.getStatus());
			tdgRequestListDO.setStatusdescription(tdgRequestListDTO.getStatusdescription());
			tdgRequestListDO.setFlatFilesPath(tdgRequestListDTO.getFlatFilesPath());
			tdgRequestListDO.setGenerationType(tdgRequestListDTO.getGenerationType());
			tdgRequestListDO.setRequiredcolumns(tdgRequestListDTO.getRequiredcolumns());
		}
		return tdgRequestListDO;
	}

	@Override
	public TdgRequestListDTO convertTdgRequestListDOToTdgRequestListDTO(
			TdgRequestListDO tdgRequestListDO){
		TdgRequestListDTO tdgRequestListDTO = new TdgRequestListDTO();
		if (tdgRequestListDO != null) {
			tdgRequestListDTO.setConditions(tdgRequestListDO.getConditions());
			tdgRequestListDTO.setReqschemaid(tdgRequestListDO.getReqschemaid());
			tdgRequestListDTO.setRequestCount(tdgRequestListDO.getRequestCount());
			tdgRequestListDTO.setRequestid(tdgRequestListDO.getRequestid());
			tdgRequestListDTO.setUserid(tdgRequestListDO.getUserid());
			tdgRequestListDTO.setSchemaname(tdgRequestListDO.getSchemaname());
			tdgRequestListDTO.setStatus(tdgRequestListDO.getStatus());
			tdgRequestListDTO.setStatusdescription(tdgRequestListDO.getStatusdescription());
			tdgRequestListDTO.setFlatFilesPath(tdgRequestListDO.getFlatFilesPath());
			tdgRequestListDTO.setGenerationType(tdgRequestListDO.getGenerationType());
			tdgRequestListDTO.setRequiredcolumns(tdgRequestListDO.getRequiredcolumns());
		}
		return tdgRequestListDTO;
	}

	@Override
	public TdgRequestListDTO convertTdgRequestListDOToTdgRequestListDTO(
			List<TdgRequestListDO> listTdgRequestListDO){
		TdgRequestListDTO tdgRequestListDTOs = new TdgRequestListDTO();
		List<TdgRequestListDTO> listTdgRequestListDTO = new ArrayList<TdgRequestListDTO>();
		for (TdgRequestListDO tdgRequestListDO : listTdgRequestListDO) {
			listTdgRequestListDTO.add(convertTdgRequestListDOToTdgRequestListDTO(tdgRequestListDO));
			tdgRequestListDTOs.setListTdgRequestListDTO(listTdgRequestListDTO);
		}
		return tdgRequestListDTOs;
	}

	@Override
	public List<TdgDynamicPageContentDTO> convertTdgSchemaDOToTdgDynamicPageContentDTO(
			List<TdgSchemaDO> listTdgSchemaDO){
		List<TdgDynamicPageContentDTO> listTdgDynamicContentDTO = new ArrayList<TdgDynamicPageContentDTO>();
		for (TdgSchemaDO tdgSchemaDO : listTdgSchemaDO) {
			TdgDynamicPageContentDTO tdgDynamicContentDTO = new TdgDynamicPageContentDTO();
			List<TdgDynamicGuiDTO> setTdgGuiDetailsDTO = new ArrayList<TdgDynamicGuiDTO>();
			List<TdgDynamicGuiDTO> setForDependsTdgGuiDetailsDTO = new ArrayList<TdgDynamicGuiDTO>();
			if (tdgSchemaDO != null) {
				tdgDynamicContentDTO.setPassword(tdgSchemaDO.getPassword());
				tdgDynamicContentDTO.setName(tdgSchemaDO.getUsername());
				tdgDynamicContentDTO.setUrl(tdgSchemaDO.getUrl());
				tdgDynamicContentDTO.setSchemaId(tdgSchemaDO.getReqschemaid());
				tdgDynamicContentDTO.setSchemaname(tdgSchemaDO.getSchemaname());
				tdgDynamicContentDTO.setSeqtableprefix(tdgSchemaDO.getSeqtableprefix());
				tdgDynamicContentDTO.setSchemamastertables(tdgSchemaDO.getSchemamastertables());
				tdgDynamicContentDTO.setColumnsdepends(tdgSchemaDO.getColumnsdepends());
				tdgDynamicContentDTO.setManualdictionary(tdgSchemaDO.getManualdictionary());
				tdgDynamicContentDTO.setSchemapasstabs(tdgSchemaDO.getSchemapasstabs());
				tdgDynamicContentDTO.setDateformate(tdgSchemaDO.getDateformate());
				tdgDynamicContentDTO.setBusinessrules(tdgSchemaDO.getBusinessrules());
				tdgDynamicContentDTO.setRequiredcolumns(tdgSchemaDO.getRequiredcolumns());
				if (tdgSchemaDO.getUrl() != null
						&& tdgSchemaDO.getUrl().toUpperCase()
								.contains(TdgCentralConstant.DB_TYPE_ORACLE.toUpperCase())) {
					tdgDynamicContentDTO.setDbType(TdgCentralConstant.DB_TYPE_ORACLE);
				} else if (tdgSchemaDO.getUrl() != null
						&& tdgSchemaDO.getUrl().toUpperCase()
								.contains(TdgCentralConstant.DB_TYPE_MYSQL.toUpperCase())) {
					tdgDynamicContentDTO.setDbType(TdgCentralConstant.DB_TYPE_MYSQL);
				} else if (tdgSchemaDO.getUrl() != null
						&& tdgSchemaDO.getUrl().toUpperCase()
								.contains(TdgCentralConstant.DB_TYPE_DB2.toUpperCase())) {
					tdgDynamicContentDTO.setDbType(TdgCentralConstant.DB_TYPE_DB2);
				}else if (tdgSchemaDO.getUrl() != null
						&& tdgSchemaDO.getUrl().toUpperCase()
						.contains(TdgCentralConstant.DB_TYPE_SQLSERVER.toUpperCase())) {
			tdgDynamicContentDTO.setDbType(TdgCentralConstant.DB_TYPE_SQLSERVER);
		}
				Set<TdgGuiDetailsDO> setTdgGuiDetailsDO = tdgSchemaDO.getTdgGuiDetailsDOs();
				for (TdgGuiDetailsDO tdgGuiDetailsDO : setTdgGuiDetailsDO) {
					TdgDynamicGuiDTO tdgDynamicGuiDTO = new TdgDynamicGuiDTO();
					tdgDynamicGuiDTO.setColumnLabel(tdgGuiDetailsDO.getColumnLabel());
					tdgDynamicGuiDTO.setColumnName(tdgGuiDetailsDO.getColumnname());
					tdgDynamicGuiDTO.setColumnType(tdgGuiDetailsDO.getColumnType());
					tdgDynamicGuiDTO.setColumnValues(tdgGuiDetailsDO.getColumnValues());
					if (tdgGuiDetailsDO.getColumnValues() == null) {
						setTdgGuiDetailsDTO.add(tdgDynamicGuiDTO);
					}
					if (tdgGuiDetailsDO.getColumnValues() != null
							&& !tdgGuiDetailsDO.getColumnValues().contains("DEPENDS_ON")) {
						String[] strSplits = tdgGuiDetailsDO.getColumnValues() != null ? tdgGuiDetailsDO
								.getColumnValues().split(",") : null;
						Map<String, String> mapVals = new HashMap<String, String>();
						if (strSplits != null) {
							for (int i = 0; i < strSplits.length; i++) {
								String[] strSplVals = strSplits[i].split(":");
								if (strSplVals.length == 2)
									mapVals.put(
											strSplVals[0],
											strSplVals[1].contains(";") ? strSplVals[1].substring(
													0, strSplVals[1].indexOf(";")) : strSplVals[1]);
								if (strSplVals.length == 1)
									mapVals.put(strSplVals[0], "");
							}
						}
						tdgDynamicGuiDTO.setMapValues(mapVals);
						setTdgGuiDetailsDTO.add(tdgDynamicGuiDTO);
					}
					if (tdgGuiDetailsDO.getColumnValues() != null
							&& tdgGuiDetailsDO.getColumnValues().contains("DEPENDS_ON")) {
						StringBuffer strValue = new StringBuffer(
								tdgDynamicContentDTO.getDependevalues() != null ? tdgDynamicContentDTO
										.getDependevalues() + ","
										: "");
						String strSplit[] = tdgGuiDetailsDO.getColumnValues().split("#");
						strValue.append(tdgGuiDetailsDO.getColumnname()).append('=')
								.append(strSplit[1]);
						tdgDynamicContentDTO.setDependevalues(strValue.toString().substring(0,
								strValue.toString().length() - 1));
						setForDependsTdgGuiDetailsDTO.add(tdgDynamicGuiDTO);
					}
				}
				setTdgGuiDetailsDTO.addAll(setForDependsTdgGuiDetailsDTO);
				tdgDynamicContentDTO.setListDynamicPojo(setTdgGuiDetailsDTO);
			}
			listTdgDynamicContentDTO.add(tdgDynamicContentDTO);
		}
		return listTdgDynamicContentDTO;
	}

	@Override
	public TdgDynamicPageContentDTO convertTdgSchemaDOToTdgDynamicPageContentDTO(
			TdgSchemaDO tdgSchemaDO, List<String> listManualDictionaryValues){
		TdgDynamicPageContentDTO tdgDynamicContentDTO = new TdgDynamicPageContentDTO();
		List<TdgDynamicGuiDTO> setTdgGuiDetailsDTO = new ArrayList<TdgDynamicGuiDTO>();
		List<TdgDynamicGuiDTO> setForDependsTdgGuiDetailsDTO = new ArrayList<TdgDynamicGuiDTO>();
		if (tdgSchemaDO != null) {
			tdgDynamicContentDTO.setPassword(tdgSchemaDO.getPassword());
			tdgDynamicContentDTO.setName(tdgSchemaDO.getUsername());
			tdgDynamicContentDTO.setUrl(tdgSchemaDO.getUrl());
			tdgDynamicContentDTO.setSchemaId(tdgSchemaDO.getReqschemaid());
			tdgDynamicContentDTO.setSchemaname(tdgSchemaDO.getSchemaname());
			tdgDynamicContentDTO.setSeqtableprefix(tdgSchemaDO.getSeqtableprefix());
			tdgDynamicContentDTO.setSchemamastertables(tdgSchemaDO.getSchemamastertables());
			tdgDynamicContentDTO.setColumnsdepends(tdgSchemaDO.getColumnsdepends());
			tdgDynamicContentDTO.setManualdictionary(tdgSchemaDO.getManualdictionary());
			tdgDynamicContentDTO.setSchemapasstabs(tdgSchemaDO.getSchemapasstabs());
			tdgDynamicContentDTO.setDateformate(tdgSchemaDO.getDateformate());
			tdgDynamicContentDTO.setBusinessrules(tdgSchemaDO.getBusinessrules());
			tdgDynamicContentDTO.setRequiredcolumns(tdgSchemaDO.getRequiredcolumns());
			if (tdgSchemaDO.getUrl() != null
					&& tdgSchemaDO.getUrl().toUpperCase()
							.contains(TdgCentralConstant.DB_TYPE_ORACLE.toUpperCase())) {
				tdgDynamicContentDTO.setDbType(TdgCentralConstant.DB_TYPE_ORACLE);
			} else if (tdgSchemaDO.getUrl() != null
					&& tdgSchemaDO.getUrl().toUpperCase()
							.contains(TdgCentralConstant.DB_TYPE_MYSQL.toUpperCase())) {
				tdgDynamicContentDTO.setDbType(TdgCentralConstant.DB_TYPE_MYSQL);
			} else if (tdgSchemaDO.getUrl() != null
					&& tdgSchemaDO.getUrl().toUpperCase()
							.contains(TdgCentralConstant.DB_TYPE_DB2.toUpperCase())) {
				tdgDynamicContentDTO.setDbType(TdgCentralConstant.DB_TYPE_DB2);
			}else if (tdgSchemaDO.getUrl() != null
					&& tdgSchemaDO.getUrl().toUpperCase()
					.contains(TdgCentralConstant.DB_TYPE_SQLSERVER.toUpperCase())) {
		tdgDynamicContentDTO.setDbType(TdgCentralConstant.DB_TYPE_SQLSERVER);
	}
			Set<TdgGuiDetailsDO> setTdgGuiDetailsDO = tdgSchemaDO.getTdgGuiDetailsDOs();
			for (TdgGuiDetailsDO tdgGuiDetailsDO : setTdgGuiDetailsDO) {
				TdgDynamicGuiDTO tdgDynamicGuiDTO = new TdgDynamicGuiDTO();
				tdgDynamicGuiDTO.setColumnLabel(tdgGuiDetailsDO.getColumnLabel());
				tdgDynamicGuiDTO.setColumnName(tdgGuiDetailsDO.getColumnname());
				tdgDynamicGuiDTO.setColumnType(tdgGuiDetailsDO.getColumnType());
				tdgDynamicGuiDTO.setColumnValues(tdgGuiDetailsDO.getColumnValues());
				if (listManualDictionaryValues != null
						&& listManualDictionaryValues.contains(tdgGuiDetailsDO.getColumnname())) {
					tdgDynamicGuiDTO.setManualDictionaryContains(true);
				}
				if (tdgGuiDetailsDO.getColumnValues() == null) {
					setTdgGuiDetailsDTO.add(tdgDynamicGuiDTO);
				}
				if (tdgGuiDetailsDO.getColumnValues() != null
						&& !tdgGuiDetailsDO.getColumnValues().contains("DEPENDS_ON")) {
					String[] strSplits = tdgGuiDetailsDO.getColumnValues() != null ? tdgGuiDetailsDO
							.getColumnValues().split(",") : null;
					Map<String, String> mapVals = new HashMap<String, String>();
					if (strSplits != null) {
						for (int i = 0; i < strSplits.length; i++) {
							String[] strSplVals = strSplits[i].split(":");
							if (strSplVals.length == 2)
								mapVals.put(
										strSplVals[0],
										strSplVals[1].contains(";") ? strSplVals[1].substring(0,
												strSplVals[1].indexOf(";")) : strSplVals[1]);
							if (strSplVals.length == 1)
								mapVals.put(strSplVals[0], "");
						}
					}
					tdgDynamicGuiDTO.setMapValues(mapVals);
					setTdgGuiDetailsDTO.add(tdgDynamicGuiDTO);
				}
				if (tdgGuiDetailsDO.getColumnValues() != null
						&& tdgGuiDetailsDO.getColumnValues().contains("DEPENDS_ON")) {
					StringBuffer strValue = new StringBuffer(
							tdgDynamicContentDTO.getDependevalues() != null ? tdgDynamicContentDTO
									.getDependevalues() + "," : "");
					String strSplit[] = tdgGuiDetailsDO.getColumnValues().split("#");
					strValue.append(tdgGuiDetailsDO.getColumnname()).append('=')
							.append(strSplit[1]);
					tdgDynamicContentDTO.setDependevalues(strValue.toString().substring(0,
							strValue.toString().length() - 1));
					setForDependsTdgGuiDetailsDTO.add(tdgDynamicGuiDTO);
				}
			}
			setTdgGuiDetailsDTO.addAll(setForDependsTdgGuiDetailsDTO);
			tdgDynamicContentDTO.setListDynamicPojo(setTdgGuiDetailsDTO);
		}
		return tdgDynamicContentDTO;
	}

	@Override
	public TdgRequestListDTO convertTdgRequestListDOToTdgRequestListDTO(
			TdgRequestListDO tdgRequestListDO, List<TdgGeneratedRequestDO> lstTdgGeneratedRequestDO){
		TdgRequestListDTO tdgRequestListDTO = new TdgRequestListDTO();
		if (tdgRequestListDO != null && lstTdgGeneratedRequestDO != null
				&& !lstTdgGeneratedRequestDO.isEmpty()) {
			tdgRequestListDTO = convertTdgRequestListDOToTdgRequestListDTO(tdgRequestListDO);
			List<List<String>> lstStringVals = new ArrayList<List<String>>();
			for (TdgGeneratedRequestDO tdgGeneratedRequestDO : lstTdgGeneratedRequestDO) {
				List<String> listVals = new ArrayList<String>();
				for (int i = 1; i <= 30; i++) {
					try {
						if (!StringUtils.isEmpty(BeanUtils.getProperty(tdgGeneratedRequestDO,
								"column" + i))) {
							listVals.add(BeanUtils.getProperty(tdgGeneratedRequestDO, "column" + i));
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
					} catch (NoSuchMethodException e) {
					}
				}
				lstStringVals.add(listVals);
			}
			tdgRequestListDTO.setListGeneratedData(lstStringVals);
		}
		return tdgRequestListDTO;
	}

	@Override
	public List<TdgDataConditionDTO> convertTdgDataConditionDOToTdgDataConditionDTO(
			List<TdgDataConditionalDO> fetchDataConditionalDetailsAll){
		List<TdgDataConditionDTO> tdgDataConditionDTO = new ArrayList<TdgDataConditionDTO>();
		if (fetchDataConditionalDetailsAll != null && !fetchDataConditionalDetailsAll.isEmpty()) {
			for (TdgDataConditionalDO tdgDataConditionalDO : fetchDataConditionalDetailsAll) {
				tdgDataConditionDTO
						.add(convertTdgDataConditionDOToTdgDataConditionDTO(tdgDataConditionalDO));
			}
		}
		return tdgDataConditionDTO;
	}

	@Override
	public TdgDataConditionDTO convertTdgDataConditionDOToTdgDataConditionDTO(
			TdgDataConditionalDO dataConditionalDetails){
		TdgDataConditionDTO tdgDataConditionDTO = new TdgDataConditionDTO();
		if (dataConditionalDetails != null) {
			tdgDataConditionDTO.setId(dataConditionalDetails.getId());
			tdgDataConditionDTO.setPassword(dataConditionalDetails.getPassword());
			tdgDataConditionDTO.setTablename(dataConditionalDetails.getTablename());
			tdgDataConditionDTO.setUrl(dataConditionalDetails.getUrl());
			tdgDataConditionDTO.setUserid(dataConditionalDetails.getUserid());
			tdgDataConditionDTO.setUsername(dataConditionalDetails.getUsername());
		}
		return tdgDataConditionDTO;
	}
}
