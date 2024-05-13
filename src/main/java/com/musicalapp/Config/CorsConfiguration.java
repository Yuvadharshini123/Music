package com.musicalapp.Config;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
	
	  private static final String GET="GET";
	  private static final String POST="POST";  
	  private static final String DELETE="DELETE";
	  private static final String PUT="PUT";
	  
	
      public WebMvcConfigurer corsConfigurer() {
    	  return new WebMvcConfigurer() {
    		  
    		  @Override
    		  public void addCorsMappings(CorsRegistry registry) {
    			 
    			 registry.addMapping("/**")
    			 .allowedOrigins("http://localhost:4200")
    			  .allowedMethods("GET", "POST", "PUT", "DELETE")
    			  .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization")
    			  .allowCredentials(true);
    			  
    			  
    		  }
    	  };
      }
}
