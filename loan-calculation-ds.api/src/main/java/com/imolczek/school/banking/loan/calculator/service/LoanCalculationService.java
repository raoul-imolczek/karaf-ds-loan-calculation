package com.imolczek.school.banking.loan.calculator.service;

import java.math.BigDecimal;

import com.imolczek.school.banking.loan.calculator.exceptions.LoanCalculationException;
import com.imolczek.school.banking.loan.calculator.model.LoanCalculationResult;

/**
 * @author Fabian Bouché
 * The interface for the loan calculation service
 */
public interface LoanCalculationService {

	/**
	 * Calculate a loan with the following arguments
	 * @param amount the amount to be lent
	 * @param installment the desired monthly installment
	 * @param rate the annual rate of the loan
	 * @return a loan calculation result
	 * @throws LoanCalculationException
	 */
	public LoanCalculationResult calculate(BigDecimal amount, BigDecimal installment, BigDecimal rate) throws LoanCalculationException;
	
}
