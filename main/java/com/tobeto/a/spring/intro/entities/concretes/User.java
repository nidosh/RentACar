package com.tobeto.a.spring.intro.entities.concretes;

import com.tobeto.a.spring.intro.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity implements UserDetails {
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @JoinTable(name = "roles",joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private List<Role> authorities;



    /*GETTER
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    @Override
    public String getPassword() {
        return null;
    }
    @Override
    public String getUsername() {
        return null;
    }*/



    //Kullanıcının aktif olup olmadığının kontrolünün yapıldığı pointler.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
