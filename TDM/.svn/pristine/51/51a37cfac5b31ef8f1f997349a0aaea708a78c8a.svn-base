package com.tesda.dao.impl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.tesda.dao.TDMAdminDAO;
import com.tesda.exception.DAOException;
import com.tesda.model.DO.TdmUserDO;
import com.tesda.model.DO.TdmUsersAuthDO;
import com.tesda.model.DO.TdmUsersAuthDOPK;

@Component("tDMAdminDAO")
public class TDMAdminDAOImpl implements TDMAdminDAO
{

	final static Logger logger = Logger.getLogger(TDMAdminDAOImpl.class);

	@PersistenceUnit(unitName = "csaaUserPersistenceUnit")
	private EntityManagerFactory factory;

	@Autowired
	private MessageSource messageSource;

	@Override
	public String saveUserDetails(TdmUserDO userdo, boolean bCreate) throws DAOException
	{
		String strMessage = "Failed";
		EntityManager entityManager = null;
		try
		{
			logger.info("In TDMAdminDAOImpl.saveUserDetails  : ");
			entityManager = factory.createEntityManager();
			Random randomno = new Random();
			TdmUsersAuthDO tdmUsersAuthDO = new TdmUsersAuthDO();
			tdmUsersAuthDO.setRole(userdo.getTdmUsersAuths().getRole());
			userdo.setPassword(userdo.getUsername().substring(0, 3) + randomno.nextInt(100) + "$");
			TdmUsersAuthDOPK id = new TdmUsersAuthDOPK();
			id.setUserId(userdo.getUserId());
			boolean bCheckValidateUserid = true;
			entityManager.getTransaction().begin();
			String idrole = "";
			if (bCreate)
			{
				String no = (String) entityManager.createQuery(
						"SELECT MAX(p.id.userRoleId)  from TdmUsersAuthDO p").getSingleResult();
				int noo = Integer.parseInt(no) + 1;
				idrole = Integer.toString(noo);
			} else
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
		} catch (IllegalStateException illegalStateEx)
		{

			if (entityManager != null)
			{
				entityManager.getTransaction().rollback();
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx)
		{
			if (entityManager != null)
			{
				entityManager.getTransaction().rollback();
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx)
		{
			if (entityManager != null)
			{
				entityManager.getTransaction().rollback();
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx)
		{
			if (entityManager != null)
			{
				entityManager.getTransaction().rollback();
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);
		}

	}

	@Override
	public List<TdmUserDO> getAllUser(TdmUserDO userdo, int offSet, int recordsperpage, boolean b)
	{
		logger.info("In TDMAdminDAOImpl.getAllUser  : ");
		EntityManager entityManager = factory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<TdmUserDO> listUser = entityManager
				.createQuery(
						"SELECT p FROM TdmUserDO p where p.userId != '" + userdo.getUserId() + "' ")
				.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();
		entityManager.close();
		return listUser;
	}

	@Override
	public TdmUserDO getEditUser(String userId) throws DAOException
	{
		EntityManager entityManager = null;
		try
		{
			entityManager = factory.createEntityManager();
			TdmUserDO listUser = (TdmUserDO) entityManager.createQuery(
					"SELECT p FROM TdmUserDO p where p.userId='" + userId + "'").getSingleResult();
			entityManager.close();
			return listUser;
		} catch (IllegalStateException illegalStateEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);

		}
	}

	@Override
	public String deleteUserByUserId(String userId) throws DAOException
	{
		EntityManager entityManager = null;
		try
		{
			entityManager = factory.createEntityManager();
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
		} catch (IllegalStateException illegalStateEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);

		}
	}

	@Override
	public Long searchUserRecordsCount(TdmUserDO userdo) throws DAOException
	{
		EntityManager entityManager = null;
		try
		{
			entityManager = factory.createEntityManager();

			String query = "SELECT count(*) FROM TdmUserDO p Where p.userId !='"
					+ userdo.getUserId() + "'";
			Long count = (Long) entityManager.createQuery(query).getSingleResult();

			entityManager.close();
			return count;
		} catch (IllegalStateException illegalStateEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx)
		{

			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public boolean validateUserId(String userId) throws DAOException
	{
		EntityManager entityManager = null;
		try
		{
			entityManager = factory.createEntityManager();
			List<TdmUserDO> listUserDo = entityManager
					.createNamedQuery("TdmUserDO.findByUserId", TdmUserDO.class)
					.setParameter("userId", userId).getResultList();
			entityManager.close();
			return listUserDo != null && !listUserDo.isEmpty() ? false : true;
		} catch (IllegalStateException illegalStateEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx)
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);
		}
	}

}
