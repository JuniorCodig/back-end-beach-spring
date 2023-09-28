package com.br.puc.beachtennis.service;

import com.br.puc.beachtennis.model.User;
import com.br.puc.beachtennis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean validarCredenciais(String email, String password) {
        // Deve ser implementado criptografia de senha na função e guardar no banco

        User user = userRepository.findByEmail(email);
        if (user == null) return false;

        // Verifica se a senha corresponde
        return Objects.equals(password, user.getPassword());
    }

    public User createUser(User user) {
        System.out.println("createUser");
        return userRepository.save(user);
    }
}
