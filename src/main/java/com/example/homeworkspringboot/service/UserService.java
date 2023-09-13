package com.example.homeworkspringboot.service;

import com.example.homeworkspringboot.dto.User;
import com.example.homeworkspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User a = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(a.getUsername(), a.getPassword(), Collections.emptyList());
    }
}
