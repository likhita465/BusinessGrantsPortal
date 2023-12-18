package com.govtech.pages;

import com.govtecg.util.ConfigReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class BasePage {

    protected Properties prop;

    public BasePage () {
        prop = ConfigReader.initializeProperties();
    }

    protected void waitFor(int milliSec) {
        try {
            Thread.sleep(milliSec);
        } catch (Exception ex) {}
    }

    protected void waitFor(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected void scrollTo(WebDriver driver, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", webElement);
    }
}
