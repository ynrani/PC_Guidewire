package com.tesda.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TdmPolicyAutoPropSearchDAO;
import com.tesda.exception.DAOException;
import com.tesda.exception.ServiceException;
import com.tesda.model.DO.PolicySummaryStg;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchResultDTO;
import com.tesda.model.mapper.TdmPolicyAutoPropSearchMapper;
import com.tesda.service.TdmPolicyAutoPropSearchService;

@Component
@Service("tdmPolicyAutoPropSearchService")
@Transactional(propagation = Propagation.REQUIRED)
public class TdmPolicyAutoPropSearchServiceImpl extends TdmBaseServiceImpl implements
		TdmPolicyAutoPropSearchService
{
	final static Logger logger = Logger.getLogger(TdmPolicyAutoPropSearchServiceImpl.class);

	@Autowired
	TdmPolicyAutoPropSearchDAO tdmPolicyAutoPropSearchDAO;

	@Autowired
	TdmPolicyAutoPropSearchMapper tdmPolicyAutoPropSearchMapper;

	@Autowired
	private MessageSource messageSource;

	@Override
	public TdmPolicyPropertySearchDTO searchPolicyPropRecordsByPolicySearchNew(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException {
		String searchType = "CSAA_PO";
		String policytype = "Property";

		List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchDTOList = null;
		List<PolicySummaryStg> policySummaryStgDOs = null;
		List<TdmReservationDO> reservationDOs1 = null;
		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();

			/**
			 * 1. going to fetch reserved records
			 */
			reservationDOs1 = tdmPolicyAutoPropSearchDAO.getReservedRecords(userName, searchType,
					managerCsaaUser);
			StringBuffer policyProps = new StringBuffer();
			if (null != reservationDOs1 && 0 < reservationDOs1.size()) {
				for (TdmReservationDO reservationDO : reservationDOs1) {
					if (null != reservationDO.getReserveDataType()
							&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
						policyProps.append(",'" + reservationDO.getPolicyNumber() + "'");
					}
				}
			}
			reservationDOs1 = null;

			/**
			 * 2. going to fetch remains records apart from reserved based on criteria
			 */
			policySummaryStgDOs = tdmPolicyAutoPropSearchDAO
					.searchPolicyPropRecordsByPolicySearchNew(tdmPolicyPropertySearchDTO, offSet,
							recordsperpage, pageNationOnOffFlag, policyProps, policytype,
							managerCsaaUser);

			/**
			 * 3. going to convert DO to DTO class
			 */
			tdmPolicyPropertySearchDTOList = tdmPolicyAutoPropSearchMapper
					.converPolicysummaryToTdmPolicyPropertySearchDTONew(policySummaryStgDOs,
							tdmPolicyPropertySearchDTO);

			tdmPolicyPropertySearchDTO
					.setTdmPolicyPropertySearchResultDTOList(tdmPolicyPropertySearchDTOList);

			closeCsaaUserEntityManager(managerCsaaUser);
			return tdmPolicyPropertySearchDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public TdmPolicyAutoSearchDTO searchPolicyAutoRecordsByPolicySearchNew(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException {
		String searchType = "CSAA_AU";
		String ptype = "AUTO";

		try {
			EntityManager managerUser = openCsaaUserEntityManager();

			/**
			 * 1. going to fetch reserved records
			 */
			List<TdmReservationDO> reservationDOs1 = tdmPolicyAutoPropSearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			StringBuffer policyautos = new StringBuffer();
			if (null != reservationDOs1 && 0 < reservationDOs1.size()) {
				for (TdmReservationDO reservationDO : reservationDOs1) {
					if (null != reservationDO.getReserveDataType()
							&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
						policyautos.append(",'" + reservationDO.getPolicyNumber() + '\'');
					}
				}
			}
			/**
			 * 2. going to fetch remains records apart from reserved based on criteria
			 */

			List<PolicySummaryStg> policySummaryStgDOs = tdmPolicyAutoPropSearchDAO
					.searchPolicyAutoRecordsByPolicySearchNew(tdmPolicyAutoSearchDTO, offSet,
							recordsperpage, pageNationOnOffFlag, policyautos, ptype, managerUser);

			/**
			 * 3. going to convert DO to DTO class
			 */
			List<TdmPolicyAutoSearchResultDTO> tdmPolicyAutoSearchResultDTO = tdmPolicyAutoPropSearchMapper
					.converPolicysummaryToTdmPolicyAutoSearchResultDTONew(policySummaryStgDOs,
							tdmPolicyAutoSearchDTO);
			tdmPolicyAutoSearchDTO
					.setTdmPolicyAutoSearchResultDTOList(tdmPolicyAutoSearchResultDTO);

			closeCsaaUserEntityManager(managerUser);

			return tdmPolicyAutoSearchDTO;
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);
		} catch (DAOException daoEx) {
			logger.error("DAO exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);
		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public int saveReservedData(TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			String userName, String enviro) throws ServiceException {

		try {
			List<TdmReservationDO> list = null;

			if (null != tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList()
					&& 0 < tdmPolicyPropertySearchDTO.getTdmPolicyPropertySearchResultDTOList()
							.size()) {
				EntityManager managerCsaaUser = openCsaaUserEntityManager();
				List<TdmReservationDO> reservationDOs = tdmPolicyAutoPropSearchMapper
						.converTdmPolicyPropertySearchDTOToTdmReservationDO(
								tdmPolicyPropertySearchDTO
										.getTdmPolicyPropertySearchResultDTOList(),
								tdmPolicyPropertySearchDTO.getSearchCriti(), userName, enviro);
				list = tdmPolicyAutoPropSearchDAO.saveReservedData(reservationDOs,
						tdmPolicyPropertySearchDTO.getTestCaseId(),
						tdmPolicyPropertySearchDTO.getTestCaseName(), managerCsaaUser);
				closeCsaaUserEntityManager(managerCsaaUser);
			}

			return list.size();
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}

	}

	@Override
	public int saveReservedData(TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, String userName,
			String enviro) throws ServiceException {

		try {
			List<TdmReservationDO> list = null;

			if (null != tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList()
					&& 0 < tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList().size()) {
				EntityManager managerCsaaUser = openCsaaUserEntityManager();
				List<TdmReservationDO> reservationDOs = tdmPolicyAutoPropSearchMapper
						.converTdmPolicyAutoSearchResultDTOToTdmReservationDO(
								tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList(),
								tdmPolicyAutoSearchDTO.getSearchCriti(), userName, enviro);
				list = tdmPolicyAutoPropSearchDAO.saveReservedData(reservationDOs,
						tdmPolicyAutoSearchDTO.getTestCaseId(),
						tdmPolicyAutoSearchDTO.getTestCaseName(), managerCsaaUser);
				closeCsaaUserEntityManager(managerCsaaUser);
			}
			return list.size();
		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

}
