package com.ecomerce.ecomerce.email;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:env/mail.properties")
public class EmailConfig {

    @Autowired
    private Environment env;

    @Bean
    public JavaMailSender mailSender(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(env.getProperty("mail.smtp.host"));
        Integer port = env.getProperty("mail.smtp.port", Integer.class);
        if (port != null) {
            mailSender.setPort(port);
        }
        mailSender.setUsername(env.getProperty("mail.smtp.username"));
        mailSender.setUsername(env.getProperty("mail.smtp.password"));

        Properties props = mailSender.getJavaMailProperties();

        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }



}
