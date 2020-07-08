package com.noida.authority.body_model;

public class TokenResponse {

    String access_token, token_type, error;
    long expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public String getError() {
        return error;
    }
}
