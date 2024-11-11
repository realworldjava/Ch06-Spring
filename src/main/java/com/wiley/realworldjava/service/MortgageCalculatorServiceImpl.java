package com.wiley.realworldjava.service;

import com.wiley.realworldjava.exception.MortgageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MortgageCalculatorServiceImpl implements MortgageCalculatorService {

  @Value("${mortgage.maxLoanAmount}")
  private int maximumLoanAmount;

  @Value("${default.interestRate}")
  private double defaultInterestRate;

  @Override
  public double payment(double principal, int termInYears) {
    return payment(principal, defaultInterestRate, termInYears);
  }
  @Override
  public double payment(double principal,
                        double annualInterestRate, int termInYears) {
    if(principal > maximumLoanAmount) {
      throw new MortgageException(String.format("Principal: $%,.2f exceeds maximum of $%,.0f", principal, (double)maximumLoanAmount));
    }
    double monthlyInterestRate = annualInterestRate / 12 / 100;
    int numberOfPayments = termInYears * 12;

    // mortgage formula: P * R * [(1+R)^N] / [(1+R)^N - 1]
    return principal * (monthlyInterestRate
       * Math.pow(1 + monthlyInterestRate, numberOfPayments))
       / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
  }
}
