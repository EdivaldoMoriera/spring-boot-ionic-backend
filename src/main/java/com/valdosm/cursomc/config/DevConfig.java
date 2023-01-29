package com.valdosm.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.valdosm.cursomc.service.DBservice;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Configuration
@Profile("dev")
public class DevConfig {
    @Autowired
    private DBservice dBservice;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        if(!"create" .equals(strategy)){
            return false;
        }
        dBservice.instantiateTestDatabase();

        return true;
    }

}
