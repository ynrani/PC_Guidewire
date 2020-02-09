/*---------------------------------------------------------------------------------------
 * Object Name: TDMAdminDAOImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. 		Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary   11/04/15  NA          		Created
 * 2		Sikandar Shaikh		18/06/15  Logging changes	Updated
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tesda.dao.impl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tesda.constants.TDMConstants;
import com.tesda.dao.TDMAdminDAO;
import com.tesda.exception.DAOException;
import com.tesda.model.DO.TdmUserDO;
import com.tesda.model.DO.TdmUsersAuthDO;
import com.tesda.model.DO.TdmUsersAuthDOPK;

@Component(TDMConstants.ADMIN_DAO)
public class TDMAdminDAOImpl implements TDMAdminDAO
{

	private static final Logger logger = LoggerFactory.getLogger(TDMAdminDAOImpl.class);

	@PersistenceUnit(unitName = TDMConstants.USER_UNIT)
	private EntityManagerFactory factory;

	@Override
	public String saveUserDetails(TdmUserDO userdo, boolean bCreate) throws DAOException
	{
		try
		{
			String strMessage = "Failed";
			Random randomno = new Random();
			TdmUsersAuthDO tdmUsersAuthDO = new TdmUsersAuthDO();
			tdmUsersAuthDO.setRole(userdo.getTdmUsersAuths().getRole());
			userdo.setPassword(userdo.getUsername().substring(0, 3) + randomno.nextInt(100) + "$");
			TdmUsersAuthDOPK id = new TdmUsersAuthDOPK();
			id.setUserId(userdo.getUserId());
			EntityManager entityManager = factory.createEntityManager();
			boolean bCheckValidateUserid = true;
			entityManager.getTransaction().begin();
			String idrole = "";
			if (bCreate)
			{
				String no = (String) entityManager.createQuery(
						"SELECT MAX(p.id.userRoleId)  from TdmUsersAuthDO p").getSingleResult();
				int noo = Integer.parseInt(no) + 1;
				idrole = Integer.toString(noo);
			}
			else
			{
				List<TdmUsersAuthDO> listUserAuthDo = entityManager
						.createNamedQuery("TdmUsersAuthDO.findByUserId", TdmUsersAuthDO.class)
						.setParameter("userId", userdo.getUserId()).getResultList();
				if (listUserAuthDo != null && !listUserAuthDo.isEmpty())
					idrole = listUserAuthDo.iterator().next().getId().getUserRoleId();
			}
			if (bCheckValidateUserid)
			{
				id.setUserRoleId(idrole);

				tdmUsersAuthDO.setId(id);
				tdmUsersAuthDO.setTdmUser(userdo);
				userdo.setTdmUsersAuths(tdmUsersAuthDO);

				entityManager.merge(userdo);
				entityManager.getTransaction().commit();
				strMessage = "Success";
			}
			entityManager.close();
			return strMessage;
		}
		catch (Exception re)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_61, re);
			throw new DAOException(re.getMessage());
		}
	}

	@Override
	public List<TdmUserDO> getAllUser(TdmUserDO userdo, int offSet, int recordsperpage, boolean b)
			throws DAOException
	{
		try
		{
			EntityManager entityManager = factory.createEntityManager();
			@SuppressWarnings(TDMConstants.UNCHECKED)
			List<TdmUserDO> listUser = entityManager
					.createQuery(
							"SELECT p FROM TdmUserDO p where p.userId != '" + userdo.getUserId()
									+ "' ").setFirstResult(offSet).setMaxResults(recordsperpage)
					.getResultList();
			entityManager.close();
			return listUser;
		}
		catch (Exception re)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_62, re);
			throw new DAOException(re.getMessage());
		}
	}

	@Override
	public TdmUserDO getEditUser(String userId) throws DAOException
	{
		try
		{
			EntityManager entityManager = factory.createEntityManager();
			TdmUserDO listUser = (TdmUserDO) entityManager.createQuery(
					"SELECT p FROM TdmUserDO p where p.userId='" + userId + "'").getSingleResult();
			entityManager.close();
			return listUser;
		}
		catch (Exception re)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_63, re);
			throw new DAOException(re.getMessage());
		}
	}

	@Override
	public String deleteUserByUserId(String userId) throws DAOException
	{
		try
		{
			EntityManager entityManager = factory.createEntityManager();
			entityManager.getTransaction().begin();
			Query q1 = entityManager
					.createQuery("DELETE FROM  TdmUsersAuthDO p where p.id.userId =:userId");
			q1.setParameter("userId", userId);
			q1.executeUpdate();
			Query q2 = entityManager.createQuery("DELETE FROM TdmUserDO p where p.userId =:userId");
			q2.setParameter("userId", userId);
			q2.executeUpdate();
			// int count=q1.executeUpdate();
			entityManager.getTransaction().commit();
			entityManager.close();
			return null;
		}
		catch (Exception re)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_64, re);
			throw new DAOException(re.getMessage());
		}
	}

	@Override
	public Long searchUserRecordsCount(TdmUserDO userdo) throws DAOException
	{
		try
		{
			EntityManager entityManager = factory.createEntityManager();
			String query = "SELECT count(*) FROM TdmUserDO p Where p.userId !='"
					+ userdo.getUserId() + "'";
			Long count = (Long) entityManager.createQuery(query).getSingleResult();
			entityManager.close();
			return count;
		}
		catch (Exception re)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_65, re);
			throw new DAOException(re.getMessage());
		}
	}

	@Override
	public boolean validateUserId(String userId) throws DAOException
	{
		try
		{
			EntityManager entityManager = factory.createEntityManager();
			List<TdmUserDO> listUserDo = entityManager
					.createNamedQuery("TdmUserDO.findByUserId", TdmUserDO.class)
					.setParameter("userId", userId).getResultList();
			entityManager.close();
			return listUserDo != null && !listUserDo.isEmpty() ? false : true;
		}
		catch (Exception re)
		{
			logger.error(TDMConstants.TDMP_DAO_ERROR_66, re);
			throw new DAOException(re.getMessage());
		}
	}

}
