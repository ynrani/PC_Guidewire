package com.tesda.model.mapper;

import java.util.List;

import com.tesda.exception.ServiceException;
import com.tesda.model.DO.RequestorDO;
import com.tesda.model.DO.TdmOnboardReqDO;
import com.tesda.model.DTO.TdgDataMaskingDTO;
import com.tesda.model.DTO.TdmOnBoardReqDTO;

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
