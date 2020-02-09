/*---------------------------------------------------------------------------------------
 * Object Name: TdmBankSearchMapperImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          09/10/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.model.mapper.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tdm.constant.MessageConstant;
import com.tdm.exception.ServiceException;
import com.tdm.model.DO.AccountDO;
import com.tdm.model.DO.ReservationDO;
import com.tdm.model.DTO.AccountDTO;
import com.tdm.model.DTO.TDMBankReservationDTO;
import com.tdm.model.mapper.TdmBankSearchMapper;

/**
 * 
 * @author Seshadri Chowdary
 *
 */
@Component
@Service(MessageConstant.TDM_BANK_SEARCH_MAPPER)
public class TdmBankSearchMapperImpl implements TdmBankSearchMapper
{

	@Override
	public List<AccountDTO> convertAccountDosToAccountDTO(List<AccountDO> accountDos,
			boolean hasCreditCard) throws ServiceException {
		try {
			List<AccountDTO> accountDToList = null;
			if (accountDos != null) {
				accountDToList = new ArrayList<AccountDTO>();
				for (AccountDO acDo : accountDos) {
					AccountDTO acDTO = new AccountDTO();

					acDTO.setAccountNum(acDo.getAccountNum());
					acDTO.setAccountStatus(acDo.getAccountStatus());
					acDTO.setAccoutnType(acDo.getAccoutnType());
					acDTO.setBalance(String.valueOf(acDo.getBalance()));
					acDTO.setBranchCode(acDo.getBranchCode());
					acDTO.setAcOpendate(acDo.getAcOpenDate());
					acDTO.setCustmerId(acDo.getCustmerId());
					acDTO.setCustomerName(acDo.getCustmerDetails().getFirstName());
					acDTO.setAddrLane1(acDo.getCustmerDetails().getAddrLane1());
					acDTO.setAddrLane2(acDo.getCustmerDetails().getAddrLane2());
					acDTO.setCity(acDo.getCustmerDetails().getCity());
					acDTO.setCountry(acDo.getCustmerDetails().getCountry());
					acDTO.setZipCode(acDo.getCustmerDetails().getZipCode());
					acDTO.setCustmerType(acDo.getCustmerDetails().getCustomerType());
					acDTO.setCustSurName(acDo.getCustmerDetails().getLastName());
					acDTO.setCustomerEmail(acDo.getCustmerDetails().getEmail());
					if (hasCreditCard)
						acDTO.setCreditCardNum(acDo.getCreditCardDetails().getCreditNum());
					acDTO.setTitle(acDo.getCustmerDetails().getTitle());

					accountDToList.add(acDTO);
				}
			}
			return accountDToList;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
	}

	@Override
	public List<ReservationDO> convertAccountDToReservationDO(AccountDTO accountDtos)
			throws ServiceException {
		try {
			List<ReservationDO> resrvationDos = null;
			List<AccountDTO> accountDTList = null;
			if (accountDtos != null && accountDtos.getAccountDTosList() != null) {
				resrvationDos = new ArrayList<ReservationDO>();
				accountDTList = new ArrayList<AccountDTO>();
				for (AccountDTO acDTO : accountDtos.getAccountDTosList()) {
					if (acDTO.getReservedYN() != null) {
						ReservationDO resDo = new ReservationDO();
						resDo.setAccBal(Integer.parseInt(acDTO.getBalance()));
						resDo.setAccNum(acDTO.getAccountNum());
						resDo.setAccStatus(acDTO.getAccountStatus());
						resDo.setAddrLn1(acDTO.getAddrLane1());
						resDo.setAddrLn2(acDTO.getAddrLane2());
						resDo.setBranchCode(Integer.parseInt(acDTO.getBranchCode()));
						// resDo.setBuildingNum(Integer.parseInt(acDTO.get));
						resDo.setCity(acDTO.getCity());
						resDo.setCountry(acDTO.getCountry());
						if (acDTO.getCreditCardNum() != null
								&& !"".equals(acDTO.getCreditCardNum()))
							resDo.setCreditCardNum(Integer.parseInt(acDTO.getCreditCardNum()));
						resDo.setCustName(acDTO.getCustomerName());
						resDo.setCustNum(acDTO.getCustmerId());
						resDo.setLocked("Y");
						resDo.setRecCreateDate(new Timestamp(new Date().getTime()));
						resDo.setReserveDate(new Timestamp(new Date().getTime()));
						resDo.setUnreservDate(new Timestamp(new Date().getTime()));
						resDo.setCustSurName(acDTO.getCustSurName());
						resDo.setZipCode(acDTO.getZipCode());
						resrvationDos.add(resDo);
					} else {
						accountDTList.add(acDTO);
					}
				}
				accountDtos.setAccountDTosList(accountDTList);
			}
			return resrvationDos;
		} catch (NullPointerException nullPointerEx) {
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, ex);
		}
	}

	@Override
	public List<TDMBankReservationDTO> convertResvrationDosToReservationDTO(
			List<ReservationDO> reservDos) throws ServiceException {
		List<TDMBankReservationDTO> bankResrevDTos = null;
		if (reservDos != null && reservDos.size() > 0) {
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a zzz");
			bankResrevDTos = new ArrayList<TDMBankReservationDTO>();
			for (ReservationDO resrveDo : reservDos) {
				TDMBankReservationDTO resvrDTO = new TDMBankReservationDTO();
				resvrDTO.setAccBal(String.valueOf(resrveDo.getAccBal()));
				resvrDTO.setAccNum(resrveDo.getAccNum());
				resvrDTO.setAccStatus(resrveDo.getAccStatus());
				resvrDTO.setAddrLn1(resrveDo.getAddrLn1());
				resvrDTO.setAddrLn2(resrveDo.getAddrLn2());
				resvrDTO.setBuildingNum(String.valueOf(resrveDo.getBuildingNum()));
				resvrDTO.setCity(resrveDo.getCity());
				resvrDTO.setCreditCardNum(String.valueOf(resrveDo.getCreditCardNum()));
				resvrDTO.setRecCreateDate(format.format(resrveDo.getRecCreateDate()));
				resvrDTO.setReserveDate(format.format(resrveDo.getReserveDate()));
				resvrDTO.setCustName(resrveDo.getCustName());
				resvrDTO.setCustSurName(resrveDo.getCustSurName());
				resvrDTO.setTestCaseId(resrveDo.getTestCaseId());
				resvrDTO.setTestCaseName(resrveDo.getTestCaseName());
				resvrDTO.setBranchCode(String.valueOf(resrveDo.getBranchCode()));
				resvrDTO.setCountry(resrveDo.getCountry());
				resvrDTO.setZipCode(resrveDo.getZipCode());
				resvrDTO.setCreditCardNum(String.valueOf(resrveDo.getCreditCardNum()));
				resvrDTO.setCustNum(resrveDo.getCustNum());
				bankResrevDTos.add(resvrDTO);
			}
		}
		return bankResrevDTos;
	}

	@Override
	public List<ReservationDO> convertbankReservationDTOtoDOs(AccountDTO accountDTO)
			throws ServiceException {
		List<ReservationDO> bankResrevDos = null;
		List<TDMBankReservationDTO> bankResrevDTos = null;
		if (accountDTO != null && accountDTO.getResrvationDTOsList() != null) {
			bankResrevDos = new ArrayList<ReservationDO>();
			bankResrevDTos = new ArrayList<TDMBankReservationDTO>();
			for (TDMBankReservationDTO resrveDo : accountDTO.getResrvationDTOsList()) {
				if (resrveDo.getUnreserveYN() != null) {
					ReservationDO resvrDTO = new ReservationDO();
					if (resrveDo.getAccBal() != null)
						resvrDTO.setAccBal(Integer.parseInt(resrveDo.getAccBal()));
					resvrDTO.setAccNum(resrveDo.getAccNum());
					resvrDTO.setAccStatus(resrveDo.getAccStatus());
					resvrDTO.setAddrLn1(resrveDo.getAddrLn1());
					resvrDTO.setAddrLn2(resrveDo.getAddrLn2());
					if (resrveDo.getBuildingNum() != null)
						resvrDTO.setBuildingNum(Integer.parseInt(resrveDo.getBuildingNum()));
					resvrDTO.setCity(resrveDo.getCity());
					if (resrveDo.getCreditCardNum() != null)
						resvrDTO.setCreditCardNum(Integer.parseInt(resrveDo.getCreditCardNum()));
					resvrDTO.setCustName(resrveDo.getCustName());
					resvrDTO.setCustSurName(resrveDo.getCustSurName());
					resvrDTO.setTestCaseId(resrveDo.getTestCaseId());
					resvrDTO.setTestCaseName(resrveDo.getTestCaseName());
					resvrDTO.setLocked("N");
					bankResrevDos.add(resvrDTO);
				} else {
					bankResrevDTos.add(resrveDo);
				}
			}
			accountDTO.setResrvationDTOsList(bankResrevDTos);
		}
		return bankResrevDos;
	}

}
