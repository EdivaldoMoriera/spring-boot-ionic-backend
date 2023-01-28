package com.valdosm.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.valdosm.cursomc.service.DBservice;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBservice dBservice;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dBservice.instantiateTestDatabase();

        return true;
    }

}
