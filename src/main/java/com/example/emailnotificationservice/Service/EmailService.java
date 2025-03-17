package com.example.emailnotificationservice.Service;

import com.example.emailnotificationservice.Dto.SendEmailDto;

public interface EmailService {
    public void sendEmail(SendEmailDto sendEmailDto);
}
