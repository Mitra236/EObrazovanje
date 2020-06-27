package com.eObrazovanje.studentServices.DTO;

import com.eObrazovanje.studentServices.entity.AuthUser;

import java.io.Serializable;

@SuppressWarnings("unused")
public class AuthUserDTO implements Serializable {
    private int id;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuthUserDTO(AuthUser authUser) {
        this.id = authUser.getId();
        this.username = authUser.getUsername();
    }
}
