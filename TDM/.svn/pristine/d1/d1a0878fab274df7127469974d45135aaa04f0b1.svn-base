/*
 * Object Name : TDMUserMapperImp.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tesda.model.DO.TdmUserDO;
import com.tesda.model.DO.TdmUsersAuthDO;
import com.tesda.model.DTO.TdmUserAuthDTO;
import com.tesda.model.DTO.TdmUserDTO;
import com.tesda.model.mapper.TDMUserMapper;

@Component
@Service("tdmUserMapper")
public class TDMUserMapperImp implements TDMUserMapper{
	@Override
	public TdmUserDTO converTdmUserDOToUserSearchResultDTO(TdmUserDO tdmUserDo,
			TdmUsersAuthDO tdmUsersAuthDo){
		if (tdmUsersAuthDo != null) {
			tdmUserDo.setTdmUsersAuths(tdmUsersAuthDo);
		}
		TdmUserDTO tdmUserDTO = converTdmUserDOToUserSearchResultDTO(tdmUserDo);
		return tdmUserDTO;
	}

	@Override
	public TdmUserDTO converTdmUserDOToUserSearchResultDTO(TdmUserDO tdmUserDo){
		TdmUserDTO tdmUserDTO = new TdmUserDTO();
		TdmUserAuthDTO tdmUserAuthDTO = new TdmUserAuthDTO();
		tdmUserDTO.setCreated(false);
		tdmUserDTO.setEmailId(tdmUserDo.getEmailId());
		tdmUserDTO.setMobileNo(tdmUserDo.getMobileNo());
		tdmUserDTO.setPassword(tdmUserDo.getPassword());
		tdmUserDTO.setUserId(tdmUserDo.getUserId());
		tdmUserDTO.setUsername(tdmUserDo.getUsername());
		tdmUserDTO.setEnabled(tdmUserDo.getEnabled());
		tdmUserAuthDTO.setTdmUserDTO(tdmUserDTO);
		if (tdmUserDo.getTdmUsersAuths() != null)
			tdmUserAuthDTO.setRole(tdmUserDo.getTdmUsersAuths().getRole());
		tdmUserDTO.setTdmUserAuthDTO(tdmUserAuthDTO);
		return tdmUserDTO;
	}

	@Override
	public List<TdmUserDTO> converTdmUserDOToUserSearchResultListDTO(List<TdmUserDO> listTdmUserDo){
		List<TdmUserDTO> listTdmUserDTO = new ArrayList<TdmUserDTO>();
		for (TdmUserDO tdmUserDO : listTdmUserDo) {
			listTdmUserDTO.add(converTdmUserDOToUserSearchResultDTO(tdmUserDO));
		}
		return listTdmUserDTO;
	}

	@Override
	public TdmUserDO converTdmUserDTOToUserDO(TdmUserDTO tdmUserDTo, TdmUserAuthDTO tdmUsersAuthDo){
		TdmUserDO tdmUserDO = new TdmUserDO();
		TdmUsersAuthDO tdmUsersAuthDO = new TdmUsersAuthDO();
		tdmUserDO.setEmailId(tdmUserDTo.getEmailId());
		tdmUserDO.setMobileNo(tdmUserDTo.getMobileNo());
		tdmUserDO.setPassword(tdmUserDTo.getPassword());
		tdmUserDO.setUserId(tdmUserDTo.getUserId());
		tdmUserDO.setUsername(tdmUserDTo.getUsername());
		tdmUserDO.setEnabled(tdmUserDTo.getEnabled());
		tdmUsersAuthDO.setTdmUser(tdmUserDO);
		if (tdmUsersAuthDo != null)
			tdmUsersAuthDO.setRole(tdmUsersAuthDo.getRole());
		tdmUserDO.setTdmUsersAuths(tdmUsersAuthDO);
		return tdmUserDO;
	}

	@Override
	public TdmUserDO converTdmUserDTOToUserDO(TdmUserDTO tdmUserDTO){
		TdmUserDO tdmUserDO = new TdmUserDO();
		TdmUsersAuthDO tdmUsersAuthDO = new TdmUsersAuthDO();
		TdmUserAuthDTO tdmUserAuthDTO = tdmUserDTO.getTdmUserAuthDTO();
		tdmUserDO.setEmailId(tdmUserDTO.getEmailId());
		tdmUserDO.setMobileNo(tdmUserDTO.getMobileNo());
		tdmUserDO.setPassword(tdmUserDTO.getPassword());
		tdmUserDO.setUserId(tdmUserDTO.getUserId());
		tdmUserDO.setUsername(tdmUserDTO.getUsername());
		tdmUserDO.setEnabled(tdmUserDTO.getEnabled());
		tdmUsersAuthDO.setTdmUser(tdmUserDO);
		if (tdmUserAuthDTO != null)
			tdmUsersAuthDO.setRole(tdmUserAuthDTO.getRole());
		tdmUserDO.setTdmUsersAuths(tdmUsersAuthDO);
		return tdmUserDO;
	}

	@Override
	public List<TdmUserDO> converTdmUserDTOToUserDO(List<TdmUserDTO> listTdmUserDTO){
		List<TdmUserDO> listTdmUserDo = new ArrayList<TdmUserDO>();
		for (TdmUserDTO tdmUserDTO : listTdmUserDTO) {
			listTdmUserDo.add(converTdmUserDTOToUserDO(tdmUserDTO));
		}
		return listTdmUserDo;
	}
}
