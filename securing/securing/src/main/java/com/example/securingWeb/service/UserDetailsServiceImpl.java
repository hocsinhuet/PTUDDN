package com.example.securingWeb.service;

import com.example.securingWeb.model.User;
import com.example.securingWeb.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public final
class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository = null;

    public UserDetailsServiceImpl() {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
