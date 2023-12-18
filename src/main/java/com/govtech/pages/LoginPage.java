package com.govtech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    //FindBy Locators
    @FindBy(id = "entityId")
    WebElement entityIdInputLocator;

    @FindBy(id = "userId")
    WebElement userIdInputLocator;

    @FindBy(id = "userRole")
    WebElement userRoleInputLocator;

    @FindBy(id = "userFullName")
    WebElement userFullNameInputLocator;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButtonLocator;

    @FindBy(xpath = "//div[@class='modal-dialog']/div[2]//input[@name='username']")
    WebElement usernameInputLocator;

    @FindBy(xpath = "//div[@class='modal-dialog']/div[2]//input[@name='password']")
    WebElement passwordInputLocator;

    @FindBy(xpath = "//div[@class='modal-dialog']/div[2]//input[@name='signInSubmitButton']")
    WebElement signInButtonLocator;

    @FindBy(id = "login-button")
    WebElement loginButtonLocator;

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods
    public void getEntityId(String entityId){
        entityIdInputLocator.sendKeys(entityId);
    }

    public void getUserId(String userId){
        userIdInputLocator.sendKeys(userId);
    }

    public void getUserRole(String userRole){
        userRoleInputLocator.sendKeys(userRole);
    }

    public void getUserFullName(String fullName){
        userFullNameInputLocator.sendKeys(fullName);
    }

    public void clickLoginButton(){
        submitButtonLocator.click();
    }

    public void getUserName(String uname){
        usernameInputLocator.sendKeys(uname);
    }

    public void getPassword(String pwd){
        passwordInputLocator.sendKeys(pwd);
    }

    public void clickSignInButton(){
        signInButtonLocator.click();
    }

    public boolean checkLoginButtonDisplayed(){
       return loginButtonLocator.isDisplayed();
    }

    public void clickHomePageLoginButton(){
        loginButtonLocator.click();
    }
}
