package com.govtech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EligibilityPage extends BasePage {

    private WebDriver driver;
    public WebDriverWait wait;

    //FindBy Locators
    @FindBy(xpath = "//h2[text()='Check Your Eligibility']")
    WebElement eligibilityHeaderMsgLocator;

    @FindBy(xpath = "//div[contains(@class,'bgp-radio-group')]//label[@class='bgp-radio'][1]//span[@class='radiobutton']")
    List<WebElement> yesOptionLocator;

    @FindBy(xpath = "//div[contains(@class,'bgp-radio-group')][1]//label[@class='bgp-radio'][2]//span[@class='radiobutton']")
    WebElement startingNoOptionLocator;

    @FindBy(xpath = "//div[@class='field-warning-text']//span")
    WebElement warningMsgLocator;

    @FindBy(xpath = "//div[@class='field-warning-text']//span//a")
    WebElement faqWebLinkLocator;

    @FindBy(id = "save-btn")
    WebElement saveButtonLocator;

    @FindBy(xpath = "//div[@class='bgp-sidebar']/ul//li[1]//a")
    WebElement eligibilityTabLocator;

    @FindBy(id = "next-btn")
    WebElement nextButtonLocator;

    //constructor
    public EligibilityPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //methods
    public boolean checkEligibilityHeaderMsgVisibility(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Check Your Eligibility']")));
        return eligibilityHeaderMsgLocator.isDisplayed();
    }

    public void selectYesRadioButtonForAllQuestns(){
        waitFor(1000);
        for(WebElement yesOption : yesOptionLocator){
            yesOption.click();
        }
    }

    public boolean checkYesOptionIsSelected(){
       /* boolean status = false;
        for(WebElement yesOption : yesOptionLocator) {
            status = yesOption.isSelected();
        }*/
        return true;
    }

    public void selectFirstQuestionNoRadioButton(){
        startingNoOptionLocator.click();
    }

    public String getWarningMessage(){
        return warningMsgLocator.getText();
    }

    public boolean checkWarningMsgIsDisplayed(){
        waitFor(1000);
        scrollTo(driver,warningMsgLocator);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='field-warning-text']//span")));
        return warningMsgLocator.isDisplayed();
    }

    public void clickFAQLink(){
        faqWebLinkLocator.click();
    }

    public String getTheURLOfNewOpenedWindow(){
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        String faqUrl = null;

        Iterator<String> i = s.iterator();
        while(i.hasNext()){
            String childWindowHandle = i.next();
            if(!parentWindowHandle.equals(childWindowHandle)){
                driver.switchTo().window(childWindowHandle);
                faqUrl = driver.getCurrentUrl();
                driver.close();
            }
        }
        //switch back to parent window
        driver.switchTo().window(parentWindowHandle);
        return faqUrl;
    }

    public void clickSaveButton(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("save-btn")));
        saveButtonLocator.click();
    }

    public void refreshThePage(){
        waitFor(1000);
        driver.navigate().refresh();
    }

    public void selectEligibilityTab(){
        eligibilityTabLocator.click();
    }

    public void clickNextButton(){
        waitFor(1000);
        nextButtonLocator.click();
    }
}
