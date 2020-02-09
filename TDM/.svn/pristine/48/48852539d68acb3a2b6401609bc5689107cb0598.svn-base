/*
 * Object Name : TDMUserMapper.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.model.mapper;

import java.util.List;

import com.tesda.model.DO.TdmUserDO;
import com.tesda.model.DO.TdmUsersAuthDO;
import com.tesda.model.DTO.TdmUserAuthDTO;
import com.tesda.model.DTO.TdmUserDTO;

public interface TDMUserMapper{
	public TdmUserDTO converTdmUserDOToUserSearchResultDTO(TdmUserDO tdmUserDo,
			TdmUsersAuthDO tdmUsersAuthDo);

	public TdmUserDTO converTdmUserDOToUserSearchResultDTO(TdmUserDO tdmUserDo);

	public List<TdmUserDTO> converTdmUserDOToUserSearchResultListDTO(List<TdmUserDO> listTdmUserDo);

	public TdmUserDO converTdmUserDTOToUserDO(TdmUserDTO tdmUserDo, TdmUserAuthDTO tdmUsersAuthDo);

	public TdmUserDO converTdmUserDTOToUserDO(TdmUserDTO tdmUserDo);

	public List<TdmUserDO> converTdmUserDTOToUserDO(List<TdmUserDTO> listTdmUserDo);
}
