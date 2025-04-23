package com.example.jsonservice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {

    @PostMapping("/echo")
    public Message echoMessage(@RequestBody Message input) {
        // Create a new Message with the input content and "I did it" on a new line
        String modifiedContent = input.getContent() + "\nI did it";
        return new Message(modifiedContent);
    }
}

class Message {
    private String content;

    public Message() {}

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
