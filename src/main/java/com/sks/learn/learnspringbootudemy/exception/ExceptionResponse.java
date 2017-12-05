package com.sks.learn.learnspringbootudemy.exception;

import java.util.Date;

public class ExceptionResponse {
	private Date errorTimestamp;
	private String errorCode;
	private String errorMessage;

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(Date errorTimestamp, String errorCode, String errorMessage) {
		super();
		this.errorTimestamp = errorTimestamp;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public Date getErrorTimestamp() {
		return errorTimestamp;
	}

	public void setErrorTimestamp(Date errorTimestamp) {
		this.errorTimestamp = errorTimestamp;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
