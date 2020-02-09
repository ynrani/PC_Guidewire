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
 * 
 * BaseException is a base exception class which can be extended by the individual exception classes
 * in the Application. This may be termed as a sample and is used in the CommonFacesServlet and
 * BasePageBean in the framework
 * 
 * @author CapGemini
 */

@SuppressWarnings("serial")
public class BaseException extends Exception
{
	// ErrorCode and ErrorMessage are to carry sufficient error information
	// to display on UI. -
	private String errorCode;
	private String errorMessage;
	private Class<? extends Object> originatingClass;
	private Throwable rootCause;

	/**
	 * Constructor
	 * 
	 */
	public BaseException()
	{
		super();
	}

	/**
	 * Base Exception
	 * 
	 * @param e
	 *            BaseException
	 * 
	 */
	public BaseException(BaseException e)
	{
		super(e);
	}

	/**
	 * Constructor with error code
	 * 
	 * @param errorCode
	 */
	protected BaseException(String errorCode)
	{
		super(errorCode);
		this.errorCode = errorCode;

	}

	/**
	 * Constructor with error code and error message. NOTE: ErrorCode and ErrorMessage are to carry
	 * sufficient error information upto UI.
	 * 
	 * @author Seshadri chowdary
	 * @param errorCode
	 * @param errorMessage
	 */
	protected BaseException(String errorCode, String errorMessage)
	{
		super(errorCode);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * Constructor with error code and originating class
	 * 
	 * @param errorCode
	 * @param originatingClass
	 */
	protected BaseException(String errorCode, Class<? extends Object> originatingClass)
	{
		// super(errorCode);
		this.errorCode = errorCode;
		this.originatingClass = originatingClass;
	}

	/**
	 * Constructor with error code and root cause
	 * 
	 * @param errorCode
	 * @param rootCause
	 */
	protected BaseException(String errorCode, Throwable rootCause)
	{
		super(rootCause);
		this.errorCode = errorCode;
		this.rootCause = rootCause;
	}

	/**
	 * Constructor with error code, root cause and originating class
	 * 
	 * @param errorCode
	 * @param rootCause
	 * @param originatingClass
	 */
	protected BaseException(String errorCode, Throwable rootCause,
			Class<? extends Object> originatingClass)
	{
		super(rootCause);
		this.errorCode = errorCode;
		this.rootCause = rootCause;
		this.originatingClass = originatingClass;
	}

	/**
	 * @return the error code
	 */
	public String getErrorCode()
	{
		return errorCode;
	}

	/**
	 * @return Originating Class object
	 */
	public Class<? extends Object> getOriginatingClass()
	{
		return originatingClass;
	}

	/**
	 * @return root cause
	 */
	public Throwable getRootCause()
	{
		return rootCause;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
}