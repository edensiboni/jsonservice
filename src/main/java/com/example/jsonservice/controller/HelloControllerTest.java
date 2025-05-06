package com.example.jsonservice.controller;

import com.example.jsonservice.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(HelloController.class)  // This annotation loads only the HelloController for testing
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;  // Inject MockMvc to simulate HTTP requests

    @Test
    public void testEchoMessage() throws Exception {
        // Test valid input
        mockMvc.perform(post("/api/echo")
                        .contentType("application/json")
                        .content("{\"content\":\"Hello, world!\"}"))
                .andExpect(status().isOk())  // Assert the HTTP status is 200 OK
                .andExpect(jsonPath("$.content").value("Hello, world!\nI did it"))  // Assert response content
                .andExpect(jsonPath("$.statusCode").value("200"));  // Assert statusCode is 200

        // Test invalid input (empty content)
        mockMvc.perform(post("/api/echo")
                        .contentType("application/json")
                        .content("{\"content\":\"\"}"))
                .andExpect(status().isBadRequest())  // Assert the HTTP status is 400
                .andExpect(jsonPath("$.content").value("Please provide 'content' in the request."));  // Assert response content
    }
}
