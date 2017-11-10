package com.imolczek.school.banking.loan.calculator.service.exceptions;

public class LoanCalculationServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5267202885335080735L;
	
	/**
	 * An error message
	 */
	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param message the error message
	 */
	public LoanCalculationServiceException(String message) {
		super();
		this.message = message;
	}

}
