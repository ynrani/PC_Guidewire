/*
 * Object Name : DBConnectionException.java
 * Modification Block
 * ---------------------------------------------------------------------
 * S.No.	Name 			Date			Bug_Fix_No			Desc
 * ---------------------------------------------------------------------
 * 	1.	  vkrish14		Jun 15, 2015			NA             Created
 * ---------------------------------------------------------------------
 * Copyrights: 2015 Capgemini.com
 */
package com.tesda.exceptions;

public class DBConnectionException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a DBConnectionException with the given detail message.
	 *
	 * @param message
	 *            The detail message of the DAOException.
	 */
	public DBConnectionException(String message) {
		super(message);
	}

	/**
	 * Constructs a DBConnectionException with the given root cause.
	 *
	 * @param cause
	 *            The root cause of the DAOException.
	 */
	public DBConnectionException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a DBConnectionException with the given detail message and root
	 * cause.
	 *
	 * @param message
	 *            The detail message of the DAOException.
	 * @param cause
	 *            The root cause of the DAOException.
	 */
	public DBConnectionException(String message, Throwable cause) {
		super(message, cause);
	}
}
