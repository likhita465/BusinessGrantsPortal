package com.govtecg.util;

import com.govtech.factory.DriverFactory;
import com.govtech.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class CommonMethods {

    private WebDriver driver;
    private Properties prop;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    public CommonMethods(){
        prop = ConfigReader.initializeProperties();
    }

    public void doLogin(){
        //get the current driver
        driver = DriverFactory.getDriver();
        //get the url
        driver.get(prop.getProperty("url"));
        //username and password
        loginPage.getUserName(prop.getProperty("username"));
        loginPage.getPassword(prop.getProperty("password"));
        loginPage.clickSignInButton();
        //business grants portal manual login page
        loginPage.clickHomePageLoginButton();
        loginPage.getEntityId(prop.getProperty("entity_id"));
        loginPage.getUserId(prop.getProperty("user_id"));
        loginPage.getUserRole(prop.getProperty("user_role"));
        loginPage.getUserFullName(prop.getProperty("user_fullname"));
        loginPage.clickLoginButton();
    }

}
