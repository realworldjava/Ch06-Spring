package com.wiley.realworldjava.mtg_calc.service;

import org.springframework.stereotype.Service;

public interface MortgageCalculatorService {
  double payment(double principal,
                 double annualInterestRate, int years);
}
