package com.example.hellospring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.trace("trace");
        auth
                .inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("user123")).roles("USER")
                .and()
                .withUser("login").password(passwordEncoder().encode("login123")).roles("LOGIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/hodim").permitAll()
                .antMatchers(HttpMethod.POST,"/register").permitAll()
                .antMatchers("/api/hodim1/**").hasRole("LOGIN")
                .antMatchers("/api/hodim1/*").hasAnyRole("USER", "LOGIN")
                .antMatchers("/api/employee/all").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
