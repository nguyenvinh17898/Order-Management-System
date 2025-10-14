package com.learning.cloud.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {

    private String name;

    private String email;

    private String username;

    private String password;

}
