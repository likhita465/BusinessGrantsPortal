package com.govtech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReviewYourApplicationPage extends BasePage {

    private WebDriver driver;

    //FindBy Locators
    @FindBy(xpath = "//div[contains(@class,'layoutStyles-children')]/div/div/div[1]//h3[text()='Review Your Application']")
    WebElement reviewYourApplicationHeaderMsgLocator;

    @FindBy(id = "react-declaration-info_truthfulness_check")
    WebElement declarationCheckBoxLocator;

    @FindBy(id = "submit-btn")
    WebElement submitButtonLocator;

    @FindBy(xpath = "//section[@class='card']//h3")
    WebElement successMsgLocator;

    @FindBy(xpath = "//div[@class='cols-sm-6'][1]//tr[1]//td[2]")
    WebElement refIdLocator;

    @FindBy(xpath = "//div[@class='cols-sm-6'][2]//tr[1]//td[2]//span[1]")
    WebElement agencyDetails;

    @FindBy(xpath = "//a[@class='back-title-container']//span[@class='back-text']")
    WebElement backToGrantActionsLocator;

    //constructor
    public ReviewYourApplicationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public String getTheReviewPageHeader(){
        waitFor(1000);
        //scrollTo(driver,reviewYourApplicationHeaderMsgLocator);
        //waitFor(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'layoutStyles-children')]/div/div/div[1]//h3[text()='Review Your Application']")));
        return reviewYourApplicationHeaderMsgLocator.getText();
    }

    public void clickDeclarationCheckBox(){
        waitFor(1000);
        scrollTo(driver,declarationCheckBoxLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-declaration-info_truthfulness_check")));
        declarationCheckBoxLocator.click();
    }

    public void clickSubmitButton(){
        submitButtonLocator.click();
    }

    public String getSuccessMsg(){
        waitFor(3000);
        return successMsgLocator.getText();
    }

    public String getReferenceId(){
        return refIdLocator.getText();
    }

    public String getAgencyDetails(){
        return agencyDetails.getText();
    }

    public void clickBackToGrantAction(){
        backToGrantActionsLocator.click();
    }
}
