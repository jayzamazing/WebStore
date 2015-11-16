package com.adrianjaylopez.webstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author Adrian J Lopez
 * @version 1.1
 * @since <pre>10/4/15</pre>
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private AuthenticationProvider blah;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.authenticationProvider(blah);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/admin/**").authenticated()
                .and()
                .httpBasic()
                .realmName("WebStore")
                .and()
                .csrf()
                .disable();
    }
}
