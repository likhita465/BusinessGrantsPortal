package com.govtech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BusinessImpactPage extends BasePage {

    private WebDriver driver;

    //@FindBy Locators
    @FindBy(xpath = "//div[@class='cols-sm-12']//span")
    WebElement fyEndDateLocator;

    @FindBy(xpath = "//div[@class='rdtPicker']//div[@class='rdtDays']//tbody//td[contains(@class, 'rdtToday')]")
    WebElement selectFYEndDateLocator;

    @FindBy(id = "react-project_impact-overseas_sales_0")
    WebElement overseasSales1Locator;

    @FindBy(id = "react-project_impact-overseas_sales_1")
    WebElement overseasSales2Locator;

    @FindBy(id = "react-project_impact-overseas_sales_2")
    WebElement overseasSales3Locator;

    @FindBy(id = "react-project_impact-overseas_sales_3")
    WebElement overseasSales4Locator;

    @FindBy(id = "react-project_impact-overseas_investments_0")
    WebElement overseasInvestments1Locator;

    @FindBy(id = "react-project_impact-overseas_investments_1")
    WebElement overseasInvestments2Locator;

    @FindBy(id = "react-project_impact-overseas_investments_2")
    WebElement overseasInvestments3Locator;

    @FindBy(id = "react-project_impact-overseas_investments_3")
    WebElement overseasInvestments4Locator;

    @FindBy(xpath = "//div[@class='form-group'][1]//textarea")
    WebElement rationaleForProjectionsLocator;

    @FindBy(xpath = "//div[@class='form-group'][2]//textarea")
    WebElement nonTangibleBenefits;

    @FindBy(xpath = "//div[@class='bgp-sidebar']//li[4]//span[@class='menu-text']")
    WebElement businessImpactSectionTabLocator;

    @FindBy(xpath = "//div[@class='bgp-sidebar']//li[4]//div[@class='sidebar-label']//span")
    WebElement errorLabelLocator;

    @FindBy(xpath = "//div[@class='form-group'][2]//div[@class='bgp-textareabox margin-btm-50']//p")
    WebElement errorMsgLocator;

    //Constructor
    public BusinessImpactPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void selectFYEndDate(){
        waitFor(1000);
        fyEndDateLocator.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='rdtPicker']//div[@class='rdtDays']//tbody//td[contains(@class, 'rdtToday')]")));
        selectFYEndDateLocator.click();
    }

    public void setRationaleForProjections(){
        scrollTo(driver,rationaleForProjectionsLocator);
        rationaleForProjectionsLocator.sendKeys("Test");
    }

    public void setNonTangibleBenefits(){
        scrollTo(driver,nonTangibleBenefits);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group'][2]//textarea")));
        nonTangibleBenefits.sendKeys("Test");
    }

    public void setOverseasSales(){
        overseasSales1Locator.sendKeys("100");
        overseasSales2Locator.sendKeys("200");
        overseasSales3Locator.sendKeys("300");
        overseasSales4Locator.sendKeys("400");
    }

    public void setOverseasInvestments(){
        overseasInvestments1Locator.sendKeys("1000");
        overseasInvestments2Locator.sendKeys("2000");
        overseasInvestments3Locator.sendKeys("3000");
        overseasInvestments4Locator.sendKeys("4000");
    }

    public void clickBusinessImpactSection(){
        businessImpactSectionTabLocator.click();
    }

    public void clearNonTangibleBenefitsInputText(){
        waitFor(1000);
        scrollTo(driver,nonTangibleBenefits);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group'][2]//textarea")));
        nonTangibleBenefits.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    }

    public String getErrorLabelWithCountIsDisplayed(){
        String count = errorLabelLocator.getText();
        return count;
    }

    public boolean checkErrorMsg(){
        waitFor(1000);
        scrollTo(driver,errorMsgLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group'][2]//div[@class='bgp-textareabox margin-btm-50']//p")));
        return errorMsgLocator.isDisplayed();
    }
}
