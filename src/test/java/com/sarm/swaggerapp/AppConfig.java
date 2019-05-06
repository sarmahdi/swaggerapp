package com.sarm.swaggerapp;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.sarm", "com.sarm.swaggerapp" , "io.swagger.configuration"})
public class AppConfig {
}
