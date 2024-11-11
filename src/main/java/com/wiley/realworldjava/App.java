package com.wiley.realworldjava;

import com.wiley.realworldjava.config.AppConfig;
import com.wiley.realworldjava.service.MortgageCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {
  @Autowired
  private MortgageCalculatorService calculatorService;

  public static void main(String[] args) {
    ApplicationContext context
       = new AnnotationConfigApplicationContext(AppConfig.class);
    App app = context.getBean(App.class);

    double principal = 250_000;
    double annualInterestRate = 6.5;
    int termInYears = 30;
    double payment = app.calculatorService.payment(principal, annualInterestRate, termInYears);

    // display result to 2 decimal places and commas for thousands separators
    System.out.printf("Monthly Payment: $%,.2f%n", payment);
  }
}
