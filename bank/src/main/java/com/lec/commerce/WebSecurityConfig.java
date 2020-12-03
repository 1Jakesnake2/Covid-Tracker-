package com.lec.commerce;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable(); // Sensitive
	  }
}
