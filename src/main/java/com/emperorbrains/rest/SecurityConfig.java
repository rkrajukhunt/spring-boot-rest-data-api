package com.emperorbrains.rest;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter{ 
  
  private static final List<String> allowedOrigins = Arrays.asList("http://localhost:1214");
  private static final List<String> allowedMethods = Arrays.asList("GET", "POST", "HEAD", "OPTIONS",
                                                                   "PATCH");
  private static final List<String> exposedHeaders = Arrays.asList("Authorization", "Cache-Control",
                                                                   "Content-Type",
                                                                   "Access-Control-Allow-Origin",
                                                                   "Access-Control-Allow-Headers");
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http.cors();
  }
  
  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    log.info("\n inside cors configuration source which is automatically picked up by httpsecurity");
    final CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.setAllowedOrigins(allowedOrigins);
    corsConfig.setAllowedMethods(allowedMethods);
    corsConfig.addAllowedHeader("*");
    corsConfig.setAllowCredentials(true);
    corsConfig.setExposedHeaders(exposedHeaders);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);
    return source;
  }
}
