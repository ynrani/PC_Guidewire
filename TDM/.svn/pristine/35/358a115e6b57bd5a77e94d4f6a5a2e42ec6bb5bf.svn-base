package com.tdm.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tdm.dao.RefreshDAO;
import com.tdm.exception.DAOException;
import com.tdm.exception.ServiceException;
import com.tdm.service.RefreshService;

@Component
@Service("refreshService")
@Transactional(propagation = Propagation.REQUIRED)
public class RefreshServiceImpl extends TdmBaseServiceImpl implements RefreshService
{
	final static Logger logger = Logger.getLogger(RefreshServiceImpl.class);

	@Autowired
	RefreshDAO refreshDAO;

	@Autowired
	private MessageSource messageSource;

	@Override
	public boolean getPolicysummaryData(HttpServletRequest request, HttpServletResponse response)
			throws ServiceException {
		try {
			boolean refreshFlag = false;
			boolean scriptFlag = false;
			scriptFlag = refreshDAO.getRunScript(request, response);
			if (scriptFlag) {
				refreshFlag = refreshDAO.getPolicysummaryData();
				System.out.println("@@@@@@@@@@@@@@  >  Part - 1 Done .........  ");

				refreshFlag = refreshDAO.getPolicyDerivedData();
				System.out.println("%%%%%%%%%%%%%  >  Part - 2 Done .........  ");
			}

			return refreshFlag;

		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public boolean getPolicyCoverageData() throws ServiceException {
		try {
			boolean refreshFlag = refreshDAO.getPolicyRiskCoverage();
			System.out.println(" Part - 2 Done .........  ");

			return refreshFlag;

		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

	@Override
	public boolean getPolicyDerivedData() throws ServiceException {
		try {
			boolean refreshFlag = refreshDAO.getPolicyDerivedData();
			System.out.println(" Part - 3 Done .........  ");

			return refreshFlag;

		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION", nullPointerEx);
			throw new ServiceException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null,
					null), nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error("DAO exception", daoEx);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error("Service exception", otherEx);
			throw new ServiceException(messageSource.getMessage("SERVICE_EXCEPTION", null, null),
					otherEx);
		}
	}

}
