package com.br.puc.beachtennis.controller;

import com.br.puc.beachtennis.dto.LoginRequestDto;
import com.br.puc.beachtennis.model.User;
import com.br.puc.beachtennis.service.UserService;
import com.br.puc.beachtennis.service.UserServiceImpl;
import com.br.puc.beachtennis.ultil.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.List;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    protected ValidationUtils validationUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDto loginRequestDto, BindingResult bindingResult) {
        System.out.println("LOGANDO");
        if (bindingResult.hasErrors()) {
            List<String> validationErrors = ValidationUtils.getValidationErrors(bindingResult);
            return ResponseEntity.badRequest().body(validationErrors);
        }

        // Lógica de autenticação aqui

        if (userServiceImpl.validarCredenciais(loginRequestDto.getUsername(), loginRequestDto.getPassword())) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
        }
    }

    // Criar usuário
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User userDTO) {
        System.out.println("BATI NO CREATEEEE");
        User user = userServiceImpl.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);

    }
}
