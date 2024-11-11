package com.wiley.realworldjava.mtgcalc.controller;

import com.wiley.realworldjava.mtgcalc.MtgCalcApplication;
import com.wiley.realworldjava.mtgcalc.domain.Mortgage;
import com.wiley.realworldjava.mtgcalc.domain.Response;
import com.wiley.realworldjava.mtgcalc.service.MortgageCalculatorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/mtg")
public class MortgageController {
  private final MortgageCalculatorServiceImpl mortgageCalculator;
  private final Logger logger = LoggerFactory.getLogger(MtgCalcApplication.class);


  public MortgageController(MortgageCalculatorServiceImpl mortgageCalculator) {
    this.mortgageCalculator = mortgageCalculator;
  }

  @PostMapping("/payment")
  public ResponseEntity<Response> calculateMonthlyPayment(@RequestBody List<Mortgage> mortgages) {
    logger.info("Called payment POST endpoint " + mortgages);
    for(Mortgage mortgage:mortgages) {
      double principal = mortgage.getPrincipal();
      double rate = mortgage.getInterest();
      int years = mortgage.getYears();
      double payment = mortgageCalculator.payment(principal, rate, years);
      mortgage.setPayment(payment);
    }
    HttpHeaders headers = new HttpHeaders();
    headers.add("Request time", "Call for payment at " + LocalDateTime.now());
    return new ResponseEntity<>(new Response(mortgages, LocalDateTime.now()), headers, HttpStatus.OK);
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
