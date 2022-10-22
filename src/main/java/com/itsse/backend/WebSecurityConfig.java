package com.itsse.backend;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {@Override
	
	protected void configure(HttpSecurity http) throws Exception {
		//
		http.authorizeRequests()
		.mvcMatchers(HttpMethod.OPTIONS, "/**").permitAll();
		http.csrf().disable();
	}
}
