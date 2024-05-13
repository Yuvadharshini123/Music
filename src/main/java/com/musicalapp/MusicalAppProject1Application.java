package com.musicalapp;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableConfigurationProperties
public class MusicalAppProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(MusicalAppProject1Application.class, args);
	}

}
