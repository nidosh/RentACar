package com.tobeto.a.spring.intro.entities.concretes;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    MODERATOR,
    CUSTOMER;



    @Override
    public String getAuthority() {
        return name();
    }
}
