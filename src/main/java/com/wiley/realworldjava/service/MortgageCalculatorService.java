package com.wiley.realworldjava.service;

public interface MortgageCalculatorService {
  double payment(double principal,
                 double annualInterestRate, int years);

  double payment(double principal, int termInYears);
}
