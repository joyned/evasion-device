package com.venus.evasion.device.config;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class BotConfiguration {

    BotConfiguration() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @Bean
    public WebDriver chromeDriver() {
        try {
            return new ChromeDriver();
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return null;
    }

}
