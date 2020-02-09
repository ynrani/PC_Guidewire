/*
 * Object Name : TdgBaseServiceImpl.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class TdgBaseServiceImpl{
	@PersistenceUnit(unitName = "tdgPersistenceUnit")
	private EntityManagerFactory factory;
	EntityManager entityManager = null;

	public EntityManager openEntityManager(){
		EntityManager managerUser = factory.createEntityManager();
		return managerUser;
	}

	public void closeEntityManager(EntityManager managerUser){
		managerUser.close();
	}
}
