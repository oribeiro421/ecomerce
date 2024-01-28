package com.ecomerce.ecomerce.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EnviarEmailService enviarEmailService;

    @PostMapping
    public ResponseEntity<?> sendMail(@RequestBody Email email){
        return new ResponseEntity<>(enviarEmailService.enviar(email), HttpStatus.OK);
    }
}
