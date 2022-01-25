package com.chovietz.model;


public class JwtResponse {

    private final String jwttoken;
    private String userRole;
    private String userId;

    public JwtResponse(String jwttoken, String userRole, String userId) {
        this.jwttoken = jwttoken;
        this.userRole = userRole;
        this.userId = userId;
    }

    public String getToken() {
        return this.jwttoken;
    }
    public String getUserRole() {
    	return this.userRole;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}