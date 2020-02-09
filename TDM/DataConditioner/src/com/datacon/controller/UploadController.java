/*---------------------------------------------------------------------------------------
 * Object Name: UploadController.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          27/07/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.datacon.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.datacon.constant.AppConstant;
import com.datacon.constant.MessageConstant;
import com.datacon.exception.BaseException;
import com.datacon.model.DTO.CreateStamentDTO;
import com.datacon.model.DTO.UploadDTO;
import com.datacon.model.DTO.UploadTableNameDTO;
import com.datacon.service.UploadService;

/**
 * @author Seshadri Chowdary
 * @version 1.0
 */

@Scope("session")
@Controller
public class UploadController
{

	private static Logger logger = Logger.getLogger(UploadController.class);

	@Resource(name = MessageConstant.UPLOAD_SERVICE)
	UploadService uploadService;

	CommonsMultipartFile multipartFile;

	List<Object[]> listToUi = null;
	Map<String, String> dbList = null;
	String selDBVal = null;
	String selTabVal = null;
	Map<String, List<String>> listTabs = null;
	List<Object[]> selectedColumns = null;
	String createStmt = null;

	@RequestMapping(value = AppConstant.UPLOAD_DATA_CON_PAGE_1, method = RequestMethod.GET)
	public String dataConPage1UploadGet(
			@ModelAttribute(MessageConstant.UPLOAD_DTO) UploadDTO uploadDTO, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_1_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String stopUpload = null;
		try {
			Map<String, String> scheckAvailability = uploadService.getAvilableDBs((String) request
					.getSession().getAttribute(AppConstant.SESSION_UID));
			if (null == scheckAvailability
					|| (null != scheckAvailability && scheckAvailability.isEmpty())) {
				stopUpload = "STOP";
			}
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_1_GET
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					modelmap.addAttribute("stopUpload", stopUpload);
					return AppConstant.UPLOAD_DATA_CON_PAGE_1_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			modelmap.addAttribute("stopUpload", stopUpload);
			return AppConstant.UPLOAD_DATA_CON_PAGE_1_VIEW;
		}
		modelmap.addAttribute("stopUpload", stopUpload);
		return AppConstant.UPLOAD_DATA_CON_PAGE_1_VIEW;
	}

	/**
	 * 
	 * @param cancel
	 * @param upload
	 * @param uploadDTO
	 * @param modelmap
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = AppConstant.UPLOAD_DATA_CON_PAGE_1, method = RequestMethod.POST)
	public String dataConPage1UploadPost(
			@RequestParam(value = "cancel", required = false) String cancel,
			@RequestParam(value = "upload", required = false) String upload,
			@ModelAttribute(MessageConstant.UPLOAD_DTO) UploadDTO uploadDTO, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_1_POST
				+ MessageConstant.LOG_INFO_PARAMS_NO);

		if (null != upload) {
			if (null != uploadDTO) {
				multipartFile = null;
				multipartFile = uploadDTO.getFile();

				String fileName = "";
				if (multipartFile != null) {
					fileName = multipartFile.getOriginalFilename();
					logger.info(MessageConstant.UPLOAD_CTLR
							+ MessageConstant.UPLOAD_DATA_CON_PAGE_1_POST
							+ MessageConstant.LOG_INFO_PARAMS_SEPC + fileName);
				}
			}
			return AppConstant.UPLOAD_DATA_CON_PAGE_2_REDIRECT;
		} else if (null != cancel) {
			multipartFile = null;

			listToUi = null;
			dbList = null;
			selDBVal = null;
			selTabVal = null;
			listTabs = null;
			return AppConstant.UPLOAD_DATA_CON_PAGE_1_VIEW;
		}
		return AppConstant.UPLOAD_DATA_CON_PAGE_1_VIEW;
	}

	/**
	 * 
	 * @param uploadDTO
	 * @param modelmap
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = AppConstant.UPLOAD_DATA_CON_PAGE_2, method = RequestMethod.GET)
	public String dataConPage2UploadGet(
			@ModelAttribute(MessageConstant.UPLOAD_DTO) UploadDTO uploadDTO, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_2_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			if (null != multipartFile) {
				if (multipartFile != null) {

					listToUi = uploadService.convertFileToData(multipartFile);
					if (null != listToUi) {
						listToUi.size();
						selectedColumns = new ArrayList<Object[]>();
						for (Object[] objects : listToUi) {
							if (selectedColumns.isEmpty()) {
								selectedColumns.add(objects);
								break;
							}
						}
					}

				}
				uploadDTO.setSelectedColumns(selectedColumns);
			}

		} catch (BaseException baseEx) {
			logger.error(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_2_GET
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					modelmap.addAttribute("listToUi", listToUi);
					return AppConstant.UPLOAD_DATA_CON_PAGE_2_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			modelmap.addAttribute("listToUi", listToUi);
			modelmap.addAttribute(MessageConstant.UPLOAD_DTO, uploadDTO);
			return AppConstant.UPLOAD_DATA_CON_PAGE_2_VIEW;
		}
		modelmap.addAttribute("listToUi", listToUi);
		modelmap.addAttribute(MessageConstant.UPLOAD_DTO, uploadDTO);
		return AppConstant.UPLOAD_DATA_CON_PAGE_2_VIEW;
	}

	/**
	 * 
	 * @param cancel
	 * @param next1
	 * @param uploadDTO
	 * @param modelmap
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = AppConstant.UPLOAD_DATA_CON_PAGE_2, method = RequestMethod.POST)
	public String dataConPage2UploadPost(
			@RequestParam(value = "cancel", required = false) String cancel,
			@RequestParam(value = "next1", required = false) String next1,
			@ModelAttribute(MessageConstant.UPLOAD_DTO) UploadDTO uploadDTO, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_2_POST
				+ MessageConstant.LOG_INFO_PARAMS_NO);

		if (null != next1) {
			selectedColumns = uploadDTO.getSelectedColumns();
			return AppConstant.UPLOAD_DATA_CON_PAGE_3_REDIRECT;
		} else if (null != cancel) {
			multipartFile = null;

			listToUi = null;
			dbList = null;
			selDBVal = null;
			selTabVal = null;
			listTabs = null;
			return AppConstant.UPLOAD_DATA_CON_PAGE_1_VIEW;
		}
		modelmap.addAttribute(MessageConstant.UPLOAD_DTO, uploadDTO);
		return AppConstant.UPLOAD_DATA_CON_PAGE_2_VIEW;
	}

	/**
	 * 
	 * @param uploadDTO
	 * @param modelmap
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */

	@RequestMapping(value = AppConstant.UPLOAD_DATA_CON_PAGE_3, method = RequestMethod.GET)
	public String dataConPage3UploadGet(
			@ModelAttribute(MessageConstant.UPLOAD_DTO) UploadDTO uploadDTO, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_3_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			dbList = uploadService.getAvilableDBs((String) request.getSession().getAttribute(
					AppConstant.SESSION_UID));
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_3_GET
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.UPLOAD_DATA_CON_PAGE_3_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			modelmap.addAttribute("dbList", dbList);
			modelmap.addAttribute(MessageConstant.UPLOAD_DTO, uploadDTO);
			return AppConstant.UPLOAD_DATA_CON_PAGE_3_VIEW;
		}
		modelmap.addAttribute("dbList", dbList);
		modelmap.addAttribute(MessageConstant.UPLOAD_DTO, uploadDTO);
		return AppConstant.UPLOAD_DATA_CON_PAGE_3_VIEW;
	}

	/**
	 * 
	 * @param cancel
	 * @param next2
	 * @param uploadDTO
	 * @param modelmap
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = AppConstant.UPLOAD_DATA_CON_PAGE_3, method = RequestMethod.POST)
	public String dataConPage3UploadPost(
			@RequestParam(value = "cancel", required = false) String cancel,
			@RequestParam(value = "next2", required = false) String next2,
			@ModelAttribute(MessageConstant.UPLOAD_DTO) UploadDTO uploadDTO, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_3_POST
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		if (null != next2) {
			if (null != uploadDTO) {
				selDBVal = uploadDTO.getDbValues();
			}
			return AppConstant.UPLOAD_DATA_CON_PAGE_4_REDIRECT;
		} else if (null != cancel) {
			multipartFile = null;

			listToUi = null;
			dbList = null;
			selDBVal = null;
			selTabVal = null;
			listTabs = null;
			return AppConstant.UPLOAD_DATA_CON_PAGE_1_VIEW;
		}
		modelmap.addAttribute(MessageConstant.UPLOAD_DTO, uploadDTO);
		return AppConstant.UPLOAD_DATA_CON_PAGE_3_VIEW;
	}

	/**
	 * 
	 * @param uploadDTO
	 * @param modelmap
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = AppConstant.UPLOAD_DATA_CON_PAGE_4, method = RequestMethod.GET)
	public String dataConPage4UploadGet(
			@ModelAttribute(MessageConstant.UPLOAD_DTO) UploadDTO uploadDTO, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_4_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);

		try {
			if (null != selDBVal) {
				uploadDTO.setSelDbValues(selDBVal);
				listTabs = uploadService.getAllTableDetails(selDBVal);
				createStmt = uploadService.createTab(multipartFile, selectedColumns);
				if (null != listTabs && !listTabs.isEmpty()) {
					UploadTableNameDTO uploadTableNameDTO = null;
					List<UploadTableNameDTO> listToAdd = new ArrayList<UploadTableNameDTO>();
					for (int i = 0; i < listTabs.size(); i++) {

						uploadTableNameDTO = new UploadTableNameDTO();
						listToAdd.add(uploadTableNameDTO);
					}
					uploadDTO.setUploadTableNameDTOs(listToAdd);
				}
			}
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_4_GET
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {
					return AppConstant.UPLOAD_DATA_CON_PAGE_4_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();
			modelmap.addAttribute("listTabs", listTabs);
			modelmap.addAttribute("createStmt", createStmt);
			modelmap.addAttribute(MessageConstant.UPLOAD_DTO, uploadDTO);
			return AppConstant.UPLOAD_DATA_CON_PAGE_4_VIEW;
		}
		modelmap.addAttribute("listTabs", listTabs);
		modelmap.addAttribute("createStmt", createStmt);
		modelmap.addAttribute(MessageConstant.UPLOAD_DTO, uploadDTO);
		return AppConstant.UPLOAD_DATA_CON_PAGE_4_VIEW;
	}

	/**
	 * 
	 * @param cancel
	 * @param next3
	 * @param uploadDTO
	 * @param modelmap
	 * @param request
	 * @param response
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value = AppConstant.UPLOAD_DATA_CON_PAGE_4, method = RequestMethod.POST)
	public String dataConPage4UploadPost(
			@RequestParam(value = "cancel", required = false) String cancel,
			@RequestParam(value = "create", required = false) String create,
			@RequestParam(value = "next3", required = false) String next3,
			@ModelAttribute(MessageConstant.UPLOAD_DTO) UploadDTO uploadDTO, ModelMap modelmap,
			HttpServletRequest request, HttpServletResponse response) throws BaseException {
		logger.info(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_4_POST
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String dumpMsg = null;
		String errMsg = null;
		String cancelBtn = null;

		try {
			if (null != next3) {
				selTabVal = uploadDTO.getTableNames();
				dumpMsg = uploadService.insertDataToDB(multipartFile, uploadDTO.getTableNames(),
						uploadDTO, selectedColumns);

				if (null != dumpMsg) {
					multipartFile = null;
					listToUi = null;
				}
			} else if (null != cancel) {
				multipartFile = null;
				listToUi = null;
				dbList = null;
				selDBVal = null;
				selTabVal = null;
				listTabs = null;
				return AppConstant.UPLOAD_DATA_CON_PAGE_1_VIEW;
			}
			if (null != dumpMsg) {
				cancelBtn = "Yes";
			}
		} catch (BaseException baseEx) {
			logger.error(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_DATA_CON_PAGE_4_POST
					+ MessageConstant.LOG_INFO_PARAMS_YES + baseEx);
			errMsg = baseEx.getRootCause().getMessage();
			cancelBtn = "No";
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null")) {
				// String exceptionMsg = passcodes and get msg from properties file by passing key
				// as
				// baseEx.getErrorCode();
				if (baseEx.getErrorCode().startsWith("")) {

					modelmap.addAttribute("errMsg", errMsg);
					modelmap.addAttribute("errMsg", errMsg);
					modelmap.addAttribute("dumpMsg", dumpMsg);
					modelmap.addAttribute("cancelBtn", cancelBtn);
					modelmap.addAttribute("listTabs", listTabs);
					return AppConstant.UPLOAD_DATA_CON_PAGE_4_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by passing key as
			// baseEx.getErrorCode();

			modelmap.addAttribute("errMsg", errMsg);
			modelmap.addAttribute("dumpMsg", dumpMsg);
			modelmap.addAttribute("listTabs", listTabs);
			modelmap.addAttribute("cancelBtn", cancelBtn);
			modelmap.addAttribute(MessageConstant.UPLOAD_DTO, uploadDTO);
			return AppConstant.UPLOAD_DATA_CON_PAGE_4_VIEW;
		}

		modelmap.addAttribute("dumpMsg", dumpMsg);
		modelmap.addAttribute("listTabs", listTabs);
		modelmap.addAttribute("cancelBtn", cancelBtn);
		modelmap.addAttribute(MessageConstant.UPLOAD_DTO, uploadDTO);
		return AppConstant.UPLOAD_DATA_CON_PAGE_4_VIEW;
	}

	// TODO

	/**
	 * 
	 * @param uploadDTO
	 * @param modelmap
	 * @return
	 */
	@RequestMapping(value = AppConstant.TDM_INDEX, method = RequestMethod.GET)
	public String indexUploadGet(@ModelAttribute(MessageConstant.UPLOAD_DTO) UploadDTO uploadDTO,
			ModelMap modelmap) {
		logger.info(MessageConstant.UPLOAD_CTLR + MessageConstant.UPLOAD_GET
				+ MessageConstant.LOG_INFO_PARAMS_NO);

		modelmap.addAttribute("listToUi", listToUi);
		modelmap.addAttribute("dbList", dbList);

		return AppConstant.TDM_INDEX_VIEW;
	}

	@RequestMapping(value = "/createTable", method = RequestMethod.GET)
	public String popupEmailL1L2Get(
			@ModelAttribute("createStamentDTO") CreateStamentDTO createStamentDTO, ModelMap model,
			@RequestParam(value = "create", required = false) String create,
			@RequestParam(value = "type", required = false) String type,
			HttpServletRequest request, HttpServletResponse response, Principal principal) {

		String tmp = create.replace(",", ",\n");
		System.out.println("type   " + type);
		if (null != type) {
			if (type.contains("SqlServer_")) {
				System.out.println("SqlServer_   ");
			} else if (type.contains("DB2_")) {
				System.out.println("DB2_   ");
			} else if (type.contains("MySql_")) {
				System.out.println("MySql_   ");
			} else if (type.contains("Oracle_")) {
				System.out.println("Oracle_   ");
			}
		}
		createStamentDTO.setUserId((String) request.getSession().getAttribute("UserId"));
		createStamentDTO.setCreateStmt(tmp);
		createStamentDTO.setDbName(type);

		return "createTable";
	}
}
