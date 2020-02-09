/*---------------------------------------------------------------------------------------
 * Object Name: BaseException.Java
 * 
 * Modification Block:
 * --------------------------------------------------------------------------------------
 * S.No. Name                Date      Bug Fix no. Desc
 * --------------------------------------------------------------------------------------
 * 1     Seshadri Chowdary          11/06/15  NA          Created
 * --------------------------------------------------------------------------------------
 *
 * Copyright: 2015 <CapGemini>
 *---------------------------------------------------------------------------------------*/

package com.tdm.exception;

/**
 * TODO add description
 * 
 * @author Seshadri Chowdary
 * @version 1.0
 */
public class DAOException extends BaseException
{
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with error code
	 * 
	 * @param errorCode
	 */
	public DAOException(String message)
	{
		super(message);
	}

	/**
	 * Constructor with error code and originating class
	 * 
	 * @param errorCode
	 * @param originatingClass
	 */
	public DAOException(String errorCode, Class<? extends Object> originatingClass)
	{
		super(errorCode, originatingClass);
	}

	/**
	 * Constructor with error code and root cause
	 * 
	 * @param errorCode
	 * @param rootCause
	 */
	public DAOException(String errorCode, Throwable rootCause)
	{
		super(errorCode, rootCause);
	}

	/**
	 * Constructor with error code, root cause and originating class
	 * 
	 * @param errorCode
	 * @param rootCause
	 * @param originatingClass
	 */
	public DAOException(String errorCode, Throwable rootCause,
			Class<? extends Object> originatingClass)
	{
		super(errorCode, rootCause, originatingClass);
	}
}
