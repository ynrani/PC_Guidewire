package com.tdm.service;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DTO.AccountDTO;
import com.tdm.model.DTO.TDMBankReservationDTO;

public interface TdmBankSearchService
{

	public AccountDTO searchAccoutnDetails(AccountDTO acDTO) throws ServiceException;

	public AccountDTO unresrveRecord(AccountDTO acDTO) throws ServiceException;

	public int reserveBankRecords(AccountDTO acDTO, String userID) throws ServiceException;

	public List<TDMBankReservationDTO> getReservedRecords(String username) throws ServiceException;

	public int unReserveReservedRecords(AccountDTO accountDTO, String userName)
			throws ServiceException;

}
