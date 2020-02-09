/*---------------------------------------------------------------------------------------
 * Object Name: TdmBaseServiceImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary   11/04/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tesda.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Component;

import com.tesda.constants.TDMConstants;

@Component
public class TdmBaseServiceImpl
{

	@PersistenceUnit(unitName = TDMConstants.USER_UNIT)
	private EntityManagerFactory factoryUser;

	@PersistenceUnit(unitName = TDMConstants.DTMASKING_UNIT)
	private EntityManagerFactory factoryDataMasking;

	@PersistenceUnit(unitName = TDMConstants.SUBSCR_UNIT)
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
