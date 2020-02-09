/*
 * Object Name : TdgOperationsController.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tesda.model.DTO.TdgDynamicGuiDTO;
import com.tesda.model.DTO.TdgDynamicPageContentDTO;
import com.tesda.model.DTO.TdgRequestListDTO;
import com.tesda.model.DTO.TestDataGenerateDTO;
import com.tesda.service.TdgOperationsService;
import com.tesda.util.CSVGenerator;
import com.tesda.util.PaginationUtil;
import com.tesda.util.TdgCentralConstant;

@Controller
public class TdgOperationsController{
	private static Logger logger = Logger.getLogger(TdgOperationsController.class);
	private static String strClassName = " [ TdgOperationsController ] ";
	@Resource(name = "tdgOperationsService")
	TdgOperationsService tdgOperationsService;

	@RequestMapping(value = "/tdgOperationsDetails", method = RequestMethod.GET)
	public String generateDataDetails(
			@ModelAttribute("dynamicPageContent") TdgDynamicPageContentDTO dynamicPageContent,
			ModelMap model, HttpServletRequest request, HttpServletResponse response){
		String strMethodName = " [ schemaDetails() ]";
		logger.info(strClassName + strMethodName + " inside of schemaDetails get method ");
		List<TdgDynamicPageContentDTO> listDynamicPageContentDTO = tdgOperationsService
				.getAllSchemaDetailsForDynamicPage();
		model.addAttribute("requestList", listDynamicPageContentDTO);
		logger.info(strClassName + strMethodName + " return from schemaDetails method ");
		return "tdgOperationsDetails";
	}

	/*@RequestMapping(value = "/tdgOperationsDetails", method = RequestMethod.POST)
	public @ResponseBody String generateDataDetails(
			@RequestParam(required = false, value = "reqVals") String reqVals, ModelMap model,
			@ModelAttribute("dynamicPageContent") TdgDynamicPageContentDTO dynamicPageContent,
			HttpServletRequest request, HttpServletResponse response){
		String strMethodName = " [ schemaDetails() ]";
		logger.info(strClassName + strMethodName + " inside of schemaDetails post method ");
		String strRequestValues = request.getParameter("reqVals");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = user.getUsername();
		StringBuffer strSuccess = new StringBuffer("");
		List<TdgDynamicPageContentDTO> listDynamicPageContentDTO = null;
		long lSelectedSchemaId = 0;
		long lRequestedCount = 0;
		String strCountValue = "";
		List<String> lstDictionaryCols = new ArrayList<String>();
		String strGenerationType = "";
		
		if (strRequestValues != null && strRequestValues.contains("*")) {
			String[] strParentSplit = strRequestValues.split("\\*");
			Map<String, Object> mapConditions = new HashMap<String, Object>();
			Map<String, Object> mapConditionsPassed = new HashMap<String, Object>();
			for (int i = 0; i < strParentSplit.length; i++) {
				if (strParentSplit[i].contains(":")) {
					String[] strChildSplit = strParentSplit[i].split(":");
					if (strChildSplit.length > 0) {
						if (strChildSplit[1].contains("SCHEMA_ID")) {
							lSelectedSchemaId = Long.parseLong(strChildSplit[0]);
						}
						if (strChildSplit[1].contains("GenerateCount")) {
							strCountValue = strChildSplit[0];
						} else if(strChildSplit[1].contains("GenerateType")){
							strGenerationType = strChildSplit[0];
						}else if (!strChildSplit[1].contains("SCHEMA_ID")) {
							if (strChildSplit[1].toUpperCase().contains(
									TdgCentralConstant.MANUAL_DICTIONARY)
									&& !StringUtils.isEmpty(strChildSplit[0])) {
								lstDictionaryCols.add(strChildSplit[1].toUpperCase().substring(
										0,
										strChildSplit[1].toUpperCase().lastIndexOf(
												TdgCentralConstant.MANUAL_DICTIONARY)));
							}else {
								if(mapConditions.containsKey(strChildSplit[1].toUpperCase()) && !mapConditions.get(strChildSplit[1].toUpperCase()).equals(strChildSplit[0])){
									mapConditions.put(strChildSplit[1].toUpperCase(), mapConditions.get(strChildSplit[1].toUpperCase())+"#"+strChildSplit[0]);
								}else{
									mapConditions.put(strChildSplit[1].toUpperCase(), strChildSplit[0]);
								}
							}
						}
					}
				}
			}
			
			
			*//**
			 * Going to fetch schema Details
			 *//*
			listDynamicPageContentDTO = tdgOperationsService.getAllSchemaDetailsForDynamicPage();
			StringBuffer strBufferCondition = new StringBuffer("");
			String strUrl = "";
			String strPass = "";
			String strName = "";
			String strSchemaName = "";
			String strMasterTables = "";
			String strSequencePrefix = "";
			String strColumnDependes = "";
			String strDictionaryName = "";
			String strPassedTabs = "";
			String strDateFormate = "";
			String strBusinessRules = "";
			int i = 1;
			for (TdgDynamicPageContentDTO dynamicDTO : listDynamicPageContentDTO) {
				if (lSelectedSchemaId == dynamicDTO.getSchemaId()) {
					strUrl = dynamicDTO.getUrl();
					strPass = dynamicDTO.getPassword();
					strName = dynamicDTO.getName();
					strSchemaName = dynamicDTO.getSchemaname();
					strMasterTables = dynamicDTO.getSchemamastertables();
					strSequencePrefix = dynamicDTO.getSeqtableprefix();
					strColumnDependes = dynamicDTO.getColumnsdepends();
					strDictionaryName = dynamicDTO.getManualdictionary();
					strPassedTabs = dynamicDTO.getSchemapasstabs();
					strDateFormate = dynamicDTO.getDateformate();
					strBusinessRules = dynamicDTO.getBusinessrules();
					List<TdgDynamicGuiDTO> listGuiDTOs = dynamicDTO.getListDynamicPojo();
					for (TdgDynamicGuiDTO dynamicGui : listGuiDTOs) {
						if (mapConditions.containsKey(dynamicGui.getColumnName().toUpperCase())) {
							for (Map.Entry<String, Object> mapEntry : mapConditions.entrySet()) {
								if (mapEntry.getKey().equals(
										dynamicGui.getColumnName().toUpperCase())) {
									strBufferCondition.append(dynamicGui.getColumnLabel()).append(
											':');
									if (dynamicGui.getColumnValues() != null
											&& dynamicGui.getColumnValues().contains(":")) {
										strBufferCondition.append(
												dynamicGui.getMapValues().get(mapEntry.getValue()))
												.append('#');
									} else {
										strBufferCondition.append(mapEntry.getValue()).append('#');
									}
									break;
								}
							}
						}
					}
					//going for append the business rules conditions
					if(strBusinessRules != null && !strBusinessRules.equals(';')){
						if(strBusinessRules.contains("#")){
							String[] strArray = strBusinessRules.split("#");
							for(int iRules=0;iRules<strArray.length;iRules++){
								if(strArray[iRules].contains(":")){
									String[] strBusinessConditions = strArray[iRules].split(":");
									mapConditions.put(strBusinessConditions[0].toUpperCase(), strBusinessConditions[1].contains(";")?strBusinessConditions[1].substring(0, strBusinessConditions[1].length()-1):strBusinessConditions[1]);
								}
							}
						}else if(strBusinessRules.contains(":")){
							String[] strBusinessConditions = strBusinessRules.endsWith(";") ? strBusinessRules.substring(0,strBusinessRules.length()).split(":") : strBusinessRules.split(":");
							mapConditions.put(strBusinessConditions[0].toUpperCase(), strBusinessConditions[1].contains(";")?strBusinessConditions[1].substring(0, strBusinessConditions[1].length()-1):strBusinessConditions[1]);
						}			
					}
					break;
				}
			}
			List<String> listPassedTabs = new ArrayList<String>();
			if (StringUtils.isNotEmpty(strPassedTabs)) {
				if (strPassedTabs.contains(";")) {
					String strArrays[] = strPassedTabs.split(";");
					if (strArrays.length >= 1) {
						if (strArrays[0].contains(",")) {
							String[] strMasterTabs = strArrays[0].split(",");
							for (String strVal : strMasterTabs) {
								listPassedTabs.add(strVal.toUpperCase().trim());
							}
						} else {
							listPassedTabs.add(strArrays[0].toUpperCase().trim());
						}
					}
				}
			}
			String strCondition = strBufferCondition.toString();
			if (strCondition != null && strCondition.contains("#")
					&& strCondition.lastIndexOf("#") == strCondition.length() - 1) {
				strCondition = strCondition.substring(0, strCondition.lastIndexOf("#"));
			}
			logger.info("Condition criteria is :: " + strCondition);
			try {
				lRequestedCount = Long.parseLong(strCountValue);
				if (lRequestedCount <= 0
						|| lRequestedCount > TdgCentralConstant.GENERATECOUNT_LIMIT) {
					strSuccess
							.append(TdgCentralConstant.FAILED_MESSAGE)
							.append('#')
							.append(i)
							.append(". Generate Count should be greater than 0 and less than "
									+ TdgCentralConstant.GENERATECOUNT_LIMIT);
					i++;
				}
			} catch (NumberFormatException ne) {
				logger.error(ne.getMessage());
				strSuccess
						.append(TdgCentralConstant.FAILED_MESSAGE)
						.append('#')
						.append(i)
						.append(". Generate Count should be greater than 0 and less than "
								+ TdgCentralConstant.GENERATECOUNT_LIMIT);
				i++;
			}
			if (mapConditions != null) {
				boolean bCheck = false;
				for (Map.Entry<String, Object> mapValue : mapConditions.entrySet()) {
					if (null != mapValue.getValue() && !"".equals(mapValue.getValue())
							&& !"".equals(mapValue.getValue().toString().trim())) {
						bCheck = true;
						if (mapValue.getKey().contains("#")) {
							String strArray[] = mapValue.getKey().split("#");
							for (int ii = 0; ii < strArray.length; ii++) {
								if (lstDictionaryCols != null
										&& !lstDictionaryCols.contains(strArray[ii])) {
									mapConditionsPassed.put(strArray[ii], mapValue.getValue());
								}
							}
						} else {
							if (lstDictionaryCols != null
									&& !lstDictionaryCols.contains(mapValue.getKey())) {
								mapConditionsPassed.put(mapValue.getKey(), mapValue.getValue());
							}
						}
					}
				}
				if (lstDictionaryCols != null && !lstDictionaryCols.isEmpty()) {
					bCheck = true;
				}
				if (!bCheck) {
					if (strSuccess.toString().contains(TdgCentralConstant.FAILED_MESSAGE)) {
						strSuccess
								.append("<br/>")
								.append(i)
								.append(". Atleast one criteria is required apart from Generate Count");
					} else {
						strSuccess
								.append(TdgCentralConstant.FAILED_MESSAGE)
								.append('#')
								.append(i)
								.append(". Atleast one criteria is required apart from Generate Count");
					}
				}
			}
			logger.info("Requested count to generate the records :: " + lRequestedCount);
			if (!strSuccess.toString().contains(TdgCentralConstant.FAILED_MESSAGE)) {
				TestDataGenerateDTO testDataGenerateDTO = new TestDataGenerateDTO();
				testDataGenerateDTO.setGenerationType(strGenerationType);
				testDataGenerateDTO.setMapinputData(mapConditionsPassed);
				testDataGenerateDTO.setGenerateRecordsCount(lRequestedCount);
				testDataGenerateDTO.setPassword(strPass);
				testDataGenerateDTO.setUsername(strName);
				testDataGenerateDTO.setUrl(strUrl);
				testDataGenerateDTO.setSchemaId(lSelectedSchemaId);
				testDataGenerateDTO.setUserId(userId);
				testDataGenerateDTO.setCondition(strCondition);
				testDataGenerateDTO.setSchemaname(strSchemaName);
				testDataGenerateDTO.setSchemamastertables(strMasterTables);
				testDataGenerateDTO.setSeqtableprefix(strSequencePrefix);
				testDataGenerateDTO.setGUIDictionaryColumns(lstDictionaryCols);
				testDataGenerateDTO.setDateFormate(strDateFormate);
				testDataGenerateDTO.setColumnsdepends(strColumnDependes);
				testDataGenerateDTO.setSequenceOrder(false);
				if (!listPassedTabs.isEmpty()) {
					testDataGenerateDTO.setDataConditionalTabNames(listPassedTabs);
				}
				*//**
				 * Going for read the data dictionary values
				 *//*
				Map<String, List<String>> mapResult = null;
				if (!StringUtils.isEmpty(strDictionaryName)) {
					mapResult = tdgOperationsService
							.retrieveManualDictionaryValues(strDictionaryName);
				}
				 TdgExcelOperationsUtil tdgExcelOperationUtil = new TdgExcelOperationsUtil(
				 * "C:/Test.xlsx");
				 * Map<String, List<String>> mapResult = tdgExcelOperationUtil.readFile(); 
				if (mapResult != null && !mapResult.isEmpty()) {
					testDataGenerateDTO.setMapDictionaryVals(mapResult);
				}
				if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_XLS.equals(testDataGenenarteDTO.getGenerationType()) || TdgCentralConstant.SCHEMA_GENERATION_TYPE_CSV.equals(testDataGenenarteDTO.getGenerationType())){
					Map<String,Map<String,List<Object[]>>> mapResponse = tdgOperationsService.generateFlatTestData(testDataGenenarteDTO);
					if (mapResponse.containsKey(TdgCentralConstant.TDG_GENERATE_SUCCESS)) {
						if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_XLS.equals(testDataGenenarteDTO.getGenerationType())){
							
						}else if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_CSV.equals(testDataGenenarteDTO.getGenerationType())){
							Map<String,List<Object[]>> mapRes = mapResponse.get(TdgCentralConstant.TDG_GENERATE_SUCCESS);
							Map<String,List<Object[]>> mapRes = mapResponse.get(TdgCentralConstant.TDG_GENERATE_SUCCESS);
							try {
							for(Map.Entry<String, List<Object[]>> mapEntry : mapRes.entrySet()){
							response.setContentType("text/csv");
							String disposition = "attachment; fileName="+mapEntry.getKey()+".csv";
							response.setHeader("Content-Disposition", disposition);							
								response.getWriter().append(
										CSVGenerator.getCSVForList(mapEntry.getValue()));							
							}
							
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							downloadTdgCSVFlatFile(mapRes, response);
						}
							
						strSuccess.append(lRequestedCount).append(" record(s) are generated");					
					} else {
						strSuccess.append("0 record(s) are generated.");
					}
				}else if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_DB.equals(testDataGenenarteDTO.getGenerationType())){
				String strResponse = tdgOperationsService.generateTestData(testDataGenerateDTO);
				if (TdgCentralConstant.SUCCESS_MESSAGE.equals(strResponse)) {
					strSuccess.append(lRequestedCount).append(" record(s) are generated");					
				} else {
					strSuccess.append("0 record(s) are generated.");
				}
				//}
			}
		} else {
			strSuccess
					.append(TdgCentralConstant.FAILED_MESSAGE)
					.append('#')
					.append("Generate Count should be greater than 0 and less than "
							+ TdgCentralConstant.GENERATECOUNT_LIMIT);
		}
		model.addAttribute("requestList", listDynamicPageContentDTO);
		model.addAttribute("dynamicPageContent", dynamicPageContent);
		logger.info(strClassName + strMethodName + " return from schemaDetails post method ");
		return strSuccess.toString();
	}*/
	
	@RequestMapping(value = "/tdgOperationsDetails", method = RequestMethod.POST)
	public @ResponseBody String generateDataDetails(
			@RequestParam(required = false, value = "reqVals") String reqVals, ModelMap model,
			@ModelAttribute("dynamicPageContent") TdgDynamicPageContentDTO dynamicPageContent,
			HttpServletRequest request, HttpServletResponse response){
		String strMethodName = " [ schemaDetails() ]";
		logger.info(strClassName + strMethodName + " inside of schemaDetails post method ");
		String strRequestValues = request.getParameter("reqVals");
		StringBuffer strSuccess = new StringBuffer("");
		List<TdgDynamicPageContentDTO> listDynamicPageContentDTO = null;
		//long lSelectedSchemaId = 0;
		long lRequestedCount = 0;
		
		if (strRequestValues != null && strRequestValues.contains("*")) {			
			
			/**
			 * Going to fetch schema Details
			 */
			listDynamicPageContentDTO = tdgOperationsService.getAllSchemaDetailsForDynamicPage();
			TestDataGenerateDTO testDataGenerateDTO = generateTestData(strRequestValues, dynamicPageContent, listDynamicPageContentDTO);
				lRequestedCount = testDataGenerateDTO.getGenerateRecordsCount();
				if (lRequestedCount <= 0
						|| lRequestedCount > TdgCentralConstant.GENERATECOUNT_LIMIT) {
					strSuccess
							.append(TdgCentralConstant.FAILED_MESSAGE)
							.append('#')
							.append(" Generate Count should be greater than 0 and less than "
									+ TdgCentralConstant.GENERATECOUNT_LIMIT);
				}
			
			if (testDataGenerateDTO.getMapinputData().isEmpty()) {
				if (strSuccess.toString().contains(TdgCentralConstant.FAILED_MESSAGE)) {
					strSuccess
							.append("<br/>")
							.append(" Atleast one criteria is required apart from Generate Count");
				} else {
					strSuccess
							.append(TdgCentralConstant.FAILED_MESSAGE)
							.append('#')
							.append(" Atleast one criteria is required apart from Generate Count");
				}
			}
			
			logger.info("Requested count to generate the records :: " + lRequestedCount);
			if (!strSuccess.toString().contains(TdgCentralConstant.FAILED_MESSAGE)) {
				
				/**
				 * Going for read the data dictionary values
				 */
				/*String strDictionaryName = "";
				for (TdgDynamicPageContentDTO dynamicDTO : listDynamicPageContentDTO) {
					if (lSelectedSchemaId == dynamicDTO.getSchemaId()) {
						strDictionaryName = dynamicDTO.getManualdictionary();
					}
				}
				Map<String, List<String>> mapResult = null;
				if (!StringUtils.isEmpty(strDictionaryName)) {
					mapResult = tdgOperationsService
							.retrieveManualDictionaryValues(strDictionaryName);
				}
				 TdgExcelOperationsUtil tdgExcelOperationUtil = new TdgExcelOperationsUtil(
				 * "C:/Test.xlsx");
				 * Map<String, List<String>> mapResult = tdgExcelOperationUtil.readFile(); 
				if (mapResult != null && !mapResult.isEmpty()) {
					testDataGenerateDTO.setMapDictionaryVals(mapResult);
				}*/
				/*if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_XLS.equals(testDataGenenarteDTO.getGenerationType()) || TdgCentralConstant.SCHEMA_GENERATION_TYPE_CSV.equals(testDataGenenarteDTO.getGenerationType())){
					Map<String,Map<String,List<Object[]>>> mapResponse = tdgOperationsService.generateFlatTestData(testDataGenenarteDTO);
					if (mapResponse.containsKey(TdgCentralConstant.TDG_GENERATE_SUCCESS)) {
						if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_XLS.equals(testDataGenenarteDTO.getGenerationType())){
							
						}else if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_CSV.equals(testDataGenenarteDTO.getGenerationType())){
							Map<String,List<Object[]>> mapRes = mapResponse.get(TdgCentralConstant.TDG_GENERATE_SUCCESS);
							Map<String,List<Object[]>> mapRes = mapResponse.get(TdgCentralConstant.TDG_GENERATE_SUCCESS);
							try {
							for(Map.Entry<String, List<Object[]>> mapEntry : mapRes.entrySet()){
							response.setContentType("text/csv");
							String disposition = "attachment; fileName="+mapEntry.getKey()+".csv";
							response.setHeader("Content-Disposition", disposition);							
								response.getWriter().append(
										CSVGenerator.getCSVForList(mapEntry.getValue()));							
							}
							
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							downloadTdgCSVFlatFile(mapRes, response);
						}
							
						strSuccess.append(lRequestedCount).append(" record(s) are generated");					
					} else {
						strSuccess.append("0 record(s) are generated.");
					}
				}else if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_DB.equals(testDataGenenarteDTO.getGenerationType())){*/
				String strResponse = tdgOperationsService.generateTestData(testDataGenerateDTO);
				if (strResponse.contains(TdgCentralConstant.SUCCESS_MESSAGE)) {
					strSuccess.append(lRequestedCount).append(" record(s) are generated " +(strResponse.contains("#") ? " and request id is : "+strResponse.split("#")[1] : ""));					
				} else {
					strSuccess.append("0 record(s) are generated " +(strResponse.contains("#") ? " and request id is : "+strResponse.split("#")[1] : ""));
				}
				//}
			}
		} else {
			strSuccess
					.append(TdgCentralConstant.FAILED_MESSAGE)
					.append('#')
					.append("Generate Count should be greater than 0 and less than "
							+ TdgCentralConstant.GENERATECOUNT_LIMIT);
		}
		model.addAttribute("requestList", listDynamicPageContentDTO);
		model.addAttribute("dynamicPageContent", dynamicPageContent);
		logger.info(strClassName + strMethodName + " return from schemaDetails post method ");
		return strSuccess.toString();
	}
	
	
	
	private TestDataGenerateDTO generateTestData(String strRequestValues,TdgDynamicPageContentDTO dynamicPageContent,List<TdgDynamicPageContentDTO> listDynamicPageContentDTO){
		TestDataGenerateDTO testDataGenerateDTO = new TestDataGenerateDTO();	

		String strMethodName = " [ schemaDetails() ]";
		logger.info(strClassName + strMethodName + " inside of schemaDetails post method ");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userId = user.getUsername();
		StringBuffer strSuccess = new StringBuffer("");
		long lSelectedSchemaId = 0;
		long lRequestedCount = 0;
		String strCountValue = "";
		List<String> lstDictionaryCols = new ArrayList<String>();
		String strGenerationType = "";
		
		//if (strRequestValues != null && strRequestValues.contains("*")) {
			String[] strParentSplit = strRequestValues.split("\\*");
			Map<String, Object> mapConditions = new HashMap<String, Object>();
			Map<String, Object> mapConditionsPassed = new HashMap<String, Object>();
			for (int i = 0; i < strParentSplit.length; i++) {
				if (strParentSplit[i].contains(":")) {
					String[] strChildSplit = strParentSplit[i].split(":");
					if (strChildSplit.length > 0) {
						if (strChildSplit[1].contains("SCHEMA_ID")) {
							lSelectedSchemaId = Long.parseLong(strChildSplit[0]);
						}
						if (strChildSplit[1].contains("GenerateCount")) {
							strCountValue = strChildSplit[0];
						} else if(strChildSplit[1].contains("GenerateType")){
							strGenerationType = strChildSplit[0];
						}else if (!strChildSplit[1].contains("SCHEMA_ID")) {
							if (strChildSplit[1].toUpperCase().contains(
									TdgCentralConstant.MANUAL_DICTIONARY)
									&& !StringUtils.isEmpty(strChildSplit[0])) {
								lstDictionaryCols.add(strChildSplit[1].toUpperCase().substring(
										0,
										strChildSplit[1].toUpperCase().lastIndexOf(
												TdgCentralConstant.MANUAL_DICTIONARY)));
							}else {
								if(mapConditions.containsKey(strChildSplit[1].toUpperCase()) && !mapConditions.get(strChildSplit[1].toUpperCase()).equals(strChildSplit[0])){
									mapConditions.put(strChildSplit[1].toUpperCase(), mapConditions.get(strChildSplit[1].toUpperCase())+"#"+strChildSplit[0]);
								}else{
									mapConditions.put(strChildSplit[1].toUpperCase(), strChildSplit[0]);
								}
							}
						}
					}
				}
			}
			
			
			/**
			 * Going to fetch schema Details
			 */
			StringBuffer strBufferCondition = new StringBuffer("");
			String strUrl = "";
			String strPass = "";
			String strName = "";
			String strSchemaName = "";
			String strMasterTables = "";
			String strSequencePrefix = "";
			String strColumnDependes = "";
			String strDictionaryName = "";
			String strPassedTabs = "";
			String strDateFormate = "";
			String strBusinessRules = "";
			String strRequiredColumns = "";
			int i = 1;
			for (TdgDynamicPageContentDTO dynamicDTO : listDynamicPageContentDTO) {
				if (lSelectedSchemaId == dynamicDTO.getSchemaId()) {
					strUrl = dynamicDTO.getUrl();
					strPass = dynamicDTO.getPassword();
					strName = dynamicDTO.getName();
					strSchemaName = dynamicDTO.getSchemaname();
					strMasterTables = dynamicDTO.getSchemamastertables();
					strSequencePrefix = dynamicDTO.getSeqtableprefix();
					strColumnDependes = dynamicDTO.getColumnsdepends();
					strDictionaryName = dynamicDTO.getManualdictionary();
					strPassedTabs = dynamicDTO.getSchemapasstabs();
					strDateFormate = dynamicDTO.getDateformate();
					strBusinessRules = dynamicDTO.getBusinessrules();
					strRequiredColumns = dynamicDTO.getRequiredcolumns();
					List<TdgDynamicGuiDTO> listGuiDTOs = dynamicDTO.getListDynamicPojo();
					for (TdgDynamicGuiDTO dynamicGui : listGuiDTOs) {
						if (mapConditions.containsKey(dynamicGui.getColumnName().toUpperCase())) {
							for (Map.Entry<String, Object> mapEntry : mapConditions.entrySet()) {
								if (mapEntry.getKey().equals(
										dynamicGui.getColumnName().toUpperCase())) {
									strBufferCondition.append(dynamicGui.getColumnLabel()).append(
											':');
									if (dynamicGui.getColumnValues() != null
											&& dynamicGui.getColumnValues().contains(":")) {
										strBufferCondition.append(
												dynamicGui.getMapValues().get(mapEntry.getValue()))
												.append('#');
									} else {
										strBufferCondition.append(mapEntry.getValue()).append('#');
									}
									break;
								}
							}
						}
					}
					//going for append the business rules conditions
					if(strBusinessRules != null && !strBusinessRules.equals(";")){
						if(strBusinessRules.contains("#")){
							String[] strArray = strBusinessRules.split("#");
							for(int iRules=0;iRules<strArray.length;iRules++){
								if(strArray[iRules].contains(":")){
									String[] strBusinessConditions = strArray[iRules].split(":");
									mapConditions.put(strBusinessConditions[0].toUpperCase(), strBusinessConditions[1].contains(";")?(strBusinessConditions[1].substring(0, strBusinessConditions[1].length()-1).contains("TDG_COLON") ? strBusinessConditions[1].substring(0, strBusinessConditions[1].length()-1).replaceAll("TDG_COLON", ":") : strBusinessConditions[1].substring(0, strBusinessConditions[1].length()-1)) : (strBusinessConditions[1].contains("TDG_COLON") ? strBusinessConditions[1].replaceAll("TDG_COLON",":"): strBusinessConditions[1]));
								}
							}
						}else if(strBusinessRules.contains(":")){
							String[] strBusinessConditions = strBusinessRules.endsWith(";") ? strBusinessRules.substring(0,strBusinessRules.length()).split(":") : strBusinessRules.split(":");
							mapConditions.put(strBusinessConditions[0].toUpperCase(), strBusinessConditions[1].contains(";")?(strBusinessConditions[1].substring(0, strBusinessConditions[1].length()-1).contains("TDG_COLON") ? strBusinessConditions[1].substring(0, strBusinessConditions[1].length()-1).replaceAll("TDG_COLON", ":") : strBusinessConditions[1].substring(0, strBusinessConditions[1].length()-1)) : (strBusinessConditions[1].contains("TDG_COLON") ? strBusinessConditions[1].replaceAll("TDG_COLON",":"): strBusinessConditions[1]));
						}			
					}
					break;
				}
			}
			//below code is added for sequence of columns and required columns
			List<String> lstRequiredColumns = new ArrayList<String>();
			if(strRequiredColumns != null && !strRequiredColumns.trim().equals(";") && !strRequiredColumns.trim().equals("")){
				if(strRequiredColumns.contains("#")){
					String[] splitedVals = strRequiredColumns.split("#");
					for(int j = 0 ;j<splitedVals.length; j++){
						lstRequiredColumns.add(splitedVals[j]);
					}
				}else{
					lstRequiredColumns.add(strRequiredColumns);
				}
			}
			//end
			
			List<String> listPassedTabs = new ArrayList<String>();
			if (StringUtils.isNotEmpty(strPassedTabs)) {
				if (strPassedTabs.contains(";")) {
					String strArrays[] = strPassedTabs.split(";");
					if (strArrays.length >= 1) {
						if (strArrays[0].contains(",")) {
							String[] strMasterTabs = strArrays[0].split(",");
							for (String strVal : strMasterTabs) {
								listPassedTabs.add(strVal.toUpperCase().trim());
							}
						} else {
							listPassedTabs.add(strArrays[0].toUpperCase().trim());
						}
					}
				}
			}
			String strCondition = strBufferCondition.toString();
			if (strCondition != null && strCondition.contains("#")
					&& strCondition.lastIndexOf("#") == strCondition.length() - 1) {
				strCondition = strCondition.substring(0, strCondition.lastIndexOf("#"));
			}
			logger.info("Condition criteria is :: " + strCondition);
			try {
				lRequestedCount = Long.parseLong(strCountValue);
				
			} catch (NumberFormatException ne) {
				logger.error(ne.getMessage());
				
			}
			if (mapConditions != null) {
				boolean bCheck = false;
				for (Map.Entry<String, Object> mapValue : mapConditions.entrySet()) {
					if (null != mapValue.getValue() && !"".equals(mapValue.getValue())
							&& !"".equals(mapValue.getValue().toString().trim())) {
						bCheck = true;
						if (mapValue.getKey().contains("#")) {
							String strArray[] = mapValue.getKey().split("#");
							for (int ii = 0; ii < strArray.length; ii++) {
								if (lstDictionaryCols != null
										&& !lstDictionaryCols.contains(strArray[ii])) {
									mapConditionsPassed.put(strArray[ii], mapValue.getValue());
								}
							}
						} else {
							if (lstDictionaryCols != null
									&& !lstDictionaryCols.contains(mapValue.getKey())) {
								mapConditionsPassed.put(mapValue.getKey(), mapValue.getValue());
							}
						}
					}
				}
				if (lstDictionaryCols != null && !lstDictionaryCols.isEmpty()) {
					bCheck = true;
				}
				if (!bCheck) {
					if (strSuccess.toString().contains(TdgCentralConstant.FAILED_MESSAGE)) {
						strSuccess
								.append("<br/>")
								.append(i)
								.append(". Atleast one criteria is required apart from Generate Count");
					} else {
						strSuccess
								.append(TdgCentralConstant.FAILED_MESSAGE)
								.append('#')
								.append(i)
								.append(". Atleast one criteria is required apart from Generate Count");
					}
				}
			}
			logger.info("Requested count to generate the records :: " + lRequestedCount);
			if (!strSuccess.toString().contains(TdgCentralConstant.FAILED_MESSAGE)) {
				//TestDataGenerateDTO testDataGenerateDTO = new TestDataGenerateDTO();
				testDataGenerateDTO.setGenerationType(strGenerationType);
				testDataGenerateDTO.setMapinputData(mapConditionsPassed);
				testDataGenerateDTO.setGenerateRecordsCount(lRequestedCount);
				testDataGenerateDTO.setPassword(strPass);
				testDataGenerateDTO.setUsername(strName);
				testDataGenerateDTO.setUrl(strUrl);
				testDataGenerateDTO.setSchemaId(lSelectedSchemaId);
				testDataGenerateDTO.setUserId(userId);
				testDataGenerateDTO.setCondition(strCondition);
				testDataGenerateDTO.setSchemaname(strSchemaName);
				testDataGenerateDTO.setSchemamastertables(strMasterTables);
				testDataGenerateDTO.setSeqtableprefix(strSequencePrefix);
				testDataGenerateDTO.setGUIDictionaryColumns(lstDictionaryCols);
				testDataGenerateDTO.setDateFormate(strDateFormate);
				testDataGenerateDTO.setColumnsdepends(strColumnDependes);
				testDataGenerateDTO.setSequenceOrder(false);
				if(!lstRequiredColumns.isEmpty())
					testDataGenerateDTO.setRequiredSequenceColumns(lstRequiredColumns);
				if (!listPassedTabs.isEmpty()) {
					testDataGenerateDTO.setDataConditionalTabNames(listPassedTabs);
				}
				/**
				 * Going for read the data dictionary values
				 */
				Map<String, List<String>> mapResult = null;
				if (!StringUtils.isEmpty(strDictionaryName)) {
					mapResult = tdgOperationsService
							.retrieveManualDictionaryValues(strDictionaryName);
				}
				/* TdgExcelOperationsUtil tdgExcelOperationUtil = new TdgExcelOperationsUtil(
				 * "C:/Test.xlsx");
				 * Map<String, List<String>> mapResult = tdgExcelOperationUtil.readFile(); */
				if (mapResult != null && !mapResult.isEmpty()) {
					testDataGenerateDTO.setMapDictionaryVals(mapResult);
				}
				/*if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_XLS.equals(testDataGenenarteDTO.getGenerationType()) || TdgCentralConstant.SCHEMA_GENERATION_TYPE_CSV.equals(testDataGenenarteDTO.getGenerationType())){
					Map<String,Map<String,List<Object[]>>> mapResponse = tdgOperationsService.generateFlatTestData(testDataGenenarteDTO);
					if (mapResponse.containsKey(TdgCentralConstant.TDG_GENERATE_SUCCESS)) {
						if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_XLS.equals(testDataGenenarteDTO.getGenerationType())){
							
						}else if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_CSV.equals(testDataGenenarteDTO.getGenerationType())){
							Map<String,List<Object[]>> mapRes = mapResponse.get(TdgCentralConstant.TDG_GENERATE_SUCCESS);
							Map<String,List<Object[]>> mapRes = mapResponse.get(TdgCentralConstant.TDG_GENERATE_SUCCESS);
							try {
							for(Map.Entry<String, List<Object[]>> mapEntry : mapRes.entrySet()){
							response.setContentType("text/csv");
							String disposition = "attachment; fileName="+mapEntry.getKey()+".csv";
							response.setHeader("Content-Disposition", disposition);							
								response.getWriter().append(
										CSVGenerator.getCSVForList(mapEntry.getValue()));							
							}
							
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							downloadTdgCSVFlatFile(mapRes, response);
						}
							
						strSuccess.append(lRequestedCount).append(" record(s) are generated");					
					} else {
						strSuccess.append("0 record(s) are generated.");
					}
				}else if(TdgCentralConstant.SCHEMA_GENERATION_TYPE_DB.equals(testDataGenenarteDTO.getGenerationType())){*/
				/*String strResponse = tdgOperationsService.generateTestData(testDataGenerateDTO);
				if (TdgCentralConstant.SUCCESS_MESSAGE.equals(strResponse)) {
					strSuccess.append(lRequestedCount).append(" record(s) are generated");					
				} else {
					strSuccess.append("0 record(s) are generated.");
				}*/
				//}
			}
		/*} else {
			strSuccess
					.append(TdgCentralConstant.FAILED_MESSAGE)
					.append('#')
					.append("Generate Count should be greater than 0 and less than "
							+ TdgCentralConstant.GENERATECOUNT_LIMIT);
		}	*/
		return testDataGenerateDTO;
	}
	
	public void downloadTdgCSVFlatFile(Map<String,List<Object[]>> mapRes, HttpServletResponse response){
		for(Map.Entry<String, List<Object[]>> mapEntry : mapRes.entrySet()){
		response.setContentType("text/csv");
		String disposition = "attachment; fileName="+mapEntry.getKey()+".csv";
		response.setHeader("Content-Disposition", disposition);							
			try {
				response.getWriter().append(
						CSVGenerator.getCSVForList(mapEntry.getValue()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

	@RequestMapping(value = "/tdgDashBoardDetails", method = RequestMethod.GET)
	public String tdgDashBoardDetails(@RequestParam(value = "page", required = false) String page,
			@ModelAttribute("tdgRequestListDTO") TdgRequestListDTO tdgRequestListDTO,
			HttpServletRequest request, HttpServletResponse response, ModelMap model){
		String strMethodName = " [ tdgDashBoardDetails() ]";
		logger.info(strClassName + strMethodName + " inside of tdgDashBoardDetails get method ");
		if (page != null) {
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			long lRequestId = tdgRequestListDTO != null && tdgRequestListDTO.getRequestid() != null ? tdgRequestListDTO
					.getRequestid() : 0;
			int recordsperpage = Integer.valueOf(TdgCentralConstant.PAGINATION_SIZE);
			int offSet = pagenation.getOffset(request, recordsperpage);
			totalRecords = tdgOperationsService
					.getReservedRecordsForRequestGeneratedCount(lRequestId);
			logger.debug(strClassName + strMethodName + " Total records found in server is :: "
					+ totalRecords);
			TdgRequestListDTO tempTdgRequestListDTO = tdgOperationsService.getDashBoardDetails(
					lRequestId, offSet, recordsperpage, true);
			pagenation.paginate(totalRecords, request, Double.valueOf(recordsperpage),
					recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute("noOfPages", noOfPages);
			tempTdgRequestListDTO.setRequestid(tdgRequestListDTO != null ? tdgRequestListDTO
					.getRequestid() : null);
			model.addAttribute("tdgRequestListDTO", tempTdgRequestListDTO);
		} else {
		}
		logger.info(strClassName + strMethodName + " return from tdgDashBoardDetails get method ");
		return "tdgDashBoard";
	}

	@RequestMapping(value = "/tdgDashBoardDetails", method = RequestMethod.POST)
	public String tdgDashBoardDetails(@RequestParam(value = "page", required = false) String page,
			@ModelAttribute("tdgRequestListDTO") TdgRequestListDTO tdgRequestListDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response){
		String strMethodName = " [ tdgDashBoardDetails() ]";
		logger.info(strClassName + strMethodName + " inside of tdgDashBoardDetails post method ");
		Long totalRecords = 0L;
		PaginationUtil pagenation = new PaginationUtil();
		int recordsperpage = Integer.valueOf(TdgCentralConstant.PAGINATION_SIZE);
		int offSet = pagenation.getOffset(request, recordsperpage);
		long lRequestId = tdgRequestListDTO != null && tdgRequestListDTO.getRequestid() != null ? tdgRequestListDTO
				.getRequestid() : 0;
		totalRecords = tdgOperationsService.getReservedRecordsForRequestGeneratedCount(lRequestId);
		logger.debug(strClassName + strMethodName + " Total records found in server is :: "
				+ totalRecords);
		TdgRequestListDTO tempTdgRequestListDTO = tdgOperationsService.getDashBoardDetails(
				lRequestId, offSet, recordsperpage, true);
		pagenation.paginate(totalRecords, request, Double.valueOf(recordsperpage), recordsperpage);
		int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
		request.setAttribute("noOfPages", noOfPages);
		tempTdgRequestListDTO.setRequestid(tdgRequestListDTO != null ? tdgRequestListDTO
				.getRequestid() : null);
		if (tempTdgRequestListDTO.getListTdgRequestListDTO() == null) {
			tempTdgRequestListDTO.setMessageConstant(TdgCentralConstant.FAILED_MESSAGE);
			tempTdgRequestListDTO.setMessage("No record(s) found for given criteria ");
		}
		model.addAttribute("tdgRequestListDTO", tempTdgRequestListDTO);
		logger.info(strClassName + strMethodName + " return from tdgDashBoardDetails post method ");
		return "tdgDashBoard";
	}

	@RequestMapping(value = "/tdgDependentDetails", method = RequestMethod.GET)
	public @ResponseBody String dependentValuesDetails(
			@RequestParam(required = false, value = "reqvalsDependent") String reqvalsDependent,
			ModelMap model, HttpServletRequest request, HttpServletResponse response){
		String strMethodName = " [ schemaDetails() ]";
		logger.info(strClassName + strMethodName + " inside of schemaDetails get method ");
		long lSelectedSchemaId = 0;
		String strResponse = "";
		String strConditionvalue = "";
		String strComponentName = "";
		if (reqvalsDependent != null && reqvalsDependent.contains("*")) {
			String[] strParentSplit = reqvalsDependent.split("\\*");
			for (int i = 0; i < strParentSplit.length; i++) {
				if (strParentSplit[i].contains(":")) {
					String[] strChildSplit = strParentSplit[i].split(":");
					if (strChildSplit.length > 0) {
						if (strChildSplit[0].contains("SCHEMA_ID")) {
							lSelectedSchemaId = Long.parseLong(strChildSplit[1]);
						} else if (strChildSplit[0].contains("COMPONENT_NAME")) {
							strComponentName = strChildSplit[1];
						} else {
							strConditionvalue = strChildSplit[1];
						}
					}
				}
			}
			strResponse = tdgOperationsService.getDynamicDependentValues(lSelectedSchemaId,
					strComponentName, strConditionvalue);
		}
		logger.info(strClassName + strMethodName + " return from schemaDetails method ");
		return strResponse;
	}
	
    //downloadFlatFiles	
	@RequestMapping(value = "/downloadFlatFiles", method = RequestMethod.GET)
	public void downloadFlatFiles(
			@RequestParam(value = "reqId", required = false) String reqId, ModelMap model,
 HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String strMethodName = " [ downloadTdgRequest() ]";
		logger.info(strClassName + strMethodName
				+ " inside of downloadTdgRequest get method ");
		TdgRequestListDTO tdgRequestListDTO = null;
		if (reqId != null) {
			tdgRequestListDTO = tdgOperationsService
					.getDashBoardRequestedRecords(Long.valueOf(request
							.getParameter("reqId")));
		}
		if (tdgRequestListDTO != null
				&& TdgCentralConstant.TDG_GENERATE_SUCCESS
						.equalsIgnoreCase(tdgRequestListDTO.getStatus())) {
			String statusDes = tdgRequestListDTO.getStatusdescription();

			response.setContentType("application/octet-stream");
			// response.setContentLength(2048);
			response.setHeader(
					"Content-Disposition",
					"attachment;filename=\""
							+ statusDes.substring(
									statusDes.lastIndexOf("/") + 1,
									statusDes.length()) + "\"");
			try {
				File f = new File(statusDes);
				byte[] arBytes = new byte[(int) f.length()];
				FileInputStream is = new FileInputStream(f);
				is.read(arBytes);
				ServletOutputStream op = response.getOutputStream();
				op.write(arBytes);
				op.flush();
				is.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		logger.info(strClassName + strMethodName
				+ " return from tdgDashBoardDetails get method ");
	}
	
	
	@RequestMapping(value = "/downloadTdgRequest", method = RequestMethod.GET)
	public ModelAndView downloadTdgRequest(
			@RequestParam(value = "dataFile", required = false) String dataFile,
			@RequestParam(value = "reqId", required = false) String reqId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String strMethodName = " [ downloadTdgRequest() ]";
		logger.info(strClassName + strMethodName + " inside of downloadTdgRequest get method ");
		TdgRequestListDTO tdgRequestListDTO = null;
		if (reqId != null) {
			tdgRequestListDTO = tdgOperationsService.getDashBoardRequestedRecords(Long
					.valueOf(request.getParameter("reqId")));
		}
		if (tdgRequestListDTO != null && tdgRequestListDTO.getConditions() != null
				&& dataFile != null && dataFile.equals(".xls")) {
			logger.info(strClassName + strMethodName
					+ " return from tdgDashBoardDetails get method ");
			return new ModelAndView("tdgExcelSearchResultListView", "tdgExcelSearchResultListDTOs",
					tdgRequestListDTO);
		} else if (tdgRequestListDTO != null && tdgRequestListDTO.getConditions() != null
				&& dataFile != null && dataFile.equals(".pdf")) {
			return new ModelAndView("pdfView", "tdgPdfSearchResultListDTOs", tdgRequestListDTO);
		}
		logger.info(strClassName + strMethodName + " return from tdgDashBoardDetails get method ");
		return null;
	}

	@RequestMapping(value = "/downloadTdgCSVRequest", method = RequestMethod.GET)
	public void downloadTdgCSVRequest(
			@RequestParam(value = "dataFile", required = false) String dataFile,
			@RequestParam(value = "reqId", required = false) String reqId, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String strMethodName = " [ downloadTdgCSVRequest() ]";
		logger.info(strClassName + strMethodName + " inside of downloadTdgCSVRequest get method ");
		TdgRequestListDTO tdgRequestListDTO = null;
		if (reqId != null && dataFile != null && dataFile.equals(".csv")) {
			tdgRequestListDTO = tdgOperationsService.getDashBoardRequestedRecords(Long
					.valueOf(request.getParameter("reqId")));
			Map<String, String> colvalMap = new HashMap<String, String>();
			if (tdgRequestListDTO.getConditions() != null
					&& tdgRequestListDTO.getConditions().contains("#")) {
				String[] colvalue = tdgRequestListDTO.getConditions().split("\\#");
				for (int i = 0; i < colvalue.length; i++) {
					if (colvalue[i].contains(":")) {
						String[] strChildSplit = colvalue[i].split(":");
						if (strChildSplit.length > 1) {
							if (strChildSplit[0] != null && strChildSplit[1] != null) {
								colvalMap.put(strChildSplit[0], strChildSplit[1]);
							}
						} else if (strChildSplit.length == 1) {
							colvalMap.put(strChildSplit[0], null);
						} else {
							colvalMap.put(strChildSplit[i], null);
						}
					} else {
						colvalMap.put(colvalue[i], null);
					}
				}
			} else if (tdgRequestListDTO.getConditions() != null
					&& tdgRequestListDTO.getConditions().contains(":")) {
				String[] colvalue = tdgRequestListDTO.getConditions().split(":");
				if (colvalue.length > 1) {
					if (colvalue[0] != null && colvalue[1] != null) {
						colvalMap.put(colvalue[0], colvalue[1]);
					}
				} else if (colvalue.length == 1) {
					colvalMap.put(colvalue[0], null);
				}
			} else {
				colvalMap.put(tdgRequestListDTO.getConditions(), null);
			}
			response.setContentType("text/csv");
			String disposition = "attachment; fileName=downloadTdgRequest.csv";
			response.setHeader("Content-Disposition", disposition);
			response.getWriter().append(
					CSVGenerator.getCSV(colvalMap, tdgRequestListDTO.getRequestCount(),
							tdgRequestListDTO.getListGeneratedData()));
		}
	}
}
