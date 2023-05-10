package com.app.security.type;

public enum Role {
    MEMBER, ADMIN;

    private static final String ROLE_PREFIX = "ROLE_";

    public String getSecurityRole(){
        return ROLE_PREFIX + name();
    }
}
