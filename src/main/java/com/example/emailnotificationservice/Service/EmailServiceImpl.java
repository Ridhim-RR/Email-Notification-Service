package com.example.emailnotificationservice.Service;

import com.example.emailnotificationservice.Dto.SendEmailDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.host}")
    private String smtpHost;

    @Value("${spring.mail.port}")
    private int smtpPort;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;
    @Override
    public void sendEmail(SendEmailDto sendEmailDto) {
        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendEmailDto.getTo()));
            message.setSubject(sendEmailDto.getSubject());
            message.setText(sendEmailDto.getBody());
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (Exception e) {
            System.out.println(e.getMessage() + " : Exception");
            e.printStackTrace();
            throw new RuntimeException("Failed to send email", e);
        }
    }
    }

