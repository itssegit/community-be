package com.itsse.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;

import com.itsse.backend.security.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		//
		http.cors()
		.and()
		.csrf()
		    .disable()
		.httpBasic()
		    .disable()
		.sessionManagement()
		    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		    .antMatchers("/", "/api/user/**").permitAll()
		.anyRequest()
		    .authenticated();
		
		http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);
	}
}
