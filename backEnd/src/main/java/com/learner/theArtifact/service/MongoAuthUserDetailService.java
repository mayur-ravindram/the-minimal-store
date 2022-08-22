package com.learner.theArtifact.service;

import com.learner.theArtifact.model.User;
import com.learner.theArtifact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MongoAuthUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(userName);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        if(user.isEmpty()) {
            throw new UsernameNotFoundException("error");
        }

        return User.builder().username(user.get().getUsername()).password(user.get().getPassword()).userRoles(grantedAuthorities).build();
    }

}