package com.stssecuritycrud.configuration;

import com.stssecuritycrud.entity.User;
import com.stssecuritycrud.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Optional<User> optionalUsers = userRepo.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers.map(CustomUserDetails::new).get();
    }
}
