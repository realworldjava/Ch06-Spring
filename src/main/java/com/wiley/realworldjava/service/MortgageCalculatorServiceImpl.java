package com.wiley.realworldjava.service;

public class MortgageCalculatorServiceImpl implements MortgageCalculatorService {

  @Override
  public double payment(double principal,
                        double annualInterestRate, int termInYears) {
    double monthlyInterestRate = annualInterestRate / 12 / 100;
    int numberOfPayments = termInYears * 12;

    // mortgage formula: P * R * [(1+R)^N] / [(1+R)^N - 1]
    return principal * (monthlyInterestRate
       * Math.pow(1 + monthlyInterestRate, numberOfPayments))
       / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
  }
}
