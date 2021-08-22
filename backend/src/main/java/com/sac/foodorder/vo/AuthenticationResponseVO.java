package com.sac.foodorder.vo;

public class AuthenticationResponseVO {

    private final String jwt;

    public AuthenticationResponseVO(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
