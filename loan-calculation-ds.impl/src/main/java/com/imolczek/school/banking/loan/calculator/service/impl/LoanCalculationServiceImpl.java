package com.imolczek.school.banking.loan.calculator.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.osgi.service.component.annotations.Component;

import com.imolczek.school.banking.loan.calculator.StandardLoanCalculator;
import com.imolczek.school.banking.loan.calculator.exceptions.LoanCalculationException;
import com.imolczek.school.banking.loan.calculator.exceptions.LoanSettingsException;
import com.imolczek.school.banking.loan.calculator.service.LoanCalculationService;
import com.imolczek.school.banking.loan.calculator.service.exceptions.LoanCalculationServiceException;
import com.imolczek.school.banking.loan.model.LoanCalculationResult;

/**
 * @author Fabian Bouché
 * An implementation for the loan calculation service
 */
@Component (
		immediate = true,
		service = LoanCalculationService.class
		)
public class LoanCalculationServiceImpl implements LoanCalculationService {

	@Override
	public LoanCalculationResult calculate(BigDecimal amount, BigDecimal installment, BigDecimal rate) throws LoanCalculationServiceException {
		StandardLoanCalculator calculator = new StandardLoanCalculator();
		calculator.setAnnualRate(rate);
		calculator.setLoanAmount(amount);
		calculator.setMonthlyInstallment(installment);
		calculator.setLoanStartDate(LocalDate.now());
		calculator.setFirstReimbursementDate(LocalDate.now().plusMonths(1));
		LoanCalculationResult result;
		try {
			result = calculator.calculateForFixedInstallment();
		} catch (LoanSettingsException e) {
			throw new LoanCalculationServiceException("Wrong settings for the loan calculation: " + e.getMessage());
		} catch (LoanCalculationException e) {
			throw new LoanCalculationServiceException("Unable to calculate loan result: " + e.getMessage());
		}
		return result;
	}

}
