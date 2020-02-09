package com.datacon.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author Seshadri Chowdary
 * 
 */
public class XLSXLoader
{

	private static final String SQL_INSERT = "INSERT INTO ${table}(${keys}) VALUES(${values})";
	private static final String TABLE_REGEX = "\\$\\{table\\}";
	private static final String KEYS_REGEX = "\\$\\{keys\\}";
	private static final String VALUES_REGEX = "\\$\\{values\\}";

	private JdbcTemplate template;

	/**
	 * Public constructor to build XLSXLoader object with Connection details. The connection is
	 * closed on success or failure.
	 * 
	 * @param connection
	 */
	public XLSXLoader(JdbcTemplate template)
	{
		this.template = template;

	}

	/**
	 * Parse XLS or XLSX file using POI library and load in given database table.
	 * 
	 * @param multipartFile
	 * @param tableName
	 * @param truncateBeforeLoad
	 * @param missingColumns
	 * @throws Exception
	 */
	public void loadXLSX(List<Object[]> dbDump, String tableName, boolean truncateBeforeLoad,
			List<Integer> missingColumns) throws Exception {

		if (null == this.template) {
			throw new Exception("Not a valid connection.");
		}

		Object[] obj = null;
		if (null != dbDump) {

			obj = null;
			obj = dbDump.get(0);

			// removing header
			if (null != missingColumns) {
				for (Integer inter : missingColumns) {
					obj = ArrayUtils.remove(obj, inter);
				}
			}

			String questionmarks = StringUtils.repeat("?,", obj.length);
			questionmarks = (String) questionmarks.subSequence(0, questionmarks.length() - 1);

			String query = SQL_INSERT.replaceFirst(TABLE_REGEX, tableName);
			query = query.replaceFirst(KEYS_REGEX, StringUtils.join(obj, ","));
			query = query.replaceFirst(VALUES_REGEX, questionmarks);

			System.out.println("Query: " + query);

			Connection con = null;
			PreparedStatement ps = null;
			DataSource ds = null;
			try {
				ds = this.template.getDataSource();
				con = ds.getConnection();
				con.setAutoCommit(false);
				ps = con.prepareStatement(query);

				if (truncateBeforeLoad) {
					// delete data from table before loading csv
					con.createStatement().execute("DELETE FROM " + tableName);
				}

				final int batchSize = 1000;
				int count = 0;
				Date date = null;
				int ind = 0;

				for (int i = 0; i < dbDump.size(); i++) {

					if (0 != ind) {
						obj = dbDump.get(i);

						if (null != missingColumns) {
							for (Integer inter : missingColumns) {
								obj = ArrayUtils.remove(obj, inter);
							}
						}

						if (null != obj && 0 != ind) {
							int index = 1;
							for (Object string : obj) {
								if (null != string) {
									date = com.datacon.util.DateUtil.convertToDate(string + "");

									if (null != date) {
										ps.setDate(index++, new java.sql.Date(date.getTime()));
									} else {
										ps.setString(index++, string.toString());
									}
								} else {
									ps.setString(index++, null);
								}
							}
							ps.addBatch();
						}
						if (++count % batchSize == 0) {
							ps.executeBatch();
						}
					} else {
						ind = 1;
					}

				}
				ps.executeBatch(); // insert remaining records
				con.commit();
			} catch (Exception e) {
				con.rollback();
				e.printStackTrace();
				throw new Exception("Error occured while loading data from file to database."
						+ e.getMessage());
			} finally {
				if (null != ps)
					ps.close();
				if (null != con)
					con.close();

			}

		}
	}

}
