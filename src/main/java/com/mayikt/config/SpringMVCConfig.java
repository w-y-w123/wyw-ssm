package com.mayikt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.mayikt.controller","com.mayikt.config"})
@EnableWebMvc
public class SpringMVCConfig {

}