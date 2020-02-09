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

package com.datacon.exception;

/**
 * Service Exception
 * 
 * @author Seshadri Chowdary
 * @version 1.0
 */
public class ServiceException extends BaseException
{
	// private String errorCode;
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with error code
	 * 
	 * @param errorCode
	 */
	public ServiceException(String message)
	{
		super(message);
	}

	/**
	 * Constructor with error code and originating class
	 * 
	 * @param errorCode
	 * @param originatingClass
	 */
	public ServiceException(String errorCode, Class<? extends Object> originatingClass)
	{
		super(errorCode, originatingClass);
	}

	/**
	 * Constructor with error code and originating class
	 * 
	 * @param errorCode
	 * @param originatingClass
	 */
	public ServiceException(String errorCode, String errorMessage)
	{
		super(errorCode, errorMessage);
	}

	/**
	 * 
	 * Constructor
	 * 
	 * @param errorCode
	 * @param rootCause
	 * @param methodName
	 */
	/*
	 * public ServiceException(String errorCode, Throwable rootCause) { super(errorCode, rootCause);
	 * 
	 * }
	 */

	/**
	 * Constructor with error code and root cause
	 * 
	 * @param errorCode
	 * @param rootCause
	 */
	public ServiceException(String errorCode, Throwable rootCause)
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
	public ServiceException(String errorCode, Throwable rootCause,
			Class<? extends Object> originatingClass)
	{
		super(errorCode, rootCause, originatingClass);
	}

	@Override
	public String getErrorCode()
	{
		return super.getErrorCode();
	}

	public String getSuperErrorCode()
	{
		return super.getErrorCode();
	}
}
