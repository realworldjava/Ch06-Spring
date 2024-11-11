package com.wiley.realworldjava.mtgcalc.service;

public interface MortgageCalculatorService {
  double payment(double principal,
                 double annualInterestRate, int years);
}
