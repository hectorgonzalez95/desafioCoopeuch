package com.hector.desafioCoopeuch;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAutoConfiguration(exclude = {XADataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {
        "com.hector.desafioCoopeuch.controllers",
        "com.hector.desafioCoopeuch.services",
        "com.hector.desafioCoopeuch.mappers",
        "com.hector.desafioCoopeuch.repositorio"})

public class DesafioCoopeuchConfiguration implements WebMvcConfigurer{
	
	

}
