package com.learning.cloud.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {

    public UserResponse(long id, String name, String email, String username) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
    }

    private long id;

    private String name;

    private String email;

    private String username;

}
