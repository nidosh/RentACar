package com.tobeto.a.spring.intro.controller;

import com.tobeto.a.spring.intro.services.abstracts.UserService;
import com.tobeto.a.spring.intro.services.dtos.user.requests.AddUserRequest;
import com.tobeto.a.spring.intro.services.dtos.user.requests.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
    private final UserService userService;

    @PostMapping
    public void register(@RequestBody AddUserRequest request){
        userService.register(request);
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }
}
