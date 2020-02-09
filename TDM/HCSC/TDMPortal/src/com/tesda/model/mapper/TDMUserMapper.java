/*---------------------------------------------------------------------------------------
* Object Name: TDMUserMapper.Java
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


package com.tesda.model.mapper;

import java.util.List;

import com.tesda.model.DO.TdmUserDO;
import com.tesda.model.DO.TdmUsersAuthDO;
import com.tesda.model.DTO.TdmUserAuthDTO;
import com.tesda.model.DTO.TdmUserDTO;

public interface TDMUserMapper {

	public TdmUserDTO converTdmUserDOToUserSearchResultDTO(TdmUserDO tdmUserDo,TdmUsersAuthDO tdmUsersAuthDo);
	public TdmUserDTO converTdmUserDOToUserSearchResultDTO(TdmUserDO tdmUserDo);	
	public List<TdmUserDTO> converTdmUserDOToUserSearchResultListDTO(List<TdmUserDO> listTdmUserDo);

	public TdmUserDO converTdmUserDTOToUserDO(TdmUserDTO tdmUserDo,TdmUserAuthDTO tdmUsersAuthDo);
	public TdmUserDO converTdmUserDTOToUserDO(TdmUserDTO tdmUserDo);	
	public List<TdmUserDO> converTdmUserDTOToUserDO(List<TdmUserDTO> listTdmUserDo);
}
