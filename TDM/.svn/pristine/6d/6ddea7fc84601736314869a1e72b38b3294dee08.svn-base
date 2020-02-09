package com.datacon.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.datacon.constant.MessageConstant;
import com.datacon.dao.UploadDAO;
import com.datacon.exception.DAOException;
import com.datacon.exception.ServiceException;
import com.datacon.model.DO.DataConConnectionsDO;
import com.datacon.model.DTO.UploadDTO;
import com.datacon.model.DTO.UploadTableNameDTO;
import com.datacon.model.mapper.DbConnectionMapper;
import com.datacon.model.mapper.UploadMapper;
import com.datacon.service.UploadService;
import com.datacon.util.CSVCreateStmt;
import com.datacon.util.CSVLoader;
import com.datacon.util.ImportData;
import com.datacon.util.MissingNumber;
import com.datacon.util.XLSXLoader;
import com.opencsv.CSVReader;

@Component
@Service(MessageConstant.UPLOAD_SERVICE)
public class UploadServiceImpl extends DataConBaseServiceImpl implements UploadService
{
	private static Logger logger = Logger.getLogger(UploadServiceImpl.class);

	@Autowired
	UploadDAO uploadDAO;

	@Autowired
	UploadMapper uploadMapper;

	List<Object[]> dbDump = null;

	@Autowired
	DbConnectionMapper dbConnectionMapper;

	// private static String JDBC_CONNECTION_URL =
	// "jdbc:oracle:thin:csaa_user/csaa_user@IN-PNQ-COE07:1521:xe";

	@Override
	public List<Object[]> convertFileToData(CommonsMultipartFile multipartFile)
			throws ServiceException {
		logger.info(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_COVR_FILE_TO_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			List<Object[]> display = null;

			if (null != multipartFile.getOriginalFilename()) {

				String exten = multipartFile.getOriginalFilename().substring(
						multipartFile.getOriginalFilename().lastIndexOf('.'),
						multipartFile.getOriginalFilename().length());

				// .csv and .txt
				if (exten.equalsIgnoreCase(".csv") || exten.endsWith(".txt")) {

					char saperater = ',';
					if (exten.equalsIgnoreCase(".csv")) {
						saperater = ',';
					} else if (exten.equalsIgnoreCase(".txt")) {
						saperater = '\t';
					}

					CSVReader reader = new CSVReader(new InputStreamReader(
							multipartFile.getInputStream(), "UTF-8"), saperater);
					display = new ArrayList<Object[]>();
					for (Object[] strings : reader) {

						if (display.size() < 11) {
							display.add(strings);
						} else {
							break;
						}
					}
					reader.close();
				} else if (exten.equalsIgnoreCase(".xls") || exten.endsWith(".xlsx")) {
					dbDump = ImportData.convertToListFromExcel(multipartFile.getInputStream());

					display = new ArrayList<Object[]>();
					for (Object[] objects : dbDump) {
						if (display.size() < 10) {
							display.add(objects);
						} else {
							break;
						}
					}
				}

			}
			logger.info(MessageConstant.UPLOAD_SERVICE_IMPL
					+ MessageConstant.UPLOAD_COVR_FILE_TO_DATA + MessageConstant.LOG_INFO_RETURN);

			return display;
		} catch (IOException ioEx) {

			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL
					+ MessageConstant.UPLOAD_COVR_FILE_TO_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.IE_EXCEPTION, ioEx);

		} catch (NullPointerException nullPointerEx) {

			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL
					+ MessageConstant.UPLOAD_COVR_FILE_TO_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {

			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL
					+ MessageConstant.UPLOAD_COVR_FILE_TO_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public String insertDataToDB(CommonsMultipartFile multipartFile, String tabNames,
			UploadDTO uploadDTO, List<Object[]> selectedColumns) throws ServiceException {
		logger.info(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_COVR_FILE_TO_DATA
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {

			// Class.forName("oracle.jdbc.driver.OracleDriver");
			// connection = DriverManager.getConnection(JDBC_CONNECTION_URL);
			/*
			 * JndiTemplate jndiTemplate = new JndiTemplate(); DataSource dataSourceCsaa =
			 * (DataSource) jndiTemplate.lookup(USER_DS); Connection conCsaaUser =
			 * dataSourceCsaa.getConnection();
			 * 
			 * if (exten.equalsIgnoreCase(".sql")) { InputStream istream =
			 * multipartFile.getInputStream(); Reader reader = new BufferedReader(new
			 * InputStreamReader(istream, "UTF-8")); runScript(conCsaaUser, reader); }
			 */

			List<Integer> missingInts = missingColumns(selectedColumns);
			List<Integer> missingColumns = null;
			if (null != missingInts && !missingInts.isEmpty()) {

				int[] a = ArrayUtils
						.toPrimitive(missingInts.toArray(new Integer[missingInts.size()]));
				missingColumns = MissingNumber.findMissingNumbers(a, 0);

				System.out.println("Size= " + missingColumns.size());
			}
			if (null != multipartFile.getOriginalFilename()) {

				String exten = multipartFile.getOriginalFilename().substring(
						multipartFile.getOriginalFilename().lastIndexOf('.'),
						multipartFile.getOriginalFilename().length());

				char saperater = ',';
				if (exten.equalsIgnoreCase(".csv")) {
					saperater = ',';
				} else if (exten.equalsIgnoreCase(".txt")) {
					saperater = '\t';
				}

				StringBuffer url = null;
				String conId = null;
				// .csv and .txt
				//
				// String[] splittabName = tabNames.split(",");
				if (null != uploadDTO.getUploadTableNameDTOs()) {
					EntityManager managerUser = openUserEntityManager();
					UploadTableNameDTO uploadTableNameDTO = null;
					for (int i = 0; i < uploadDTO.getUploadTableNameDTOs().size(); i++) {
						uploadTableNameDTO = uploadDTO.getUploadTableNameDTOs().get(i);
						// con id
						conId = uploadTableNameDTO.getType().substring(
								uploadTableNameDTO.getType().lastIndexOf('_') + 1,
								uploadTableNameDTO.getType().length());
						// tab name
						DataConConnectionsDO dataConConnectionsDO = uploadDAO.getSelctedConnection(
								conId, managerUser);
						url = new StringBuffer();
						JdbcTemplate template = uploadDAO.getTemplate(
								uploadMapper.getUrl(dataConConnectionsDO, url) + "",
								dataConConnectionsDO.getUserName(),
								dataConConnectionsDO.getPassWord());
						// .csv and .txt
						if (exten.equalsIgnoreCase(".csv") || exten.equalsIgnoreCase(".txt")) {
							CSVLoader loader = new CSVLoader(template, saperater);
							loader.loadCSV(multipartFile, uploadTableNameDTO.getSelDbtab(), true,
									missingColumns);

						}
						// .xlsx and .xls
						if (exten.equalsIgnoreCase(".xlsx") || exten.equalsIgnoreCase(".xls")) {
							XLSXLoader loader = new XLSXLoader(template);

							loader.loadXLSX(dbDump, uploadTableNameDTO.getSelDbtab(), true,
									missingColumns);

						}

					}
					closeUserEntityManager(managerUser);
				}
			}

			logger.info(MessageConstant.UPLOAD_SERVICE_IMPL
					+ MessageConstant.UPLOAD_COVR_FILE_TO_DATA + MessageConstant.LOG_INFO_RETURN);

			return "Successfully Data Dumped";
		} catch (IOException ioEx) {

			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL
					+ MessageConstant.UPLOAD_COVR_FILE_TO_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.IE_EXCEPTION, ioEx);

		} catch (NullPointerException nullPointerEx) {

			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL
					+ MessageConstant.UPLOAD_COVR_FILE_TO_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {

			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL
					+ MessageConstant.UPLOAD_COVR_FILE_TO_DATA
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Map<String, String> getAvilableDBs(String userId) throws ServiceException {
		logger.info(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_AVIL_DBS
				+ MessageConstant.LOG_INFO_PARAMS_SEPC);
		try {
			Map<String, String> dbLists = null;
			EntityManager managerUser = openUserEntityManager();
			List<DataConConnectionsDO> dataConConnectionsDOs = uploadDAO.getAvilableDBs(userId,
					managerUser);
			closeUserEntityManager(managerUser);
			if (null != dataConConnectionsDOs && !dataConConnectionsDOs.isEmpty()) {
				dbLists = uploadMapper.convertAvilableDBsMap(dataConConnectionsDOs, dbLists);
			}
			logger.info(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_AVIL_DBS
					+ MessageConstant.LOG_INFO_RETURN);
			return dbLists;
		} catch (NullPointerException nullPointerEx) {

			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_AVIL_DBS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_AVIL_DBS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_AVIL_DBS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	@Override
	public Map<String, List<String>> getAllTableDetails(String dataConConnIds)
			throws ServiceException {
		logger.info(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_GET_ALL_TABS
				+ MessageConstant.LOG_INFO_PARAMS_SEPC);
		try {
			Map<String, List<String>> tables = null;
			EntityManager managerUser = openUserEntityManager();
			StringBuffer url = null;
			List<DataConConnectionsDO> dataConConnectionsDOs = uploadDAO.getSelctedConnections(
					dataConConnIds, managerUser);
			closeUserEntityManager(managerUser);
			if (null != dataConConnectionsDOs) {
				tables = new HashMap<String, List<String>>();
				for (DataConConnectionsDO dataConConnectionsDO : dataConConnectionsDOs) {
					url = new StringBuffer();
					List<String> allTables = uploadDAO.getAllTables(
							uploadMapper.getUrl(dataConConnectionsDO, url) + "",
							dataConConnectionsDO.getUserName(), dataConConnectionsDO.getPassWord());
					tables.put(
							dataConConnectionsDO.getDbType() + "_"
									+ dataConConnectionsDO.getDataConConnId(), allTables);
				}
			}
			logger.info(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_GET_ALL_TABS
					+ MessageConstant.LOG_INFO_RETURN);
			return tables;
		} catch (NullPointerException nullPointerEx) {

			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_GET_ALL_TABS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);

		} catch (DAOException daoEx) {
			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_GET_ALL_TABS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(daoEx.getErrorCode(), daoEx);

		} catch (Exception otherEx) {
			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_GET_ALL_TABS
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}

	public void runScript(Connection conn, Reader reader) throws IOException, SQLException {
		StringBuffer command = null;
		try {
			LineNumberReader lineReader = new LineNumberReader(reader);
			String line = null;
			while ((line = lineReader.readLine()) != null) {
				if (command == null) {
					command = new StringBuffer();
				}
				String trimmedLine = line.trim();
				if ((trimmedLine.length() >= 1) && (!trimmedLine.startsWith("//"))) {
					if ((trimmedLine.length() >= 1) && (!trimmedLine.startsWith("--"))) {
						if (trimmedLine.endsWith(";")) {
							command.append(line.substring(0, line.lastIndexOf(";")));
							command.append(" ");
							Statement statement = conn.createStatement();
							boolean hasResults = false;
							if (this.stopOnError)
								hasResults = statement.execute(command.toString());
							else {
								statement.execute(command.toString());
							}
							System.out.println("hasResults " + hasResults);
							command = null;
							statement.close();
							Thread.yield();
						} else {
							command.append(line);
							command.append(" ");
						}
					}
				}
			}

		} catch (SQLException e) {
			e.fillInStackTrace();
			printlnError("Error executing: " + command);
			printlnError(e);
			throw e;
		} catch (IOException e) {
			e.fillInStackTrace();
			printlnError("Error executing: " + command);
			printlnError(e);
			throw e;
		} finally {

			flush();
			flush();
		}

	}

	private void printlnError(Object o) {
		if (this.errorLogWriter != null)
			this.errorLogWriter.println(o);
	}

	private void flush() {
		if (this.logWriter != null) {
			this.logWriter.flush();
		}
		if (this.errorLogWriter != null)
			this.errorLogWriter.flush();
	}

	private boolean stopOnError;

	private PrintWriter logWriter = new PrintWriter(System.out);
	private PrintWriter errorLogWriter = new PrintWriter(System.err);

	private List<Integer> missingColumns(List<Object[]> selectedColumns) {
		List<Integer> ints = null;
		// List<Integer> missingInts = null;
		if (null != selectedColumns && !selectedColumns.isEmpty()) {
			ints = new ArrayList<Integer>();
			// missingInts = new ArrayList<Integer>();
			for (Object[] objects : selectedColumns) {
				int element = Integer.parseInt(objects[0].toString().substring(
						"selectedColumns".length(), objects[0].toString().length()));
				ints.add(element);
			}
			// int count = 0;
			// find the missing number
			// for (Integer i : ints) {
			// if (i != count) {
			// missingInts.add(count);
			// count++;
			// }
			// count++;

			// }
		}
		return ints;
	}

	@Override
	public String createTab(CommonsMultipartFile multipartFile, List<Object[]> selectedColumns)
			throws ServiceException {
		logger.info(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_TAB_NT_FOUND
				+ MessageConstant.LOG_INFO_PARAMS_NO);
		try {
			String query = null;
			List<Integer> missingInts = missingColumns(selectedColumns);
			List<Integer> missingColumns = null;
			if (null != missingInts && !missingInts.isEmpty()) {

				int[] a = ArrayUtils
						.toPrimitive(missingInts.toArray(new Integer[missingInts.size()]));
				missingColumns = MissingNumber.findMissingNumbers(a, 0);

			}
			if (null != multipartFile.getOriginalFilename()) {

				String exten = multipartFile.getOriginalFilename().substring(
						multipartFile.getOriginalFilename().lastIndexOf('.'),
						multipartFile.getOriginalFilename().length());

				char saperater = ',';
				if (exten.equalsIgnoreCase(".csv")) {
					saperater = ',';
				} else if (exten.equalsIgnoreCase(".txt")) {
					saperater = '\t';
				}

				// .csv and .txt
				if (exten.equalsIgnoreCase(".csv") || exten.equalsIgnoreCase(".txt")) {
					CSVCreateStmt loader = new CSVCreateStmt(saperater);
					query = loader.createStmt(multipartFile, "", missingColumns);
				}
				// .xlsx and .xls

			}

			logger.info(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_TAB_NT_FOUND
					+ MessageConstant.LOG_INFO_RETURN);

			return query;
		} catch (IOException ioEx) {

			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_TAB_NT_FOUND
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.IE_EXCEPTION, ioEx);

		} catch (NullPointerException nullPointerEx) {

			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_TAB_NT_FOUND
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.NULL_POINTER_EXCEPTION, nullPointerEx);
		} catch (Exception otherEx) {

			logger.error(MessageConstant.UPLOAD_SERVICE_IMPL + MessageConstant.UPLOAD_TAB_NT_FOUND
					+ MessageConstant.LOG_ERROR_EXCEPTION);
			throw new ServiceException(MessageConstant.SERVICE_EXCEPTION, otherEx);
		}
	}
}
