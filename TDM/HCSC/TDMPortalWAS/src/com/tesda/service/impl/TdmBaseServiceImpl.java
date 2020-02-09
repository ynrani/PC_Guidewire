package com.tesda.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

@Component
public class TdmBaseServiceImpl
{

	@PersistenceUnit(unitName = "userPersistenceUnit")
	private EntityManagerFactory factoryUser;

	@PersistenceUnit(unitName = "dataMaskingPersistenceUnit")
	private EntityManagerFactory factoryDataMasking;

	@PersistenceUnit(unitName = "subscPersistenceUnit")
	private EntityManagerFactory factorySubscriber;

	public EntityManager openUserEntityManager()
	{
		EntityManager managerUser = factoryUser.createEntityManager();

		return managerUser;
	}

	public void closeUserEntityManager(EntityManager managerUser)
	{
		managerUser.close();
	}

	public void closeClaimEntityManager(EntityManager managerClaim)
	{
		managerClaim.close();
	}

	public EntityManager openDataMaskingEntityManager()
	{
		EntityManager managerDataMasking = factoryDataMasking.createEntityManager();

		return managerDataMasking;
	}

	public void closeDataMaskingEntityManager(EntityManager managerDataMasking)
	{
		managerDataMasking.close();
	}

	public EntityManager openSubscriberEntityManager()
	{
		EntityManager managerSubscr = factorySubscriber.createEntityManager();

		return managerSubscr;
	}

	public void closeSubscriberEntityManager(EntityManager managerSubscr)
	{
		managerSubscr.close();
	}
}
