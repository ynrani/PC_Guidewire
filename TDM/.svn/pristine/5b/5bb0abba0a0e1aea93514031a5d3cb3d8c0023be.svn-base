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
	
	 
	@PersistenceUnit(unitName = "cassPolicyAutoPropertyPersistenceUnit")
	private EntityManagerFactory factoryCsaaPropAuto;
	
	@PersistenceUnit(unitName="csaaUserPersistenceUnit")
	private EntityManagerFactory factoryCsaaUser;
	
	@PersistenceUnit(unitName="fastlaneMappingPersistenceUnitSQL")
	private EntityManagerFactory factoryCsaaFastlaneMappingUserSQL;
	
// 	<---FastLane SQL Server End -->
 
	
	
	public EntityManager openCsaaPropAutoEntityManager()
	{
		EntityManager managerCsaaProp = factoryCsaaPropAuto.createEntityManager();

		return managerCsaaProp;
	}

	public void closeCsaaPropAutoEntityManager(EntityManager managerCsaaPropAuto)
	{
		managerCsaaPropAuto.close();
	}

	
	public EntityManager openCsaaUserEntityManager()
	{
		EntityManager managerCsaaUser = factoryCsaaUser.createEntityManager();

		return managerCsaaUser;
	}

	public void closeCsaaUserEntityManager(EntityManager managerCsaaUser)
	{
		managerCsaaUser.close();
	}

 
	
	public EntityManager openFastlaneSQLEntityManager()
	{
		EntityManager managerUser = factoryCsaaFastlaneMappingUserSQL.createEntityManager();

		return managerUser;
	}

	public void closeFastlaneSQLEntityManager(EntityManager managerUser)
	{
		managerUser.close();
	}
	
// 	<---FastLane SQL Server END -->
	
	
	
	
	
	
}
