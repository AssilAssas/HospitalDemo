package com.example.hospital.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration @EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager ()
    {
       InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(
               User.withUsername("user1").password(passwordEncoder.encode("1234")).roles("USER").build(),
               User.withUsername("user2").password(passwordEncoder.encode("4444")).roles("USER").build(),
               User.withUsername("admin").password(passwordEncoder.encode("0000 ")).roles("USER","ADMIN").build()
       );
       return inMemoryUserDetailsManager;

    }
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin();
      //  httpSecurity.authorizeHttpRequests().requestMatchers("/delete").hasRole("ADMIN");
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
     //
        //   httpSecurity.exceptionHandling().accessDeniedPage("/notAuthorized");
        return httpSecurity.build();




    }
}
