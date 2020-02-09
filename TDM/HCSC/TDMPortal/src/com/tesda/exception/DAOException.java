/*---------------------------------------------------------------------------------------
* Object Name: DAOException.Java
* 
 * Modification Block:
* --------------------------------------------------------------------------------------
* S.No. Name                Date      Bug Fix no. 		Desc
* --------------------------------------------------------------------------------------
* 1     Seshadri Chowdary   11/04/15  NA          		Created* 
* --------------------------------------------------------------------------------------
*
* Copyright: 2015 <CapGemini>
*---------------------------------------------------------------------------------------*/

package com.tesda.exception;

public class DAOException extends TDMException
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
