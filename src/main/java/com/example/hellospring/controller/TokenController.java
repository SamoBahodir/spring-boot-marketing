package com.example.hellospring.controller;

import com.example.hellospring.service.TokenService;
import com.example.hellospring.token.TokenRequest;
import com.example.hellospring.token.TokenResponseDto;
import com.example.hellospring.token_check.TokenCheckPayload;
import com.example.hellospring.token_check.TokenCheckResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by Turayev Bahodir on 06.02.2023.
 */
@Slf4j
@RestController
@RequestMapping("/v1/oauth/token")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TokenController {

    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<TokenResponseDto> accessTokenDtoResponseEntity(
            @RequestBody  TokenRequest tokenRequest
    ) {
        Gson gson = new Gson();
        log.info("token request: {}", gson.toJson(tokenRequest));
        ResponseEntity<TokenResponseDto> response = tokenService.getToken(tokenRequest.getUsername(), tokenRequest.getPassword());
        System.out.println("response="+gson.toJson(response));
        return response;
    }

    @PostMapping(value = "/check_token", produces = "application/json")
    public ResponseEntity<TokenCheckResponse> checkToken(
            @RequestBody TokenCheckPayload payload
    ) {
        return tokenService.checkToken(payload.getToken());
//    }
//    public Page<IndividualAudit> list(PageableRequest pageable, Long registerId, String lang) {
//        pageable.setSearch(new ArrayList<>());
//        pageable.getSearch().add(new SearchCriteria("registerId", "=", registerId.toString()));
//        return individualAuditRepository
//                .findAll(new SearchSpecification<>(pageable.getSearch()), PageableRequestUtil.toPageable(pageable))
//                .map(individualAudit -> {
//                    var pin = individualAudit.getAfter().getPin();
//                    var response = applicationFeignClient.getPin(pin);
//                    for (IndividualAuditMinIntegration integration : response) {
//                        individualAudit.setId(integration.getId());
//                        individualAudit.setCreatedAt(integration.getCreatedAt());
//                        individualAudit.setRegisterId(integration.getRegisterId());
//                        String reason=String.valueOf(integration.getApplication());
//                        individualAudit.setReason(reason);
//                    }
//                    return individualAudit;
//                });
    }

}