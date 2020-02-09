package com.tdm.model.mapper;

import java.util.List;

import com.tdm.exception.ServiceException;
import com.tdm.model.DO.RequestorDO;
import com.tdm.model.DO.TdmOnboardReqDO;
import com.tdm.model.DTO.TdgDataMaskingDTO;
import com.tdm.model.DTO.TdmOnBoardReqDTO;

public interface TDMDataMaskingMapper
{

	public RequestorDO convertMaskDTOtoDO(RequestorDO requestorDO,
			TdgDataMaskingDTO tdgDataMaskingDTO, String seq, boolean page1, boolean page2,
			boolean page3, boolean reqTypeCR) throws ServiceException;

	public TdgDataMaskingDTO convertDOtoMaskDTO(TdgDataMaskingDTO tdgDataMaskingDTO,
			RequestorDO requestorDO, boolean page1, boolean page2, boolean page3)
			throws ServiceException;

	public TdgDataMaskingDTO convertDOtoMaskDTOs(TdgDataMaskingDTO tdgDataMaskingDTO,
			List<RequestorDO> requestorDOs, boolean b, boolean c, boolean d)
			throws ServiceException;

	public TdmOnBoardReqDTO convertTdmOnboardReqDOToDO(TdmOnboardReqDO tdmOnboardReqDO)
			throws ServiceException;

	public TdmOnboardReqDO convertTdmOnBoardReqDTOToDO(TdmOnBoardReqDTO tdmOnboardReqDTO, String seq)
			throws ServiceException;

	public List<TdgDataMaskingDTO> converTdmOnboardReqDOtoDTO(List<TdmOnboardReqDO> requestorDOs)
			throws ServiceException;

}
