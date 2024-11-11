package com.wiley.realworldjava;

import com.wiley.realworldjava.service.MortgageCalculatorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  private final MortgageCalculatorService calculatorService;

  public App(MortgageCalculatorService calculatorService) {
    this.calculatorService = calculatorService;
  }

  public static void main(String[] args) {
    ApplicationContext context
       = new ClassPathXmlApplicationContext("applicationContext.xml");
    App app = context.getBean(App.class);

    double principal = 250_000;
    double annualInterestRate = 6.5;
    int termInYears = 30;
    app.calculate(principal, annualInterestRate, termInYears);
  }

  void calculate(double principal, double interest, int term) {
    double payment = calculatorService.payment(principal,interest, term);

    // display result to 2 decimal places and commas for thousands separators
    System.out.printf("Monthly Payment: $%,.2f%n", payment);
  }
}
