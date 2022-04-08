package com.clemen.Ejercicio.configuration;

import com.clemen.Ejercicio.entities.Edificio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDesafio {

    @Bean
    public Edificio edificio() {
        return new Edificio(10,10);
    }
}
