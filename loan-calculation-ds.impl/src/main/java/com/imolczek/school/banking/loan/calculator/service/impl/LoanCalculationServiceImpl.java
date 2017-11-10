package com.imolczek.school.banking.loan.calculator.service.impl;

import java.math.BigDecimal;

import org.osgi.service.component.annotations.Component;

import com.imolczek.school.banking.loan.calculator.StandardLoanCalculator;
import com.imolczek.school.banking.loan.calculator.exceptions.LoanCalculationException;
import com.imolczek.school.banking.loan.calculator.exceptions.LoanSettingsException;
import com.imolczek.school.banking.loan.calculator.model.LoanCalculationResult;
import com.imolczek.school.banking.loan.calculator.service.LoanCalculationService;

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
	public LoanCalculationResult calculate(BigDecimal amount, BigDecimal installment, BigDecimal rate) throws LoanCalculationException {
		StandardLoanCalculator calculator = new StandardLoanCalculator();
		calculator.setAnnualRate(rate);
		calculator.setLoanAmount(amount);
		calculator.setMonthlyInstallment(installment);
		LoanCalculationResult result;
		try {
			result = calculator.calculateForFixedInstallment();
		} catch (LoanSettingsException e) {
			throw new LoanCalculationException("Wrong settings for the loan calculation: " + e.getMessage());
		} catch (LoanCalculationException e) {
			throw new LoanCalculationException("Unable to calculate loan result: " + e.getMessage());
		}
		return result;
	}

}
