package com.govtech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CostPage extends BasePage {

    private WebDriver driver;

    //FindBy locators
    @FindBy(xpath = "//div[@class='accordion-container'][3]//div[@class='row']//div[1]")
    WebElement salaryOptionLocator;

    @FindBy(xpath = "//div[@class='accordion-container'][3]//button[@id='react-project_cost-salaries-add-item']")
    WebElement newItemLocator;

    @FindBy(xpath = "//div[@class='form-horizontal'][1]//input[@id='react-project_cost-salaries-0-name']")
    WebElement nameInputLocator;

    @FindBy(xpath = "//div[@class='form-horizontal'][2]//input[@id='react-project_cost-salaries-0-designation']")
    WebElement designationInputLocator;

    @FindBy(xpath = "//div[@class='form-group']//textarea[@id='react-project_cost-salaries-0-project_role']")
    WebElement roleDescriptionTextAreaLocator;

    @FindBy(xpath = "//div[@class='form-horizontal'][5]//input[@id='react-project_cost-salaries-0-involvement_months']")
    WebElement projectInvolvementInputLocator;

    @FindBy(xpath = "//div[@class='form-horizontal'][6]//input[@id='react-project_cost-salaries-0-salary_in_billing_currency']")
    WebElement monthlySalaryBillingCurrencyInputLocator;

    @FindBy(id = "react-project_cost-salaries-0-attachments-btn")
    WebElement selectFilesButtonLocator;

    //Constructor
    public CostPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void selectSalaryOption(){
        waitFor(1000);
        scrollTo(driver,salaryOptionLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='accordion-container'][3]//div[@class='row']//div[1]")));
        salaryOptionLocator.click();
    }

    public void selectNewItemButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='accordion-container'][3]//button[@id='react-project_cost-salaries-add-item']")));
        newItemLocator.click();
    }

    public void setName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='form-horizontal'][1]//input[@id='react-project_cost-salaries-0-name']")));
        nameInputLocator.sendKeys("Likhita");
    }

    public void setDesignation(){
        designationInputLocator.sendKeys("Tester");
    }

    public void setRoleInProject(){
        roleDescriptionTextAreaLocator.sendKeys("Testing the BGP application");
    }

    public void setNoOfMonthsInvolvedInProject(){
        projectInvolvementInputLocator.sendKeys("1");
    }

    public void setMonthlySalaryBillingCurrency(){
        monthlySalaryBillingCurrencyInputLocator.sendKeys("3000");
    }

    public void uploadSupportingDocuments(){
        scrollTo(driver,selectFilesButtonLocator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-project_cost-salaries-0-attachments-btn")));
        selectFilesButtonLocator.sendKeys(System.getProperty("user.dir") + "//src//test//resources//GDS_Quality_Engineer_JD.pdf");
    }

}
