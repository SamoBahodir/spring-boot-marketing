package com.example.hellospring.config;

import com.example.hellospring.CustomAccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Value("${client_id}")
    private String clientId;

    @Value("${client_credential}")
    private String clientSecret;

    @Value("${check_authorization_url}")
    private String checkAuthUrl;

    @Value("${resources_id}")
    private String resourceId;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/open/_healthcheck/**").permitAll()
                .antMatchers("/v1/oauth/token", "/oauth/check_token", "/v3/api-docs", "/actuator/**").permitAll()
                .antMatchers("/v1/oauth/token/**").permitAll()
                .antMatchers("/v1/oauth/check_token/**").permitAll()

                .anyRequest()
                .authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.resourceId(resourceId).authenticationEntryPoint(new RestAuthenticationFailureHandler());
    }

    @Bean
    public RemoteTokenServices localTokenService() {
        final RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(checkAuthUrl);
        tokenService.setClientId(clientId);
        tokenService.setClientSecret(clientSecret);
        tokenService.setAccessTokenConverter(new CustomAccessToken());
        return tokenService;
    }

}