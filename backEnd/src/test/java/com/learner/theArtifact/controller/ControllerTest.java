package com.learner.theArtifact.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest
public class ControllerTest {
    @LocalServerPort
    private int port = 8080;

    public void testController() {

    }
}
