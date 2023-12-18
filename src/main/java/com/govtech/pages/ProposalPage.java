package com.govtech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProposalPage extends BasePage {

    private WebDriver driver;

    //FindBy Locators
    @FindBy(id = "react-project-title")
    WebElement projectTitleInputLocator;

    @FindBy(id = "react-project-description")
    WebElement projectDescriptionTextAreaLocator;

    @FindBy(xpath = "//div[@class='form-horizontal'][6]//label[@class='bgp-radio'][1]")
    WebElement yesOptionRadioButtonLocator;

    @FindBy(xpath = "//div[@class='form-horizontal'][2]//div[@class='input-group date']//span[contains(@class,'bgp-datefield-icon')]")
    WebElement startDateLocator;

    @FindBy(xpath = "//div[@class='form-horizontal'][2]//div[@class='rdtPicker']//div[@class='rdtDays']//tbody//td[contains(@class, 'rdtToday')]")
    WebElement selectStartDateLocator;

    @FindBy(xpath = "//div[@class='form-horizontal'][3]//div[@class='rdtPicker']//div[@class='rdtDays']//th[@class='rdtNext']")
    WebElement endDateNextArrowLocator;

    @FindBy(xpath = "//div[@class='form-horizontal'][3]//div[@class='input-group date']//span[contains(@class,'bgp-datefield-icon')]")
    WebElement endDateLocator;

    @FindBy(xpath = "//div[@class='form-horizontal'][3]//div[@class='rdtPicker']//div[@class='rdtDays']//tbody//tr[3]//td[3]")
    WebElement selectEndDateLocator;

    @FindBy(xpath = "//div[@class=' margin-top-lg']//span[@class='Select-arrow-zone']")
    WebElement activityDropDownLocator;

    @FindBy(id ="react-select-project-activity--option-2")
    WebElement overseasMarketingPresenceOptionLocator;

    @FindBy(xpath = "//div[@class='form-horizontal'][5]//span[@class='Select-arrow-zone']")
    WebElement targetMarketDropDownLocator;

    @FindBy(id = "react-select-project-primary_market--option-201")
    WebElement singaporeOptionLocator;

    //constructor
    public ProposalPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void inputProjectTitle(){
        waitFor(1000);
        projectTitleInputLocator.sendKeys(prop.getProperty("project_title"));
    }

    public void inputProjectDescription(){
        projectDescriptionTextAreaLocator.sendKeys(prop.getProperty("project_description"));
    }

    public void selectStartDate(){
        startDateLocator.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-horizontal'][2]//div[@class='rdtPicker']//div[@class='rdtDays']//tbody//td[contains(@class, 'rdtToday')]")));
        selectStartDateLocator.click();
    }

    public void selectEndDate(){
        endDateLocator.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='form-horizontal'][3]//div[@class='input-group date']//span[contains(@class,'bgp-datefield-icon')]")));
        endDateNextArrowLocator.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='form-horizontal'][3]//div[@class='rdtPicker']//div[@class='rdtDays']//tbody//tr[3]//td[3]")));
        selectEndDateLocator.click();
    }

    public void selectActivityOptionFromDropDown(){
        activityDropDownLocator.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-project-activity--option-2")));
        overseasMarketingPresenceOptionLocator.click();
    }

    public void selectTargetMarketOptionFromDropDown(){
        targetMarketDropDownLocator.click();
        scrollTo(driver,singaporeOptionLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-project-primary_market--option-201")));
        singaporeOptionLocator.click();
    }

    public void selectYesOrNoOptionRadioButton(){
        yesOptionRadioButtonLocator.click();
    }

}
