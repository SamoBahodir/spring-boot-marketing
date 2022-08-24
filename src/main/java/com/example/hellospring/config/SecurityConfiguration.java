package com.example.hellospring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfiguration(@Lazy UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        log.trace("trace");
//        auth
//                .userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//                .inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("user123")).roles("USER")
//                .and()
//                .withUser("login").password(passwordEncoder().encode("login123")).roles("LOGIN");


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/v1/user/register").permitAll()
                .antMatchers(HttpMethod.POST, "/api/token/login").permitAll()
//                .antMatchers("/api/hodim1/**").hasRole("LOGIN")
//                .antMatchers("/api/hodim1/*").hasAnyRole("USER", "LOGIN")
//                .antMatchers("/api/employee/all").permitAll()
                .anyRequest().authenticated();

    }


}
