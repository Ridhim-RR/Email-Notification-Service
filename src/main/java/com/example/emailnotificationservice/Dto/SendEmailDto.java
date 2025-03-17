package com.example.emailnotificationservice.Dto;

import lombok.Data;

@Data
public class SendEmailDto {
    private String to;
    private String subject;
    private String body;
    private String sendFrom;

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getSendFrom() {
        return sendFrom;
    }
}