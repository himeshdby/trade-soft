package com.exchange.api.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;

import static org.springframework.http.HttpMethod.GET;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigSecurity.class);


    @Override
    public void configure(final HttpSecurity http) throws Exception {

        http
		.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // session is created by approuter
		.and()
        .authorizeRequests()
        .antMatchers("/api/exchanges/**").hasAuthority("EditTechnicalNotificationTool")
        .antMatchers(GET, "/api/technicalnotification/**").hasAuthority("ViewTechnicalNotificationTool") 
        .anyRequest().denyAll()
        .and()
        	.oauth2ResourceServer()
	        .jwt()
	        .jwtAuthenticationConverter(getJwtAuthoritiesConverter());

        
    }


    Converter<Jwt, AbstractAuthenticationToken> getJwtAuthoritiesConverter() {
        TokenAuthenticationConverter converter = new TokenAuthenticationConverter(xsuaaServiceConfiguration);
        converter.setLocalScopeAsAuthorities(true); // not applicable in case of multiple xsuaa bindings!
        return converter;
    }
}