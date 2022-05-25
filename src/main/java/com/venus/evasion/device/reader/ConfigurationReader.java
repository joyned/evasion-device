package com.venus.evasion.device.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.venus.evasion.device.model.EdConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class ConfigurationReader {

    @Bean
    public EdConfiguration readConfiguration() {
        try {
            return new ObjectMapper().readValue(new ClassPathResource("config.json").getFile(), EdConfiguration.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
