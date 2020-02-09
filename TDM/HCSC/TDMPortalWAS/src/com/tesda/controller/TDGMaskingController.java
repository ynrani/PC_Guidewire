package com.tesda.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tesda.constants.TDMConstants;
import com.tesda.constants.TDMExceptionCode;
import com.tesda.exception.ServiceException;
import com.tesda.exception.TDMException;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdmChangeReqDTO;
import com.tesda.service.TDGDataMaskingService;
import com.tesda.util.PaginationUtil;

@Controller
@Scope(TDMConstants.SCOPE_SESSION)
public class TDGMaskingController
{

	TdgDataMaskingDTO tdgDataMaskingDTO1 = null;
	TdgDataMaskingDTO tdgDataMaskingDTOfr = null;
	TdgDataMaskingDTO tdgDataMaskingDTOcr = null;
	@Resource(name = TDMConstants.DATAMASKING_SERVICE)
	TDGDataMaskingService dataMaskingService;

	@RequestMapping(value = TDMConstants.MAP_TDM_DTMASKDASHBORAD, method = RequestMethod.GET)
	public String tdmDtMaskDashboard(
			@RequestParam(value = TDMConstants.PAGE, required = false) String page,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		try
		{
			String type = "FR";
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			totalRecords = dataMaskingService.getReservedRecordsCount((String) request.getSession()
					.getAttribute(TDMConstants.USER_ID), type);
			tdgDataMaskingDTOfr = dataMaskingService.getAllDtMaskRequestedRecordForPagination(
					offSet, recordsperpage, true,
					(String) request.getSession().getAttribute(TDMConstants.USER_ID), type);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(TDMConstants.NUM_OF_PAGES, noOfPages);
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO,
					tdgDataMaskingDTOfr.getTdgDataMaskingDTOs());
			return TDMConstants.TDM_DATAMASKING_DASHBOARD;
		}
		catch (ServiceException se)
		{
			model.addAttribute(TDMConstants.ERROR, TDMConstants.ERROR_MESSAGE);
			return TDMConstants.TDM_DATAMASKING_DASHBOARD;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_TDM_DTMASK_DASHBOARD, method = RequestMethod.GET)
	public String tdmDtMaskDashboardCR(
			@RequestParam(value = TDMConstants.PAGE, required = false) String page,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		try
		{
			String type = TDMConstants.CR;
			Long totalRecords = 0L;
			PaginationUtil pagenation = new PaginationUtil();
			int recordsperpage = 10;
			int offSet = pagenation.getOffset(request, recordsperpage);
			totalRecords = dataMaskingService.getReservedRecordsCount((String) request.getSession()
					.getAttribute(TDMConstants.USER_ID), type);
			tdgDataMaskingDTOcr = dataMaskingService.getAllDtMaskRequestedRecordForPagination(
					offSet, recordsperpage, true,
					(String) request.getSession().getAttribute(TDMConstants.USER_ID), type);
			pagenation.paginate(totalRecords, request, (double) recordsperpage, recordsperpage);
			int noOfPages = (int) Math.ceil(totalRecords.doubleValue() / recordsperpage);
			request.setAttribute(TDMConstants.NUM_OF_PAGES, noOfPages);
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASK_REQLISTDTO,
					tdgDataMaskingDTOcr.getTdgDataMaskingDTOs());
			return TDMConstants.TDM_DATAMASKING_DASHBOARD_CR;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			}
			return TDMConstants.TDM_DATAMASKING_DASHBOARD_CR;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_TDM_DATAMASKING, method = RequestMethod.GET)
	public String tdmDataMasking(
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		try
		{
			if (null != (String) request.getSession().getAttribute(TDMConstants.USER_ID))
			{
				tdgDataMaskingDTO.setUserId((String) request.getSession().getAttribute(
						TDMConstants.USER_ID));
				tdgDataMaskingDTO1 = dataMaskingService.getUserDetails(tdgDataMaskingDTO);
				tdgDataMaskingDTO.setEmailId(tdgDataMaskingDTO1.getEmailId());
				tdgDataMaskingDTO.setUserName(tdgDataMaskingDTO1.getUserName());
				tdgDataMaskingDTO.setPhoneNo(tdgDataMaskingDTO1.getPhoneNo());
				if (null != (String) request.getSession().getAttribute(TDMConstants.PROJECT_ID))
				{
					tdgDataMaskingDTO.setProjectId((String) request.getSession().getAttribute(
							TDMConstants.PROJECT_ID));
				}
			}
			return TDMConstants.TDM_DATAMASKING;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));

			}
			return TDMConstants.TDM_DATAMASKING;
		}

	}

	@RequestMapping(value = TDMConstants.MAP_TDM_DATAMASKING, method = RequestMethod.POST)
	public String tdmDataMaskingPost(
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		tdgDataMaskingDTO1 = tdgDataMaskingDTO;
		return TDMConstants.TDM_DATAMASKING_PAGE2;
	}

	@RequestMapping(value = TDMConstants.MAP_TDM_DATAMASKING_PG2, method = RequestMethod.GET)
	public String tdmDataMaskingPage2(
			@RequestParam(value = TDMConstants.BACK, required = false) String back,
			@RequestParam(value = TDMConstants.READ_BACK, required = false) String readBack,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		if (back != null)
		{
			tdgDataMaskingDTO = setRequestData(tdgDataMaskingDTO1);

			if (null != (String) request.getSession().getAttribute(TDMConstants.PROJECT_ID))
			{
				tdgDataMaskingDTO.setProjectId((String) request.getSession().getAttribute(
						TDMConstants.PROJECT_ID));
			}
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO, tdgDataMaskingDTO);
			return TDMConstants.TDM_DATAMASKING;
		}
		if (readBack != null)
		{
			tdgDataMaskingDTO = setRequestData(tdgDataMaskingDTO1);

			if (null != (String) request.getSession().getAttribute(TDMConstants.PROJECT_ID))
			{
				tdgDataMaskingDTO.setProjectId((String) request.getSession().getAttribute(
						TDMConstants.PROJECT_ID));
			}
			model.addAttribute(TDMConstants.READONLY, TDMConstants.TRUE);
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO, tdgDataMaskingDTO);
			return TDMConstants.TDM_DATAMASKING;
		}

		return TDMConstants.TDM_DATAMASKING_PAGE2;
	}

	@RequestMapping(value = TDMConstants.MAP_TDM_DATAMASKING_PG2, method = RequestMethod.POST)
	public String tdmDataMaskingPage2Post(
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		tdgDataMaskingDTO1.setPage2Q1(tdgDataMaskingDTO.getPage2Q1());
		tdgDataMaskingDTO1.setPage2Q2(tdgDataMaskingDTO.getPage2Q2());
		tdgDataMaskingDTO1.setPage2Q3(tdgDataMaskingDTO.getPage2Q3());
		tdgDataMaskingDTO1.setPage2Q4(tdgDataMaskingDTO.getPage2Q4());
		tdgDataMaskingDTO1.setPage2Q5(tdgDataMaskingDTO.getPage2Q5());
		tdgDataMaskingDTO1.setPage2Q6(tdgDataMaskingDTO.getPage2Q6());
		tdgDataMaskingDTO1.setPage2Q7(tdgDataMaskingDTO.getPage2Q7());
		tdgDataMaskingDTO1.setPage2Q8(tdgDataMaskingDTO.getPage2Q8());
		tdgDataMaskingDTO1.setPage2Q9(tdgDataMaskingDTO.getPage2Q9());
		tdgDataMaskingDTO1.setPage2Q10(tdgDataMaskingDTO.getPage2Q10());
		tdgDataMaskingDTO1.setPage2Q11(tdgDataMaskingDTO.getPage2Q11());
		tdgDataMaskingDTO1.setPage2Q12(tdgDataMaskingDTO.getPage2Q12());

		return TDMConstants.TDM_DATAMASKING_PAGE3;

	}

	@RequestMapping(value = TDMConstants.MAP_TDM_DATAMASKING_PG3, method = RequestMethod.GET)
	public String tdmDataMaskingPage3(
			@RequestParam(value = TDMConstants.BACK, required = false) String back,
			@RequestParam(value = TDMConstants.READ_BACK, required = false) String readBack,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		if (back != null)
		{
			tdgDataMaskingDTO = setRequestData(tdgDataMaskingDTO1);
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO, tdgDataMaskingDTO);
			return TDMConstants.TDM_DATAMASKING_PAGE2;
		}

		if (readBack != null)
		{
			tdgDataMaskingDTO = setRequestData(tdgDataMaskingDTO1);
			model.addAttribute(TDMConstants.READONLY, TDMConstants.TRUE);
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO, tdgDataMaskingDTO);
			return TDMConstants.TDM_DATAMASKING_PAGE2;
		}

		return TDMConstants.TDM_DATAMASKING_PAGE3;
	}

	@RequestMapping(value = TDMConstants.MAP_TDM_DATAMASKING_PG3, method = RequestMethod.POST)
	@ResponseBody
	public String tdmDataMaskingPage3Post(
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		String reqId = null;
		try
		{
			tdgDataMaskingDTO1.setPage3Q1(tdgDataMaskingDTO.getPage3Q1());
			tdgDataMaskingDTO1.setPage3Q2(tdgDataMaskingDTO.getPage3Q2());
			tdgDataMaskingDTO1.setPage3Q3(tdgDataMaskingDTO.getPage3Q3());
			tdgDataMaskingDTO1.setPage3Q4(tdgDataMaskingDTO.getPage3Q4());
			tdgDataMaskingDTO1.setPage3Q5(tdgDataMaskingDTO.getPage3Q5());
			tdgDataMaskingDTO1.setPage3Q6(tdgDataMaskingDTO.getPage3Q6());
			tdgDataMaskingDTO1.setPage3Q7(tdgDataMaskingDTO.getPage3Q7());
			tdgDataMaskingDTO1.setPage3Q8(tdgDataMaskingDTO.getPage3Q8());
			tdgDataMaskingDTO1.setPage3Q9(tdgDataMaskingDTO.getPage3Q9());
			tdgDataMaskingDTO1.setPage3Q10(tdgDataMaskingDTO.getPage3Q10());
			tdgDataMaskingDTO1.setPage3NoOfApps(tdgDataMaskingDTO.getPage3NoOfApps());
			tdgDataMaskingDTO1.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingDTO
					.getTdgDataMaskingNoOfAppsDTOs());
			tdgDataMaskingDTO1.setChngReqCmmt(tdgDataMaskingDTO.getChngReqCmmt());
			tdgDataMaskingDTO1.setVno(tdgDataMaskingDTO.getVno());

			reqId = dataMaskingService.saveMaskingData(tdgDataMaskingDTO1);
			if (tdgDataMaskingDTO.getChngReqCmmt() != null)
			{
				model.addAttribute(TDMConstants.RESULT,
						"Request updated Successfully for RequestId " + reqId);
			}
			else
			{
				model.addAttribute(TDMConstants.RESULT,
						"Request created Successfully for RequestId " + reqId);

			}
			model.addAttribute("disabled", TDMConstants.TRUE);
			return reqId;
		}
		catch (ServiceException se)
		{
			if (se.getErrorCode() != null)
			{
				model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));

			}
			return reqId;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_GETDATA_MASKREQDTLS, method = RequestMethod.GET)
	public String getDataMaskRequestDtls(
			@RequestParam(value = TDMConstants.EDIT, required = false) String edit,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		try
		{
			tdgDataMaskingDTO1 = dataMaskingService
					.getDtMaskRequestedRecord(
							(String) request.getSession().getAttribute(TDMConstants.USER_ID),
							request.getParameter("reqId"));

			tdgDataMaskingDTO = setRequestData(tdgDataMaskingDTO1);
			
			model.addAttribute("oldReqId", tdgDataMaskingDTO.getId());

			if (null != (String) request.getSession().getAttribute(TDMConstants.PROJECT_ID))
			{
				tdgDataMaskingDTO.setProjectId((String) request.getSession().getAttribute(
						TDMConstants.PROJECT_ID));
			}
			if (edit != null && edit.equals(TDMConstants.TRUE))
			{
				model.addAttribute(TDMConstants.IS_CHANGE_REQ, TDMConstants.TRUE);
				model.addAttribute(TDMConstants.READONLY, TDMConstants.FALSE);
			}
			else
			{
				model.addAttribute(TDMConstants.READONLY, TDMConstants.TRUE);

			}
			model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO, tdgDataMaskingDTO);
			return TDMConstants.TDM_DATAMASKING;
		}
		catch (ServiceException se)
		{

			model.addAttribute(TDMConstants.ERROR, TDMExceptionCode.getExceptionMsg(se));
			if (se.getErrorCode().equals(TDMExceptionCode.NORESULT))
			{
				model.addAttribute(TDMConstants.MODEL_TDM_CHANGEREQ_DTO, new TdmChangeReqDTO());
				return TDMConstants.TDM_CHANGE_REQEXT;
			}
			return TDMConstants.TDM_DATAMASKING;
		}
	}

	@RequestMapping(value = TDMConstants.MAP_GETDATA_MASKREQDTLS_PG2, method = RequestMethod.GET)
	public String getDataMaskRequestDtlsForPage2(
			@RequestParam(value = TDMConstants.EDIT, required = false) String edit,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		tdgDataMaskingDTO = setRequestData(tdgDataMaskingDTO1);
		
		model.addAttribute("oldReqId", tdgDataMaskingDTO.getId());
		
		if (edit != null && edit.equals(TDMConstants.TRUE))
		{
			model.addAttribute(TDMConstants.IS_CHANGE_REQ, TDMConstants.TRUE);
			model.addAttribute(TDMConstants.READONLY, TDMConstants.FALSE);

		}
		else
		{
			model.addAttribute(TDMConstants.READONLY, TDMConstants.TRUE);

		}
		model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO, tdgDataMaskingDTO);
		return TDMConstants.TDM_DATAMASKING_PAGE2;
	}

	@RequestMapping(value = TDMConstants.MAP_GETDATA_MASKREQDTLS_PG3, method = RequestMethod.GET)
	public String getDataMaskRequestDtlsForPage3(
			@RequestParam(value = TDMConstants.EDIT, required = false) String edit,
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		tdgDataMaskingDTO = setRequestData(tdgDataMaskingDTO1);
		
		model.addAttribute("oldReqId", tdgDataMaskingDTO.getId());
		if (edit != null && edit.equals(TDMConstants.TRUE))
		{
			model.addAttribute(TDMConstants.IS_CHANGE_REQ, TDMConstants.TRUE);
			model.addAttribute(TDMConstants.READONLY, TDMConstants.FALSE);
		}
		else
		{
			model.addAttribute(TDMConstants.READONLY, TDMConstants.TRUE);

		}
		model.addAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO, tdgDataMaskingDTO);
		return TDMConstants.TDM_DATAMASKING_PAGE3;
	}

	@RequestMapping(value = TDMConstants.MAP_TDM_DATAMASKING_PG3, method = RequestMethod.GET, params = "export")
	public ModelAndView tdmDataMaskingRequestExport(
			@ModelAttribute(TDMConstants.MODEL_TDG_DATAMASKING_DTO) TdgDataMaskingDTO tdgDataMaskingDTO,
			ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws TDMException
	{
		tdgDataMaskingDTO = setRequestData(tdgDataMaskingDTO1);

		if (null != (String) request.getSession().getAttribute(TDMConstants.PROJECT_ID))
		{
			tdgDataMaskingDTO.setProjectId((String) request.getSession().getAttribute(
					TDMConstants.PROJECT_ID));
		}

		return new ModelAndView("dataMaskingRecordExcel", "tdgDataMaskingRecordDTO",
				tdgDataMaskingDTO);
	}

	private TdgDataMaskingDTO setRequestData(TdgDataMaskingDTO tdgDataMaskingDTO)
	{
		TdgDataMaskingDTO reqTdgDataMaskingDTO = new TdgDataMaskingDTO();
		reqTdgDataMaskingDTO.setId(tdgDataMaskingDTO.getId());
		reqTdgDataMaskingDTO.setUserName(tdgDataMaskingDTO.getUserName());
		reqTdgDataMaskingDTO.setUserId(tdgDataMaskingDTO.getUserId());
		reqTdgDataMaskingDTO.setEmailId(tdgDataMaskingDTO.getEmailId());
		reqTdgDataMaskingDTO.setPhoneNo(tdgDataMaskingDTO.getPhoneNo());
		reqTdgDataMaskingDTO.setDeptName(tdgDataMaskingDTO.getDeptName());
		reqTdgDataMaskingDTO.setNeededBy(tdgDataMaskingDTO.getNeededBy());
		reqTdgDataMaskingDTO.setProjName(tdgDataMaskingDTO.getProjName());
		reqTdgDataMaskingDTO.setProjPhase(tdgDataMaskingDTO.getProjPhase());
		reqTdgDataMaskingDTO.setEnvType(tdgDataMaskingDTO.getEnvType());

		reqTdgDataMaskingDTO.setPage2Q1(tdgDataMaskingDTO.getPage2Q1());
		reqTdgDataMaskingDTO.setPage2Q2(tdgDataMaskingDTO.getPage2Q2());
		reqTdgDataMaskingDTO.setPage2Q3(tdgDataMaskingDTO.getPage2Q3());
		reqTdgDataMaskingDTO.setPage2Q4(tdgDataMaskingDTO.getPage2Q4());
		reqTdgDataMaskingDTO.setPage2Q5(tdgDataMaskingDTO.getPage2Q5());
		reqTdgDataMaskingDTO.setPage2Q6(tdgDataMaskingDTO.getPage2Q6());
		reqTdgDataMaskingDTO.setPage2Q7(tdgDataMaskingDTO.getPage2Q7());
		reqTdgDataMaskingDTO.setPage2Q8(tdgDataMaskingDTO.getPage2Q8());
		reqTdgDataMaskingDTO.setPage2Q9(tdgDataMaskingDTO.getPage2Q9());
		reqTdgDataMaskingDTO.setPage2Q10(tdgDataMaskingDTO.getPage2Q10());
		reqTdgDataMaskingDTO.setPage2Q11(tdgDataMaskingDTO.getPage2Q11());
		reqTdgDataMaskingDTO.setPage2Q12(tdgDataMaskingDTO.getPage2Q12());

		reqTdgDataMaskingDTO.setPage3Q1(tdgDataMaskingDTO.getPage3Q1());
		reqTdgDataMaskingDTO.setPage3Q2(tdgDataMaskingDTO.getPage3Q2());
		reqTdgDataMaskingDTO.setPage3Q3(tdgDataMaskingDTO.getPage3Q3());
		reqTdgDataMaskingDTO.setPage3Q4(tdgDataMaskingDTO.getPage3Q4());
		reqTdgDataMaskingDTO.setPage3Q5(tdgDataMaskingDTO.getPage3Q5());
		reqTdgDataMaskingDTO.setPage3Q6(tdgDataMaskingDTO.getPage3Q6());
		reqTdgDataMaskingDTO.setPage3Q7(tdgDataMaskingDTO.getPage3Q7());
		reqTdgDataMaskingDTO.setPage3Q8(tdgDataMaskingDTO.getPage3Q8());
		reqTdgDataMaskingDTO.setPage3Q9(tdgDataMaskingDTO.getPage3Q9());
		reqTdgDataMaskingDTO.setPage3Q10(tdgDataMaskingDTO.getPage3Q10());
		reqTdgDataMaskingDTO.setPage3NoOfApps(tdgDataMaskingDTO.getPage3NoOfApps());

		reqTdgDataMaskingDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingDTO
				.getTdgDataMaskingNoOfAppsDTOs());

		return reqTdgDataMaskingDTO;
	}

	@RequestMapping(value = TDMConstants.MAP_TDMMASKING_FR, method = RequestMethod.POST, params = TDMConstants.EXPORT)
	public ModelAndView tdmMaskingExportFR(ModelMap model, HttpServletRequest request,
			HttpServletResponse response)
	{
		return new ModelAndView("dataMaskingDashBoardExcel", "tdgDataMaskingDTOs",
				tdgDataMaskingDTOfr.getTdgDataMaskingDTOs());
	}

	@RequestMapping(value = TDMConstants.MAP_TDMMASKING_CR, method = RequestMethod.POST, params = TDMConstants.EXPORT)
	public ModelAndView tdmMaskingExportCR(ModelMap model, HttpServletRequest request,
			HttpServletResponse response)
	{

		return new ModelAndView("dataMaskingDashBoardExcel", "tdgDataMaskingDTOs",
				tdgDataMaskingDTOfr.getTdgDataMaskingDTOs());
	}

}
