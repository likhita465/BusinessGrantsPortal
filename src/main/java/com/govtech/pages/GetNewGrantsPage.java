package com.govtech.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GetNewGrantsPage extends BasePage {

    private WebDriver driver;

    //FindBy Locators
    @FindBy(xpath = "//div[@class='sectorGrid']//div[@class='items-container'][1]//div[@class='col-sm-new'][4]//div[@class='item']")
    WebElement selectedSectorOptionLocator;

    @FindBy(xpath = "//div[@class='items-container']//div[@class='col-sm-12'][1]//div[@class='item']")
    WebElement selectedDevelopmentAreaOptionLocator;

    @FindBy(xpath = "//div[@class='sectorGrid']//div[@class='col-sm-12'][1]")
    WebElement selectedFunctionalAreaOptionLocator;

    @FindBy(xpath = "//button[@id='go-to-grant']")
    WebElement applyButtonLocator;

    @FindBy(xpath = "//div[contains(@class,'layoutStyles-children-wrapper')]//div//h2")
    WebElement grantActionsHeaderLocator;

    @FindBy(xpath = "//button[@id='keyPage-form-button']")
        WebElement proceedButtonLocator;

    @FindBy(xpath = "//div[contains(@class,'layoutStyles-children-wrapper')]//div[2]//h2")
    WebElement eligibilityHeaderLocator;

    //constructor
    public GetNewGrantsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void selectRequiredGrantsOptions() {
       // waitFor(DriverFactory.getDriver());
        waitFor(1000);
        scrollTo(driver,selectedSectorOptionLocator);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(selectedSectorOptionLocator));
        selectedSectorOptionLocator.click();
        selectedDevelopmentAreaOptionLocator.click();
        selectedFunctionalAreaOptionLocator.click();
    }

    public void clickApplyButton(){
        waitFor(1000);
        //waitFor(DriverFactory.getDriver());
        applyButtonLocator.click();
    }
    public String getGrantActionsHeaderMsg(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'layoutStyles-children-wrapper')]//div//h2")));
        return grantActionsHeaderLocator.getText();
    }

    public void clickProceedButton(){
        waitFor(2000);
        scrollTo(driver,proceedButtonLocator);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(proceedButtonLocator));
        proceedButtonLocator.click();
    }

    public String getEligibilityHeaderMsg(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(eligibilityHeaderLocator));
        return eligibilityHeaderLocator.getText();
    }
}
