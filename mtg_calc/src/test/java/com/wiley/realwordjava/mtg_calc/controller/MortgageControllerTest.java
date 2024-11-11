package com.wiley.realworldjava.mtg_calc.controller;

import com.wiley.realworldjava.mtg_calc.service.MortgageCalculatorService;
import com.wiley.realworldjava.mtg_calc.service.MortgageCalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MortgageControllerTest {

  @Autowired
  MockMvc mockMvc;
  @Mock
  MortgageCalculatorServiceImpl mortgageCalculator;
  @InjectMocks
  MortgageController mortgageController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testCalculateMonthlyPayment() throws Exception {
    when(mortgageCalculator.payment(anyDouble(), anyDouble(), anyInt())).thenCallRealMethod();

    mockMvc.perform(get("/mtg/payment?principal=100000&years=0&interest=6.7")).andExpect(status().isOk());
//    ResponseEntity<String> result = mortgageController.calculateMonthlyPayment(0d, 0, 0d);
//    Assertions.assertEquals(new ResponseEntity<String>("body", null, 0), result);
  }
}