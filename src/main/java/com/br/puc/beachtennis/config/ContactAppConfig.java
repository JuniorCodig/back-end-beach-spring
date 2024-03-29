package com.br.puc.beachtennis.config;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class ContactAppConfig {

    private static final String dateFormat = "dd/MM/yyyy";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            System.out.println("--- Configurado Data ---");
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
        };

    }

}