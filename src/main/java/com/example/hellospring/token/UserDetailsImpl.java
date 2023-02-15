package com.example.hellospring.token;

import com.example.hellospring.users.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private final User user;
    private final Long userId;
    private final Collection<GrantedAuthority> permissions;

    public UserDetailsImpl(User user, Collection<GrantedAuthority> permissions) {
        this.user = user;
        this.userId = user.getId();
        this.permissions = permissions;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return permissions;
    }

    public Set<String> getAuthorityList() {
        return permissions.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return "$2a$10$L1VuKxXF.3gFmVpYJerymOFTYKKoytABUeWYMNDFpDQWabZ58oHYi";
    }

    @Override
    public String getUsername() {
        return user.getId().toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getDeletedAt() == null;
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getDeletedAt() == null;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getDeletedAt() == null;
    }

    @Override
    public boolean isEnabled() {
        return user.getDeletedAt() == null;
    }

    public Long getUserId() {
        return userId;
    }

    public User getUser() {
        return user;
    }

}