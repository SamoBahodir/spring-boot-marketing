package com.example.hellospring.service;

import com.example.hellospring.token.TokenResponseDto;
import com.example.hellospring.token_check.TokenCheckResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final RestTemplate restTemplate;

    public ResponseEntity<TokenCheckResponse> checkToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> request = new HttpEntity<>(headers);
//        return request;
        return restTemplate.exchange("http://localhost:8080/oauth/check_token?token=" + token, HttpMethod.GET, request, TokenCheckResponse.class);
    }

    public ResponseEntity<TokenResponseDto> getToken(String username, String password) {
        String credentials = "mobile_admin:7her1aml32";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Basic " + new String(Base64.encodeBase64(credentials.getBytes())));
        HttpEntity<String> request = new HttpEntity<>(headers);

        String access_token_url = "http://localhost:8080/oauth/token" +
                "?username=" + username +
                "&password=" + password +
                "&grant_type=password";
        System.out.println("access_token_url="+access_token_url);
        return restTemplate.exchange(access_token_url, HttpMethod.POST, request, TokenResponseDto.class);
    }

}
