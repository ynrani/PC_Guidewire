package com.tesda.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tesda.dao.RefreshDAO;
import com.tesda.exception.DAOException;

@Component("refreshDAO")
public class RefreshDAOImpl implements RefreshDAO
{

	final static Logger logger = Logger.getLogger(RefreshDAOImpl.class);

	public static final String FASTLANE_DS = "java:jboss/datasources/tdmCsaaFastLaneDSSQL";
	public static final String PAAS_DS = "java:jboss/datasources/tdmCsaaPropAutoDS";
	public static final String USER_DS = "java:jboss/datasources/tdmCsaaUserDS";

	@PersistenceUnit(unitName = "fastlaneMappingPersistenceUnitSQL")
	private EntityManagerFactory factoryCsaaFastlaneMappingUser;
	EntityManager factoryCsaaFastLane;

	@Autowired
	private MessageSource messageSource;

	@Override
	@Transactional
	public boolean policyRefresh(EntityManager managerCsaaUser, EntityManager factoryCsaaProp)
			throws DAOException {
		boolean flag = false;
		try {
			final List<List<String>> lstResult = new ArrayList<List<String>>();
			long startTime = System.currentTimeMillis();
			factoryCsaaProp.unwrap(Session.class).doWork(new Work()
			{
				@Override
				public void execute(Connection con) throws SQLException {
					PreparedStatement pst = con
							.prepareStatement("SELECT distinct(policynumber),lob from policysummary");
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						List<String> lst = new ArrayList<String>();
						lst.add(rs.getString(1));
						lst.add(rs.getString(2));

						lstResult.add(lst);
					}
				}
			});
			long stopTime = System.currentTimeMillis();

			long elapsedTime = stopTime - startTime;
			System.out.println("@@@@@@@@@@@@@@@ " + elapsedTime);
			if (null != lstResult && !lstResult.isEmpty()) {
				EntityManager factoryCsaaFastLane = factoryCsaaFastlaneMappingUser
						.createEntityManager();
				startTime = System.currentTimeMillis();
				final Set<String> setResult = new HashSet<String>();
				factoryCsaaFastLane.unwrap(Session.class).doWork(new Work()
				{
					@Override
					public void execute(Connection con) throws SQLException {
						PreparedStatement pst = con
								.prepareStatement("select distinct pol_num from FASTLANE_ACAAU_TAB ORDER BY pol_num");
						ResultSet rs = pst.executeQuery();
						while (rs.next()) {
							setResult.add(rs.getString(1));
						}
						pst = con
								.prepareStatement("select distinct pol_num from FASTLANE_ACAHO_TAB ORDER BY pol_num");
						rs = pst.executeQuery();
						while (rs.next()) {
							setResult.add(rs.getString(1));
						}
					}
				});
				stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("%%%%%%%%%%%%% " + elapsedTime);
				managerCsaaUser.unwrap(Session.class).doWork(new Work()
				{
					@Override
					public void execute(Connection con) throws SQLException {
						PreparedStatement pst = con.prepareStatement("DELETE FROM CSAA_POL_LIST");
						pst.executeUpdate();
						pst = con
								.prepareStatement("INSERT INTO CSAA_POL_LIST(policyNumber,lob,flag)values(?,?,?)");
						int iTotalSize = lstResult.size();
						int BATCH_SIZE = 10;
						int iLoop = 1;
						int iMod = 0;
						int iNoOfTimes = 0;
						int iCaptureRecord = 0;
						if (iTotalSize > BATCH_SIZE) {
							iLoop = (iTotalSize / BATCH_SIZE);
							iMod = (iTotalSize % BATCH_SIZE);
							if (iMod > 0) {
								iLoop++;
							}
							for (int i = 0; i < iLoop; i++) {
								if (iMod > 0 && i == iLoop - 1) {
									iNoOfTimes = iMod;
								} else {
									iNoOfTimes = BATCH_SIZE;
								}
								for (int j = 0; j < iNoOfTimes; j++) {

									pst.setString(1, lstResult.get(iCaptureRecord).get(0));
									pst.setString(2, lstResult.get(iCaptureRecord).get(1));
									if (setResult.contains(lstResult.get(iCaptureRecord).get(0))) {
										pst.setString(3, "Y");
									} else {
										pst.setString(3, "N");
									}

									iCaptureRecord++;

									pst.addBatch();
								}
								pst.executeBatch();
							}
						} else {
							for (int j = 0; j < iTotalSize; j++) {
								pst.setString(1, lstResult.get(j).get(0));
								pst.setString(2, lstResult.get(j).get(1));
								if (setResult.contains(lstResult.get(j).get(0))) {
									pst.setString(3, "Y");
								} else {
									pst.setString(3, "N");
								}

								pst.addBatch();
							}

							pst.executeBatch();
						}

					}
				});
				factoryCsaaFastLane.close();
				flag = true;
			}

		} catch (IllegalStateException illegalStateEx) {
			logger.error("MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION" + illegalStateEx);
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx) {
			logger.error("MessageConstant.INVALID_QUERY_EXCEPTION" + illegalArgEx);
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION" + nullPointerEx);
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION" + otherEx);
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);

		}
		return flag;
	}

	@Override
	public boolean getPolicysummaryData(EntityManager managerCsaaUser, EntityManager factoryCsaaProp)
			throws DAOException {
		try {

			String bfr = "SELECT POLICYNUMBER, LOB, POLICYSTATUSCD, POLICYFORMCD, TIMEDPOLICYSTATUSCD, TXTYPE, CONTRACTTERMTYPECD, PRODUCTCD, RISKSTATECD, EFFECTIVE, EXPIRATION, POLICYDETAIL_ID, CURRENTREVISIONIND FROM POLICYSUMMARY ";

			List<List<String>> lstNoOfDrivers = new ArrayList<List<String>>();
			List<List<String>> lstNoOfVehi = new ArrayList<List<String>>();
			List<List<String>> lstNoOfVio = new ArrayList<List<String>>();
			List<List<String>> lstNoOfInsure = new ArrayList<List<String>>();
			Set<String> setResult = new HashSet<String>();

			long startTime = System.currentTimeMillis();

			JndiTemplate jndiTemplate = new JndiTemplate();
			DataSource dataSourcePassLane = (DataSource) jndiTemplate.lookup(FASTLANE_DS);
			DataSource dataSourcePas = (DataSource) jndiTemplate.lookup(PAAS_DS);
			DataSource dataSourceCsaa = (DataSource) jndiTemplate.lookup(USER_DS);

			Connection conPasLane = dataSourcePassLane.getConnection();
			Connection conPas = dataSourcePas.getConnection();
			Connection conCsaaUser = dataSourceCsaa.getConnection();

			/**
			 * FastLane fetch details
			 */
			// Begin

			PreparedStatement pstFL = conPasLane
					.prepareStatement("select distinct pol_num from FASTLANE_ACAAU_TAB ORDER BY pol_num");
			ResultSet rs = pstFL.executeQuery();
			rs.setFetchSize(5000);
			while (rs.next()) {
				setResult.add(rs.getString(1));
			}
			pstFL = conPasLane
					.prepareStatement("select distinct pol_num from FASTLANE_ACAHO_TAB ORDER BY pol_num");
			rs = pstFL.executeQuery();
			rs.setFetchSize(5000);
			while (rs.next()) {
				setResult.add(rs.getString(1));
			}

			/**
			 * Going for fetchind derived fields values
			 */
			PreparedStatement pst;
			/**
			 * No Of Vehicles
			 */
			pst = conPas
					.prepareStatement("SELECT R.POLICYDETAIL_ID,COUNT(*) AS countValue FROM RISKITEM R where r.seqno IS NOT NULL and R.POLICYDETAIL_ID is not null group by R.POLICYDETAIL_ID");
			pst.setFetchSize(5000);
			ResultSet rsNoOfVehi = pst.executeQuery();
			while (rsNoOfVehi.next()) {
				List<String> colResult = new ArrayList<String>();
				colResult.add(rsNoOfVehi.getString(1));
				colResult.add(rsNoOfVehi.getInt((2)) + "");

				lstNoOfVehi.add(colResult);
			}

			/**
			 * No Of Drivers
			 */
			pst = conPas
					.prepareStatement("SELECT R.POLICYDETAIL_ID,COUNT(*) AS countValue FROM DRIVER R WHERE R.SEQNO IS NOT NULL and R.POLICYDETAIL_ID is not null group by R.POLICYDETAIL_ID");
			pst.setFetchSize(1000);
			ResultSet rsNoOfDrivers = pst.executeQuery();
			while (rsNoOfDrivers.next()) {
				List<String> colResult = new ArrayList<String>();
				colResult.add(rsNoOfDrivers.getString(1));
				colResult.add(rsNoOfDrivers.getInt((2)) + "");

				lstNoOfDrivers.add(colResult);
			}

			/**
			 * No Of Viol
			 */
			pst = conPas
					.prepareStatement("select d.POLICYDETAIL_ID,count(*) AS countValue from ACCIDENTVIOLATION AV,Driver d where d.ID=AV.DRIVER_ID AND AV.SEQNO IS NOT NULL and d.POLICYDETAIL_ID is not null group by d.POLICYDETAIL_ID");
			pst.setFetchSize(1000);
			ResultSet rsNoOfViol = pst.executeQuery();
			while (rsNoOfViol.next()) {
				List<String> colResult = new ArrayList<String>();
				colResult.add(rsNoOfViol.getString(1));
				colResult.add(rsNoOfViol.getInt((2)) + "");

				lstNoOfVio.add(colResult);
			}

			/**
			 * No Of Insured
			 */
			pst = conPas
					.prepareStatement("select POLICYDETAIL_ID,count(*) AS countValue from INSUREDPRINCIPAL where POLICYDETAIL_ID is not null group by POLICYDETAIL_ID");
			pst.setFetchSize(1000);
			ResultSet rsNoOfName = pst.executeQuery();
			while (rsNoOfName.next()) {
				List<String> colResult = new ArrayList<String>();
				colResult.add(rsNoOfName.getString(1));
				colResult.add(rsNoOfName.getInt((2)) + "");

				lstNoOfInsure.add(colResult);
			}

			PreparedStatement pst2 = conCsaaUser.prepareStatement("DELETE FROM POLICY_SUMMARY_STG");
			pst2.executeUpdate();

			pst2 = conCsaaUser
					.prepareStatement("INSERT INTO POLICY_SUMMARY_STG(POLICYNUMBER, LOB, POLICYSTATUSCD, POLICYFORMCD, TIMEDPOLICYSTATUSCD, TXTYPE, CONTRACTTERMTYPECD, PRODUCTCD, RISKSTATECD, POLICYDETAIL_ID, CURRENTREVISIONIND, NO_OF_DRIVERS, NO_OF_VEHI, NO_OF_INSU, NO_OF_VIO, DOC_YN) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?,?)");
			int iCount = 0;

			pst = conPas.prepareStatement(bfr);
			pst.setFetchSize(5000);
			ResultSet rs1 = pst.executeQuery();
			while (rs1.next()) {
				iCount++;
				pst2.setString(1, rs1.getString(1));
				pst2.setString(2, rs1.getString(2));
				pst2.setString(3, rs1.getString(3));
				pst2.setString(4, rs1.getString(4));
				pst2.setString(5, rs1.getString(5));
				pst2.setString(6, rs1.getString(6));
				pst2.setString(7, rs1.getString(7));
				pst2.setString(8, rs1.getString(8));
				pst2.setString(9, rs1.getString(9));
				// pst2.setString(10,Calendar.getInstance().getTime()+"");
				// pst2.setString(11,Calendar.getInstance().getTime()+"");*/
				pst2.setString(10, rs1.getString(12));
				pst2.setString(11, rs1.getString(13));

				if (!lstNoOfDrivers.isEmpty()) {
					for (List<String> listResult : lstNoOfDrivers) {
						if (!listResult.isEmpty()
								&& listResult.get(0).equalsIgnoreCase(rs1.getString(1))) {
							pst2.setString(12, listResult.get(1));
							break;
						} else {
							if (listResult.isEmpty()) {
								pst2.setString(12, "0");
							} else {
								pst2.setString(12, "0");
							}
						}
					}
				} else {
					pst2.setString(12, "0");
				}

				// for vehi
				if (!lstNoOfVehi.isEmpty()) {
					for (List<String> listResult : lstNoOfVehi) {
						if (!listResult.isEmpty()
								&& listResult.get(0).equalsIgnoreCase(rs1.getString(1))) {
							pst2.setString(13, listResult.get(1));
							break;
						} else {
							if (listResult.isEmpty()) {
								pst2.setString(13, "0");
							} else {
								pst2.setString(13, "0");
							}
						}
					}
				} else {
					pst2.setString(13, "0");
				}

				// insured
				if (!lstNoOfInsure.isEmpty()) {
					for (List<String> listResult : lstNoOfInsure) {
						if (!listResult.isEmpty()
								&& listResult.get(0).equalsIgnoreCase(rs1.getString(1))) {
							pst2.setString(14, listResult.get(1));
							break;
						} else {
							if (listResult.isEmpty()) {
								pst2.setString(14, "0");
							} else {
								pst2.setString(14, "0");
							}
						}
					}
				} else {
					pst2.setString(14, "0");
				}

				// for vio
				if (!lstNoOfVio.isEmpty()) {
					for (List<String> listResult : lstNoOfVio) {
						if (!listResult.isEmpty()
								&& listResult.get(0).equalsIgnoreCase(rs1.getString(1))) {
							pst2.setString(15, listResult.get(1));
							break;
						} else {
							if (listResult.isEmpty()) {
								pst2.setString(15, "0");
							} else {
								pst2.setString(15, "0");
							}
						}
					}
				} else {
					pst2.setString(15, "0");
				}

				// End Derived fields

				if (setResult.contains(rs1.getString(1))) {
					pst2.setString(16, "Y");
				} else {
					pst2.setString(16, "N");
				}

				pst2.addBatch();
				if (iCount % 10000 == 0) {
					pst2.executeBatch();
					iCount = 0;
				}

				// }
			}
			if (iCount > 0) {
				pst2.executeBatch();
			}

			// closing resource pre stmts
			if (pstFL != null) {
				pstFL.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (pst2 != null) {
				pst2.close();
			}

			// closing resource resultsets
			if (rs != null) {
				rs.close();
			}
			if (rs1 != null) {
				rs1.close();
			}

			if (rsNoOfVehi != null) {
				rsNoOfVehi.close();
			}
			if (rsNoOfDrivers != null) {
				rsNoOfDrivers.close();
			}
			if (rsNoOfViol != null) {
				rsNoOfViol.close();
			}
			if (rsNoOfName != null) {
				rsNoOfName.close();
			}

			// End

			//

			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println("%%%%%%%%%%%%% " + elapsedTime);
			/**
			 * Going for fetching coverage details
			 */
			boolean covsts = getPolicyCoverage(managerCsaaUser, factoryCsaaProp);

			return covsts;

		} catch (IllegalStateException illegalStateEx) {
			logger.error("MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION" + illegalStateEx);
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx) {
			logger.error("MessageConstant.INVALID_QUERY_EXCEPTION" + illegalArgEx);
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION" + nullPointerEx);
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION" + otherEx);
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);

		}
	}

	private boolean getPolicyCoverage(EntityManager managerCsaaUser, EntityManager factoryCsaaProp)
			throws DAOException {
		try {

			List<String> lstRisk = new ArrayList<String>();

			long startTime = System.currentTimeMillis();

			JndiTemplate jndiTemplate = new JndiTemplate();
			DataSource dataSourcePas = (DataSource) jndiTemplate.lookup(PAAS_DS);
			DataSource dataSourceCsaa = (DataSource) jndiTemplate.lookup(USER_DS);

			Connection conPas = dataSourcePas.getConnection();
			Connection conCsaaUser = dataSourceCsaa.getConnection();

			/**
			 * FastLane fetch details
			 */
			// Begin

			//

			/**
			 * Going for fetching coverage details
			 */
			PreparedStatement pstCov = conPas
					.prepareStatement("Select ID,POLICYDETAIL_ID,COVERAGECD from COVERAGE where POLICYDETAIL_ID is not null");
			pstCov.setFetchSize(5000);
			ResultSet rsCoverage = pstCov.executeQuery();
			/**
			 * going for fetch risk items
			 */

			pstCov = conPas
					.prepareStatement("Select POLICYDETAIL_ID from RISKITEM where seqno IS NOT NULL and POLICYDETAIL_ID is not null");
			pstCov.setFetchSize(5000);
			ResultSet rsRisk = pstCov.executeQuery();
			while (rsRisk.next()) {
				lstRisk.add(rsRisk.getString(1));
			}

			// Going insert records into local mart

			PreparedStatement pstCoverage = conCsaaUser
					.prepareStatement("DELETE FROM COVERAGE_RISK_STG");
			pstCoverage.executeUpdate();

			pstCoverage = conCsaaUser
					.prepareStatement("INSERT INTO COVERAGE_RISK_STG(ID,POLICYDETAIL_ID,COVERAGECD,RISK_POLICY_DTL_ID)values(?,?,?,?)");
			int iCount = 0;
			while (rsCoverage.next()) {
				iCount++;
				pstCoverage.setString(1, rsCoverage.getLong(1) + "");
				pstCoverage.setString(2, rsCoverage.getString(2));
				pstCoverage.setString(3, rsCoverage.getString(3));
				if (lstRisk.contains(rsCoverage.getString(2))) {
					pstCoverage.setString(4, "Y");
				} else {
					pstCoverage.setString(4, "N");
				}

				pstCoverage.addBatch();
				if (iCount % 10000 == 0) {
					pstCoverage.executeBatch();
					iCount = 0;
				}
				// lstCoverages.add(colResultCoverage);
			}
			if (iCount != 0 && iCount < 10000) {
				pstCoverage.executeBatch();
			}

			// closing resource pre stmts
			if (pstCov != null) {
				pstCov.close();
			}

			if (pstCoverage != null) {
				pstCoverage.close();
			}

			// closing resource resultsets
			if (rsCoverage != null) {
				rsCoverage.close();
			}
			if (rsRisk != null) {
				rsRisk.close();
			}

			if (conPas != null) {
				conPas.close();
			}
			if (conCsaaUser != null) {
				conCsaaUser.close();
			}

			long stopTime = System.currentTimeMillis();
			long elapsedTime = stopTime - startTime;
			System.out.println("%%%%%%%%%%%%% " + elapsedTime);

			return true;

		} catch (IllegalStateException illegalStateEx) {
			logger.error("MessageConstant.NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION" + illegalStateEx);
			throw new DAOException(messageSource.getMessage(
					"NRE_ENTITY_MGR_FACTORY_CLOSED_EXCEPTION", null, null), illegalStateEx);

		} catch (IllegalArgumentException illegalArgEx) {
			logger.error("MessageConstant.INVALID_QUERY_EXCEPTION" + illegalArgEx);
			throw new DAOException(messageSource.getMessage("INVALID_QUERY_EXCEPTION", null, null),
					illegalArgEx);

		} catch (NullPointerException nullPointerEx) {
			logger.error("MessageConstant.NULL_POINTER_EXCEPTION" + nullPointerEx);
			throw new DAOException(messageSource.getMessage("NULL_POINTER_EXCEPTION", null, null),
					nullPointerEx);

		} catch (Exception otherEx) {
			logger.error("MessageConstant.DATABASE_EXCEPTION" + otherEx);
			throw new DAOException(messageSource.getMessage("DATABASE_EXCEPTION", null, null),
					otherEx);

		}
	}

}
