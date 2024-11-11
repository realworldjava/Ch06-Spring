package com.wiley.realworldjava.mtg_calc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MtgCalcApplication {
  public static void main(String[] args) {
    SpringApplication.run(MtgCalcApplication.class, args);
    System.out.println("Hello, Mortgage Calculator");
  }
}
