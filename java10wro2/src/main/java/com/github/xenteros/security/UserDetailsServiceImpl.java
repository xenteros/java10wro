package com.github.xenteros.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

class UserDetailsServiceImpl implements UserDetailsService {

    private Map<String, String> users;

    public UserDetailsServiceImpl() {
        users = new HashMap<>();
        users.put("user", "password");
        users.put("admin", "secret");
        users.put("super-admin", "super-secret");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!users.containsKey(username)) {
            throw new UsernameNotFoundException("Username not found");
        }

        return new UserDetailsImpl(username, users.get(username));
    }
}
