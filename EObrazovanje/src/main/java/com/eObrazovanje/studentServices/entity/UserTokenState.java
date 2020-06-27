package com.eObrazovanje.studentServices.entity;

@SuppressWarnings("unused")
public class UserTokenState {
    private String access_token;
    private Long expires_in;
    private int role;

    public UserTokenState() {
    }

    public UserTokenState(String access_token, long expires_in, int role) {
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.role = role;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
