package com.ecomerce.ecomerce.email;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:env/mail.properties")
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(@NotNull Email email){
        var message = new SimpleMailMessage();
        message.setFrom("email@email.com");
        message.setTo(email.destinatarios());
        message.setSubject(email.assunto());
        message.setText(email.mensagem());
        mailSender.send(message);
    }
}
