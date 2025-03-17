package com.example.emailnotificationservice.Config;

import com.example.emailnotificationservice.Dto.SendEmailDto;
import com.example.emailnotificationservice.Service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SendEmailProducer {
    private ObjectMapper objectMapper;
    private EmailService emailService;



    public SendEmailProducer(ObjectMapper objectMapper, EmailService emailService) {
        this.objectMapper = objectMapper;
        this.emailService = emailService;
    }
 @KafkaListener(topics = "sendEmails", groupId = "email-consumers")
    public void handleMessage(String message) {
     SendEmailDto sendEmailDto = null;
     try {
         sendEmailDto = objectMapper.readValue(message, SendEmailDto.class);
         emailService.sendEmail(sendEmailDto);
     } catch (JsonMappingException e) {
         throw new RuntimeException(e);
     } catch (JsonProcessingException e) {
         System.out.println(e.getMessage() + " : Error while parsing json");
         throw new RuntimeException(e);
     }

     System.out.println(sendEmailDto);
    }
}
