package com.govtech.pages;

import com.govtech.factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyGrantsHomePage extends BasePage{

    private WebDriver driver;
    public WebDriverWait wait;

    //FindBy Locators
    @FindBy(xpath = "//div//h2[text()='my Grants']")
    WebElement myGrantsHeaderMsgLocator;

    @FindBy(xpath = "//div[@id='grants']/div[2]//h4[text()='Get new grant']")
    WebElement newGrantLocator;

    @FindBy(xpath = "//div[@id='grants']//div[3]//section[@class='dashboard-tab-container']//li[3]//a")
    WebElement processingTabLocator;

    @FindBy(xpath = "//table[@id='db-apps-processing']//tbody//tr[1]//td[1]")
    WebElement myGrantsRefIdLocator;

    @FindBy(xpath = "//a[@class='back-title-container']//span[@class='back-text']")
    WebElement backToMyGrantsLocator;


    //constructor
    public MyGrantsHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //methods
    public String getMyGrantsHeaderMsg(){
        //waitFor(DriverFactory.getDriver());
        waitFor(5000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//h2[text()='my Grants']")));
        return myGrantsHeaderMsgLocator.getText();
    }

    public void selectGetNewGrantOption(){
       newGrantLocator.click();
    }

    public String getTheReferenceId(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grants']//div[3]//section[@class='dashboard-tab-container']//li[3]//a")));
        processingTabLocator.click();
        scrollTo(driver,myGrantsRefIdLocator);
        waitFor(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='db-apps-processing']//tbody//tr[1]//td[1]")));
        return myGrantsRefIdLocator.getText();
    }

    public void clickBackToMyGrants(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='back-title-container']//span[@class='back-text']")));
        backToMyGrantsLocator.click();
    }
}
