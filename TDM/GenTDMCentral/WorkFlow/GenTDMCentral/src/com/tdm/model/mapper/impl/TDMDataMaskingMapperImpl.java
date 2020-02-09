/*---------------------------------------------------------------------------------------
 * Object Name: TDMDataMaskingMapperImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          12/06/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.model.mapper.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.exception.ServiceException;
import com.tdm.model.DO.ReqChDO;
import com.tdm.model.DO.RequestorDO;
import com.tdm.model.DO.TdmOnboadReqNoTabDO;
import com.tdm.model.DO.TdmOnboardReqDO;
import com.tdm.model.DTO.TdgDataMaskingDTO;
import com.tdm.model.DTO.TdgDataMaskingNoOfAppsDTO;
import com.tdm.model.DTO.TdmOnBoardReqDTO;
import com.tdm.model.mapper.TDMDataMaskingMapper;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
@Service(MessageConstant.MAPPER_DMASK)
public class TDMDataMaskingMapperImpl implements TDMDataMaskingMapper
{
	private static Logger logger = Logger.getLogger(TDMDataMaskingMapperImpl.class);

	@Override
	public RequestorDO convertMaskDTOtoDO(RequestorDO requestorDO,
			TdgDataMaskingDTO tdgDataMaskingDTO, String seq, boolean page1, boolean page2,
			boolean page3, boolean reqTypeCR) throws ServiceException
	{
		logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DTO_TO_DO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			if (null != tdgDataMaskingDTO)
			{
				if (null == requestorDO)
				{
					requestorDO = new RequestorDO();
				}
				if (page1)
				{
					if (StringUtils.isNotEmpty(tdgDataMaskingDTO.getId()))
					{
						if (tdgDataMaskingDTO.isReqTypeCR())
						{
							int crNo = tdgDataMaskingDTO.getVno() + 1;
							if (tdgDataMaskingDTO.getId().contains(AppConstant.CR))
							{
								requestorDO.setId(tdgDataMaskingDTO.getId().replace(
										tdgDataMaskingDTO.getId().substring(
												tdgDataMaskingDTO.getId().indexOf(AppConstant.C),
												tdgDataMaskingDTO.getId().length()),
										AppConstant.CR + crNo));
								tdgDataMaskingDTO.setId(requestorDO.getId());
							}
							else
							{
								requestorDO.setId(tdgDataMaskingDTO.getId() + AppConstant.CR
										+ (tdgDataMaskingDTO.getVno() + 1));
								tdgDataMaskingDTO.setId(requestorDO.getId());
							}
							requestorDO.setVno(tdgDataMaskingDTO.getVno() + 1);
						}
						else
						{
							requestorDO.setId(tdgDataMaskingDTO.getId());
							requestorDO.setVno(tdgDataMaskingDTO.getVno());
						}
					}
					else
					{
						requestorDO.setId(AppConstant.MR + seq);
						requestorDO.setVno(0);
					}
					requestorDO.setStatus(AppConstant.OPEN);
					requestorDO.setUserName(tdgDataMaskingDTO.getUserId());
					requestorDO.setName(tdgDataMaskingDTO.getUserName());
					requestorDO.setEmailid(tdgDataMaskingDTO.getEmailId());
					requestorDO.setPhoneno(tdgDataMaskingDTO.getPhoneNo());
					requestorDO.setDepartment(tdgDataMaskingDTO.getDeptName());
					requestorDO.setNeededby(tdgDataMaskingDTO.getNeededBy());
					requestorDO.setProjectName(tdgDataMaskingDTO.getProjName());
					requestorDO.setProjectPhase(tdgDataMaskingDTO.getProjPhase());
					requestorDO.setProjectId(tdgDataMaskingDTO.getProjectId());
					requestorDO.setEnvironment(tdgDataMaskingDTO.getEnvType());
					requestorDO.setRequestTime(new Timestamp(new Date().getTime()));
				}
				if (page2)
				{
					requestorDO.setHlfd(tdgDataMaskingDTO.getPage2Q1());
					requestorDO.setDsmech(tdgDataMaskingDTO.getPage2Q2());
					requestorDO.setOdsmech(tdgDataMaskingDTO.getPage2Q3());
					requestorDO.setProdnonprodUpsteam(tdgDataMaskingDTO.getPage2Q4());
					requestorDO.setNonEnglishChar(tdgDataMaskingDTO.getPage2Q5());
					requestorDO.setDfdchart(tdgDataMaskingDTO.getPage2Q6());
					requestorDO.setOatpsource(tdgDataMaskingDTO.getPage2Q7());
					requestorDO.setDsADU(tdgDataMaskingDTO.getPage2Q8());
					requestorDO.setPiiMnpi(tdgDataMaskingDTO.getPage2Q9());
					requestorDO.setMaskNonProd(tdgDataMaskingDTO.getPage2Q10());
					requestorDO.setValMaskData(tdgDataMaskingDTO.getPage2Q11());
					requestorDO.setProdSensElem(tdgDataMaskingDTO.getPage2Q12());
					requestorDO.setRequestTime(new Timestamp(new Date().getTime()));

					if (tdgDataMaskingDTO.getMaskingReqChkbx() != null)
					{
						requestorDO.setMaskingReqInd("Y");
					}
					if (tdgDataMaskingDTO.getSubsettingChkbx() != null)
					{
						requestorDO.setSubSetReqInd("Y");
					}
					if (tdgDataMaskingDTO.getDataRefershChkbx() != null)
					{
						requestorDO.setDataRfreshReqInd("Y");
					}
				}
				if (page3)
				{
					if (tdgDataMaskingDTO.getDataSubsetting() == AppConstant.TRUE)
					{
						requestorDO.setSubSettingReqQ1(tdgDataMaskingDTO.getSubSetQ1());
						requestorDO.setSubSettingCritQ2(tdgDataMaskingDTO.getSubSetQ2());
						requestorDO.setSubSettingEnvQ3(tdgDataMaskingDTO.getSubSetQ3());
					}
					else if (tdgDataMaskingDTO.getDataRefresh() == AppConstant.TRUE)
					{
						requestorDO.setDrFreqQ1(tdgDataMaskingDTO.getDataRefreshQ1());
						requestorDO.setDrNonProdEnvQ2(tdgDataMaskingDTO.getDataRefreshQ2());
						requestorDO.setDrMaskingQ3(tdgDataMaskingDTO.getDataRefreshQ3());
					}
					else
					{
						requestorDO.setNonEngLang(tdgDataMaskingDTO.getPage3Q1());
						requestorDO.setNoOfTable(tdgDataMaskingDTO.getPage3Q2());
						requestorDO.setCountDatabase(tdgDataMaskingDTO.getPage3Q3());
						requestorDO.setDsSchemaChnage(tdgDataMaskingDTO.getPage3Q4());
						requestorDO.setVolDataDataMask(tdgDataMaskingDTO.getPage3Q5());
						requestorDO.setPlaceMaskingStg(tdgDataMaskingDTO.getPage3Q6());
						requestorDO.setNonProdMask(tdgDataMaskingDTO.getPage3Q7());
						requestorDO.setDataMaskDev(tdgDataMaskingDTO.getPage3Q8());
						requestorDO.setDataMaskOngoingSupport(tdgDataMaskingDTO.getPage3Q9());
						requestorDO.setSlaDataMasking(tdgDataMaskingDTO.getPage3Q10());
					}

					requestorDO.setRequestTime(new Timestamp(new Date().getTime()));
					if(tdgDataMaskingDTO.isSubmitingReq())
					{
					 requestorDO.setStatus(AppConstant.SUBMITTED);
					}
					requestorDO.setNoOfApps(tdgDataMaskingDTO.getPage3NoOfApps());
					if (!tdgDataMaskingDTO.isCaptured())
					{
						ReqChDO reqChDO = null;
						List<ReqChDO> reqChDOList = new ArrayList<ReqChDO>();
						for (TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO : tdgDataMaskingDTO
								.getTdgDataMaskingNoOfAppsDTOs())
						{
							reqChDO = new ReqChDO();
							reqChDO.setRequestor(requestorDO);
							reqChDO.setPId(requestorDO.getId());
							reqChDO.setAppName(tdgDataMaskingNoOfAppsDTO.getAppName());
							reqChDO.setDbName(tdgDataMaskingNoOfAppsDTO.getDbName());
							reqChDO.setNoOfTable(tdgDataMaskingNoOfAppsDTO.getNoOfTables());
							if (StringUtils.isNotEmpty(tdgDataMaskingNoOfAppsDTO.getAppName()))
							{
								reqChDOList.add(reqChDO);
							}
						}
						requestorDO.setChngReqCmmt(tdgDataMaskingDTO.getChngReqCmmt());
						requestorDO.setReqChDOs(reqChDOList);
					}
				}
				else if (null != requestorDO.getReqChDOs()
						&& requestorDO.getId().contains(AppConstant.CR))
				{
					for (int i = 0; i < requestorDO.getReqChDOs().size(); i++)
					{
						requestorDO.getReqChDOs().get(i).setPId(requestorDO.getId());
						requestorDO.getReqChDOs().get(i).setId(null);
					}
				}
			}
			logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DTO_TO_DO
					+ MessageConstant.LOG_INFO_RETURN);
			return requestorDO;
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdgDataMaskingDTO convertDOtoMaskDTO(TdgDataMaskingDTO tdgDataMaskingDTO,
			RequestorDO requestorDO, boolean page1, boolean page2, boolean page3)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DO_TO_DTO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			List<TdgDataMaskingNoOfAppsDTO> tdgDataMaskingNoOfAppsDTOList = null;
			TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO = null;
			if (requestorDO != null)
			{
				if (page1)
				{
					tdgDataMaskingDTO.setId(requestorDO.getId());
					tdgDataMaskingDTO.setUserName(requestorDO.getName());
					tdgDataMaskingDTO.setUserId(requestorDO.getUserName());
					tdgDataMaskingDTO.setEmailId(requestorDO.getEmailid());
					tdgDataMaskingDTO.setPhoneNo(requestorDO.getPhoneno());
					tdgDataMaskingDTO.setDeptName(requestorDO.getDepartment());
					tdgDataMaskingDTO.setNeededBy(requestorDO.getNeededby());
					tdgDataMaskingDTO.setProjName(requestorDO.getProjectName());
					tdgDataMaskingDTO.setProjPhase(requestorDO.getProjectPhase());
					tdgDataMaskingDTO.setEnvType(requestorDO.getEnvironment());
					tdgDataMaskingDTO.setProjectId(requestorDO.getProjectId());
					tdgDataMaskingDTO.setVno(requestorDO.getVno());
				}
				if (page2)
				{
					tdgDataMaskingDTO.setPage2Q1(requestorDO.getHlfd());
					tdgDataMaskingDTO.setPage2Q2(requestorDO.getDsmech());
					tdgDataMaskingDTO.setPage2Q3(requestorDO.getOdsmech());
					tdgDataMaskingDTO.setPage2Q4(requestorDO.getProdnonprodUpsteam());
					tdgDataMaskingDTO.setPage2Q5(requestorDO.getNonEnglishChar());
					tdgDataMaskingDTO.setPage2Q6(requestorDO.getDfdchart());
					tdgDataMaskingDTO.setPage2Q7(requestorDO.getOatpsource());
					tdgDataMaskingDTO.setPage2Q8(requestorDO.getDsADU());
					tdgDataMaskingDTO.setPage2Q9(requestorDO.getPiiMnpi());
					tdgDataMaskingDTO.setPage2Q10(requestorDO.getMaskNonProd());
					tdgDataMaskingDTO.setPage2Q11(requestorDO.getValMaskData());
					tdgDataMaskingDTO.setPage2Q12(requestorDO.getProdSensElem());
					if (requestorDO.getMaskingReqInd() != null
							&& !"".equals(requestorDO.getMaskingReqInd()))
					{
						tdgDataMaskingDTO.setMaskingReqChkbx(AppConstant.TRUE);
					}
					if (requestorDO.getSubSetReqInd() != null
							&& !"".equals(requestorDO.getSubSetReqInd()))
					{
						tdgDataMaskingDTO.setSubsettingChkbx(AppConstant.TRUE);
					}
					if (requestorDO.getDataRfreshReqInd() != null
							&& !"".equals(requestorDO.getDataRfreshReqInd()))
					{
						tdgDataMaskingDTO.setDataRefershChkbx(AppConstant.TRUE);
					}
				}
				if (page3)
				{
					tdgDataMaskingDTO.setPage3Q1(requestorDO.getNonEngLang());
					tdgDataMaskingDTO.setPage3Q2(requestorDO.getNoOfTable());
					tdgDataMaskingDTO.setPage3Q3(requestorDO.getCountDatabase());
					tdgDataMaskingDTO.setPage3Q4(requestorDO.getDsSchemaChnage());
					tdgDataMaskingDTO.setPage3Q5(requestorDO.getVolDataDataMask());
					tdgDataMaskingDTO.setPage3Q6(requestorDO.getPlaceMaskingStg());
					tdgDataMaskingDTO.setPage3Q7(requestorDO.getNonProdMask());
					tdgDataMaskingDTO.setPage3Q8(requestorDO.getDataMaskDev());
					tdgDataMaskingDTO.setPage3Q9(requestorDO.getDataMaskOngoingSupport());
					tdgDataMaskingDTO.setPage3Q10(requestorDO.getSlaDataMasking());
					tdgDataMaskingDTO.setPage3NoOfApps(requestorDO.getNoOfApps());
					tdgDataMaskingDTO.setChngReqCmmt(requestorDO.getChngReqCmmt());

					tdgDataMaskingDTO.setDataRefreshQ1(requestorDO.getDrFreqQ1());
					tdgDataMaskingDTO.setDataRefreshQ2(requestorDO.getDrNonProdEnvQ2());
					tdgDataMaskingDTO.setDataRefreshQ3(requestorDO.getDrMaskingQ3());

					tdgDataMaskingDTO.setSubSetQ1(requestorDO.getSubSettingReqQ1());
					tdgDataMaskingDTO.setSubSetQ2(requestorDO.getSubSettingCritQ2());
					tdgDataMaskingDTO.setSubSetQ3(requestorDO.getSubSettingEnvQ3());

					if (requestorDO.getReqChDOs() != null && 0 < requestorDO.getReqChDOs().size())
					{
						tdgDataMaskingNoOfAppsDTOList = new ArrayList<TdgDataMaskingNoOfAppsDTO>();
						for (ReqChDO reqChDO : requestorDO.getReqChDOs())
						{
							tdgDataMaskingNoOfAppsDTO = new TdgDataMaskingNoOfAppsDTO();
							tdgDataMaskingNoOfAppsDTO.setAppName(reqChDO.getAppName());
							tdgDataMaskingNoOfAppsDTO.setDbName(reqChDO.getDbName());
							tdgDataMaskingNoOfAppsDTO.setId(String.valueOf(reqChDO.getId()));
							tdgDataMaskingNoOfAppsDTO.setNoOfTables(reqChDO.getNoOfTable());
							tdgDataMaskingNoOfAppsDTOList.add(tdgDataMaskingNoOfAppsDTO);
						}
					}
					tdgDataMaskingDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingNoOfAppsDTOList);
				}
				if (page1 && page2 && page3)
				{
					tdgDataMaskingDTO.setReqTime(requestorDO.getRequestTime().toString());
					tdgDataMaskingDTO.setStatus(requestorDO.getStatus());
				}
			}
			logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DO_TO_DTO
					+ MessageConstant.LOG_INFO_RETURN);
			return tdgDataMaskingDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdgDataMaskingDTO convertDOtoMaskDTOs(TdgDataMaskingDTO tdgDataMaskingDTO,
			List<RequestorDO> requestorDOs, boolean page1, boolean page2, boolean page3)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DO_TO_DTOS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			List<TdgDataMaskingDTO> tdgDataMaskingDTOs = null;
			TdgDataMaskingDTO tdgDataMaskingDTO1 = null;
			if (null != requestorDOs && 0 < requestorDOs.size())
			{
				tdgDataMaskingDTOs = new ArrayList<TdgDataMaskingDTO>();
				for (RequestorDO requestorDO : requestorDOs)
				{
					tdgDataMaskingDTO1 = new TdgDataMaskingDTO();
					tdgDataMaskingDTOs.add(convertDOtoMaskDTO(tdgDataMaskingDTO1, requestorDO,
							page1, page2, page3));
					tdgDataMaskingDTO1 = null;
				}
			}
			tdgDataMaskingDTO.setTdgDataMaskingDTOs(tdgDataMaskingDTOs);
			logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DO_TO_DTOS
					+ MessageConstant.LOG_INFO_RETURN);
			return tdgDataMaskingDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DO_TO_DTOS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_DMASK_DO_TO_DTOS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdgDataMaskingDTO> converTdmOnboardReqDOtoDTO(List<TdmOnboardReqDO> tdmOnboardReqDOs)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DO_TO_DTO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			SimpleDateFormat format = new SimpleDateFormat(AppConstant.DDMMYYYY_HHMMSS);
			TdgDataMaskingDTO tdgDataMaskingDTO = null;
			List<TdgDataMaskingDTO> tdgDataMaskingDTOList = null;
			if (tdmOnboardReqDOs != null && 0 < tdmOnboardReqDOs.size())
			{
				tdgDataMaskingDTOList = new ArrayList<TdgDataMaskingDTO>();
				for (TdmOnboardReqDO tdmOnboardReqDO : tdmOnboardReqDOs)
				{
					tdgDataMaskingDTO = new TdgDataMaskingDTO();
					tdgDataMaskingDTO.setId(tdmOnboardReqDO.getOnboardReqId());
					tdgDataMaskingDTO.setUserName(tdmOnboardReqDO.getUName());
					tdgDataMaskingDTO.setUserId(tdmOnboardReqDO.getUserName());
					tdgDataMaskingDTO.setDeptName(tdmOnboardReqDO.getDept());
					tdgDataMaskingDTO.setProjName(tdmOnboardReqDO.getAppName());
					tdgDataMaskingDTO.setProjPhase(tdmOnboardReqDO.getAppPhase());
					tdgDataMaskingDTO.setReqTime(format.format(tdmOnboardReqDO.getActionDt()));
					tdgDataMaskingDTO.setStatus(tdmOnboardReqDO.getStatus());
					tdgDataMaskingDTO.setDesc(tdmOnboardReqDO.getAppDesc());
					tdgDataMaskingDTOList.add(tdgDataMaskingDTO);
				}
			}
			logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DO_TO_DTO
					+ MessageConstant.LOG_INFO_RETURN);
			return tdgDataMaskingDTOList;
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DO_TO_DTO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmOnboardReqDO convertTdmOnBoardReqDTOToDO(TdmOnBoardReqDTO tdmOnboardReqDTO, String seq)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DTO_TO_DO
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			TdmOnboardReqDO tdmOnboardReqDO = null;
			if (null != tdmOnboardReqDTO)
			{
				tdmOnboardReqDO = new TdmOnboardReqDO();
				if (StringUtils.isNotEmpty(tdmOnboardReqDTO.getOnboardReqId()))
				{
					int crNo = tdmOnboardReqDTO.getVno() + 1;
					if (tdmOnboardReqDTO.getOnboardReqId().contains(AppConstant.CR))
					{
						tdmOnboardReqDO.setOnboardReqId(tdmOnboardReqDTO.getOnboardReqId().replace(
								tdmOnboardReqDTO.getOnboardReqId().substring(
										tdmOnboardReqDTO.getOnboardReqId().indexOf(AppConstant.C),
										tdmOnboardReqDTO.getOnboardReqId().length()),
								AppConstant.CR + crNo));
						tdmOnboardReqDTO.setOnboardReqId(tdmOnboardReqDO.getOnboardReqId());
					}
					else
					{
						tdmOnboardReqDO.setOnboardReqId(tdmOnboardReqDTO.getOnboardReqId()
								+ AppConstant.CR + (tdmOnboardReqDTO.getVno() + 1));
						tdmOnboardReqDTO.setOnboardReqId(tdmOnboardReqDO.getOnboardReqId());
					}
					tdmOnboardReqDO.setVno(tdmOnboardReqDTO.getVno() + 1);
				}
				else
				{
					tdmOnboardReqDO.setOnboardReqId(AppConstant.TR + seq);
					tdmOnboardReqDO.setVno(0);
				}
				tdmOnboardReqDO.setAppDesc(tdmOnboardReqDTO.getAppDesc());
				tdmOnboardReqDO.setAppName(tdmOnboardReqDTO.getAppName());
				tdmOnboardReqDO.setAppPhase(tdmOnboardReqDTO.getAppPhase());
				tdmOnboardReqDO.setDept(tdmOnboardReqDTO.getDeptName());
				tdmOnboardReqDO.setEmailId(tdmOnboardReqDTO.getEmailId());
				tdmOnboardReqDO.setEnvName(tdmOnboardReqDTO.getEnvType());
				tdmOnboardReqDO.setPhoneNo(tdmOnboardReqDTO.getPhoneNo());
				tdmOnboardReqDO.setUName(tdmOnboardReqDTO.getUserName());
				tdmOnboardReqDO.setUserName(tdmOnboardReqDTO.getUserId());
				tdmOnboardReqDO.setActionBy(tdmOnboardReqDTO.getUserId());
				tdmOnboardReqDO.setActionDt(new Timestamp(new Date().getTime()));
				tdmOnboardReqDO.setStatus(AppConstant.SUBMITTED);
				if (null != tdmOnboardReqDTO.getTdgDataMaskingNoOfAppsDTOs()
						&& 0 < tdmOnboardReqDTO.getTdgDataMaskingNoOfAppsDTOs().size())
				{
					TdmOnboadReqNoTabDO tdmOnboadReqNoTabDO = null;
					List<TdmOnboadReqNoTabDO> tdmOnboadReqNoTabDOs = new ArrayList<TdmOnboadReqNoTabDO>();
					for (TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO : tdmOnboardReqDTO
							.getTdgDataMaskingNoOfAppsDTOs())
					{
						tdmOnboadReqNoTabDO = new TdmOnboadReqNoTabDO();
						tdmOnboadReqNoTabDO.setAppName(tdgDataMaskingNoOfAppsDTO.getAppName());
						tdmOnboadReqNoTabDO.setDbName(tdgDataMaskingNoOfAppsDTO.getDbName());
						tdmOnboadReqNoTabDO.setId(RandomUtils.nextInt());
						tdmOnboadReqNoTabDO.setNoOfTable(tdgDataMaskingNoOfAppsDTO.getNoOfTables());
						tdmOnboadReqNoTabDO.setOnboardReqId(tdmOnboardReqDO.getOnboardReqId());
						tdmOnboadReqNoTabDO.setTdmOnboardReq(tdmOnboardReqDO);
						if (StringUtils.isNotEmpty(tdgDataMaskingNoOfAppsDTO.getAppName()))
						{
							tdmOnboadReqNoTabDOs.add(tdmOnboadReqNoTabDO);
						}
					}
					tdmOnboardReqDO.setTdmOnboadReqNoTabs(tdmOnboadReqNoTabDOs);
				}
			}
			logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DTO_TO_DO
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmOnboardReqDO;
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DTO_TO_DO
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmOnBoardReqDTO convertTdmOnboardReqDOToDO(TdmOnboardReqDO tdmOnboardReqDO)
			throws ServiceException
	{
		logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DO_TO_DTOS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			TdmOnBoardReqDTO tdmOnBoardReqDTO = null;
			if (null != tdmOnboardReqDO)
			{
				tdmOnBoardReqDTO = new TdmOnBoardReqDTO();
				tdmOnBoardReqDTO.setOnboardReqId(tdmOnboardReqDO.getOnboardReqId());
				tdmOnBoardReqDTO.setAppDesc(tdmOnboardReqDO.getAppDesc());
				tdmOnBoardReqDTO.setAppName(tdmOnboardReqDO.getAppName());
				tdmOnBoardReqDTO.setAppPhase(tdmOnboardReqDO.getAppPhase());
				tdmOnBoardReqDTO.setDeptName(tdmOnboardReqDO.getDept());
				tdmOnBoardReqDTO.setEmailId(tdmOnboardReqDO.getEmailId());
				tdmOnBoardReqDTO.setEnvType(tdmOnboardReqDO.getEnvName());
				tdmOnBoardReqDTO.setPhoneNo(tdmOnboardReqDO.getPhoneNo());
				tdmOnBoardReqDTO.setUserName(tdmOnboardReqDO.getUName());
				tdmOnBoardReqDTO.setUserId(tdmOnboardReqDO.getUserName());
				tdmOnBoardReqDTO.setVno(tdmOnboardReqDO.getVno());
				if (null != tdmOnboardReqDO.getTdmOnboadReqNoTabs()
						&& 0 < tdmOnboardReqDO.getTdmOnboadReqNoTabs().size())
				{
					TdgDataMaskingNoOfAppsDTO tdgDataMaskingNoOfAppsDTO = null;
					List<TdgDataMaskingNoOfAppsDTO> tdgDataMaskingNoOfAppsDTOs = new ArrayList<TdgDataMaskingNoOfAppsDTO>();
					for (TdmOnboadReqNoTabDO tdmOnboadReqNoTabDO : tdmOnboardReqDO
							.getTdmOnboadReqNoTabs())
					{
						tdgDataMaskingNoOfAppsDTO = new TdgDataMaskingNoOfAppsDTO();
						tdgDataMaskingNoOfAppsDTO.setAppName(tdmOnboadReqNoTabDO.getAppName());
						tdgDataMaskingNoOfAppsDTO.setDbName(tdmOnboadReqNoTabDO.getDbName());
						tdgDataMaskingNoOfAppsDTO
								.setId(String.valueOf(tdmOnboadReqNoTabDO.getId()));
						tdgDataMaskingNoOfAppsDTO.setNoOfTables(tdmOnboadReqNoTabDO.getNoOfTable());
						tdgDataMaskingNoOfAppsDTOs.add(tdgDataMaskingNoOfAppsDTO);
					}
					tdmOnBoardReqDTO.setTdgDataMaskingNoOfAppsDTOs(tdgDataMaskingNoOfAppsDTOs);
				}
			}
			logger.info(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DO_TO_DTOS
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmOnBoardReqDTO;
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DO_TO_DTOS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_DMASK_MAPPER + MessageConstant.TDM_ONBOARD_DO_TO_DTOS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

}
