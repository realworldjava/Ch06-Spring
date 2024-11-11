package com.wiley.realworldjava.mtgcalc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MtgCalcApplication {
  private final static Logger logger = LoggerFactory.getLogger(MtgCalcApplication.class);
  public static void main(String[] args) {
    SpringApplication.run(MtgCalcApplication.class, args);
    logger.info("Hello, Mortgage Calculator");
  }
}
