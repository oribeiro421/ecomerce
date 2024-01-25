package com.ecomerce.ecomerce.view.controller;

import com.ecomerce.ecomerce.dto.AuthenticationDTO;
import com.ecomerce.ecomerce.dto.RegisterDTO;
import com.ecomerce.ecomerce.model.user.Usuario;
import com.ecomerce.ecomerce.repository.UserRepository;
import org.apache.catalina.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid @NotNull AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data){
        if (this.userRepository.findByLogin(data.login()) != null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario newUser = new Usuario(data.nome(), data.login(), encryptedPassword, data.role());

        this.userRepository.save(newUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
