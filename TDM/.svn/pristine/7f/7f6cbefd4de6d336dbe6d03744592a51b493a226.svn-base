/*
 * Object Name : TDMAdminDAOImpl.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.dao.impl;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.tesda.dao.TDMAdminDAO;
import com.tesda.model.DO.TdgSchemaDO;
import com.tesda.model.DO.TdgUsersDO;
import com.tesda.model.DO.TdmUserDO;
import com.tesda.model.DO.TdmUsersAuthDO;
import com.tesda.model.DO.TdmUsersAuthDOPK;
import com.tesda.util.TdgCentralConstant;

@Component("tDMAdminDAO")
public class TDMAdminDAOImpl implements TDMAdminDAO{
	@PersistenceUnit(unitName = "userPersistenceUnit")
	private EntityManagerFactory factory;

	@Override
	public String saveUserDetails(TdmUserDO userdo, boolean bCreate){
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
		if (bCreate) {
			String no = (String) entityManager.createQuery(
					"SELECT MAX(p.id.userRoleId)  from TdmUsersAuthDO p").getSingleResult();
			int noo = Integer.parseInt(no) + 1;
			idrole = Integer.toString(noo);
		} else {
			List<TdmUsersAuthDO> listUserAuthDo = entityManager
					.createNamedQuery("TdmUsersAuthDO.findByUserId", TdmUsersAuthDO.class)
					.setParameter("userId", userdo.getUserId()).getResultList();
			if (listUserAuthDo != null && !listUserAuthDo.isEmpty())
				idrole = listUserAuthDo.iterator().next().getId().getUserRoleId();
		}
		if (bCheckValidateUserid) {
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

	@Override
	public List<TdmUserDO> getAllUser(TdmUserDO userdo, int offSet, int recordsperpage, boolean b){
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
	public TdmUserDO getEditUser(String userId){
		EntityManager entityManager = factory.createEntityManager();
		TdmUserDO listUser = (TdmUserDO) entityManager.createQuery(
				"SELECT p FROM TdmUserDO p where p.userId='" + userId + "'").getSingleResult();
		entityManager.close();
		return listUser;
	}

	@Override
	public String deleteUserByUserId(String userId){
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

	@Override
	public Long searchUserRecordsCount(TdmUserDO userdo){
		EntityManager entityManager = factory.createEntityManager();
		String query = "SELECT count(*) FROM TdmUserDO p Where p.userId !='" + userdo.getUserId()
				+ "'";
		Long count = (Long) entityManager.createQuery(query).getSingleResult();
		entityManager.close();
		return count;
	}

	@Override
	public boolean validateUserId(String userId){
		EntityManager entityManager = factory.createEntityManager();
		List<TdmUserDO> listUserDo = entityManager
				.createNamedQuery("TdmUserDO.findByUserId", TdmUserDO.class)
				.setParameter("userId", userId).getResultList();
		entityManager.close();
		return listUserDo != null && !listUserDo.isEmpty() ? false : true;
	}

	public String saveMasterDictionaryData(TdgUsersDO tdgUsersDo){
		String strMessage = "Success";
		EntityManager entityManager = factory.createEntityManager();
		Object obj = entityManager.merge(tdgUsersDo);
		if (obj == null) {
			strMessage = "Failed";
		}
		entityManager.close();
		return strMessage;
	}

	public List<TdgUsersDO> findAllByUserId(String strUserId){
		EntityManager entityManager = factory.createEntityManager();
		List<TdgUsersDO> listResult = entityManager
				.createNamedQuery("TdgUsersDO.findByUserid", TdgUsersDO.class)
				.setParameter("userid", strUserId).getResultList();
		entityManager.close();
		return listResult;
	}

	@Override
	public void deleteTdgMasterDictionaryByReqSchemaId(EntityManager entityManager, String reqId,
			String manualDictionaryId){
		long reqSchemaId = Long.parseLong(reqId);
		if (entityManager != null) {
			entityManager.getTransaction().begin();
			TdgSchemaDO tdgSchemaDO = (TdgSchemaDO) entityManager
					.createNamedQuery("TdgSchemaDO.findBySchemaId")
					.setParameter("reqschemaid", Long.parseLong(reqId)).getSingleResult();
			if (!StringUtils.isEmpty(manualDictionaryId)) {				
				dropManualDictionaryDetails(tdgSchemaDO.getManualdictionary(), entityManager);
				tdgSchemaDO.setManualdictionary("");
				entityManager.merge(tdgSchemaDO);
			} else {
				Query q1 = entityManager
						.createQuery("DELETE FROM TdgGuiDetailsDO t WHERE t.tdgSchemaDO.reqschemaid =:reqschemaid");
				q1.setParameter("reqschemaid", reqSchemaId);
				q1.executeUpdate();
				Query q2 = entityManager
						.createQuery("DELETE FROM TdgSchemaDO t WHERE t.reqschemaid =:reqschemaid");
				q2.setParameter("reqschemaid", reqSchemaId);
				q2.executeUpdate();
				if (!StringUtils.isEmpty(tdgSchemaDO.getManualdictionary())) {				
					dropManualDictionaryDetails(tdgSchemaDO.getManualdictionary(), entityManager);
				}
			}
			entityManager.getTransaction().commit();
		}
	}

	private String dropManualDictionaryDetails(String strTabName, EntityManager managerEntity){
		String strResponse = TdgCentralConstant.FAILED_MESSAGE;
		StringBuffer strCreateQuery = new StringBuffer(" DROP TABLE ");
		if (!StringUtils.isEmpty(strTabName)) {
			strCreateQuery.append(strTabName);
			managerEntity.createNativeQuery(strCreateQuery.toString()).executeUpdate();
			strResponse = TdgCentralConstant.SUCCESS_MESSAGE;
		}
		return strResponse;
	}
}
