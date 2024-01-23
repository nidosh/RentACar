package com.tobeto.a.spring.intro.services.concretes;

import com.tobeto.a.spring.intro.repositories.UserRepository;
import com.tobeto.a.spring.intro.services.abstracts.UserService;
import com.tobeto.a.spring.intro.services.dtos.user.requests.AddUserRequest;
import com.tobeto.a.spring.intro.services.dtos.user.requests.LoginRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




@Service
@AllArgsConstructor
@Data
public class UserManager implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @Override
    public void register(AddUserRequest addUserRequest) {
        /*User user = (User) User.builder()
                .username(addUserRequest.getUsername())
                .email(addUserRequest.getEmail())
                .authorities(addUserRequest.getRoles())
                .password(passwordEncoder.encode(addUserRequest.getPassword()))
                .build();
        userRepository.save(user);*/
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found!"));
    }

    @Override
    public String login(LoginRequest loginRequest) {

        return "";
    }
    
    }

