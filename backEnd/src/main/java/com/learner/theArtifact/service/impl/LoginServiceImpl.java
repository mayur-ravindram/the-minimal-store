package com.learner.theArtifact.service.impl;

import com.learner.theArtifact.model.LoginRequest;
import com.learner.theArtifact.repository.LoginRepository;
import com.learner.theArtifact.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository repo;

    @Override
    public Optional<String> login(LoginRequest loginData) {
        LoginRequest password = repo.findByUsername(loginData.getUserName());

        return password.getPassword().equals(loginData.getPassword()) ? Optional.of("200 OK"): Optional.of("Invalid credentials");
    }
}
