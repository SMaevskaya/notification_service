package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

   private final EmailService emailService;
    @Autowired
    public EmailController(EmailService emailService){
        this.emailService=emailService;
    }

    @PostMapping()
    public ResponseEntity<?> sendEmail(@RequestBody Email email) {
        String address = email.getToAddress();
        try {
            emailService.sendEmail(email.getToAddress(), email.getSubject(), email.getText());
            return ResponseEntity.ok().body("Письмо отправлено "+address);
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка при отправке письма " +address);
        }

    }

}

