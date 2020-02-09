package com.tdm.model.mapper;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DO.AccountDO;
import com.tdm.model.DO.ReservationDO;
import com.tdm.model.DTO.AccountDTO;
import com.tdm.model.DTO.TDMBankReservationDTO;

public interface TdmBankSearchMapper
{
	public List<AccountDTO> convertAccountDosToAccountDTO(List<AccountDO> accountDo,
			boolean hasCreditcard) throws ServiceException;

	public List<ReservationDO> convertAccountDToReservationDO(AccountDTO accountDtos)
			throws ServiceException;

	public List<TDMBankReservationDTO> convertResvrationDosToReservationDTO(
			List<ReservationDO> reservDos) throws ServiceException;

	public List<ReservationDO> convertbankReservationDTOtoDOs(AccountDTO accountDTO)
			throws ServiceException;

}
