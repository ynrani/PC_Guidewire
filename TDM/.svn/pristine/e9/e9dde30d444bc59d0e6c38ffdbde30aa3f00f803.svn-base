package com.tdm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.tdm.exception.DAOException;
import com.tdm.model.DO.TdmWfCreateReqTxDO;
import com.tdm.model.DTO.TdmSearchRequestDTO;

public interface TdmRequestDAO {

	public String createReq(TdmWfCreateReqTxDO tdmWfCreateReqTxDO, EntityManager managerUser) throws DAOException;

	public String reqRuningRecId(EntityManager managerUser) throws DAOException;

	public Long reqListCount(String userId, EntityManager managerUser) throws DAOException;

	public List<TdmWfCreateReqTxDO> reqList(int offSet, int recordsperpage, boolean b, String userId,
			EntityManager managerUser) throws DAOException;

	public TdmWfCreateReqTxDO selectRecord(String reqId, EntityManager managerUser) throws DAOException;

	public List<TdmWfCreateReqTxDO> searchReq(TdmSearchRequestDTO tdmSearchRequestDTO, int offSet, int recordsperpage,
			boolean b, EntityManager managerUser) throws DAOException;

	public Long searchReqCnt(TdmSearchRequestDTO tdmSearchRequestDTO, EntityManager managerUser) throws DAOException;

}
