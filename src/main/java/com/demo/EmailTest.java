package com.demo;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

public class EmailTest {
    public static void main(String[] args) throws EmailException {
        Email email = new Email() {
            @Override
            public Email setMsg(String msg){
                return null;
            }
        };
        email.setHostName("smtp.example.com");
        email.setSmtpPort(-1);
        email.addTo("test@example.com");
        email.setFrom("sender@example.com");
        email.setSubject("Test");
        email.setMsg("Hello World");
        email.send();
    }
}