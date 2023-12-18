package com.govtech.stepdefs;

import com.govtecg.util.CommonMethods;
import com.govtech.factory.DriverFactory;
import com.govtech.pages.ContactDetailsPage;
import com.govtech.pages.EligibilityPage;
import com.govtech.pages.GetNewGrantsPage;
import com.govtech.pages.MyGrantsHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class EligibilityFormStepDef {


    CommonMethods methods = new CommonMethods();
    MyGrantsHomePage grantsHomePage = new MyGrantsHomePage(DriverFactory.getDriver());
    GetNewGrantsPage newGrantsPage = new GetNewGrantsPage(DriverFactory.getDriver());
    EligibilityPage eligibilityPage = new EligibilityPage(DriverFactory.getDriver());
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage(DriverFactory.getDriver());


    @Given("the Applicant should login to the Business Grants Portal")
    public void the_applicant_should_login_to_the_business_grants_portal() {
        methods.doLogin();
    }
    @When("the Applicant click on Get new grant")
    public void the_applicant_click_on_get_new_grant() {
        grantsHomePage.selectGetNewGrantOption();
    }
    @When("select the required sectors")
    public void select_the_required_sectors() {
        newGrantsPage.selectRequiredGrantsOptions();
    }
    @When("the Applicant click on apply button")
    public void the_applicant_click_on_apply_button() {
        newGrantsPage.clickApplyButton();
    }

    @When("the Applicant click on Proceed button")
    public void the_applicant_click_on_proceed_button() {
        newGrantsPage.clickProceedButton();
    }
    @Given("the Applicant is on the Eligibility page")
    public void the_applicant_is_on_the_eligibility_page() {
        Assert.assertTrue(eligibilityPage.checkEligibilityHeaderMsgVisibility());
    }

    @Then("verify Grant Actions header is displayed")
    public void verifyGrantActionsHeaderIsDisplayed() {
        String expectedHeaderMsg = "Grant Actions";
        Assert.assertTrue(expectedHeaderMsg.equalsIgnoreCase(newGrantsPage.getGrantActionsHeaderMsg()));
    }

    @Then("verify Check Your Eligibility header is displayed")
    public void verifyCheckYourEligibilityHeaderIsDisplayed() {
        String expectedHeaderMsg = "Check Your Eligibility";
        Assert.assertTrue(expectedHeaderMsg.equalsIgnoreCase(newGrantsPage.getEligibilityHeaderMsg()));
    }

    @When("the Applicant answers all questions with Yes option")
    public void theApplicantAnswersAllQuestionsWithYesOption() {
        eligibilityPage.selectYesRadioButtonForAllQuestns();
    }

    @Then("the questions should be answered with Yes option")
    public void theQuestionsShouldBeAnsweredWithYesOption() {
        Assert.assertTrue(eligibilityPage.checkYesOptionIsSelected());
    }

    @When("the Applicant answers any question with No option")
    public void theApplicantAnswersAnyQuestionWithNoOption() {
        eligibilityPage.selectFirstQuestionNoRadioButton();
    }

    @Then("a warning message should be displayed stating {string}")
    public void warningMessageShouldBeDisplayedStating(String expectedMsg) {
        String actualMsg = eligibilityPage.getWarningMessage();
        Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg));
    }

    @When("the warning message about eligibility criteria is displayed")
    public void theWarningMessageAboutEligibilityCriteriaIsDisplayed() {
        eligibilityPage.selectFirstQuestionNoRadioButton();
        eligibilityPage.checkWarningMsgIsDisplayed();
    }

    @And("the Applicant clicks the link in the warning message")
    public void theApplicantClicksTheLinkInTheWarningMessage() {
        eligibilityPage.clickFAQLink();
    }

    @Then("a new tab should open with the URL {string}")
    public void aNewTabShouldOpenWithTheURL(String expectedUrl) {
        String actualUrl = eligibilityPage.getTheURLOfNewOpenedWindow();
        Assert.assertTrue(expectedUrl.equalsIgnoreCase(actualUrl));
    }

    @And("Applicant click on save button and refreshes the page")
    public void applicantClickOnSaveButtonAndRefreshesThePage() {
        eligibilityPage.clickSaveButton();
        eligibilityPage.refreshThePage();
    }

    @Then("refreshing the page should reload the saved values")
    public void refreshingThePageShouldReloadTheSavedValues() {
        Assert.assertTrue(eligibilityPage.checkYesOptionIsSelected());
    }

    @When("the Applicant answers all questions and clicks Save button")
    public void theApplicantAnswersAllQuestionsAndClicksSaveButton() {
        eligibilityPage.selectYesRadioButtonForAllQuestns();
        eligibilityPage.clickSaveButton();
    }

    @And("Applicant navigate to contact details Page")
    public void applicantNavigateToContactDetailsPage() {
        contactDetailsPage.selectContactDetailsTab();
    }

    @And("returns to the Eligibility page")
    public void returnsToTheEligibilityPage() {
        eligibilityPage.selectEligibilityTab();
    }

    @Then("the saved answers should persist and match the previously saved values")
    public void theSavedAnswersShouldPersistAndMatchThePreviouslySavedValues() {
        Assert.assertTrue(eligibilityPage.checkYesOptionIsSelected());
    }

}
