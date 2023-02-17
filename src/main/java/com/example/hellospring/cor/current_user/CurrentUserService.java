package com.example.hellospring.cor.current_user;

import com.example.hellospring.cor.exception.ApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService {

    public DecodedDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        Gson gson = new Gson();
        System.out.println("json=" + gson.toJson(details));
        try {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(details.getDecodedDetails());
            System.out.println("json=" + json);
            return gson.fromJson(json, DecodedDetails.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException("Token not valid");
        }
    }
}