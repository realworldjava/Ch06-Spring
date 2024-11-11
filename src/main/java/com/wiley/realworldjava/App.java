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
// access the bean from its id specified in the applicationContext.xml
    App app = (App) context.getBean("app");
// alternatively, you can access it via its class type
//    App app = context.getBean(App.class);
    double principal = 250_000;
    double annualInterestRate = 6.5;
    int termInYears = 30;
    double payment = app.calculatorService.payment(principal,
       annualInterestRate, termInYears);
// display result to 2 decimal places and commas for thousands separators
    System.out.printf("Monthly Payment: $%,.2f%n", payment);
  }
}
