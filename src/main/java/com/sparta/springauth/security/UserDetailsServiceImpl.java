package com.sparta.springauth.security;

import com.sparta.springauth.entity.User;
import com.sparta.springauth.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("userDetailService");
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found " + username));

        System.out.println(user.getUsername());
        return new UserDetailsImpl(user);
    }
}