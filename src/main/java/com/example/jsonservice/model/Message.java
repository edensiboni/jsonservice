package com.example.jsonservice.model;


public class Message {
    private String content;
    private String statusCode;

    public Message() {}

    public Message(String content, String statusCode) {
        this.content = content;
        this.statusCode = statusCode;
    }

    public String getContent() {
        return content;
    }

    public String getStatusCode() { 
        return statusCode;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
