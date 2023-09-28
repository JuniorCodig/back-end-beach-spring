package com.br.puc.beachtennis.ultil;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;
@Component
public class ValidationUtils {

    public static List<String> getValidationErrors(BindingResult bindingResult) {
        List<String> errors = new ArrayList<>();

        // Iterar pelos erros de campo
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String fieldName = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            errors.add("Campo '" + fieldName + "': " + errorMessage);
        }

        // Iterar pelos erros globais
        for (ObjectError objectError : bindingResult.getGlobalErrors()) {
            String errorMessage = objectError.getDefaultMessage();
            errors.add("Erro global: " + errorMessage);
        }

        return errors;
    }
}
