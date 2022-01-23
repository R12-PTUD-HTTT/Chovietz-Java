package com.chovietz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {

    private final String jwttoken;
    private String userRole;
    private String userId;
    
    public JwtResponse(String jwttoken, String userRole, String userId) {
        this.jwttoken = jwttoken;
        this.userRole = userRole;
        this.userId = userId;
    }

}