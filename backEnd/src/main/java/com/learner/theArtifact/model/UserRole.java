package com.learner.theArtifact.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class UserRole {
    private GrantedAuthority role;
}
