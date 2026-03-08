package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @Autowired
    EmailService emailService;


    @KafkaListener(topics = {"save-user","delete-user"},groupId = "my-group-id")
    public void consumeMessage(String message) {
        System.out.println("Получено сообщение: " + message);
        String email = message.split(" ")[1];
        System.out.println(email);
        String operation = message.split(" ")[0];
        System.out.println(operation);
        if(operation.equals("save"))
            emailService.sendEmail(email, "AutoMessage", " Здравствуйте! Ваш аккаунт на сайте ваш сайт был успешно создан!");
        if(operation.equals("delete"))
            emailService.sendEmail(email, "AutoMessage", " Здравствуйте! Ваш аккаунт был удалён!");

    }
}
