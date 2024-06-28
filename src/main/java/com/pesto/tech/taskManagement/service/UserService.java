package com.pesto.tech.taskManagement.service;

import com.pesto.tech.taskManagement.entity.User;
import com.pesto.tech.taskManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    private UserRepository theUserRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.theUserRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User theUser = theUserRepository.loadUserByUsername(username);
        UserDetails theUserDetails = org.springframework.security.core.userdetails.User.builder()
                .username(theUser.getUserName()).password(theUser.getPassword())
                .accountExpired(false).build();
        return theUserDetails;
    }
}
