package com.wiley.realworldjava.config;

import oracle.jdbc.pool.OracleDataSource;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Configuration
@PropertySource("classpath:application.properties")
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class AppConfig {
  @Autowired
  private Environment environment;

  @Value("${preferred.mortgage.holder}")
  private String preferredMortgageHolder;
  @Value("${country}")
  private String country;

  @Bean
  @Profile("dev")
  public DataSource devDatasource() {
    JdbcDataSource jdbcDataSource = new JdbcDataSource();
    System.out.println("Loading Dev datasource");
    // configure the dev datasource
    return jdbcDataSource;
  }

  @Bean
  @Profile("prod")
  public DataSource prodDatasource() throws SQLException {
    OracleDataSource oracleDataSource = new OracleDataSource();
    System.out.println("Loading Prod datasource");
    // configure the prod datasource
    return oracleDataSource;
  }


  @PostConstruct
  public void displayProfiles(){
    String[] activeProfiles = environment.getActiveProfiles();
    System.out.println("Profiles:" + Arrays.asList(activeProfiles));
    System.out.println("Preferred mortgage holder:" + preferredMortgageHolder);
    System.out.println("Company home:" + country);
  }
}
