package com.pesto.tech.taskManagement.service;

import com.pesto.tech.taskManagement.entity.Role;
import com.pesto.tech.taskManagement.entity.User;
import com.pesto.tech.taskManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class UserService implements UserDetailsService {

    private UserRepository theUserRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.theUserRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User theUser = theUserRepository.loadUserByUsername(username);
        if (theUser == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(theUser.getRoles());

        UserDetails theUserDetails = org.springframework.security.core.userdetails.User.builder()
                .username(theUser.getUserName()).password(theUser.getPassword())
                .accountExpired(false).authorities(authorities).build();

        return theUserDetails;
    }

    private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.addAll(roles.stream().map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toList()));

        return authorities;
    }
}
