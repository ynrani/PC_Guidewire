package com.tdm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tdm.exception.DAOException;
import com.tdm.model.DO.AccountDO;
import com.tdm.model.DO.ReservationDO;
import com.tdm.model.DTO.AccountDTO;

public interface TdmBankSearchDAO
{
	public List<AccountDO> searchAccountDetails(AccountDTO acDTO, int offSet, int recordsperpage,
			EntityManager managerSubsc) throws DAOException;

	public void resrerveBankRecords(List<ReservationDO> reservationDO, String testcaseID,
			String testcaseName, String userId, EntityManager managerSubsc) throws DAOException;

	public List<ReservationDO> getResrvedRecords(String username, EntityManager managerSubsc)
			throws DAOException;

	public void unReserveBankResrvedRecords(List<ReservationDO> unResrveList, String userId,
			EntityManager managerSubsc) throws DAOException;
}
