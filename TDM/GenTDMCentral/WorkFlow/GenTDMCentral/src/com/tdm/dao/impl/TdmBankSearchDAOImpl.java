/*---------------------------------------------------------------------------------------
 * Object Name: TdmBankSearchDAOImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          09/10/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.tdm.constant.MessageConstant;
import com.tdm.dao.TdmBankSearchDAO;
import com.tdm.exception.DAOException;
import com.tdm.model.DO.AccountDO;
import com.tdm.model.DO.ReservationDO;
import com.tdm.model.DTO.AccountDTO;

/**
 * 
 * @author Seshadri Chowdary
 *
 */

@Component(MessageConstant.TDM_BANK_SEARCH_DAO)
public class TdmBankSearchDAOImpl implements TdmBankSearchDAO
{
	private static Logger logger = Logger.getLogger(TdmBankSearchDAOImpl.class);

	@Override
	public List<AccountDO> searchAccountDetails(AccountDTO acDTO, int offSet, int recordsperpage,
			EntityManager managerSubsc) throws DAOException {
		try {
			StringBuffer query = new StringBuffer(
					"SELECT s FROM AccountDO s JOIN s.custmerDetails scus JOIN s.creditCardDetails scredit where 0=0 ");

			if (StringUtils.isNotEmpty(acDTO.getAccoutnType())
					&& !MessageConstant.ANY.equalsIgnoreCase(acDTO.getAccoutnType())) {
				query.append(" AND s.accoutnType ='").append(acDTO.getAccoutnType().toUpperCase())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(acDTO.getBalFrom())
					&& !MessageConstant.ANY.equalsIgnoreCase(acDTO.getBalFrom())) {
				query.append(" AND s.balance >= '").append(acDTO.getBalFrom()).append('\'');
			}
			if (StringUtils.isNotEmpty(acDTO.getBalTo())
					&& !MessageConstant.ANY.equalsIgnoreCase(acDTO.getBalTo())) {
				query.append(" AND s.balance <= '").append(acDTO.getBalTo()).append('\'');
			}
			if (StringUtils.isNotEmpty(acDTO.getAccountStatus())
					&& !MessageConstant.ANY.equalsIgnoreCase(acDTO.getAccountStatus())) {
				query.append(" AND s.accountStatus ='")
						.append(acDTO.getAccountStatus().toUpperCase()).append('\'');
			}

			if (acDTO.isOverDraftEnabled()) {
				query.append(" AND s.overDftInd ='N'");
			} else {
				query.append(" AND s.overDftInd ='Y'");
			}

			if (StringUtils.isNotEmpty(acDTO.getBranchCode())) {
				query.append(" AND s.branchCode ='").append(acDTO.getBranchCode()).append('\'');
			}
			if (StringUtils.isNotEmpty(acDTO.getCustmerType())
					&& !MessageConstant.ANY.equalsIgnoreCase(acDTO.getCustmerType())) {
				// put the exact column name of customerType here
				query.append(" AND scus.custmerType ='")
						.append(acDTO.getCustmerType().toUpperCase()).append('\'');
			}
			if (StringUtils.isNotEmpty(acDTO.getCcExpdateTo())
					&& !MessageConstant.ANY.equalsIgnoreCase(acDTO.getCcExpdateTo())) {
				query.append(" AND s.expDate like %'").append(acDTO.getCcExpdateTo()).append("% ")
						.append('\'');
			}

			if (acDTO.isGender()) {
				query.append(" AND scus.gender ='Male'");
			} else {
				query.append(" AND scus.gender ='Female'");
			}

			if (acDTO.isCreditCard()) {
				query.append(" AND scredit.creditCardType ='")
						.append(acDTO.getCrditCardType().toUpperCase()).append('\'');
			}

			@SuppressWarnings("unchecked")
			List<AccountDO> list = managerSubsc.createQuery(query.toString())
					.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();

			return list;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public void resrerveBankRecords(List<ReservationDO> reservationDOList, String testcseId,
			String testcseName, String userId, EntityManager managerSubsc) throws DAOException {
		try {
			List<ReservationDO> reservationDOs = null;
			if (null != reservationDOList && 0 < reservationDOList.size()) {
				managerSubsc.getTransaction().begin();
				reservationDOs = new ArrayList<ReservationDO>();
				for (ReservationDO reservationDO : reservationDOList) {
					if (null != reservationDO) {
						reservationDO.setTestCaseId(testcseId);
						reservationDO.setTestCaseName(testcseName);
						reservationDO.setUserId(userId);
						reservationDO = managerSubsc.merge(reservationDO);

						reservationDOs.add(reservationDO);
					}

				}
				managerSubsc.getTransaction().commit();
			}
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
		} catch (IllegalStateException illegalStateEx) {
			illegalStateEx.printStackTrace();
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}

	}

	@Override
	public List<ReservationDO> getResrvedRecords(String username, EntityManager managerSubsc)
			throws DAOException {
		try {
			@SuppressWarnings("unchecked")
			List<ReservationDO> tdmReservationDO = managerSubsc.createQuery(
					"SELECT t FROM ReservationDO t where t.userId='" + username
							+ "' AND t.locked='Y'").getResultList();
			return tdmReservationDO;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public void unReserveBankResrvedRecords(List<ReservationDO> unResrveList, String userId,
			EntityManager managerSubsc) throws DAOException {
		List<ReservationDO> reservationDOs = null;
		try {
			if (null != unResrveList && 0 < unResrveList.size()) {
				managerSubsc.getTransaction().begin();
				reservationDOs = new ArrayList<ReservationDO>();
				for (ReservationDO tdmReserveDo : unResrveList) {
					if (tdmReserveDo != null) {
						tdmReserveDo.setUserId(userId);
						tdmReserveDo = managerSubsc.merge(tdmReserveDo);
						reservationDOs.add(tdmReserveDo);
					}
				}
				managerSubsc.getTransaction().commit();
			}
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

}
