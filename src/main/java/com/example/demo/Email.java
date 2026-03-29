package com.example.demo;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;


@Data

public class Email {
    private String toAddress;
    private String subject;
    private String text;


    @Autowired
    public Email(String toAddress, String subject, String text) {
        this.toAddress = toAddress;
        this.subject = subject;
        this.text = text;

    }

    public Email(){}

    public String getToAddress(){
        return toAddress;
    }

    public String getSubject(){
        return subject;
    }

    public String getText(){
        return text;
    }
}
