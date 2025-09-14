package com.tayatu.springSecurity.service;

import com.tayatu.springSecurity.model.User;
import com.tayatu.springSecurity.model.UserPrincipal;
import com.tayatu.springSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =  userRepo.findByUsername(username);

        if(user == null){
            System.out.println("user not found " + username);
            throw new UsernameNotFoundException("user not found " + username);
        }
        return new UserPrincipal(user);
    }
}
