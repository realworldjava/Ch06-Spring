package com.wiley.realworldjava.mtg_calc.controller;

import com.wiley.realworldjava.mtg_calc.service.MortgageCalculatorServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/mtg")
public class MortgageController {
  private MortgageCalculatorServiceImpl mortgageCalculator;

  public MortgageController(MortgageCalculatorServiceImpl mortgageCalculator) {
    this.mortgageCalculator = mortgageCalculator;
  }

  @GetMapping("/payment")
  public ResponseEntity<String> calculateMonthlyPayment(@RequestParam double principal,
                                                        @RequestParam int years, @RequestParam double interest) {
    double payment = mortgageCalculator.payment(principal, interest, years);
    String rval = String.format("Principal:%,.2f<br>Interest: %.2f<br>" +
       "Years: %d<br>Monthly Payment:%.2f", principal, interest, years, payment);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Request time", "Call for payment at " + LocalDateTime.now());
     return new ResponseEntity<>(rval, headers, HttpStatus.OK);
  }

  @GetMapping("/hello")
  public String hello() {
    return LocalDateTime.now() + ": Hello, World ";
  }
}
