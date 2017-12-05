package dev.attendancemanager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;

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
}
