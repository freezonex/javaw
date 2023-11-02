package com.supos.app.vo;

import java.io.Serializable;

public class AuthAccessToken implements Serializable {
    private static final long serialVersionUID = 4229698091473283894L;
    private String accessToken;
    private String refreshToken;
    private Long expiresIn;
    private String companyCode;
    private String personCode;
    private String userType;
    private String username;

    public AuthAccessToken() {
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public Long getExpiresIn() {
        return this.expiresIn;
    }

    public String getCompanyCode() {
        return this.companyCode;
    }

    public String getPersonCode() {
        return this.personCode;
    }

    public String getUserType() {
        return this.userType;
    }

    public String getUsername() {
        return this.username;
    }
}