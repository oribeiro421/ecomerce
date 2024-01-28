package com.ecomerce.ecomerce.email;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnviarEmailService {


    @Autowired
    private JavaMailSender javaMailSender;


    public String enviar(@NotNull Email email){
        var mensagem = new SimpleMailMessage();
        mensagem.setFrom(email.getRemetente());
        mensagem.setTo(email.getDestinatarios().toArray(new String[email.getDestinatarios().size()]));
        mensagem.setText(email.getMensagem());
        mensagem.setSubject(email.getAssunto());

        javaMailSender.send(mensagem);

        return "E-nmail enviado com sucesso!";
    }
}
