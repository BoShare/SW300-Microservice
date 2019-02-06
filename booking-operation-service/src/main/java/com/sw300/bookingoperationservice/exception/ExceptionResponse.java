package com.sw300.bookingoperationservice.exception;

import java.util.Date;

public class ExceptionResponse {
	//timestamp
	private Date timestamp;
	//message
	private String messsage;
	//details
	private String details;
	public ExceptionResponse(Date timestamp, String messsage, String details) {
		super();
		this.timestamp = timestamp;
		this.messsage = messsage;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMesssage() {
		return messsage;
	}
	public String getDetails() {
		return details;
	}
	
	

}
