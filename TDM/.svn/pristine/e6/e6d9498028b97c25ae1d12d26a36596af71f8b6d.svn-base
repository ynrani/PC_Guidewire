package com.tesda.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tesda.constants.MessageConstants;
import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.exception.ServiceException;
import com.tesda.exception.TDMException;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdgDataMaskingNoOfAppsDTO;
import com.tesda.service.TDMDataMaskingService;
import com.tesda.util.PaginationUtil;

@Controller
@Scope(TDMConstants.SCOPE_SESSION)
public class TDMDataMaskingController
{
	private static final Logger logger = LoggerFactory.getLogger(TDMDataMaskingController.class);

	@Resource(name = TDMConstants.DATAMASKING_SERVICE)
	TDMDataMaskingService tdmDataMaskingService;

	/**
	 * 
	 * @param reqId
	 * @param status
	 * @param edit
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDM_DATA_MASKING_1_NEW, method = RequestMethod.GET)
	public String tdmDataMaskingReqDtlGet(
			@RequestParam(value = TDMConstants.REQ_ID, required = false) String reqId,
			@RequestParam(value = TDMConstants.STATUS, required = false) String status,
			@RequestParam(value = TDMConstants.EDIT, required = false) String edit,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.GETREQDTLS);
		boolean reqTypeCR = false;
		try
		{
			if (null == reqId)
			{
				String userId = (String) request.getSession().getAttribute(TDMConstants.USER_ID);
				if (null != userId)
				{
					logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.GETREQDTLS
							+ userId);
					tdgDataMaskingDTO.setUserId(userId);
					tdgDataMaskingDTO = tdmDataMaskingService.getUserDetails(tdgDataMaskingDTO);
					tdgDataMaskingDTO.setUserId(userId);
					if (null != (String) request.getSession().getAttribute(TDMConstants.PROJECT_ID))
					{
						tdgDataMaskingDTO.setProjectId((String) request.getSession().getAttribute(
								TDMConstants.PROJECT_ID));
					}
				}
			}
			else
			{
				logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.GETREQDTLS + reqId);
				if (null == status)
				{
					reqTypeCR = true;
					logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.GETREQDTLS
							+ status);
				}
				if (null != edit)
				{
					tdgDataMaskingDTO.setEdit(edit);
					logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.GETREQDTLS + edit);
				}
				tdgDataMaskingDTO.setId(reqId);
				tdgDataMaskingDTO.setReqTypeCR(reqTypeCR);
				tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtls(tdgDataMaskingDTO, true,
						false, false);
			}
			if (null != status)
			{
				if (status.equalsIgnoreCase(TDMConstants.STATUS_SUBMITTED))
				{
					tdgDataMaskingDTO.setStatus(status);
					model.addAttribute(TDMConstants.READONLY, true);
				}
			}
		}
		catch (ServiceException baseEx)
		{
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
			{
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.GETREQDTLS,
						TDMExceptionCode.getExceptionMsg(baseEx));
				if (baseEx.getErrorCode().startsWith(""))
				{
					return TDMConstants.TDM_DATA_MASKING_1_NEW_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
		}
		model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO, tdgDataMaskingDTO);
		logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.GETREQDTLS
				+ MessageConstants.LOG_INFO_RETURN);
		return TDMConstants.TDM_DATA_MASKING_1_NEW_VIEW;
	}

	/**
	 * 
	 * @param submitType
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = TDMConstants.MAP_TDM_DATA_MASKING_1_NEW, method = RequestMethod.POST)
	public String tdmDataMaskingReqDtlPost(
			@RequestParam(value = TDMConstants.SUBMIT, required = false) String submitType,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		try
		{
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.POSTREQDTLS + submitType);
			if (null != submitType)
			{
				if (submitType.equalsIgnoreCase(TDMConstants.SAVE_AND_CONTI))
				{
					tdgDataMaskingDTO = tdmDataMaskingService.saveReqDtls(tdgDataMaskingDTO, true,
							false, false);
				}
				else if (!submitType.equalsIgnoreCase(TDMConstants.SAVE_AND_CONTI))
				{
					model.addAttribute(TDMConstants.READONLY, true);
				}
			}
		}
		catch (ServiceException baseEx)
		{
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
			{
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();

				logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.POSTREQDTLS,
						TDMExceptionCode.getExceptionMsg(baseEx));
				if (baseEx.getErrorCode().startsWith(""))
				{
					return TDMConstants.TDM_DATA_MASKING_PAGE2_REDIRECT + tdgDataMaskingDTO.getId()
							+ TDMConstants.TDM_DATA_MASKING_PARAM_STS
							+ tdgDataMaskingDTO.getStatus();
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return TDMConstants.TDM_DATA_MASKING_PAGE2_REDIRECT + tdgDataMaskingDTO.getId()
					+ TDMConstants.TDM_DATA_MASKING_PARAM_STS + tdgDataMaskingDTO.getStatus();
		}
		logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.POSTREQDTLS
				+ MessageConstants.LOG_INFO_RETURN);
		return TDMConstants.TDM_DATA_MASKING_PAGE2_REDIRECT + tdgDataMaskingDTO.getId()
				+ TDMConstants.TDM_DATA_MASKING_PARAM_STS + tdgDataMaskingDTO.getStatus();
	}

	/**
	 * 
	 * @param reqId
	 * @param status
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDM_DATA_MASKING_2_NEW, method = RequestMethod.GET)
	public String tdmDataMaskingPreReqGet(
			@RequestParam(value = TDMConstants.REQ_ID, required = false) String reqId,
			@RequestParam(value = TDMConstants.STATUS, required = false) String status,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		try
		{
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.GETPREREQ + status);
			tdgDataMaskingDTO.setId(reqId);
			tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtls(tdgDataMaskingDTO, false, true,
					false);
			if (null != status)
			{
				if (status.equalsIgnoreCase(TDMConstants.STATUS_SUBMITTED))
				{
					tdgDataMaskingDTO.setStatus(status);
					model.addAttribute(TDMConstants.READONLY, true);
				}
			}
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO, tdgDataMaskingDTO);
		}
		catch (ServiceException baseEx)
		{
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
			{
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.GETPREREQ,
						TDMExceptionCode.getExceptionMsg(baseEx));
				if (baseEx.getErrorCode().startsWith(""))
				{
					return TDMConstants.TDM_DATA_MASKING_2_NEW_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return TDMConstants.TDM_DATA_MASKING_2_NEW_VIEW;
		}
		logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.GETPREREQ
				+ MessageConstants.LOG_INFO_RETURN);
		return TDMConstants.TDM_DATA_MASKING_2_NEW_VIEW;
	}

	/**
	 * 
	 * @param submit
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDM_DATA_MASKING_2_NEW, method = RequestMethod.POST)
	public String tdmDataMaskingPreReqPost(
			@RequestParam(value = TDMConstants.SUBMIT, required = false) String submit,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		try
		{
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.POSTPREREQ + submit);
			if (null != submit)
			{
				if (submit.equalsIgnoreCase(TDMConstants.SAVE_AND_CONTI))
				{
					tdgDataMaskingDTO = tdmDataMaskingService.saveReqDtls(tdgDataMaskingDTO, false,
							true, false);
				}
				else if (!submit.equalsIgnoreCase(TDMConstants.SAVE_AND_CONTI))
				{
					model.addAttribute(TDMConstants.READONLY, true);
				}
			}
			if (null != submit && !submit.equalsIgnoreCase(TDMConstants.BACK))
			{
				logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.POSTPREREQ
						+ MessageConstants.LOG_INFO_RETURN);
				return TDMConstants.TDM_DATA_MASKING_PAGE3_REDIRECT + tdgDataMaskingDTO.getId()
						+ TDMConstants.TDM_DATA_MASKING_PARAM_STS + tdgDataMaskingDTO.getStatus();
			}
			else
			{
				logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.POSTPREREQ
						+ MessageConstants.LOG_INFO_RETURN);
				return TDMConstants.TDM_DATA_MASKING_PAGE1_REDIRECT + tdgDataMaskingDTO.getId()
						+ TDMConstants.TDM_DATA_MASKING_PARAM_STS + tdgDataMaskingDTO.getStatus();
			}
		}
		catch (ServiceException baseEx)
		{
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
			{
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.POSTPREREQ,
						TDMExceptionCode.getExceptionMsg(baseEx));
				if (baseEx.getErrorCode().startsWith(""))
				{
					return TDMConstants.TDM_DATA_MASKING_2_NEW_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return TDMConstants.TDM_DATA_MASKING_2_NEW_VIEW;
		}
	}

	/**
	 * 
	 * @param reqId
	 * @param status
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDM_DATA_MASKING_3_NEW, method = RequestMethod.GET)
	public String tdmDataMaskingMskDtlGet(
			@RequestParam(value = TDMConstants.REQ_ID, required = false) String reqId,
			@RequestParam(value = TDMConstants.STATUS, required = false) String status,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		tdgDataMaskingDTO.setId(reqId);
		try
		{
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.GETMSKDTLS + status);
			tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtls(tdgDataMaskingDTO, false, false,
					true);
			if (null != status)
			{
				if (status.equalsIgnoreCase(TDMConstants.STATUS_SUBMITTED))
				{
					tdgDataMaskingDTO.setStatus(status);
					model.addAttribute(TDMConstants.READONLY, true);
				}
			}
			if ((StringUtils.isEmpty(status) && reqId.contains(TDMConstants.CR))
					|| StringUtils.isNotEmpty(tdgDataMaskingDTO.getChngReqCmmt()))
			{
				if (null == tdgDataMaskingDTO.getTdgDataMaskingNoOfAppsDTOs())
				{
					List<TdgDataMaskingNoOfAppsDTO> tdgDataMaskingNoOfAppsDTOs = new ArrayList<TdgDataMaskingNoOfAppsDTO>();
					TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO = new TdgDataMaskingNoOfAppsDTO();
					tdgDataMaskingNoOfAppsDTOs.add(tdgDataMaskingNoOfAppsDTO);
					tdgDataMaskingDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingNoOfAppsDTOs);
				}
				else
				{
					tdgDataMaskingDTO.getTdgDataMaskingNoOfAppsDTOs().add(
							new TdgDataMaskingNoOfAppsDTO());
				}
				model.addAttribute(TDMConstants.IS_CHANGE_REQ, true);
			}
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO, tdgDataMaskingDTO);
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.GETMSKDTLS
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.TDM_DATA_MASKING_3_NEW_VIEW;
		}
		catch (ServiceException baseEx)
		{
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
			{
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.GETMSKDTLS,
						TDMExceptionCode.getExceptionMsg(baseEx));
				if (baseEx.getErrorCode().startsWith(""))
				{
					return TDMConstants.TDM_DATA_MASKING_3_NEW_VIEW;
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return TDMConstants.TDM_DATA_MASKING_3_NEW_VIEW;
		}

	}

	/**
	 * 
	 * @param submit
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDM_DATA_MASKING_3_NEW, method = RequestMethod.POST)
	@ResponseBody
	public String tdmDataMaskingMskDtlPost(
			@RequestParam(value = TDMConstants.SUBMIT, required = false) String submit,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		try
		{
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.POSTMSKDTLS + submit);
			tdgDataMaskingDTO = tdmDataMaskingService.saveReqDtls(tdgDataMaskingDTO, false, false,
					true);
			model.addAttribute(TDMConstants.DISABLED, TDMConstants.TRUE);
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO, tdgDataMaskingDTO);
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.POSTMSKDTLS
					+ MessageConstants.LOG_INFO_RETURN);
			return tdgDataMaskingDTO.getId();
		}
		catch (ServiceException baseEx)
		{
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
			{
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.POSTMSKDTLS,
						TDMExceptionCode.getExceptionMsg(baseEx));
				if (baseEx.getErrorCode().startsWith(""))
				{
					return tdgDataMaskingDTO.getId();
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return tdgDataMaskingDTO.getId();
		}
	}

	/**
	 * 
	 * @param tdgDataMaskingDTO
	 * @param reqId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDM_DATA_MASKING_3_NEW_EXPORT, method = RequestMethod.GET)
	public ModelAndView tdmMaskingExportFRGet(
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			@RequestParam(value = TDMConstants.REQ_ID, required = false) String reqId,
			HttpServletRequest request, HttpServletResponse response) throws TDMException
	{
		logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGEXPRT);
		List<TdgDataMaskingDTO> list = null;
		try
		{
			tdgDataMaskingDTO.setId(reqId);
			tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtls(tdgDataMaskingDTO, true, true,
					true);
			if (null == tdgDataMaskingDTO.getTdgDataMaskingDTOs())
			{
				list = new ArrayList<TdgDataMaskingDTO>();
				list.add(tdgDataMaskingDTO);
			}
			else
			{
				list = tdgDataMaskingDTO.getTdgDataMaskingDTOs();
			}
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGEXPRT
					+ MessageConstants.LOG_INFO_RETURN);
			return new ModelAndView(TDMConstants.TDM_DATA_MASKING_DASH_BOARD_XLS,
					TDMConstants.MODEL_TDM_DATA_MASKING_DTOS, list);
		}
		catch (ServiceException baseEx)
		{
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
			{
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGEXPRT,
						TDMExceptionCode.getExceptionMsg(baseEx));
				if (baseEx.getErrorCode().startsWith(""))
				{
					return new ModelAndView(TDMConstants.TDM_DATA_MASKING_DASH_BOARD_XLS,
							TDMConstants.MODEL_TDM_DATA_MASKING_DTOS, list);
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return new ModelAndView(TDMConstants.TDM_DATA_MASKING_DASH_BOARD_XLS,
					TDMConstants.MODEL_TDM_DATA_MASKING_DTOS, list);
		}
	}

	/**
	 * 
	 * @param page
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDM_DTMASKDASHBORAD, method = RequestMethod.GET)
	public String tdmDtMaskDashboard(
			@RequestParam(value = TDMConstants.PAGE, required = false) String page,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		String type = TDMConstants.FR;
		Long totalRecords = 0L;
		try
		{
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGDASHBRD);
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.valueOf(10);
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(
					TDMConstants.USER_ID));
			totalRecords = tdmDataMaskingService.getReservedRecordsCount(
					tdgDataMaskingDTO.getUserId(), type);
			tdgDataMaskingDTO = tdmDataMaskingService.getAllDtMaskRequestedRecordForPagination(
					offSet, recordsperpage, true, tdgDataMaskingDTO, type);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(TDMConstants.NUM_OF_PAGES, noOfPages);
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASK_REQLISTDTO,
					tdgDataMaskingDTO.getTdgDataMaskingDTOs());
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGDASHBRD
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.TDM_DATAMASKING_DASHBOARD;

		}
		catch (ServiceException baseEx)
		{
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
			{
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGDASHBRD,
						TDMExceptionCode.getExceptionMsg(baseEx));
				if (baseEx.getErrorCode().startsWith(""))
				{
					return TDMConstants.TDM_DATAMASKING_DASHBOARD;
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return TDMConstants.TDM_DATAMASKING_DASHBOARD;
		}
	}

	/**
	 * 
	 * @param page
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.TDM_DATAMASKING_DASHBOARD_CR, method = RequestMethod.GET)
	public String tdmDtMaskDashboardCR(
			@RequestParam(value = TDMConstants.PAGE, required = false) String page,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		String type = TDMConstants.CR;
		Long totalRecords = 0L;
		try
		{
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNG_DASHBRDCR);
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = Integer.valueOf(10);
			int offSet = pagenation.getOffset(request, recordsperpage);
			tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(
					TDMConstants.USER_ID));
			totalRecords = tdmDataMaskingService.getReservedRecordsCount(
					tdgDataMaskingDTO.getUserId(), type);
			tdgDataMaskingDTO = tdmDataMaskingService.getAllDtMaskRequestedRecordForPagination(
					offSet, recordsperpage, true, tdgDataMaskingDTO, type);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(TDMConstants.NUM_OF_PAGES, noOfPages);
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASK_REQLISTDTO,
					tdgDataMaskingDTO.getTdgDataMaskingDTOs());
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNG_DASHBRDCR
					+ MessageConstants.LOG_INFO_RETURN);
			return TDMConstants.TDM_DATAMASKING_DASHBOARD_CR;
		}
		catch (ServiceException baseEx)
		{
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
			{
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNG_DASHBRDCR,
						TDMExceptionCode.getExceptionMsg(baseEx));
				if (baseEx.getErrorCode().startsWith(""))
				{
					return TDMConstants.TDM_DATAMASKING_DASHBOARD_CR;
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return TDMConstants.TDM_DATAMASKING_DASHBOARD_CR;
		}
	}

	/**
	 * 
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDMMASKING_FR, method = RequestMethod.POST, params = TDMConstants.EXPORT)
	public ModelAndView tdmMaskingExportFR(
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		List<TdgDataMaskingDTO> list = null;
		try
		{
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGEXPRT_FR);
			tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(
					TDMConstants.USER_ID));
			String type = TDMConstants.FR;
			tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtlsforExport(tdgDataMaskingDTO,
					true, true, true, type);
			if (null == tdgDataMaskingDTO.getTdgDataMaskingDTOs())
			{
				list = new ArrayList<TdgDataMaskingDTO>();
				list.add(tdgDataMaskingDTO);
			}
			else
			{
				list = tdgDataMaskingDTO.getTdgDataMaskingDTOs();
			}
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGEXPRT_FR
					+ MessageConstants.LOG_INFO_RETURN);
			return new ModelAndView(TDMConstants.TDM_DATA_MASKING_DASH_BOARD_XLS,
					TDMConstants.MODEL_TDM_DATA_MASKING_DTOS, list);
		}
		catch (ServiceException baseEx)
		{
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
			{
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGEXPRT_FR,
						TDMExceptionCode.getExceptionMsg(baseEx));
				if (baseEx.getErrorCode().startsWith(""))
				{
					return new ModelAndView(TDMConstants.TDM_DATA_MASKING_DASH_BOARD_XLS,
							TDMConstants.MODEL_TDM_DATA_MASKING_DTOS, list);
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return new ModelAndView(TDMConstants.TDM_DATA_MASKING_DASH_BOARD_XLS,
					TDMConstants.MODEL_TDM_DATA_MASKING_DTOS, list);
		}
	}

	/**
	 * 
	 * @param tdgDataMaskingDTO
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = TDMConstants.MAP_TDMMASKING_CR, method = RequestMethod.POST, params = TDMConstants.EXPORT)
	public ModelAndView tdmMaskingExportCR(
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		List<TdgDataMaskingDTO> list = null;
		try
		{
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGEXPRT_CR);
			tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(
					TDMConstants.USER_ID));
			String type = TDMConstants.CR;
			tdgDataMaskingDTO = tdmDataMaskingService.getSavedDtlsforExport(tdgDataMaskingDTO,
					true, true, true, type);
			if (null == tdgDataMaskingDTO.getTdgDataMaskingDTOs())
			{
				list = new ArrayList<TdgDataMaskingDTO>();
				list.add(tdgDataMaskingDTO);
			}
			else
			{
				list = tdgDataMaskingDTO.getTdgDataMaskingDTOs();
			}
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGEXPRT_CR
					+ MessageConstants.LOG_INFO_RETURN);
			return new ModelAndView(TDMConstants.TDM_DATA_MASKING_DASH_BOARD_XLS,
					TDMConstants.MODEL_TDM_DATA_MASKING_DTOS, list);
		}
		catch (ServiceException baseEx)
		{
			if (null != baseEx.getErrorCode() || baseEx.getErrorCode().equalsIgnoreCase("null"))
			{
				// String exceptionMsg = passcodes and get msg from properties
				// file by passing key
				// as
				// baseEx.getErrorCode();
				logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.MSKNGEXPRT_CR,
						TDMExceptionCode.getExceptionMsg(baseEx));
				if (baseEx.getErrorCode().startsWith(""))
				{
					return new ModelAndView(TDMConstants.TDM_DATA_MASKING_DASH_BOARD_XLS,
							TDMConstants.MODEL_TDM_DATA_MASKING_DTOS, list);
				}
			}
			// responseMsg = passcodes and get msg from properties file by
			// passing key as
			// baseEx.getErrorCode();
			return new ModelAndView(TDMConstants.TDM_DATA_MASKING_DASH_BOARD_XLS,
					TDMConstants.MODEL_TDM_DATA_MASKING_DTOS, list);
		}
	}

	/**
	 * 
	 * @param reqId
	 * @param request
	 * @param response
	 * @return
	 * @throws TDMException
	 */
	@RequestMapping(value = TDMConstants.MAP_CANCEL_MASKINGREQ, method = RequestMethod.POST)
	@ResponseBody
	public String tdmCancelOnboardReq(
			@RequestParam(value = "reqId", required = false) String reqId,
			HttpServletRequest request, HttpServletResponse response) throws TDMException
	{
		try
		{
			logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.CANCL_ONBRDREQ
					+ MessageConstants.LOG_INFO_RETURN);
			boolean isCancelled = tdmDataMaskingService.cancelOnBoardingRequest(reqId);
			if (isCancelled)
			{
				logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.CANCL_ONBRDREQ
						+ MessageConstants.LOG_INFO_RETURN + isCancelled);
				return TDMConstants.TRUE;
			}
			else
			{
				logger.info(MessageConstants.MSKING_CNTRL + MessageConstants.CANCL_ONBRDREQ
						+ MessageConstants.LOG_INFO_RETURN + isCancelled);
				return TDMConstants.FALSE;
			}
		}
		catch (ServiceException se)
		{
			logger.error(MessageConstants.MSKING_CNTRL + MessageConstants.CANCL_ONBRDREQ,
					TDMExceptionCode.getExceptionMsg(se));
			return TDMConstants.ERROR;
		}
	}
}
