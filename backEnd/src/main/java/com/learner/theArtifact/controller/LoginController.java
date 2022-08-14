package com.learner.theArtifact.controller;

import com.learner.theArtifact.exception.InvalidUserException;
import com.learner.theArtifact.model.LoginRequest;
import com.learner.theArtifact.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/security")
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginData) {
        String response = loginService.login(loginData).get();
        if(response.contains("200")) {
            return ResponseEntity.ok("Validated");
        }
        throw new InvalidUserException("Invalid Credentials");
    }

}
