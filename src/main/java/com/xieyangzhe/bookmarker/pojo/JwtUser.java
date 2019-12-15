package com.xieyangzhe.bookmarker.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class JwtUser implements UserDetails {

    private Integer userId;
    private String email;
    private String password;
    private String nickname;

    private Collection<? extends GrantedAuthority> authorities;
    private boolean enabled;

    public JwtUser(Integer userId,
                   String email,
                   String password,
                   String nickname,
                   Collection<? extends GrantedAuthority> authorities,
                   boolean enabled) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    public JwtUser(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole().getRoleName()));
        this.enabled = user.isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

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
        return enabled;
    }
}
