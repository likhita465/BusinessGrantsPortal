package com.govtech.stepdefs;

import com.govtecg.util.ConfigReader;
import com.govtech.factory.DriverFactory;
import com.govtech.pages.LoginPage;
import com.govtech.pages.MyGrantsHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPageStepDef extends BaseStepDef {

    private WebDriver driver;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    public MyGrantsHomePage myGrantsHomePage = new MyGrantsHomePage(DriverFactory.getDriver());

    @Given("user is on the Login Page")
    public void userIsOnTheLoginPage() throws InterruptedException {
        driver = DriverFactory.getDriver();
        //driver.get("https://qa-internet.bgp.onl/");
        driver.get(prop.getProperty("url"));
    }

    @When("user entered the username and password")
    public void userEnteredTheUsernameAndPassword() {
        loginPage.getUserName(prop.getProperty("username"));
        loginPage.getPassword(prop.getProperty("password"));
    }

    @And("user click on the SignIn button")
    public void userClickOnTheSignInButton() {
        loginPage.clickSignInButton();
    }

    @Then("verify {string} title is displayed")
    public void verifyTitleIsDisplayed(String expectedTitleMsg) {
        String actualTitleMsg = driver.getTitle();
        Assert.assertTrue(actualTitleMsg.equalsIgnoreCase(expectedTitleMsg));
    }

    @And("verify Login Button is displayed")
    public void verifyLoginButtonIsDisplayed() {
        Assert.assertTrue(loginPage.checkLoginButtonDisplayed());
    }

    @When("user click on login button")
    public void userClickOnLoginButton() {
        loginPage.clickHomePageLoginButton();
    }

    @When("user entered all the required details")
    public void userEnteredAllTheRequiredDetails() {
        loginPage.getEntityId(prop.getProperty("entity_id"));
        loginPage.getUserId(prop.getProperty("user_id"));
        loginPage.getUserRole(prop.getProperty("user_role"));
        loginPage.getUserFullName(prop.getProperty("user_fullname"));
    }

    @And("user click on the login button")
    public void userClickOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("verify {string} header is displayed")
    public void verifyHeaderIsDisplayed(String expectedHeaderMsg) {
        String actualHeaderMsg = myGrantsHomePage.getMyGrantsHeaderMsg();
        Assert.assertTrue(expectedHeaderMsg.equalsIgnoreCase(actualHeaderMsg));
    }
}
