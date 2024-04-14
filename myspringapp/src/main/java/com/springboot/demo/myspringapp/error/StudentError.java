package com.springboot.demo.myspringapp.error;

public class StudentError {

	private int statusCode;
	private String errorMessage;
	private long timeStamp;
	
	
	
	public StudentError() {
		super();
	}
	
	
	public StudentError(int statusCode, String errorMessage, long timeStamp) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
		this.timeStamp = timeStamp;
	}


	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
