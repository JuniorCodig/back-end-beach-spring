package com.br.puc.beachtennis.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
@Data
public class GeneralParameters {

    public SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    public SimpleDateFormat monthFormat = new SimpleDateFormat("MM");

}
