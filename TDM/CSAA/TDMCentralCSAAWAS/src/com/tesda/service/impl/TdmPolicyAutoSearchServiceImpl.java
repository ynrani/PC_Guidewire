package com.tesda.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.TdmPolicyAutoSearchDAO;
import com.tesda.exception.DAOException;
import com.tesda.exception.ServiceException;
import com.tesda.model.DO.CassPolListDO;
import com.tesda.model.DO.PolicysummaryDO;
import com.tesda.model.DO.TdmPolicySearchDO;
import com.tesda.model.DO.TdmReservationDO;
import com.tesda.model.DTO.TdmAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchDTO;
import com.tesda.model.DTO.TdmPolicyAutoSearchResultDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchDTO;
import com.tesda.model.DTO.TdmPolicyPropertySearchResultDTO;
import com.tesda.model.mapper.TdmPolicyAutoSearchMapper;
import com.tesda.service.TdmPolicyAutoSearchService;

@Component
@Service("tdmPolicyAutoSearchService")
@Transactional(propagation = Propagation.REQUIRED)
public class TdmPolicyAutoSearchServiceImpl extends TdmBaseServiceImpl implements
		TdmPolicyAutoSearchService
{
	final static Logger logger = Logger.getLogger(TdmPolicyAutoSearchServiceImpl.class);

	@Autowired
	TdmPolicyAutoSearchDAO tdmPolicyAutoSearchDAO;

	@Autowired
	TdmPolicyAutoSearchMapper tdmPolicyAutoSearchMapper;

	@Autowired
	private MessageSource messageSource;

	@Override
	public TdmPolicyPropertySearchDTO searchPolicyPropRecords(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException {
		StringBuffer sb = null;
		String searchType = "CSAA_PO";
		String policytype = "Property";
		String ptype = "HOME";
		List<Object[]> riskCovList = null;
		try {

			if (StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddDocReq())
					&& "Y".equalsIgnoreCase(tdmPolicyPropertySearchDTO.getAddDocReq())) {

				tdmPolicyPropertySearchDTO = searchPolicyPropRecordsByPolicySearch(
						tdmPolicyPropertySearchDTO, offSet, recordsperpage, pageNationOnOffFlag,
						userName);
			} else {
				EntityManager managerCsaaUser = openCsaaUserEntityManager();
				EntityManager factoryCsaaProp = openCsaaPropAutoEntityManager();

				List<TdmReservationDO> reservationDOs1 = tdmPolicyAutoSearchDAO.getReservedRecords(
						userName, searchType, managerCsaaUser);
				StringBuffer policyProps = new StringBuffer();
				if (null != reservationDOs1 && 0 < reservationDOs1.size()) {
					for (TdmReservationDO reservationDO : reservationDOs1) {
						if (null != reservationDO.getReserveDataType()
								&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
							policyProps.append(",'" + reservationDO.getPolicyNumber() + "'");
						}
					}
				}
				StringBuffer listOfPolocies = null;
				List<CassPolListDO> cassPolListDOs = null;

				List<PolicysummaryDO> propPolicyDOlist = tdmPolicyAutoSearchDAO
						.searchPolicyPropRecords(tdmPolicyPropertySearchDTO, offSet,
								recordsperpage, pageNationOnOffFlag, policyProps, policytype,
								listOfPolocies, factoryCsaaProp);

				// risk Coverage
				if (!StringUtils.isNotEmpty(tdmPolicyPropertySearchDTO.getAddRiskCovge())
						&& null != propPolicyDOlist && 0 < propPolicyDOlist.size()) {
					sb = new StringBuffer();
					for (PolicysummaryDO policysummaryDO : propPolicyDOlist) {
						sb.append(",'" + policysummaryDO.getPolicynumber() + "'");
					}
					riskCovList = tdmPolicyAutoSearchDAO.getPolicyRiskCov(sb, ptype,
							factoryCsaaProp);
				}
				List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchDTOList = tdmPolicyAutoSearchMapper
						.converPolicysummaryToTdmPolicyPropertySearchDTO(propPolicyDOlist,
								reservationDOs1, userName, tdmPolicyPropertySearchDTO, riskCovList,
								cassPolListDOs);
				tdmPolicyPropertySearchDTO
						.setTdmPolicyPropertySearchResultDTOList(tdmPolicyPropertySearchDTOList);
				closeCsaaPropAutoEntityManager(factoryCsaaProp);
				closeCsaaUserEntityManager(managerCsaaUser);
			}
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
	public TdmPolicyAutoSearchDTO searchPolicyAutoRecords(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException {

		List<Object[]> covList = null;
		List<Object[]> riskCovList = null;
		String searchType = "CSAA_AU";
		String policytype = "Auto";
		String ptype = "AUTO";
		StringBuffer sb = null;

		try {

			if (StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getAssoDocReq())
					&& "Y".equalsIgnoreCase(tdmPolicyAutoSearchDTO.getAssoDocReq())) {

				tdmPolicyAutoSearchDTO = searchPolicyAutoRecordsByPolicySearch(
						tdmPolicyAutoSearchDTO, offSet, recordsperpage, pageNationOnOffFlag,
						userName);
			} else {
				EntityManager managerUser = openCsaaUserEntityManager();
				EntityManager managerCsaa = openCsaaPropAutoEntityManager();
				List<TdmReservationDO> reservationDOs1 = tdmPolicyAutoSearchDAO.getReservedRecords(
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

				TdmAutoSearchResultDTO tdmAutoSearchResultDTO = tdmPolicyAutoSearchDAO
						.searchPolicyAutoRecords(tdmPolicyAutoSearchDTO, offSet, recordsperpage,
								pageNationOnOffFlag, policyautos, policytype, null, managerCsaa);
				// policy Coverage
				if (!StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getPolicyCovge())
						&& null != tdmAutoSearchResultDTO.getListPolicySummeryDo()
						&& 0 < tdmAutoSearchResultDTO.getListPolicySummeryDo().size()) {
					sb = new StringBuffer();
					for (PolicysummaryDO policysummaryDO : tdmAutoSearchResultDTO
							.getListPolicySummeryDo()) {
						sb.append(",'" + policysummaryDO.getPolicynumber() + '\'');
					}
					covList = tdmPolicyAutoSearchDAO.getPolicyCov(sb, managerCsaa);
				}
				sb = null;
				// risk Coverage
				if (!StringUtils.isNotEmpty(tdmPolicyAutoSearchDTO.getRiskCovge())
						&& null != tdmAutoSearchResultDTO.getListPolicySummeryDo()
						&& 0 < tdmAutoSearchResultDTO.getListPolicySummeryDo().size()) {
					sb = new StringBuffer();
					for (PolicysummaryDO policysummaryDO : tdmAutoSearchResultDTO
							.getListPolicySummeryDo()) {
						sb.append(",'" + policysummaryDO.getPolicynumber() + '\'');
					}
					riskCovList = tdmPolicyAutoSearchDAO.getPolicyRiskCov(sb, ptype, managerCsaa);
				}
				List<TdmPolicyAutoSearchResultDTO> fTDProvSearchResultListDTOList50 = tdmPolicyAutoSearchMapper
						.converPolicysummaryToFTdmPolicyAutoSearchResultDTO(tdmAutoSearchResultDTO,
								reservationDOs1, userName, tdmPolicyAutoSearchDTO, covList,
								riskCovList, null);
				tdmPolicyAutoSearchDTO
						.setTdmPolicyAutoSearchResultDTOList(fTDProvSearchResultListDTOList50);
				closeCsaaPropAutoEntityManager(managerCsaa);
				closeCsaaUserEntityManager(managerUser);
			}
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
	public Long searchPolicyAutoRecordsCount(TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO,
			String userName) throws ServiceException {

		try {
			EntityManager managerUser = openCsaaUserEntityManager();
			EntityManager managerCsaa = openCsaaPropAutoEntityManager();

			String searchType = "CSAA_AU";
			String policytype = "Auto";

			List<TdmReservationDO> reservationDOs1 = tdmPolicyAutoSearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			StringBuffer providersIds = new StringBuffer();
			if (null != reservationDOs1 && 0 < reservationDOs1.size()) {
				for (TdmReservationDO reservationDO : reservationDOs1) {
					if (null != reservationDO.getReserveDataType()
							&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
						providersIds.append("'," + reservationDO.getPolicyNumber() + '\'');
					}
				}
			}
			Long count = tdmPolicyAutoSearchDAO.searchPolicyAutoRecordsCount(
					tdmPolicyAutoSearchDTO, providersIds, policytype, managerCsaa);
			if (0 == count && null != reservationDOs1 && 0 < reservationDOs1.size()) {
				count = tdmPolicyAutoSearchDAO.searchPolicyAutoRecordsCount(tdmPolicyAutoSearchDTO,
						null, policytype, managerCsaa);
			}
			closeCsaaPropAutoEntityManager(managerCsaa);
			closeCsaaUserEntityManager(managerUser);

			return count;
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
	public Long searchPolicyPropRecordsCount(TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO,
			String userName) throws ServiceException {

		try {
			String searchType = "CSAA_PO";
			String policytype = "Property";

			EntityManager managerUser = openCsaaUserEntityManager();
			EntityManager factoryCsaaProp = openCsaaPropAutoEntityManager();
			List<TdmReservationDO> reservationDOs1 = tdmPolicyAutoSearchDAO.getReservedRecords(
					userName, searchType, managerUser);
			List<String> policyProps = new ArrayList<String>();
			if (null != reservationDOs1 && 0 < reservationDOs1.size()) {
				for (TdmReservationDO reservationDO : reservationDOs1) {
					if (null != reservationDO.getReserveDataType()
							&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
						policyProps.add(reservationDO.getPolicyNumber());
					}
				}
			}
			Long count = tdmPolicyAutoSearchDAO.searchPolicyPropRecordsCount(
					tdmPolicyPropertySearchDTO, policyProps, policytype, factoryCsaaProp);
			if (0 == count && null != reservationDOs1 && 0 < reservationDOs1.size()) {

				count = tdmPolicyAutoSearchDAO.searchPolicyPropRecordsCount(
						tdmPolicyPropertySearchDTO, null, policytype, factoryCsaaProp);
			}
			closeCsaaPropAutoEntityManager(factoryCsaaProp);
			closeCsaaUserEntityManager(managerUser);

			return count;
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
				List<TdmReservationDO> reservationDOs = tdmPolicyAutoSearchMapper
						.converTdmPolicyPropertySearchDTOToTdmReservationDO(
								tdmPolicyPropertySearchDTO
										.getTdmPolicyPropertySearchResultDTOList(),
								tdmPolicyPropertySearchDTO.getSearchCriti(), userName, enviro);
				list = tdmPolicyAutoSearchDAO.saveReservedData(reservationDOs,
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
				List<TdmReservationDO> reservationDOs = tdmPolicyAutoSearchMapper
						.converTdmPolicyAutoSearchResultDTOToTdmReservationDO(
								tdmPolicyAutoSearchDTO.getTdmPolicyAutoSearchResultDTOList(),
								tdmPolicyAutoSearchDTO.getSearchCriti(), userName, enviro);
				list = tdmPolicyAutoSearchDAO.saveReservedData(reservationDOs,
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

	@Override
	public TdmPolicyAutoSearchDTO searchPolicyAutoRecordsByPolicySearch(
			TdmPolicyAutoSearchDTO tdmPolicyAutoSearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException {
		String searchType = "CSAA_AU";
		String ptype = "AUTO";

		try {
			EntityManager managerUser = openCsaaUserEntityManager();
			EntityManager managerCsaa = openCsaaPropAutoEntityManager();
			/**
			 * 1. going to fetch reserved records
			 */
			List<TdmReservationDO> reservationDOs1 = tdmPolicyAutoSearchDAO.getReservedRecords(
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

			List<TdmPolicySearchDO> listResult = tdmPolicyAutoSearchDAO
					.searchPolicyAutoRecordsByPolicySearchNew(tdmPolicyAutoSearchDTO, offSet,
							pageNationOnOffFlag, recordsperpage, policyautos, ptype, managerUser);

			/**
			 * 3. going to convert DO to DTO class
			 */
			List<TdmPolicyAutoSearchResultDTO> fTDProvSearchResultListDTOList50 = tdmPolicyAutoSearchMapper
					.converPolicysummaryToFTdmPolicyAutoSearchResultDTONew(listResult,
							tdmPolicyAutoSearchDTO);
			tdmPolicyAutoSearchDTO
					.setTdmPolicyAutoSearchResultDTOList(fTDProvSearchResultListDTOList50);
			closeCsaaPropAutoEntityManager(managerCsaa);
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
	public TdmPolicyPropertySearchDTO searchPolicyPropRecordsByPolicySearch(
			TdmPolicyPropertySearchDTO tdmPolicyPropertySearchDTO, int offSet, int recordsperpage,
			boolean pageNationOnOffFlag, String userName) throws ServiceException {
		String searchType = "CSAA_PO";
		String policytype = "Property";
		try {
			EntityManager managerCsaaUser = openCsaaUserEntityManager();

			List<TdmReservationDO> reservationDOs1 = tdmPolicyAutoSearchDAO.getReservedRecords(
					userName, searchType, managerCsaaUser);
			StringBuffer policyProps = new StringBuffer();
			if (null != reservationDOs1 && 0 < reservationDOs1.size()) {
				for (TdmReservationDO reservationDO : reservationDOs1) {
					if (null != reservationDO.getReserveDataType()
							&& reservationDO.getReserveDataType().equalsIgnoreCase(searchType)) {
						policyProps.append(",'" + reservationDO.getPolicyNumber() + "'");
					}
				}
			}
			List<TdmPolicySearchDO> propPolicyDOlist = tdmPolicyAutoSearchDAO
					.searchPolicyPropRecordsByPolicySearch(tdmPolicyPropertySearchDTO, offSet,
							recordsperpage, pageNationOnOffFlag, policyProps, policytype,
							managerCsaaUser);

			List<TdmPolicyPropertySearchResultDTO> tdmPolicyPropertySearchDTOList = tdmPolicyAutoSearchMapper
					.converPolicysummaryToTdmPolicyPropertySearchDTO(propPolicyDOlist,
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

}
