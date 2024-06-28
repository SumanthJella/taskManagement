package com.pesto.tech.taskManagement.service;

import com.pesto.tech.taskManagement.entity.User;
import com.pesto.tech.taskManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;

public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User theUser = userRepository.loadUserByUsername(username);
        UserDetails theUserDetails = org.springframework.security.core.userdetails.User.builder()
                .username(theUser.getUserName()).password(theUser.getPassword())
                .accountExpired(false).build();
        return theUserDetails;
    }
}
