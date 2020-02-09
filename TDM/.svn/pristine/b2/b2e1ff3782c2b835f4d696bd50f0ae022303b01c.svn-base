/**
 * Object Name : TdgDataConditionalController.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 22, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
import org.springframework.web.multipart.MultipartFile;

import com.tesda.model.DTO.BaseDTO;
import com.tesda.model.DTO.TdgDataConditionDTO;
import com.tesda.model.DTO.TdgDataConditionalDTO;
import com.tesda.model.DTO.TestDataGenerateDTO;
import com.tesda.service.TDMAdminService;
import com.tesda.service.TdgOperationsService;
import com.tesda.service.impl.TdgDataConditionService;
import com.tesda.util.PaginationUtil;
import com.tesda.util.TdgCentralConstant;
import com.tesda.util.TdgExcelOperationsUtil;

@Controller
public class TdgDataConditionalController{
	private static Logger logger = Logger.getLogger(TdgDataConditionalController.class);
	private static String strClassName = " [ TdgDataConditionalController ] ";
	@Resource(name = "tdgDataConditionService")
	TdgDataConditionService tdgDataConditionService;
	@Resource(name = "tdgOperationsService")
	TdgOperationsService tdgOperationsService;
	@Resource(name = "tDMAdminService")
	TDMAdminService tDMAdminService;

	@RequestMapping(value = "/tdgDataConditional", method = RequestMethod.GET)
	public String uploadDataConditionalData(
			@ModelAttribute("tdgDataConditionalDTO") TdgDataConditionalDTO tdgDataConditionalDTO){
		String strMethodName = " [ uploadDataConditionalData() ]";
		logger.info(strClassName + strMethodName
				+ " inside of uploadDataConditionalData get method ");
		return "tdgDataCondition";
	}

	@RequestMapping(value = "/tdgDataConditional", headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public String uploadDataConditionalData(
			@ModelAttribute("tdgDataConditionalDTO") TdgDataConditionalDTO tdgDataConditionalDTO,
			ModelMap model){
		String strMethodName = " [ uploadDataConditionalData() ]";
		logger.info(strClassName + strMethodName
				+ " inside of uploadDataConditionalData post method ");
		List<String> listValidation = new ArrayList<String>();
		List<String> lstcolNames = new ArrayList<String>();
		String strMessage = "";
		if (tdgDataConditionalDTO != null) {
			MultipartFile file = tdgDataConditionalDTO.getMaltiPartFile();
			List<String> lstTabs = new ArrayList<String>();
			Map<String, List<String>> mapResult = new HashMap<String, List<String>>();
			if (file != null && !StringUtils.isEmpty(tdgDataConditionalDTO.getUsername())
					&& !StringUtils.isEmpty(tdgDataConditionalDTO.getPassword())
					&& !StringUtils.isEmpty(tdgDataConditionalDTO.getUrl())) {
				try {
					User user = (User) SecurityContextHolder.getContext().getAuthentication()
							.getPrincipal();
					TdgExcelOperationsUtil tdgExcelOperationsUtil = new TdgExcelOperationsUtil();
					String tabName = file.getOriginalFilename().toUpperCase();
					if (tabName.toUpperCase().contains(".")) {
						tabName = tabName.substring(0, tabName.indexOf(".")).toUpperCase();
					}
					lstTabs.add(tabName);
					mapResult.putAll(tdgExcelOperationsUtil.readFile(file.getOriginalFilename()
							.toUpperCase(), file.getInputStream()));
					for (Map.Entry<String, List<String>> mapEntry : mapResult.entrySet()) {
						lstcolNames.add(mapEntry.getKey());
					}
					listValidation.addAll(validateProps(tdgDataConditionalDTO.getUrl(),
							tdgDataConditionalDTO.getUsername(),
							tdgDataConditionalDTO.getPassword(), mapResult));
					if (listValidation.isEmpty()) {
						TdgDataConditionDTO tdgDataConditionDTO = new TdgDataConditionDTO();
						tdgDataConditionDTO.setPassword(tdgDataConditionalDTO.getPassword());
						tdgDataConditionDTO.setUsername(tdgDataConditionalDTO.getUsername());
						tdgDataConditionDTO.setUrl(tdgDataConditionalDTO.getUrl());
						tdgDataConditionDTO.setMapDictionaryVals(mapResult);
						tdgDataConditionDTO.setTablename(tabName);
						tdgDataConditionDTO.setUserid(user.getUsername());
						strMessage = tdgDataConditionService
								.saveDataConditionData(tdgDataConditionDTO);
						/**
						 * Going for read the data dictionary values
						 */
						/* String strResponse = tdgOperationsService
						 * .generateTestData(testDataGenenarteDTO);
						 * if (TdgCentralConstant.SUCCESS_MESSAGE.equals(strResponse)) {
						 * strSuccess.append(generateCount).append(" record(s) are created");
						 * } else {
						 * strSuccess.append("0 record(s) are created");
						 * } */
					}
				} catch (Exception e) {
					tdgDataConditionalDTO.setMessageConstant(TdgCentralConstant.FAILED_MESSAGE);
					tdgDataConditionalDTO
							.setMessage("Data condition file name already exist in the database");
					logger.error(strClassName + strMethodName + " " + e.getMessage());
					listValidation.add("You failed to upload " + file.getOriginalFilename()
							+ " => " + e.getMessage());
					return "tdgDataCondition";
				}
			} else {
				if (logger.isDebugEnabled())
					logger.debug(strClassName + strMethodName
							+ " File is empty while upload the file");
				tdgDataConditionalDTO.setMessageConstant(TdgCentralConstant.FAILED_MESSAGE);
				tdgDataConditionalDTO.setMessage("Kindly provide the valid input values.");
				listValidation.add("You failed to upload " + " because the file was empty.");
				return "tdgDataCondition";
			}
		} else {
			if (logger.isDebugEnabled())
				logger.debug(strClassName + strMethodName + " The data object values is null");
			listValidation.add("The data object values is null....");
			return "tdgDataCondition";
		}
		tdgDataConditionalDTO.setErrors(listValidation);
		// TdgDataConditionalDTO tdgDictionaryDTOTemp = new TdgDataConditionalDTO();
		if (null != listValidation && 0 < listValidation.size()) {
			tdgDataConditionalDTO.setErrors(listValidation);
		} else {
			tdgDataConditionalDTO.setErrors(null);
		}
		if (TdgCentralConstant.SUCCESS_MESSAGE.equals(strMessage)) {
			TdgDataConditionalDTO tempTdgDataConditionDTO = new TdgDataConditionalDTO();
			tempTdgDataConditionDTO.setMessageConstant(TdgCentralConstant.SUCCESS_MESSAGE);
			tempTdgDataConditionDTO.setMessage("Data conditioner details uploaded successfully");
			model.addAttribute("tdgDataConditionalDTO", tempTdgDataConditionDTO);
			return "tdgDataCondition";
		} else {
			tdgDataConditionalDTO.setMessageConstant(TdgCentralConstant.FAILED_MESSAGE);
			tdgDataConditionalDTO
					.setMessage("Data conditioner details not matched with database columns or not matched total records. ");
			model.addAttribute("tdgDataConditionalDTO", tdgDataConditionalDTO);
			return "tdgDataCondition";
		}
	}

	@RequestMapping(value = "/tdgDataCondition", method = RequestMethod.GET)
	public String dataConditionalDataForProcess(
			@ModelAttribute("testDataGenerateDTO") TestDataGenerateDTO testDataGenerateDTO,
			ModelMap model){
		String strMethodName = " [ dataConditionalDataForProcess() ]";
		model.addAttribute("testDataGenenarteDTO", testDataGenerateDTO);
		logger.info(strClassName + strMethodName
				+ " inside of dataConditionalDataForProcess get method ");
		return "tdgDataCondition2";
	}

	@RequestMapping(value = "/tdgDataCondition", method = RequestMethod.POST)
	public String dataConditionalDataForProcess(
			@ModelAttribute("testDataGenerateDTO") TestDataGenerateDTO testDataGenerateDTO){
		String strMethodName = " [ dataConditionalDataForProcess() ]";
		logger.info(strClassName + strMethodName
				+ " inside of dataConditionalDataForProcess post method ");
		StringBuffer strSuccess = new StringBuffer("");
		if (testDataGenerateDTO != null) {
			/**
			 * Going for read the data dictionary values
			 */
			String strResponse = tdgOperationsService.generateTestData(testDataGenerateDTO);
			if (TdgCentralConstant.SUCCESS_MESSAGE.equals(strResponse)) {
				strSuccess.append(testDataGenerateDTO.getGenerateRecordsCount()).append(
						" record(s) are created");
			} else {
				strSuccess.append("0 record(s) are created");
			}
		}
		return strSuccess.toString();
	}

	/* @RequestMapping(value = "/tdgDataConditional", headers = ("content-type=multipart/*"), method
	 * = RequestMethod.POST)
	 * public String uploadDataConditionalData(
	 * 
	 * @ModelAttribute("tdgDataConditionalDTO") TdgDataConditionalDTO tdgDataConditionalDTO,
	 * ModelMap model){
	 * String strMethodName = " [ uploadDataConditionalData() ]";
	 * logger.info(strClassName + strMethodName
	 * + " inside of uploadDataConditionalData post method ");
	 * List<String> listValidation = new ArrayList<String>();
	 * String strMessage = "";
	 * StringBuffer strSuccess = new StringBuffer("");
	 * if (tdgDataConditionalDTO != null) {
	 * MultipartFile file = tdgDataConditionalDTO.getMaltiPartFile();
	 * List<String> lstTabs = new ArrayList<String>();
	 * Map<String, List<String>> mapResult = new HashMap<String, List<String>>();
	 * if (!file.isEmpty() && !StringUtils.isEmpty(tdgDataConditionalDTO.getUsername())
	 * && !StringUtils.isEmpty(tdgDataConditionalDTO.getPassword())
	 * && !StringUtils.isEmpty(tdgDataConditionalDTO.getUrl())) {
	 * try {
	 * TdgExcelOperationsUtil tdgExcelOperationsUtil = new TdgExcelOperationsUtil();
	 * String tabName = file.getOriginalFilename().toUpperCase();
	 * if (tabName.toUpperCase().contains(".")) {
	 * tabName = tabName.substring(0, tabName.indexOf(".")).toUpperCase();
	 * }
	 * lstTabs.add(tabName);
	 * mapResult
	 * .putAll(tdgExcelOperationsUtil.readFile(tabName, file.getInputStream()));
	 * listValidation.addAll(validateProps(tdgDataConditionalDTO.getUrl(),
	 * tdgDataConditionalDTO.getUsername(),
	 * tdgDataConditionalDTO.getPassword(), mapResult));
	 * if (listValidation.isEmpty()) {
	 * TestDataGenerateDTO testDataGenenarteDTO = new TestDataGenerateDTO();
	 * testDataGenenarteDTO.setMapinputData(null);
	 * testDataGenenarteDTO.setGenerateRecordsCount(Long
	 * .parseLong(tdgDataConditionalDTO.getGenerateCount()));
	 * testDataGenenarteDTO.setPassword(tdgDataConditionalDTO.getPassword());
	 * testDataGenenarteDTO.setUsername(tdgDataConditionalDTO.getUsername());
	 * testDataGenenarteDTO.setUrl(tdgDataConditionalDTO.getUrl());
	 * testDataGenenarteDTO.setMapDictionaryVals(mapResult);
	 * testDataGenenarteDTO.setDataConditional(true);
	 * testDataGenenarteDTO.setDataConditionalTabNames(lstTabs); *//**
	 * Going for read the data
	 * dictionary values
	 */
	/* String strResponse = tdgOperationsService
	 * .generateTestData(testDataGenenarteDTO);
	 * if (TdgCentralConstant.SUCCESS_MESSAGE.equals(strResponse)) {
	 * strSuccess.append(generateCount).append(" record(s) are created");
	 * } else {
	 * strSuccess.append("0 record(s) are created");
	 * }
	 * }
	 * } catch (Exception e) {
	 * logger.error(strClassName + strMethodName + " " + e.getMessage());
	 * listValidation.add("You failed to upload " + file.getName() + " => "
	 * + e.getMessage());
	 * }
	 * } else {
	 * if (logger.isDebugEnabled())
	 * logger.debug(strClassName + strMethodName
	 * + " File is empty while upload the file");
	 * listValidation.add("You failed to upload " + file.getName()
	 * + " because the file was empty.");
	 * }
	 * } else {
	 * if (logger.isDebugEnabled())
	 * logger.debug(strClassName + strMethodName + " The data object values is null");
	 * listValidation.add("The data object values is null....");
	 * }
	 * tdgDataConditionalDTO.setErrors(listValidation);
	 * TdgDictionaryDTO tdgDictionaryDTOTemp = new TdgDictionaryDTO();
	 * if (null != listValidation && 0 < listValidation.size()) {
	 * tdgDictionaryDTOTemp.setErrors(listValidation);
	 * } else {
	 * tdgDictionaryDTOTemp.setErrors(null);
	 * }
	 * if (TdgCentralConstant.SUCCESS_MESSAGE.equals(strMessage)) {
	 * tdgDictionaryDTOTemp.setMessageConstant(TdgCentralConstant.SUCCESS_MESSAGE);
	 * tdgDictionaryDTOTemp.setMessage("Data dictionary uploaded successfully");
	 * } else {
	 * tdgDictionaryDTOTemp.setMessageConstant(TdgCentralConstant.FAILED_MESSAGE);
	 * tdgDictionaryDTOTemp.setMessage("Data dictionary failed to upload");
	 * }
	 * model.addAttribute("tdgDictionaryDTO", tdgDictionaryDTOTemp);
	 * logger.info(strClassName + strMethodName + " return from uploadMasterData post method ");
	 * return "tdgMasterDictionary";
	 * // return "";
	 * } */
	private List<String> validateProps(String strUrl, String strUserName, String strPassword,
			Map<String, List<String>> mapResult){
		List<String> listInvalidEntries = new ArrayList<String>();
		StringBuffer strCheckValues = new StringBuffer();
		if (listInvalidEntries.isEmpty()) {
			List<String> listCols = tDMAdminService.getAllCols(strUrl.trim(), strUserName.trim(),
					strPassword.trim());
			StringBuffer strBuffer = new StringBuffer();
			for (Map.Entry<String, List<String>> mapEntry : mapResult.entrySet()) {
				boolean bCheck = false;
				if (mapEntry.getKey().contains("#")) {
					String[] strArray = mapEntry.getKey().split("#");
					int iCheckForAll = 0;
					for (int i = 0; i < strArray.length; i++) {
						for (String strExistCol : listCols) {
							if (strArray[i].equals(strExistCol)) {
								bCheck = true;
								iCheckForAll++;
								break;
							}
						}
					}
					if (iCheckForAll != strArray.length) {
						bCheck = false;
					}
				} else {
					for (String strExistCol : listCols) {
						if (mapEntry.getKey().equals(strExistCol)) {
							bCheck = true;
							break;
						}
					}
				}
				if (!bCheck) {
					strBuffer.append(mapEntry.getKey());
				}
			}
			if (strBuffer.toString().contains(",") && strBuffer.toString().endsWith(",")) {
				listInvalidEntries.add(strBuffer.substring(0, strBuffer.length() - 1)
						+ " are invalid Column names ");
			} else if (!strBuffer.toString().isEmpty()) {
				listInvalidEntries.add(strBuffer + " are invalid Column names ");
			}
		}
		if (strCheckValues.toString().contains(",") && strCheckValues.toString().endsWith(",")) {
			listInvalidEntries.add(strCheckValues.substring(0, strCheckValues.length() - 1)
					+ " related values are not valid ");
		} else if (!strCheckValues.toString().isEmpty()) {
			listInvalidEntries.add(strCheckValues + " related values are not valid ");
		}
		return listInvalidEntries;
	}

	@RequestMapping(value = "/tdgDataConditionalDashboard", method = RequestMethod.GET)
	public String tdgDataConditionalDashboard(
			@RequestParam(value = "page", required = false) String page, ModelMap model,
			HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("baseDTO") BaseDTO baseDTO){
		String strMethodName = " [ tdgDataConditionalDashboard() ]";
		logger.info(strClassName + strMethodName
				+ " inside of tdgDataConditionalDashboard get method ");
		try {
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.valueOf(10);
			int offSet = pagenation.getOffset(request, recordsperpage);
			totalRecords = tdgDataConditionService.totalDataConditionalDetailsAll();
			List<TdgDataConditionDTO> tdgTdgDataConditionDTOList = tdgDataConditionService
					.fetchDataConditionalDetailsAll(offSet, recordsperpage, true);
			pagenation.paginate(totalRecords, request, Double.valueOf(recordsperpage),
					recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute("noOfPages", noOfPages);
			model.addAttribute("tdgDataConditionDTOList", tdgTdgDataConditionDTOList);
			model.addAttribute("baseDTO", baseDTO);
			return "tdgDataConditionalDashBoard";
		} catch (Exception e) {
			logger.error(strClassName + " " + e.getMessage());
			return "tdgDataConditionalDashBoard";
		}
	}

	@RequestMapping(value = "/deleteTdgDataConditional", method = RequestMethod.GET)
	public String deleteTdgDataConditionalDetails(
			@RequestParam(value = "id", required = false) String id, ModelMap model,
			HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("baseDTO") BaseDTO baseDTO){
		String strMethodName = " [ deleteTdgDataConditionalDetails() ]";
		logger.info(strClassName + strMethodName
				+ " inside of deleteTdgDataConditionalDetails method ");
		try {
			if (id != null) {
				tdgDataConditionService.deleteTdgDataConditionalDetails(id);
			}
		} catch (Exception ex) {
			baseDTO.setMessage(ex.getMessage());
			baseDTO.setMessageConstant(TdgCentralConstant.FAILED_MESSAGE);
			return "redirect:tdgDataConditionalDashboard";
		}
		logger.info(strClassName + strMethodName
				+ " return from deleteTdgDataConditionalDetails method");
		return "redirect:tdgDataConditionalDashboard";
	}

	@RequestMapping(value = "/fetchdictionaryDetails", method = RequestMethod.GET)
	public String fetchDictionaryDetailsByID(
			@RequestParam(value = "id", required = false) String id, ModelMap model,
			HttpServletRequest request, HttpServletResponse response){
		String strMethodName = " [ fetchDictionaryDetailsByID() ]";
		logger.info(strClassName + strMethodName + " inside of fetchDictionaryDetailsByID method ");
		try {
			if (id != null) {
				TdgDataConditionDTO tdgDataConditionDTO = tdgDataConditionService
						.fetchDataConditionalById(id);
				model.addAttribute("tdgDataConditionDTO", tdgDataConditionDTO);
			}
		} catch (Exception ex) {
		}
		logger.info(strClassName + strMethodName + " return from fetchDictionaryDetailsByID method");
		return "tdgDataConditionalPage";
	}

	@RequestMapping(value = "/dataConditionalOperations", method = RequestMethod.POST)
	public String doDumpDataConditionalData(ModelMap model, HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("tdgDataConditionDTO") TdgDataConditionDTO tdgDataConditionDTO){
		String strMethodName = " [ fetchDictionaryDetailsByID() ]";
		logger.info(strClassName + strMethodName + " inside of fetchDictionaryDetailsByID method ");
		StringBuffer strSuccess = new StringBuffer();
		int iMaxSize = 0;
		try {
			if (tdgDataConditionDTO != null) {
				if (tdgDataConditionDTO.getId() != 0) {
					Map<String, List<String>> mapResult = tdgOperationsService
							.retrieveManualDictionaryValues(tdgDataConditionDTO.getTablename());
					long lGenerateCount = Long.parseLong(tdgDataConditionDTO.getGenerateCount());
					if (mapResult != null && !mapResult.isEmpty()) {
						for (Map.Entry<String, List<String>> mapEntry : mapResult.entrySet()) {
							if (mapEntry.getValue().size() > iMaxSize) {
								iMaxSize = mapEntry.getValue().size();
							}
						}
					}
					if (iMaxSize == 0) {
						tdgDataConditionDTO.setMessageConstant(TdgCentralConstant.FAILED_MESSAGE);
						tdgDataConditionDTO.setMessage("No more records exist in the table");
					} else if (iMaxSize < lGenerateCount) {
						tdgDataConditionDTO.setMessageConstant(TdgCentralConstant.FAILED_MESSAGE);
						tdgDataConditionDTO.setMessage("Maximum allowed to create data is : "
								+ iMaxSize);
					} else {
						List<String> lstTabs = new ArrayList<String>();
						lstTabs.add(tdgDataConditionDTO.getTablename());
						TestDataGenerateDTO testDataGenenarteDTO = new TestDataGenerateDTO();
						testDataGenenarteDTO.setMapinputData(null);
						testDataGenenarteDTO.setGenerateRecordsCount(lGenerateCount);
						testDataGenenarteDTO.setPassword(tdgDataConditionDTO.getPassword());
						testDataGenenarteDTO.setUsername(tdgDataConditionDTO.getUsername());
						testDataGenenarteDTO.setUrl(tdgDataConditionDTO.getUrl());
						testDataGenenarteDTO.setMapDictionaryVals(mapResult);
						testDataGenenarteDTO.setDataConditional(true);
						testDataGenenarteDTO.setDataConditionalTabNames(lstTabs);
						/**
						 * Going for read the data dictionary values
						 */
						String strResponse = tdgOperationsService
								.generateTestData(testDataGenenarteDTO);
						if (TdgCentralConstant.SUCCESS_MESSAGE.equals(strResponse)) {
							tdgDataConditionDTO
									.setMessageConstant(TdgCentralConstant.SUCCESS_MESSAGE);
							strSuccess.append(tdgDataConditionDTO.getGenerateCount()).append(
									" record(s) are created");
							tdgDataConditionDTO.setMessage(strSuccess.toString());
							tdgDataConditionDTO.setGenerateCount(null);
						} else {
							strSuccess.append("0 record(s) are created");
							tdgDataConditionDTO.setMessage(strSuccess.toString());
						}
					}
				}
			}
		} catch (Exception ex) {
			logger.error(strClassName + strMethodName + " exception occured ", ex);
		}
		model.addAttribute("tdgDataConditionDTO", tdgDataConditionDTO);
		logger.info(strClassName + strMethodName + " return from fetchDictionaryDetailsByID method");
		return "tdgDataConditionalPage";
	}
}
