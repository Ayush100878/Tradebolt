package com.example.tradebolt.response;

public class AuthResponse {

    private String jwt;
    private  boolean status;
    private String message;
    private  boolean isTwoFactorAuthEnabled;
    private String session;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public boolean isTwoFactorAuthEnabled() {
        return isTwoFactorAuthEnabled;
    }

    public void setTwoFactorAuthEnabled(boolean twoFactorAuthEnabled) {
        isTwoFactorAuthEnabled = twoFactorAuthEnabled;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
