package com.chenlin.organization.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author Chen Lin
 * @date 2019-10-11
 */

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	@Override
	public void configure (HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated();
	}
}
