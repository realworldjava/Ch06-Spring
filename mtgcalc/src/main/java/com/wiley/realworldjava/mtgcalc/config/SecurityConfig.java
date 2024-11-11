package com.wiley.realworldjava.mtgcalc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http)
     throws Exception {
    http
       .csrf(csrf -> csrf
          .ignoringRequestMatchers(new AntPathRequestMatcher("/mtg/payment",
             HttpMethod.POST.name()))
       )
       .authorizeHttpRequests((authorize) -> authorize
          .requestMatchers(new AntPathRequestMatcher("/mtg/payment",
             HttpMethod.POST.name())).hasRole("USER")
          .requestMatchers(new AntPathRequestMatcher("/mtg/payment",
             HttpMethod.GET.name())).hasRole("USER")
          .requestMatchers(new AntPathRequestMatcher("/actuator/**",
             HttpMethod.GET.name())).hasRole("USER")
          .anyRequest().authenticated()
       )
       // use basic authentication
       .httpBasic(Customizer.withDefaults());
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    PasswordEncoder encoder =
       PasswordEncoderFactories.createDelegatingPasswordEncoder();
    UserDetails user = User.builder()
       .username("user")
       .password(encoder.encode("password"))
       .roles("USER")
       .build();
    UserDetails admin = User.builder()
       .username("admin")
       .password(encoder.encode("admin"))
       .roles("ADMIN")
       .build();
    return new InMemoryUserDetailsManager(user);
  }
}
