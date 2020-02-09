package com.tdm.model.mapper;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DO.TdmUserDO;
import com.tdm.model.DO.TdmUsersAuthDO;
import com.tdm.model.DTO.TdmUserAuthDTO;
import com.tdm.model.DTO.TdmUserDTO;

public interface TDMUserMapper
{

	public TdmUserDTO converTdmUserDOToUserSearchResultDTO(TdmUserDO tdmUserDo,
			TdmUsersAuthDO tdmUsersAuthDo) throws ServiceException;

	public TdmUserDTO converTdmUserDOToUserSearchResultDTO(TdmUserDO tdmUserDo)
			throws ServiceException;

	public List<TdmUserDTO> converTdmUserDOToUserSearchResultListDTO(List<TdmUserDO> listTdmUserDo)
			throws ServiceException;

	public TdmUserDO converTdmUserDTOToUserDO(TdmUserDTO tdmUserDo, TdmUserAuthDTO tdmUsersAuthDo)
			throws ServiceException;

	public TdmUserDO converTdmUserDTOToUserDO(TdmUserDTO tdmUserDo) throws ServiceException;

	public List<TdmUserDO> converTdmUserDTOToUserDO(List<TdmUserDTO> listTdmUserDo)
			throws ServiceException;
}
