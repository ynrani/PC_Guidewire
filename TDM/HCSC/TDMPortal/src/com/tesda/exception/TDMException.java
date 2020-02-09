/*---------------------------------------------------------------------------------------
* Object Name: TDMException.Java
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

public class TDMException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;
	private Class<? extends Object> originatingClass;
	private Throwable rootCause;

	/**
	 * Constructor
	 * 
	 */
	public TDMException()
	{
		super();
	}

	/**
	 * 
	 * @param e
	 * TDMException
	 * 
	 */
	public TDMException(TDMException e)
	{
		super(e);
	}

	/**
	 * Constructor with error code
	 * 
	 * @param errorCode
	 */
	public TDMException(String errorCode)
	{
		super(errorCode);
		this.errorCode = errorCode;

	}

	/**
	 * Constructor with error code and error message. NOTE: ErrorCode and ErrorMessage are to carry
	 * sufficient error information upto UI.
	 * 
	 * @param errorCode
	 * @param errorMessage
	 */
	protected TDMException(String errorCode, String errorMessage)
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
	protected TDMException(String errorCode, Class<? extends Object> originatingClass)
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
	protected TDMException(String errorCode, Throwable rootCause)
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
	protected TDMException(String errorCode, Throwable rootCause,
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
