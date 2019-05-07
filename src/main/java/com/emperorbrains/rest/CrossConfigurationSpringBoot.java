package com.emperorbrains.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;


@SuppressWarnings("deprecation")
@Configuration
public class CrossConfigurationSpringBoot extends RepositoryRestConfigurerAdapter{
  
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
     config.getCorsRegistry()
        .addMapping("/**")
        .allowedMethods("GET","POST")
        .allowedOrigins("http://localhost:1214")
        .allowedHeaders("origin")
        .exposedHeaders("custom-header1", "custom-header2");
   }
  
  @Bean
  WebsiteUserEventHandler authorEventHandler() {
      return new WebsiteUserEventHandler();
  }
}
