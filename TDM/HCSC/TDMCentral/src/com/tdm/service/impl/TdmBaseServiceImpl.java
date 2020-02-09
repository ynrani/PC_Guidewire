package com.tdm.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

import com.tdm.constant.AppConstant;

@Component
public class TdmBaseServiceImpl
{
	@PersistenceUnit(unitName = AppConstant.PERSISTENCE_UNIT_PROV)
	private EntityManagerFactory factoryProv;

	@PersistenceUnit(unitName = AppConstant.PERSISTENCE_UNIT_SUBC)
	private EntityManagerFactory factorySubsc;

	@PersistenceUnit(unitName = AppConstant.PERSISTENCE_UNIT_CLAIM)
	private EntityManagerFactory factoryClaim;

	@PersistenceUnit(unitName = AppConstant.PERSISTENCE_UNIT_USER)
	private EntityManagerFactory factoryUser;

	@PersistenceUnit(unitName = AppConstant.PERSISTENCE_UNIT_DTMSK)
	private EntityManagerFactory factoryDataMasking;

	public EntityManager openUserEntityManager()
	{
		EntityManager managerUser = factoryUser.createEntityManager();

		return managerUser;
	}

	public void closeUserEntityManager(EntityManager managerUser)
	{
		managerUser.close();
	}

	public EntityManager openProviderEntityManager()
	{
		EntityManager managerProv = factoryProv.createEntityManager();

		return managerProv;
	}

	public void closeProviderEntityManager(EntityManager managerProv)
	{
		managerProv.close();
	}

	public EntityManager openSubscriberEntityManager()
	{
		EntityManager managerSubsc = factorySubsc.createEntityManager();

		return managerSubsc;
	}

	public void closeSubscriberEntityManager(EntityManager managerSubsc)
	{
		managerSubsc.close();
	}

	public EntityManager openClaimEntityManager()
	{
		EntityManager managerClaim = factoryClaim.createEntityManager();

		return managerClaim;
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
}
