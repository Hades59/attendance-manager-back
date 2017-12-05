package dev.attendancemanager.configuration;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dev.attendancemanager.security.SHA1Encoder;

@Configuration
public class ServiceConfiguration {

    @Bean
    @Primary
    public ObjectMapper mapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(
            com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
            false
        );
        return objectMapper;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    		return new SHA1Encoder();
    }
/*
    @Bean
    public WebMvcConfigurer corsConfigurer() {
	    	return new WebMvcConfigurerAdapter() {
	    		@Override
	    		public void addCorsMappings(CorsRegistry registry) {
	    			registry.addMapping("/**")
		    			.allowedOrigins("*")
		    			.allowedMethods("POST", "GET",  "PUT", "DELETE")
		    			.allowCredentials(true);
	    		}
	    	};
    }
    */
}
