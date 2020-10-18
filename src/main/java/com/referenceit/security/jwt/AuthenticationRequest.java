package com.referenceit.security.jwt;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String login;
    private String password;
}
