/**
 * Object Name : TdgAsyncServiceImpl.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 19, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tesda.dao.TdgOperationsDao;
import com.tesda.service.TdgAsyncService;

@Configuration
@Component
@Service("tdgAsyncServiceImpl")
public class TdgAsyncServiceImpl implements TdgAsyncService{
	@PersistenceUnit(unitName = "tdgPersistenceUnit")
	private EntityManagerFactory factory;
	EntityManager entityManager = null;
	@Autowired
	TdgOperationsDao tdgOperationsDao;

	public EntityManager openEntityManager(){
		EntityManager managerUser = factory.createEntityManager();
		return managerUser;
	}

	public void closeEntityManager(EntityManager managerUser){
		managerUser.close();
	}

	/* (non-Javadoc)
	 * 
	 * @see com.tesda.service.TdgAsyncService#doDumpManualDictionaryValues(java.lang.String,
	 * java.util.Map) */
	@Override
	public void doDumpManualDictionaryValues(String strTabName,
			Map<String, List<String>> mapExcelValues){
		try {
			entityManager = openEntityManager();
			tdgOperationsDao
					.doDumpManualDictionaryValues(strTabName, mapExcelValues, entityManager);
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (entityManager != null) {
				closeEntityManager(entityManager);
			}
		}
	}
}
