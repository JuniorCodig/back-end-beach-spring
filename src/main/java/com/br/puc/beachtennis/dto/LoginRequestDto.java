package com.br.puc.beachtennis.dto;

import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@Setter
public class LoginRequestDto {
    @NotBlank(message = "O campo 'username' não pode estar em branco.")
    @Email(message = "O campo 'username' deve ser um endereço de e-mail válido.")
    private String username;

    @NotBlank(message = "O campo 'password' não pode estar em branco.")
    @Size(min = 6, message = "O campo 'password' deve ter pelo menos 6 caracteres.")
    private String password;
}
