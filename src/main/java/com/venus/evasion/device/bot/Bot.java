package com.venus.evasion.device.bot;

import com.venus.evasion.device.model.EdConfiguration;
import com.venus.evasion.device.model.EdField;
import com.venus.evasion.device.reader.ValuesReader;
import com.venus.evasion.device.util.StringFormatter;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class Bot {

    private final WebDriver driver;
    private final EdConfiguration configuration;
    private final ValuesReader valuesReader;

    @Bean
    public void initBot() {
        Map<String, Object> values = valuesReader.readExcel();
        driver.get(configuration.getApplicationUrl());

        for (EdField edField : configuration.getFields()) {
            if (edField.getType().equals("Select")) {
                WebElement selectElement = driver.findElement(By.xpath(edField.getXpath()));
                Select select = new Select(selectElement);
                select.selectByVisibleText(values.get(StringFormatter.format(edField.getName())).toString());
            } else if (edField.getType().equals("Text")) {
                driver.findElement(By.xpath(edField.getXpath())).sendKeys(values.get(StringFormatter.format(edField.getName())).toString());
            }
        }
    }

}
