//package com.example.innoventesProject.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  private static final String[] AUTH_WHITELIST =
//      {"/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**", "/actuator/**"
//            ,"/insert/data" };
//  private static final String[] EXTN_WHITELIST = {"/", "/favicon.ico", "/**/*.png", "/**/*.gif",
//      "/**/*.svg", "/**/*.jpg", "/**/*.html", "/**/*.css", "/**/*.js"};
//
//
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http.authorizeRequests()
//
//        .antMatchers()
//        .permitAll()
//
//        .antMatchers(AUTH_WHITELIST).permitAll()
//
//        .antMatchers(EXTN_WHITELIST).permitAll()
//
//        .antMatchers(HttpMethod.OPTIONS).permitAll()
//
//        .anyRequest().authenticated().and().httpBasic().and().csrf().disable();
//  }
//
//
//
//
//}
