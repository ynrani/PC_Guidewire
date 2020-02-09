/*---------------------------------------------------------------------------------------
 * Object Name: TDMAdminDAOImpl.Java
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

package com.tdm.dao.impl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.dao.TDMAdminDAO;
import com.tdm.exception.DAOException;
import com.tdm.model.DO.TdmUserDO;
import com.tdm.model.DO.TdmUsersAuthDO;
import com.tdm.model.DO.TdmUsersAuthDOPK;

/**
 * 
 * 
 * @author Seshadri Chowdary
 *
 */

@Component(MessageConstant.TDM_ADMIN_DAO)
public class TDMAdminDAOImpl implements TDMAdminDAO
{
	private static Logger logger = Logger.getLogger(TDMAdminDAOImpl.class);

	@Override
	public String saveUserDetails(TdmUserDO userdo, boolean bCreate, EntityManager managerUser)
			throws DAOException {
		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_SAVE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String strMessage = AppConstant.FAILED_SML;
			Random randomno = new Random();
			TdmUsersAuthDO tdmUsersAuthDO = new TdmUsersAuthDO();
			tdmUsersAuthDO.setRole(userdo.getTdmUsersAuths().getRole());
			userdo.setPassword(userdo.getUsername().substring(0, 3) + randomno.nextInt(100) + "$");
			TdmUsersAuthDOPK id = new TdmUsersAuthDOPK();
			id.setUserId(userdo.getUserId());
			boolean bCheckValidateUserid = true;
			String idrole = "";
			if (bCreate) {
				String no = (String) managerUser.createQuery(
						"SELECT MAX(p.id.userRoleId)  from TdmUsersAuthDO p").getSingleResult();
				int noo = Integer.parseInt(no) + 1;
				idrole = Integer.toString(noo);
			} else {
				List<TdmUsersAuthDO> listUserAuthDo = managerUser
						.createNamedQuery("TdmUsersAuthDO.findByUserId", TdmUsersAuthDO.class)
						.setParameter(AppConstant.SESSION_UID, userdo.getUserId()).getResultList();
				if (listUserAuthDo != null && !listUserAuthDo.isEmpty())
					idrole = listUserAuthDo.iterator().next().getId().getUserRoleId();
			}
			if (bCheckValidateUserid) {
				id.setUserRoleId(idrole);
				tdmUsersAuthDO.setId(id);
				tdmUsersAuthDO.setTdmUser(userdo);
				userdo.setTdmUsersAuths(tdmUsersAuthDO);
				managerUser.getTransaction().begin();
				managerUser.merge(userdo);
				managerUser.getTransaction().commit();
				strMessage = AppConstant.SUCCESS_SMALL;
			}
			logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_SAVE
					+ MessageConstant.LOG_INFO_RETURN);
			return strMessage;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_SAVE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_SAVE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_SAVE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_SAVE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}

	@Override
	public List<TdmUserDO> getAllUser(TdmUserDO userdo, int offSet, int recordsperpage, boolean b,
			EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmUserDO> listUser = managerUser
					.createQuery(
							"SELECT p FROM TdmUserDO p where p.userId != '" + userdo.getUserId()
									+ "' ").setFirstResult(offSet).setMaxResults(recordsperpage)
					.getResultList();
			logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_INFO_RETURN);
			return listUser;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmUserDO getEditUser(String userId, EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_EDIT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			TdmUserDO listUser = (TdmUserDO) managerUser.createQuery(
					"SELECT p FROM TdmUserDO p where p.userId='" + userId + "'").getSingleResult();
			managerUser.close();
			logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_EDIT
					+ MessageConstant.LOG_INFO_RETURN);
			return listUser;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_EDIT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_EDIT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_EDIT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_EDIT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String deleteUserByUserId(String userId, EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_DELETE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			managerUser.getTransaction().begin();
			Query q1 = managerUser
					.createQuery("DELETE FROM  TdmUsersAuthDO p where p.id.userId =:userId");
			q1.setParameter(AppConstant.USER_ID, userId);
			q1.executeUpdate();
			Query q2 = managerUser.createQuery("DELETE FROM TdmUserDO p where p.userId =:userId");
			q2.setParameter(AppConstant.USER_ID, userId);
			q2.executeUpdate();
			// int count=q1.executeUpdate();
			managerUser.getTransaction().commit();
			logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_DELETE
					+ MessageConstant.LOG_INFO_RETURN);
			return null;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_DELETE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_DELETE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_DELETE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_DELETE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long searchUserRecordsCount(TdmUserDO userdo, EntityManager managerUser)
			throws DAOException {
		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL
				+ MessageConstant.TDM_ADMIN_DAO_SEARCH_USER_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String query = "SELECT count(*) FROM TdmUserDO p Where p.userId !='"
					+ userdo.getUserId() + "'";
			Long count = (Long) managerUser.createQuery(query).getSingleResult();
			return count;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_ADMIN_DAO_SEARCH_USER_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_ADMIN_DAO_SEARCH_USER_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_ADMIN_DAO_SEARCH_USER_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_ADMIN_DAO_SEARCH_USER_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public boolean validateUserId(String userId, EntityManager managerUser) throws DAOException {
		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_VALIDATE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			List<TdmUserDO> listUserDo = managerUser
					.createNamedQuery("TdmUserDO.findByUserId", TdmUserDO.class)
					.setParameter("userId", userId).getResultList();
			logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_VALIDATE
					+ MessageConstant.LOG_INFO_RETURN);
			return listUserDo != null && !listUserDo.isEmpty() ? false : true;
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_ADMIN_DAO_VALIDATE + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_ADMIN_DAO_VALIDATE + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_ADMIN_DAO_VALIDATE + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_ADMIN_DAO_VALIDATE + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String getUserRole(TdmUserDO userdo, EntityManager managerUser) throws DAOException {

		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GETUSERROLE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		String idrole = "";

		try {

			@SuppressWarnings("unchecked")
			List<TdmUserDO> listUserAuthDo = managerUser.createQuery(
					" select p from TdmUserDO p where p.userId = '" + userdo.getUserId() + "' ")
					.getResultList();
			logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_INFO_RETURN);
			if (listUserAuthDo != null && !listUserAuthDo.isEmpty())
				idrole = listUserAuthDo.iterator().next().getTdmUsersAuths().getRole();
			System.out.println("+++++  " + idrole + " =======");
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_ADMIN_DAO_GET_ALL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
		return idrole;
	}

	@Override
	public TdmUserDO checkAvailabilityOfUserId(String userId, EntityManager managerUser)
			throws DAOException {
		logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL + MessageConstant.TDM_FTD_CHECK_AVIL_USER
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String query = "select count(u1.userId) from TdmUserDO u1 where u1.userId ='" + userId
					+ "'";
			Long count = (Long) managerUser.createQuery(query).getSingleResult();
			if (count > 0) {
				TdmUserDO userDO = managerUser.find(TdmUserDO.class, userId);
				logger.info(MessageConstant.TDM_ADMIN_DAO_IMPL
						+ MessageConstant.TDM_FTD_CHECK_AVIL_USER + MessageConstant.LOG_INFO_RETURN);
				return userDO;
			} else {

				return null;
			}
		} catch (IllegalStateException illegalStateEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_FTD_CHECK_AVIL_USER + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		} catch (IllegalArgumentException illegalArgEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_FTD_CHECK_AVIL_USER + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		} catch (NullPointerException nullPointerEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_FTD_CHECK_AVIL_USER + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {
			logger.error(MessageConstant.TDM_ADMIN_DAO_IMPL
					+ MessageConstant.TDM_FTD_CHECK_AVIL_USER + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}
}
