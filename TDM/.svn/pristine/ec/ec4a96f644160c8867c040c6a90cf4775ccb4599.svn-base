/*---------------------------------------------------------------------------------------
 * Object Name: TDMProviserSearchDAOImpl.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          12/06/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tdm.constant.AppConstant;
import com.tdm.constant.MessageConstant;
import com.tdm.dao.TDMProviserSearchDAO;
import com.tdm.exception.DAOException;
import com.tdm.model.DO.TdmClaimDO;
import com.tdm.model.DO.TdmClaimSrcMastDO;
import com.tdm.model.DO.TdmClaimStatusMastDO;
import com.tdm.model.DO.TdmClaimTypeMastDO;
import com.tdm.model.DO.TdmPosMastDO;
import com.tdm.model.DO.TdmProviderCatMasterDO;
import com.tdm.model.DO.TdmProviderDO;
import com.tdm.model.DO.TdmProviderSpecMasterDO;
import com.tdm.model.DO.TdmProviderTypeMasterDO;
import com.tdm.model.DO.TdmReservationDO;
import com.tdm.model.DO.TdmSubscLobMastDO;
import com.tdm.model.DO.TdmSubscStatusMastDO;
import com.tdm.model.DO.TdmSubscTypeMastDO;
import com.tdm.model.DO.TdmSubscriberDO;
import com.tdm.model.DO.TdmTypeOfBillMastDO;
import com.tdm.model.DO.TdmUsStateDO;
import com.tdm.model.DO.TdmUsStateSubDO;
import com.tdm.model.DO.TdmUserDO;
import com.tdm.model.DTO.TDMClaimSearchDTO;
import com.tdm.model.DTO.TDMProvSearchDTO;
import com.tdm.model.DTO.TDMSubscSearchDTO;

/**
 * 
 * @author Seshadri Chowdary
 *
 */

@Component(MessageConstant.TDM_SEARCH_DAO)
public class TDMProviserSearchDAOImpl implements TDMProviserSearchDAO
{
	private static Logger logger = Logger.getLogger(TDMProviserSearchDAOImpl.class);

	@Override
	public List<TdmProviderDO> searchProviderRecords(TDMProvSearchDTO tDMProvSearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, List<Long> providersIds,
			EntityManager managerProv) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			String stateStr = "";
			String specStr = "";

			StringBuffer query = new StringBuffer(
					"SELECT p FROM TdmProviderDO p JOIN p.tdmProviderAddrs padd JOIN p.tdmProviderTypes ptype WHERE  0=0");

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvType()))
			{
				query.append("AND ptype.providerTypeName ='")
						.append(tDMProvSearchDTO.getProvType()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvCatgType()))
			{
				query.append(
						"AND p.tdmProviderCategories.categoryDescription ='"
								+ tDMProvSearchDTO.getProvCatgType()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvSpecType()))
			{
				if (tDMProvSearchDTO.getProvSpecType().contains(","))
				{
					specStr = tDMProvSearchDTO.getProvSpecType().replaceAll(",", "','");
				}
				else
				{
					specStr = tDMProvSearchDTO.getProvSpecType();
				}

				query.append("AND p.tdmProviderSpecialities.specialityDescription IN ('")
						.append(specStr).append("')");
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvContract()))
			{
				query.append("AND p.contractName ='").append(tDMProvSearchDTO.getProvContract())
						.append('\'');
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getMedicareId()))
			{
				query.append("AND p.medicareId ='").append(tDMProvSearchDTO.getMedicareId())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getTin()))
			{
				query.append("AND p.tin ='").append(tDMProvSearchDTO.getTin()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getNip()))
			{
				query.append("AND p.npi ='").append(tDMProvSearchDTO.getNip()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvEFTYn()))
			{
				query.append("AND p.eft ='").append(tDMProvSearchDTO.getProvEFTYn()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getGender()))
			{
				if (!tDMProvSearchDTO.getGender().equalsIgnoreCase("Both"))
				{
					query.append("AND p.gender ='").append(tDMProvSearchDTO.getGender())
							.append('\'');
				}
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvTypicalYn()))
			{
				query.append("AND p.atypical ='").append(tDMProvSearchDTO.getProvTypicalYn())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getTaxonomyCode()))
			{
				query.append(
						"AND p.tdmProviderTaxonomy.providerTaxonomyCode ='"
								+ tDMProvSearchDTO.getTaxonomyCode()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getContractCode()))
			{
				query.append("AND p.contractName ='").append(tDMProvSearchDTO.getContractCode())
						.append('\'');
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getTermDate()))
			{

				query.append("AND TRUNC(p.terminationDate) = To_date('")
						.append(tDMProvSearchDTO.getTermDate()).append("', 'MM/DD/YYYY') ");

			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getEffectiveDate()))
			{
				query.append("AND  TRUNC(p.dateCreated) =To_date('")
						.append(tDMProvSearchDTO.getEffectiveDate()).append("', 'MM/DD/YYYY') ");
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvZip()))
			{
				query.append("AND padd.postalCode ='").append(tDMProvSearchDTO.getProvZip())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvState()))
			{
				if (tDMProvSearchDTO.getProvState().contains(","))
				{
					stateStr = tDMProvSearchDTO.getProvState().replaceAll(",", "','");
				}
				else
				{
					stateStr = tDMProvSearchDTO.getProvState();
				}
				query.append("AND padd.state IN ('").append(stateStr).append("') ");

			}
			if (null != providersIds && 0 < providersIds.size())
			{
				StringBuffer buf = new StringBuffer();
				query.append("AND p.providerId NOT IN ( 0 ");

				for (Long string : providersIds)
				{
					buf.append("," + string);
				}
				query.append(buf.toString());
				query.append(") ");
			}
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmProviderDO> list = managerProv.createQuery(query.toString())
					.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();

			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long searchProviderRecordsCount(TDMProvSearchDTO tDMProvSearchDTO,
			List<Long> providersIds, EntityManager managerProv) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			String stateStr = "";
			String specStr = "";
			StringBuffer query = new StringBuffer(
					"SELECT COUNT(*) FROM TdmProviderDO p JOIN p.tdmProviderAddrs padd JOIN p.tdmProviderTypes ptype WHERE  0=0");

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvType()))
			{
				query.append("AND ptype.providerTypeName ='")
						.append(tDMProvSearchDTO.getProvType()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvCatgType()))
			{
				query.append("AND p.tdmProviderCategories.categoryDescription ='")
						.append(tDMProvSearchDTO.getProvCatgType()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvSpecType()))
			{
				if (tDMProvSearchDTO.getProvSpecType().contains(","))
				{
					specStr = tDMProvSearchDTO.getProvSpecType().replaceAll(",", "','");
				}
				else
				{
					specStr = tDMProvSearchDTO.getProvSpecType();
				}
				query.append("AND p.tdmProviderSpecialities.specialityDescription IN ('")
						.append(specStr).append("') ");
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvContract()))
			{
				query.append("AND p.contractName ='").append(tDMProvSearchDTO.getProvContract())
						.append('\'');
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getMedicareId()))
			{
				query.append("AND p.medicareId ='").append(tDMProvSearchDTO.getMedicareId())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getTin()))
			{
				query.append("AND p.tin ='").append(tDMProvSearchDTO.getTin()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getNip()))
			{
				query.append("AND p.npi ='").append(tDMProvSearchDTO.getNip()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvEFTYn()))
			{
				query.append("AND p.eft ='").append(tDMProvSearchDTO.getProvEFTYn()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getGender()))
			{
				if (!tDMProvSearchDTO.getGender().equalsIgnoreCase("Both"))
				{
					query.append("AND p.gender ='").append(tDMProvSearchDTO.getGender())
							.append('\'');
				}
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvTypicalYn()))
			{
				query.append("AND p.atypical ='").append(tDMProvSearchDTO.getProvTypicalYn())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getTaxonomyCode()))
			{
				query.append(
						"AND p.tdmProviderTaxonomy.providerTaxonomyCode ='"
								+ tDMProvSearchDTO.getTaxonomyCode()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getContractCode()))
			{
				query.append("AND p.contractName ='").append(tDMProvSearchDTO.getContractCode())
						.append('\'');
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getTermDate()))
			{

				query.append("AND TRUNC(p.terminationDate) = To_date('")
						.append(tDMProvSearchDTO.getTermDate()).append("', 'MM/DD/YYYY') ");

			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getEffectiveDate()))
			{
				query.append("AND  TRUNC(p.dateCreated) =To_date('")
						.append(tDMProvSearchDTO.getEffectiveDate()).append("', 'MM/DD/YYYY') ");
			}

			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvZip()))
			{
				query.append("AND padd.postalCode ='").append(tDMProvSearchDTO.getProvZip())
						.append('\'');
			}
			if (StringUtils.isNotEmpty(tDMProvSearchDTO.getProvState()))
			{
				if (tDMProvSearchDTO.getProvState().contains(","))
				{
					stateStr = tDMProvSearchDTO.getProvState().replaceAll(",", "','");
				}
				else
				{
					stateStr = tDMProvSearchDTO.getProvState();
				}
				query.append("AND padd.state IN ('").append(stateStr).append("') ");

			}
			if (null != providersIds && 0 < providersIds.size())
			{

				StringBuffer buf = new StringBuffer();
				query.append("AND p.providerId NOT IN ( 0 ");

				for (Long string : providersIds)
				{
					buf.append("," + string);
				}
				query.append(buf.toString());
				query.append(") ");
			}
			Long count = (Long) managerProv.createQuery(query.toString()).getSingleResult();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return count;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmProviderDO> getProviderRecords(List<Long> providerIds, EntityManager managerProv)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_PROV_RECS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			List<TdmProviderDO> providerDOList = new ArrayList<TdmProviderDO>();
			for (Long providerId : providerIds)
			{
				if (providerId != null)
				{
					if (0 < (Long) managerProv.createQuery(
							"SELECT count(p.providerId)  FROM TdmProviderDO p where p.providerId='"
									+ providerId + "'").getSingleResult())
					{
						providerDOList.add((TdmProviderDO) managerProv.createQuery(
								"SELECT p FROM TdmProviderDO p where p.providerId='" + providerId
										+ "'").getSingleResult());
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_PROV_RECS
					+ MessageConstant.LOG_INFO_RETURN);
			return providerDOList;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_PROV_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_PROV_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_PROV_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_PROV_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmProviderTypeMasterDO> getProviderTypeDropDown(EntityManager managerProv)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_TYPE + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmProviderTypeMasterDO> list = managerProv.createQuery(
					"SELECT p FROM TdmProviderTypeMasterDO p").getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_TYPE + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmProviderSpecMasterDO> getProviderSpecDropDown(long catId,
			EntityManager managerProv) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_SPEC + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmProviderSpecMasterDO> list = managerProv.createQuery(
					"SELECT p FROM TdmProviderSpecMasterDO p").getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_SPEC + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_SPEC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_SPEC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_SPEC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_SPEC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmProviderCatMasterDO> getProviderCatDropDown(EntityManager managerProv)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_CAT + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmProviderCatMasterDO> list = managerProv.createQuery(
					"SELECT p FROM TdmProviderCatMasterDO p").getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_CAT + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_CAT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_CAT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_CAT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_CAT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmUsStateDO> getProviderStateDropDown(EntityManager managerProv)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_STATE + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmUsStateDO> list = managerProv.createQuery(
					"SELECT p FROM TdmUsStateDO p ORDER BY p.stateName ASC").getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_STATE
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_PROV_DROP_DOWN_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@SuppressWarnings(AppConstant.UNCHECKED)
	@Override
	public List<String> dropdownSpecialty(String value, EntityManager managerProv)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN_SPE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			List<String> list = null;
			String str = null;
			long code = 0;
			List<TdmProviderSpecMasterDO> tdmProviderSpecMasterDOs = null;

			if (StringUtils.isNotEmpty(value))
			{
				long count = Long
						.parseLong((managerProv
								.createQuery(
										"SELECT COUNT(*) FROM TdmProviderCatMasterDO p WHERE p.providerCategoryName=?1")
								.setParameter(1, value).getSingleResult()).toString());
				if (0 < count)
				{
					code = Long
							.parseLong((managerProv
									.createQuery(
											"SELECT p.providerCategoryId FROM TdmProviderCatMasterDO p WHERE p.providerCategoryName=?1")
									.setParameter(1, value).getSingleResult()).toString());
				}
				tdmProviderSpecMasterDOs = managerProv
						.createQuery(
								"SELECT p FROM TdmProviderSpecMasterDO p WHERE p.tdmProviderCatMaster.providerCategoryId=?1  ORDER BY p.providerSpecialityName ASC")
						.setParameter(1, code).getResultList();
			}
			if (null != tdmProviderSpecMasterDOs)
			{
				list = new ArrayList<String>();
				for (TdmProviderSpecMasterDO tdmProviderSpecMasterDO : tdmProviderSpecMasterDOs)
				{
					str = tdmProviderSpecMasterDO.getProviderSpecialityName();

					list.add(str);
				}
			}
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN_SPE
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN_SPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN_SPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN_SPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_DROP_DOWN_SPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmSubscriberDO> searchSubscRecords(TDMSubscSearchDTO tDMSubscSearchDTO,
			int offSet, int recordsperpage, boolean pageNationOnOffFlag,
			List<String> subscriberIds, EntityManager managerSubsc) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			String stateStr = "";
			String statusStr = "";
			String lobStr = "";
			String subTypeStr = "";

			if (tDMSubscSearchDTO.getSubscType().contains(","))
			{
				subTypeStr = tDMSubscSearchDTO.getSubscType().replaceAll(",", "','");
			}
			else
			{
				subTypeStr = tDMSubscSearchDTO.getSubscType();
			}

			StringBuffer query = new StringBuffer(
					"SELECT p FROM TdmSubscriberDO p  JOIN p.tdmSuscriberAddresses sadd LEFT OUTER JOIN p.tdmSubscriberRelationships subtype1 WHERE  0=0 ");

			if (StringUtils.isNotEmpty(subTypeStr))
			{
				if (subTypeStr.equalsIgnoreCase("Subscriber"))
				{
					query.append("AND  p.subcType IN ('").append(subTypeStr).append("') ");
				}
				else
				{
					query.append("AND subtype1.relationshipType IN ('").append(subTypeStr)
							.append("') ");
				}
			}

			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscWithCOB()))
			{
				query.append("AND p.withCob ='" + tDMSubscSearchDTO.getSubscWithCOB()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscLOB()))
			{
				if (tDMSubscSearchDTO.getSubscLOB().contains(","))
				{
					lobStr = tDMSubscSearchDTO.getSubscLOB().replaceAll(",", "','");
				}
				else
				{
					lobStr = tDMSubscSearchDTO.getSubscLOB();
				}
				query.append("AND p.lob IN ('").append(lobStr).append("') ");
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanID()))
			{
				query.append("AND p.planId ='" + tDMSubscSearchDTO.getPlanID()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanName()))
			{
				query.append("AND p.planName ='" + tDMSubscSearchDTO.getPlanName()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getContractCode()))
			{
				query.append("AND p.contractCode ='" + tDMSubscSearchDTO.getContractCode()).append(
						'\'');
			}

			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscGender()))
			{
				if (!tDMSubscSearchDTO.getSubscGender().equalsIgnoreCase("Both"))
				{
					query.append("AND p.gender ='" + tDMSubscSearchDTO.getSubscGender()).append(
							'\'');
				}
			}

			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscStatus()))
			{
				if (tDMSubscSearchDTO.getSubscStatus().contains(","))
				{
					statusStr = tDMSubscSearchDTO.getSubscStatus().replaceAll(",", "','");
				}
				else
				{
					statusStr = tDMSubscSearchDTO.getSubscStatus();
				}

				query.append("AND p.status IN ('").append(statusStr).append("') ");
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSsn()))
			{
				query.append("AND p.ssn ='" + tDMSubscSearchDTO.getSsn()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getTermDate()))
			{

				query.append("AND TRUNC(p.termDate) = To_date('")
						.append(tDMSubscSearchDTO.getTermDate()).append("', 'MM/DD/YYYY') ");

			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getDob()))
			{
				query.append("AND  TRUNC(p.birthDate) =To_date('")
						.append(tDMSubscSearchDTO.getDob()).append("', 'MM/DD/YYYY') ");
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscriberId()))
			{
				query.append("AND p.subscriberId ='" + tDMSubscSearchDTO.getSubscriberId()).append(
						'\'');
			}

			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscZip()))
			{
				query.append("AND sadd.zipCode ='" + tDMSubscSearchDTO.getSubscZip()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscState()))
			{

				if (tDMSubscSearchDTO.getSubscState().contains(","))
				{
					stateStr = tDMSubscSearchDTO.getSubscState().replaceAll(",", "','");
				}
				else
				{
					stateStr = tDMSubscSearchDTO.getSubscState();
				}

				query.append("AND sadd.stateProvince IN ('").append(stateStr).append("') ");
			}
			if (null != subscriberIds && 0 < subscriberIds.size())
			{

				StringBuffer buf = new StringBuffer();
				query.append("AND p.subscriberId NOT IN ( 0 ");

				for (String string : subscriberIds)
				{
					buf.append("," + string);
				}
				query.append(buf.toString());
				query.append(") ");
			}

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmSubscriberDO> list = managerSubsc.createQuery(query.toString())
					.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long searchSubscrRecordsCount(TDMSubscSearchDTO tDMSubscSearchDTO,
			List<String> subscriberIds, EntityManager managerSubsc) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			String stateStr = "";
			String statusStr = "";
			String lobStr = "";
			String subTypeStr = "";

			if (tDMSubscSearchDTO.getSubscType().contains(","))
			{
				subTypeStr = tDMSubscSearchDTO.getSubscType().replaceAll(",", "','");
			}
			else
			{
				subTypeStr = tDMSubscSearchDTO.getSubscType();
			}

			StringBuffer query = new StringBuffer(
					"SELECT COUNT(*) FROM TdmSubscriberDO p  JOIN p.tdmSuscriberAddresses sadd LEFT OUTER JOIN p.tdmSubscriberRelationships subtype1 WHERE  0=0 ");

			if (StringUtils.isNotEmpty(subTypeStr))
			{
				if (subTypeStr.equalsIgnoreCase("Subscriber"))
				{
					query.append("AND  p.subcType IN ('").append(subTypeStr).append("') ");
				}
				else
				{
					query.append("AND subtype1.relationshipType IN ('").append(subTypeStr)
							.append("') ");
				}
			}

			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscWithCOB()))
			{
				query.append("AND p.withCob ='" + tDMSubscSearchDTO.getSubscWithCOB()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscLOB()))
			{
				if (tDMSubscSearchDTO.getSubscLOB().contains(","))
				{
					lobStr = tDMSubscSearchDTO.getSubscLOB().replaceAll(",", "','");
				}
				else
				{
					lobStr = tDMSubscSearchDTO.getSubscLOB();
				}
				query.append("AND p.lob IN ('").append(lobStr).append("') ");
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanID()))
			{
				query.append("AND p.planId ='" + tDMSubscSearchDTO.getPlanID()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getPlanName()))
			{
				query.append("AND p.planName ='" + tDMSubscSearchDTO.getPlanName()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getContractCode()))
			{
				query.append("AND p.contractCode ='" + tDMSubscSearchDTO.getContractCode()).append(
						'\'');
			}

			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscGender()))
			{
				if (!tDMSubscSearchDTO.getSubscGender().equalsIgnoreCase("Both"))
				{
					query.append("AND p.gender ='" + tDMSubscSearchDTO.getSubscGender()).append(
							'\'');
				}
			}

			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscStatus()))
			{
				if (tDMSubscSearchDTO.getSubscStatus().contains(","))
				{
					statusStr = tDMSubscSearchDTO.getSubscStatus().replaceAll(",", "','");
				}
				else
				{
					statusStr = tDMSubscSearchDTO.getSubscStatus();
				}

				query.append("AND p.status IN ('").append(statusStr).append("') ");
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSsn()))
			{
				query.append("AND p.ssn ='" + tDMSubscSearchDTO.getSsn()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getTermDate()))
			{

				query.append("AND TRUNC(p.termDate) = To_date('")
						.append(tDMSubscSearchDTO.getTermDate()).append("', 'MM/DD/YYYY') ");

			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getDob()))
			{
				query.append("AND  TRUNC(p.birthDate) =To_date('")
						.append(tDMSubscSearchDTO.getDob()).append("', 'MM/DD/YYYY') ");
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscriberId()))
			{
				query.append("AND p.subscriberId ='" + tDMSubscSearchDTO.getSubscriberId()).append(
						'\'');
			}

			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscZip()))
			{
				query.append("AND sadd.zipCode ='" + tDMSubscSearchDTO.getSubscZip()).append('\'');
			}
			if (StringUtils.isNotEmpty(tDMSubscSearchDTO.getSubscState()))
			{

				if (tDMSubscSearchDTO.getSubscState().contains(","))
				{
					stateStr = tDMSubscSearchDTO.getSubscState().replaceAll(",", "','");
				}
				else
				{
					stateStr = tDMSubscSearchDTO.getSubscState();
				}

				query.append("AND sadd.stateProvince IN ('").append(stateStr).append("') ");
			}
			if (null != subscriberIds && 0 < subscriberIds.size())
			{
				StringBuffer buf = new StringBuffer();
				query.append("AND p.subscriberId NOT IN ( 0 ");

				for (String string : subscriberIds)
				{
					buf.append("," + string);
				}
				query.append(buf.toString());
				query.append(") ");
			}

			Long count = (Long) managerSubsc.createQuery(query.toString()).getSingleResult();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return count;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_SUB_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmSubscriberDO> getSubscriberRecords(List<String> subcriberIds,
			EntityManager managerSubsc) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_SUB_RECS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			List<TdmSubscriberDO> tdmSubscriberDOList = new ArrayList<TdmSubscriberDO>();
			for (String subcriberId : subcriberIds)
			{
				if (subcriberId != null)
				{
					if (0 < (Long) managerSubsc.createQuery(
							"SELECT count(p.subscriberId)  FROM TdmSubscriberDO p where p.subscriberId='"
									+ subcriberId + "'").getSingleResult())
					{
						tdmSubscriberDOList.add((TdmSubscriberDO) managerSubsc.createQuery(
								"SELECT p FROM TdmSubscriberDO p where p.subscriberId='"
										+ subcriberId + "'").getSingleResult());
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_SUB_RECS
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmSubscriberDOList;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_SUB_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_SUB_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_SUB_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_SUB_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmSubscTypeMastDO> getSubscTypeDropDown(EntityManager managerSubsc)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_TYPE + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmSubscTypeMastDO> list = managerSubsc.createQuery(
					"SELECT p FROM TdmSubscTypeMastDO p ORDER BY p.subscTypeDesc ASC")
					.getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_TYPE + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmSubscStatusMastDO> getSubscStsDropDown(EntityManager managerSubsc)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_SUB_DROP_DOWN_STS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmSubscStatusMastDO> list = managerSubsc.createQuery(
					"SELECT p FROM TdmSubscStatusMastDO p ORDER BY p.subscStatusDesc ASC")
					.getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_STS + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmUsStateSubDO> getSubscStateDropDown(EntityManager managerSubsc)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_STATE + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmUsStateSubDO> list = managerSubsc.createQuery(
					"SELECT p FROM TdmUsStateSubDO p ORDER BY p.stateName ASC").getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_STATE + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_STATE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmSubscLobMastDO> getSubscLobDropDown(EntityManager managerSubsc)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_SUB_DROP_DOWN_LOB
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmSubscLobMastDO> list = managerSubsc.createQuery(
					"SELECT p FROM TdmSubscLobMastDO p ORDER BY p.subscLobDesc ASC")
					.getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_LOB + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_LOB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_LOB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_LOB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SUB_DROP_DOWN_LOB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmClaimDO> searchClaimRecords(TDMClaimSearchDTO tDMClaimSearchDTO, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, List<String> claimIds,
			EntityManager managerClaim) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			StringBuffer query = new StringBuffer(
					"SELECT p FROM TdmClaimDO p join p.tdmClaimLineDetails ptcd WHERE  0=0");

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimType()))
			{
				query.append("AND p.claimType='" + tDMClaimSearchDTO.getClaimType()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimSource()))
			{
				query.append("AND p.claimSource ='" + tDMClaimSearchDTO.getClaimSource()).append(
						'\'');
			}

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimStatus()))
			{
				query.append("AND p.claimStatus ='" + tDMClaimSearchDTO.getClaimStatus()).append(
						'\'');
			}

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimId()))
			{
				query.append("AND p.claimId ='" + tDMClaimSearchDTO.getClaimId()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimProcCode()))
			{
				query.append("AND ptcd.proc='" + tDMClaimSearchDTO.getClaimProcCode()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimDXCode()))
			{
				query.append("AND ptcd.dx='" + tDMClaimSearchDTO.getClaimDXCode()).append('\'');
			}

			if (null != claimIds && 0 < claimIds.size())
			{
				StringBuffer buf = new StringBuffer();
				query.append("AND p.claimId NOT IN ( 0 ");

				for (String string : claimIds)
				{
					buf.append("," + string);
				}
				query.append(buf.toString());
				query.append(") ");
			}

			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmClaimDO> list = managerClaim.createQuery(query.toString())
					.setFirstResult(offSet).setMaxResults(recordsperpage).getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}

	@Override
	public Long searchClaimRecordsCount(TDMClaimSearchDTO tDMClaimSearchDTO, List<String> claimIds,
			EntityManager managerClaim) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC_CNT
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			StringBuffer query = new StringBuffer(
					"SELECT COUNT(p) FROM TdmClaimDO p join p.tdmClaimLineDetails ptcd WHERE  0=0");

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimType()))
			{
				query.append("AND p.claimType='" + tDMClaimSearchDTO.getClaimType()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimSource()))
			{
				query.append("AND p.claimSource ='" + tDMClaimSearchDTO.getClaimSource()).append(
						'\'');
			}

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimStatus()))
			{
				query.append("AND p.claimStatus ='" + tDMClaimSearchDTO.getClaimStatus()).append(
						'\'');
			}

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimId()))
			{
				query.append("AND p.claimId ='" + tDMClaimSearchDTO.getClaimId()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimProcCode()))
			{
				query.append("AND ptcd.proc='" + tDMClaimSearchDTO.getClaimProcCode()).append('\'');
			}

			if (StringUtils.isNotEmpty(tDMClaimSearchDTO.getClaimDXCode()))
			{
				query.append("AND ptcd.dx='" + tDMClaimSearchDTO.getClaimDXCode()).append('\'');
			}

			if (null != claimIds && 0 < claimIds.size())
			{
				StringBuffer buf = new StringBuffer();
				query.append("AND p.claimId NOT IN ( 0 ");
				for (String string : claimIds)
				{
					buf.append("," + string);
				}
				query.append(buf.toString());
				query.append(") ");
			}

			Long count = (Long) managerClaim.createQuery(query.toString()).getSingleResult();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC_CNT
					+ MessageConstant.LOG_INFO_RETURN);
			return count;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_CLM_SEARCH_REC_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmClaimDO> getClaimRecords(List<String> claimIds, EntityManager managerClaim)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_CLM_RECS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			List<TdmClaimDO> tdmClaimDOList = new ArrayList<TdmClaimDO>();
			for (String claimId : claimIds)
			{
				if (claimId != null)
				{
					if (0 < (Long) managerClaim.createQuery(
							"SELECT count(p.claimId)  FROM TdmClaimDO p where p.claimId='"
									+ claimId + "'").getSingleResult())
					{
						tdmClaimDOList.add((TdmClaimDO) managerClaim.createQuery(
								"SELECT p FROM TdmClaimDO p where p.claimId='" + claimId + "'")
								.getSingleResult());
					}
				}
			}
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_CLM_RECS
					+ MessageConstant.LOG_INFO_RETURN);
			return tdmClaimDOList;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_CLM_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_CLM_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_CLM_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_CLM_RECS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmClaimTypeMastDO> getClaimTypeDropDown(EntityManager managerClaim)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_TYPE + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmClaimTypeMastDO> list = managerClaim.createQuery(
					"SELECT p FROM TdmClaimTypeMastDO p ORDER BY p.claimTypeDesc ASC")
					.getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_TYPE + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_TYPE
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmClaimStatusMastDO> getClaimStsDropDown(EntityManager managerClaim)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_CLM_DROP_DOWN_STS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmClaimStatusMastDO> list = managerClaim.createQuery(
					"SELECT p FROM TdmClaimStatusMastDO p ORDER BY p.claimStatusDesc ASC")
					.getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_STS + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_STS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmClaimSrcMastDO> getClaimSrcDropDown(EntityManager managerClaim)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_CLM_DROP_DOWN_SRC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmClaimSrcMastDO> list = managerClaim.createQuery(
					"SELECT p FROM TdmClaimSrcMastDO p ORDER BY p.claimSrcDesc ASC")
					.getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_SRC + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_SRC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_SRC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_SRC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_SRC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmTypeOfBillMastDO> getClaimTypeOfBillsDropDown(EntityManager managerClaim)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_BILL + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmTypeOfBillMastDO> list = managerClaim.createQuery(
					"SELECT p FROM TdmTypeOfBillMastDO p ORDER BY p.billTypeDesc ASC")
					.getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_BILL + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_BILL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_BILL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_BILL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_BILL
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmPosMastDO> getClaimPOSDropDown(EntityManager managerClaim) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_CLM_DROP_DOWN_POS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmPosMastDO> list = managerClaim.createQuery(
					"SELECT p FROM TdmPosMastDO p ORDER BY p.posDesc ASC").getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_POS + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_POS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_POS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_POS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CLM_DROP_DOWN_POS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public TdmUserDO checkAvailabilityOfUserId(String userId, EntityManager managerUser)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_CHECK_AVIL_USER
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			String query = "select count(u1.userId) from TdmUserDO u1 where u1.userId ='" + userId
					+ "'";
			Long count = (Long) managerUser.createQuery(query).getSingleResult();
			if (count > 0)
			{
				TdmUserDO userDO = managerUser.find(TdmUserDO.class, userId);
				logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
						+ MessageConstant.TDM_FTD_CHECK_AVIL_USER + MessageConstant.LOG_INFO_RETURN);
				return userDO;
			}
			else
			{

				return null;
			}
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CHECK_AVIL_USER + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CHECK_AVIL_USER + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CHECK_AVIL_USER + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_CHECK_AVIL_USER + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	@Transactional
	public List<TdmReservationDO> saveReservedData(List<TdmReservationDO> reservationDOList,
			String testCaseId, String testCaseName, EntityManager managerUser) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			List<TdmReservationDO> reservationDOs = null;
			if (null != reservationDOList && 0 < reservationDOList.size())
			{
				managerUser.getTransaction().begin();
				reservationDOs = new ArrayList<TdmReservationDO>();
				for (TdmReservationDO reservationDO : reservationDOList)
				{
					if (null != reservationDO && 0 == reservationDO.getRecordId())
					{
						reservationDO.setTestCaseId(testCaseId);
						reservationDO.setTestCaseName(testCaseName);
						reservationDO = managerUser.merge(reservationDO);
						reservationDOs.add(reservationDO);
					}

				}
				managerUser.getTransaction().commit();
			}
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_INFO_RETURN);
			return reservationDOs;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_SAVE_RESAERV_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> getReservedRecords(List<TdmProviderDO> providerDOlist,
			String userName, EntityManager managerUser) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			String searchType = AppConstant.PROV;
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmReservationDO> list = managerUser.createQuery(
					"SELECT p FROM TdmReservationDO p where p.reserveDataType='" + searchType
							+ "' AND p.userId='" + userName + "'").getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> getReservedRecords(String searchType, String userId, int offSet,
			int recordsperpage, boolean pageNationOnOffFlag, EntityManager managerUser)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmReservationDO> list = managerUser
					.createQuery(
							"SELECT p FROM TdmReservationDO p where p.reserveDataType='"
									+ searchType + "' AND p.userId='" + userId
									+ "' AND p.locked='Y'").setFirstResult(offSet)
					.setMaxResults(recordsperpage).getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Long getReservedRecordsCount(String searchType, String userId, EntityManager managerUser)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT + MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			Long list = (Long) managerUser.createQuery(
					"SELECT COUNT(*) FROM TdmReservationDO p where p.reserveDataType='"
							+ searchType + "' AND p.userId='" + userId + "' AND p.locked='Y'")
					.getSingleResult();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT + MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_GET_RESERVE_CNT
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> getReservedRecordsOfSub(List<TdmSubscriberDO> subscriberDOlist,
			String userName, EntityManager managerUser) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			String searchType = AppConstant.SUB;
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmReservationDO> list = managerUser.createQuery(
					"SELECT p FROM TdmReservationDO p where p.reserveDataType='" + searchType
							+ "' AND p.userId='" + userName + "'").getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> getReservedRecords(String userId, String searchType,
			EntityManager managerUser) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmReservationDO> list = managerUser.createQuery(
					"SELECT p FROM TdmReservationDO p where p.reserveDataType IN ('" + searchType
							+ "')").getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Boolean unReservedRecordForUser(Long providerId, EntityManager managerUser)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_FTD_SER_PROV_UNRESERVE_REC
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			managerUser.getTransaction().begin();
			Query q1 = managerUser
					.createQuery("DELETE FROM TdmReservationDO p where p.reserveDataId =:reserveDataId");
			q1.setParameter("reserveDataId", String.valueOf(providerId));
			int count = q1.executeUpdate();
			managerUser.getTransaction().commit();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_UNRESERVE_REC
					+ MessageConstant.LOG_INFO_RETURN);
			return count > 0 ? true : false;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_SER_PROV_UNRESERVE_REC
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> getReservedRecordsOfSub(String userId, EntityManager managerUser)
			throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmReservationDO> list = managerUser.createQuery(
					"SELECT p FROM TdmReservationDO p where p.id.userId='" + userId + "'")
					.getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_SUB
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public List<TdmReservationDO> getReservedRecordsOfClaim(List<TdmClaimDO> claimDOlist,
			EntityManager managerUser) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			String searchType = AppConstant.CLM;
			@SuppressWarnings(AppConstant.UNCHECKED)
			List<TdmReservationDO> list = managerUser
					.createQuery(
							"SELECT p FROM TdmReservationDO p where p.reserveDataType='"
									+ searchType + "'").getResultList();
			logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_INFO_RETURN);
			return list;
		}
		catch (IllegalStateException illegalStateEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION,
					illegalStateEx);
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_REV_REC_CLM
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	/**
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public Date converDateToString(String date) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO + MessageConstant.TDM_FTD_STRING_TO_DATE
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			if (StringUtils.isNotEmpty(date))
			{
				SimpleDateFormat dataFormater = new SimpleDateFormat("MM/dd/yyyy");
				Date dt = dataFormater.parse(date);
				logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
						+ MessageConstant.TDM_FTD_STRING_TO_DATE + MessageConstant.LOG_INFO_RETURN);
				return dt;
			}
			return null;

		}
		catch (ParseException parseException)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_STRING_TO_DATE + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.PARSE_EXCEPTION, parseException);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_STRING_TO_DATE + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_FTD_STRING_TO_DATE + MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}
	}

	@Override
	public void unReserveResrvedRecords(List<TdmReservationDO> reservationDOList, String userId,
			EntityManager managerUser) throws DAOException
	{
		logger.info(MessageConstant.TDM_FTD_SERVICE_DAO
				+ MessageConstant.TDM_UNRESERVE_RESERVED_RECORDS
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try
		{
			managerUser.getTransaction().begin();
			if (reservationDOList != null && reservationDOList.size() > 0)
			{

				for (TdmReservationDO reservationDO : reservationDOList)
				{
					reservationDO.setUserId(userId);
					managerUser.merge(reservationDO);
				}
				managerUser.getTransaction().commit();
			}
		}
		catch (IllegalArgumentException illegalArgEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_UNRESERVE_RESERVED_RECORDS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.INVALID_QUERY_EXCEPTION, illegalArgEx);
		}
		catch (NullPointerException nullPointerEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_UNRESERVE_RESERVED_RECORDS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		}
		catch (Exception otherEx)
		{
			logger.error(MessageConstant.TDM_FTD_SERVICE_DAO
					+ MessageConstant.TDM_UNRESERVE_RESERVED_RECORDS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new DAOException(MessageConstant.DATABASE_EXCEPTION, otherEx);
		}

	}

}
