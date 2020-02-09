package com.tesda.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class TdmBaseServiceImpl
{
	final static Logger logger = Logger.getLogger(TdmBaseServiceImpl.class);

	@PersistenceUnit(unitName = "csaaUserPersistenceUnit")
	private EntityManagerFactory factoryCsaaUser;

	public EntityManager openCsaaUserEntityManager() {
		EntityManager managerCsaaUser = factoryCsaaUser.createEntityManager();

		return managerCsaaUser;
	}

	public void closeCsaaUserEntityManager(EntityManager managerCsaaUser) {
		managerCsaaUser.close();
	}

	// <---FastLane SQL Server END -->

}
