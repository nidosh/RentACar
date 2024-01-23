package com.tobeto.a.spring.intro.services.abstracts;

import com.tobeto.a.spring.intro.services.dtos.user.requests.AddUserRequest;
import com.tobeto.a.spring.intro.services.dtos.user.requests.LoginRequest;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
    void register(AddUserRequest addUserRequest);
    String login(LoginRequest loginRequest);
}
