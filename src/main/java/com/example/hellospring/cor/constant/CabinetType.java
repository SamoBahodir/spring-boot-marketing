package com.example.hellospring.cor.constant;

import lombok.Getter;

@Getter
public enum CabinetType {
    ADMIN_CABINET("admin_id", "for_testing", "taXD9rW2O7sT4gBUzJqmfISj");

    private final String client_id;
    private final String scope;
    private final String secret;

    CabinetType(String client_id, String scope, String secret) {
        this.client_id = client_id;
        this.scope = scope;
        this.secret = secret;
    }
}