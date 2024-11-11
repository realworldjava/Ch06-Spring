package com.wiley.realworldjava.config;

import com.wiley.realworldjava.App;
import com.wiley.realworldjava.service.MortgageCalculatorService;
import com.wiley.realworldjava.service.MortgageCalculatorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  MortgageCalculatorService mortgageCalculatorService() {
    return new MortgageCalculatorServiceImpl();
  }
  @Bean
  App app(MortgageCalculatorService mortgageCalculatorService) {
    return new App(mortgageCalculatorService);
  }
}
