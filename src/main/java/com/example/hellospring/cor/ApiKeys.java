package com.example.hellospring.cor;

import com.example.hellospring.cor.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class ApiKeys {
    private static final Map<String, ApiKey> apiKeys = new HashMap<>();

    static {
        apiKeys.put("l", new ApiKey("l", OrganizationType.LICENCE));
        apiKeys.put("n", new ApiKey("n", OrganizationType.NOTARIES));
    }

    public static ApiKey get(String key) {
        ApiKey apiKey = apiKeys.get(key);
        if (apiKey == null)
            throw new ApiException(ResponseStatus.API_KEY_DID_NOT_MATCH);
        return apiKey;
    }

    public static boolean exists(String apiKey) {
        return apiKeys.containsKey(apiKey);
    }

    public static void checkApiKey(String apiKey) {
        if (!exists(apiKey))
            throw new ApiException(ResponseStatus.API_KEY_DID_NOT_MATCH);
    }

    @Data
    @AllArgsConstructor
    public static class ApiKey {
        private String apiKey;
        private OrganizationType organizationType;
    }
}
