package com.example.jsonservice.controller;

import com.example.jsonservice.model.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @PostMapping("/echo")
    public ResponseEntity<Message> echoMessage(@RequestBody Message input) {
        // Create a new Message with the input content and "I did it" on a new line
        String userInpuString = input.getContent();
        String statusCode = "200";

        if (userInpuString == null || userInpuString.trim().isEmpty()) {

            statusCode = "400";
            return ResponseEntity.badRequest().body(new Message("Please provide 'content' in the request.", statusCode));

        }
        String modifiedContent = input.getContent() + "\nI did it";
        return ResponseEntity.ok(new Message(modifiedContent,statusCode));
    }
}


