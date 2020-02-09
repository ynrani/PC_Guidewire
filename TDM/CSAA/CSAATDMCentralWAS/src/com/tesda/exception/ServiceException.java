package com.tesda.exception;

public class ServiceException extends BaseException {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String errorCode,
			Class<? extends Object> originatingClass) {
		super(errorCode, originatingClass);
	}

	public ServiceException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

	public ServiceException(String errorCode, Throwable rootCause) {
		super(errorCode, rootCause);
	}

	public ServiceException(String errorCode, Throwable rootCause,
			Class<? extends Object> originatingClass) {
		super(errorCode, rootCause, originatingClass);
	}

	@Override
	public String getErrorCode() {
		return super.getErrorCode();
	}

	public String getSuperErrorCode() {
		return super.getErrorCode();
	}

}
