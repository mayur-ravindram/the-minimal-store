package com.learner.theArtifact.service;

import com.learner.theArtifact.model.LoginRequest;

import java.util.Optional;

public interface LoginService {

    Optional<String> login(LoginRequest loginData);

}
