package com.govtech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ContactDetailsPage extends BasePage {

    private WebDriver driver;

    //FindBy Locators
    @FindBy(xpath = "//div[@class='bgp-sidebar']/ul//li[2]//a")
    WebElement contactDetailsLocator;

    @FindBy(xpath = "//div[@class='main']//h2")
    WebElement headerMsgLocator;

    @FindBy(xpath = "//div[@class='bgp-questions-grp']/div/div[1]//div[@class='subsection-title']//h3")
    WebElement mainContactPersonHeader;

    @FindBy(xpath = "//div[@class='bgp-questions-grp']/div/div[1]//div[@class='form-horizontal']//label[contains(@class,'control-label')]")
    List<WebElement> labelsLocator;

    @FindBy(id = "react-contact_info-name")
    WebElement nameInputLocator;

    @FindBy(id = "react-contact_info-designation")
    WebElement jobTitleInputLocator;

    @FindBy(id = "react-contact_info-phone")
    WebElement contactNoInputLocator;

    @FindBy(id = "react-contact_info-primary_email")
    WebElement emailInputLocator;

    @FindBy(xpath = "//input[@id='react-contact_info-correspondence_address-postal']")
    WebElement postalCodeLocator;

    @FindBy(xpath = "//div[@class='margin-top-lg']//div[@class='bgp-checkbox']")
    WebElement mailingAddressCheckBoxLocator;

    @FindBy(xpath = "//div[@class='col-sm-4']//div[@data-testid='address-text-box-field'][1]//input")
    WebElement blockInputLocator;

    @FindBy(xpath = "//div[@class='row form-group margin-top-btm-none'][1]//div[@class='col-sm-8']//div[@data-testid='address-text-box-field'][1]//input")
    WebElement streetInputLocator;

    @FindBy(xpath = "//div[@class='bgp-questions-grp']/div/div[3]/div[@class='subsection-title']//h3")
    WebElement letterOfOfferSubHeaderLocator;

    @FindBy(xpath = "//div[@class='bgp-questions-grp']/div/div[3]/div[@class='form-horizontal']")
    List<WebElement> officeAddressInputLabelLocator;

    @FindBy(xpath = "//div[@class='bgp-questions-grp']/div/div[3]//input[@id='react-contact_info-copied']")
    WebElement sameAsMainContactPersonCheckBoxLocator;

    @FindBy(id = "react-contact_info-offeree_name")
    WebElement offereeNameInputLocator;

    @FindBy(id = "react-contact_info-offeree_designation")
    WebElement offereeDesignationInputLocator;

    @FindBy(id = "react-contact_info-offeree_email")
    WebElement offereeEmailInputLocator;


    //constructor
    public ContactDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public String getContactDetailsHeaderMsg(){
        return headerMsgLocator.getText();
    }

    public void selectContactDetailsTab(){
        contactDetailsLocator.click();
    }
    public String getContactPersonSubHeader(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bgp-questions-grp']/div/div[1]//div[@class='subsection-title']//h3")));
        return mainContactPersonHeader.getText();
    }

    public List<String> getWebEleLabelsText(){
        List<String> eleLabelsText = new ArrayList<>();
        for(WebElement element :labelsLocator ){
            eleLabelsText.add(element.getText());
        }
        return eleLabelsText;
    }

    public void setPostalCode(String code){
        waitFor(1000);
        scrollTo(driver, postalCodeLocator);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='react-contact_info-correspondence_address-postal']")));
        postalCodeLocator.sendKeys(code);
    }

    public String getPopulatedPostalCode(){
        scrollTo(driver, postalCodeLocator);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='react-contact_info-correspondence_address-postal']")));
        return postalCodeLocator.getAttribute("value");
    }

    public void selectMailingAddressCheckBox(){
        waitFor(1000);
        scrollTo(driver, mailingAddressCheckBoxLocator);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='margin-top-lg']//div[@class='bgp-checkbox']")));
        mailingAddressCheckBoxLocator.click();
    }

    public String getPopulatedBlockNumber(){
        scrollTo(driver, blockInputLocator);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-4']//div[@data-testid='address-text-box-field'][1]//input")));
        return blockInputLocator.getAttribute("value");
    }

    public String getPopulatedStreetName(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='row form-group margin-top-btm-none'][1]//div[@class='col-sm-8']//div[@data-testid='address-text-box-field'][1]//input")));
        return streetInputLocator.getAttribute("value");
    }

    public String getLetterOfOfferSubHeader(){
        return letterOfOfferSubHeaderLocator.getText();
    }

    public List<String> getOfficeAddressWebEleLabelsText(){
        List<String> eleLabelsText = new ArrayList<>();
        for(WebElement element :officeAddressInputLabelLocator ){
            eleLabelsText.add(element.getText());
        }
        return eleLabelsText;
    }

    public void selectSameAsMainPersonCheckBox(){
        waitFor(500);
        scrollTo(driver, sameAsMainContactPersonCheckBoxLocator);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bgp-questions-grp']/div/div[3]//input[@id='react-contact_info-copied']")));
        sameAsMainContactPersonCheckBoxLocator.click();
    }

    public void fillTheContactPersonDetails(){
        waitFor(500);
        scrollTo(driver, sameAsMainContactPersonCheckBoxLocator);
        nameInputLocator.sendKeys(prop.getProperty("name"));
        jobTitleInputLocator.sendKeys(prop.getProperty("job_title"));
        waitFor(500);
        scrollTo(driver, sameAsMainContactPersonCheckBoxLocator);
        contactNoInputLocator.sendKeys(prop.getProperty("contact_no"));
        emailInputLocator.sendKeys(prop.getProperty("email_id"));

    }

    public void fillTheOfferAdresseeDetails(){
        offereeNameInputLocator.sendKeys(prop.getProperty("offer_addressee_name"));
        offereeDesignationInputLocator.sendKeys(prop.getProperty("offer_addressee_designation"));
        offereeEmailInputLocator.sendKeys(prop.getProperty("offer_addressee_emailid"));
    }

    public String getPrePopulatedOffereeName(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-contact_info-offeree_name")));
        return offereeNameInputLocator.getAttribute("value");
    }

    public String getPrePopulatedOffereeDesignation(){
        return offereeDesignationInputLocator.getAttribute("value");
    }

    public String getPrePopulatedOffereeEmailId(){
        return offereeEmailInputLocator.getAttribute("value");
    }

    public String getContactPersonName(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-contact_info-name")));
        return nameInputLocator.getAttribute("value");
    }

    public String getContactPersonDesignation(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-contact_info-designation")));
        return jobTitleInputLocator.getAttribute("value");
    }

    public String getContactPersonContactNo(){
        return contactNoInputLocator.getAttribute("value");
    }

    public String getContactPersonEmailId(){
        return emailInputLocator.getAttribute("value");
    }

}
