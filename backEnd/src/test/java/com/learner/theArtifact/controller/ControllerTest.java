package com.learner.theArtifact.controller;

import com.learner.theArtifact.model.Product;
import com.learner.theArtifact.service.MongoProductService;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore("Test in progress")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MongoProductService mongoProductService;

    @Test
    public void testController() throws Exception {

        given(this.mongoProductService.list())
                .willReturn(Arrays.asList(new Product("","","",0.0,"","","")));

        this.mvc.perform(get("/mongo/list")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}

