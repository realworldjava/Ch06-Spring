package com.wiley.realworldjava;

import com.wiley.realworldjava.service.MortgageCalculatorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {
  private final MortgageCalculatorService calculatorService;

  public App(MortgageCalculatorService calculatorService) {
    this.calculatorService = calculatorService;
  }

  public static void main(String[] args) {
    ApplicationContext context
       = new AnnotationConfigApplicationContext("com.wiley.realworldjava");
    App app = context.getBean(App.class);

//    double principal = 600_000;
    double principal = 250_000;
    int termInYears = 30;

    // now calculate the payment, using the default interest rate
       double payment = app.calculatorService.payment(principal, termInYears);
    // display result to 2 decimal places and commas for thousands separators
    System.out.printf("Monthly Payment: $%,.2f%n", payment);
  }
}
