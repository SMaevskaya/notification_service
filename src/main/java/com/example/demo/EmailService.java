package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    public JavaMailSender emailSender;


    public void sendEmail(String toAddress, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("marinamarkovaqw@yandex.ru");
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        try {
            emailSender.send(simpleMailMessage);
            System.out.println("Успех");
        }
        catch(Exception e){
            System.err.println("Ошибка отправки: " + e.getMessage());
            e.printStackTrace();

        }
    }

}
