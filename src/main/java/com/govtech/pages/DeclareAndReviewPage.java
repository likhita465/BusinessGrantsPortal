package com.govtech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeclareAndReviewPage extends BasePage{

    private WebDriver driver;

    //FindBy locators
    @FindBy(xpath = "//li[@class='form-horizontal bgp-radio-group'][1]//label[@class='bgp-radio'][1]")
    WebElement selectOptionForQues1Locator;

    @FindBy(xpath = "//li[@class='form-horizontal bgp-radio-group'][2]//label[@class='bgp-radio'][1]")
    WebElement selectOptionForQues2Locator;

    @FindBy(xpath = "//li[@class='form-horizontal bgp-radio-group'][3]//label[@class='bgp-radio'][1]")
    WebElement selectOptionForQues3Locator;

    @FindBy(xpath = "//li[@class='form-horizontal bgp-radio-group'][4]//label[@class='bgp-radio'][1]")
    WebElement selectOptionForQues4Locator;

    @FindBy(xpath = "//li[@class='form-horizontal bgp-radio-group'][5]//label[@class='bgp-radio'][1]")
    WebElement selectOptionForQues5Locator;

    @FindBy(xpath = "//li[@class='form-horizontal bgp-radio-group'][6]//label[@class='bgp-radio'][1]")
    WebElement selectOptionForQues6Locator;

    @FindBy(xpath = "//li[@class='form-horizontal bgp-radio-group'][7]//label[@class='bgp-radio'][1]")
    WebElement selectOptionForQues7Locator;

    @FindBy(xpath = "//li[@class='form-horizontal bgp-radio-group'][8]//label[@class='bgp-radio'][1]")
    WebElement selectOptionForQues8Locator;

    @FindBy(id = "react-declaration-consent_acknowledgement_check")
    WebElement acknowledgeCheckBoxLocator;

    @FindBy(id= "review-btn")
    WebElement reviewButtonLocator;

    //Constructor
    public DeclareAndReviewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void selectNoOptionsForAllTheQuestions(){
        waitFor(1000);
        scrollTo(driver,selectOptionForQues1Locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='form-horizontal bgp-radio-group'][1]//label[@class='bgp-radio'][1]")));
        selectOptionForQues1Locator.click();
        selectOptionForQues2Locator.click();
        scrollTo(driver,selectOptionForQues3Locator);
        selectOptionForQues3Locator.click();
        selectOptionForQues4Locator.click();
        scrollTo(driver,selectOptionForQues5Locator);
        selectOptionForQues5Locator.click();
        selectOptionForQues6Locator.click();
        scrollTo(driver,selectOptionForQues7Locator);
        selectOptionForQues7Locator.click();
        selectOptionForQues8Locator.click();
    }

    public void selectAcknowledgeCheckBox(){
        scrollTo(driver,acknowledgeCheckBoxLocator);
        acknowledgeCheckBoxLocator.click();
    }

    public void clickReviewButton(){
        waitFor(1000);
        scrollTo(driver,reviewButtonLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("review-btn")));
        reviewButtonLocator.click();
    }
}
