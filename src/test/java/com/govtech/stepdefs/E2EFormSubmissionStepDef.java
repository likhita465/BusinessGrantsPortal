package com.govtech.stepdefs;

import com.govtech.factory.DriverFactory;
import com.govtech.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;

public class E2EFormSubmissionStepDef {

    public String refId;

    MyGrantsHomePage grantsHomePage = new MyGrantsHomePage(DriverFactory.getDriver());
    GetNewGrantsPage newGrantsPage = new GetNewGrantsPage(DriverFactory.getDriver());
    EligibilityPage eligibilityPage = new EligibilityPage(DriverFactory.getDriver());
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage(DriverFactory.getDriver());
    ProposalPage proposalPage = new ProposalPage(DriverFactory.getDriver());
    BusinessImpactPage businessImpactPage = new BusinessImpactPage(DriverFactory.getDriver());
    CostPage costPage = new CostPage(DriverFactory.getDriver());
    DeclareAndReviewPage declarePage = new DeclareAndReviewPage(DriverFactory.getDriver());
    ReviewYourApplicationPage reviewPage = new ReviewYourApplicationPage(DriverFactory.getDriver());

    @When("the Applicants fills all necessary inputs for Eligibility section")
    public void theApplicantsFillsAllNecessaryInputsForEligibilitySection() {
        grantsHomePage.getMyGrantsHeaderMsg();
        grantsHomePage.selectGetNewGrantOption();
        newGrantsPage.selectRequiredGrantsOptions();
        newGrantsPage.clickApplyButton();
        newGrantsPage.clickProceedButton();
        eligibilityPage.selectYesRadioButtonForAllQuestns();
        eligibilityPage.clickNextButton();
    }

    @And("the Applicants fills all the necessary inputs for Contact Details section")
    public void theApplicantsFillsAllTheNecessaryInputsForContactDetailsSection() {
        contactDetailsPage.fillTheContactPersonDetails();
        contactDetailsPage.selectMailingAddressCheckBox();
        contactDetailsPage.fillTheOfferAdresseeDetails();
        eligibilityPage.clickNextButton();
    }

    @And("the Applicants fills all the necessary inputs for Proposal section")
    public void theApplicantsFillsAllTheNecessaryInputsForProposalSection() {
        proposalPage.inputProjectTitle();
        proposalPage.selectStartDate();
        proposalPage.selectEndDate();
        proposalPage.inputProjectDescription();
        proposalPage.selectActivityOptionFromDropDown();
        proposalPage.selectTargetMarketOptionFromDropDown();
        proposalPage.selectYesOrNoOptionRadioButton();
        eligibilityPage.clickNextButton();
    }

    @And("the Applicants fills all the necessary inputs for Business Impact section")
    public void theApplicantsFillsAllTheNecessaryInputsForBusinessImpactSection() {
        businessImpactPage.selectFYEndDate();
        businessImpactPage.setOverseasSales();
        businessImpactPage.setOverseasInvestments();
        businessImpactPage.setRationaleForProjections();
        businessImpactPage.setNonTangibleBenefits();
        eligibilityPage.clickNextButton();
    }

    @And("the Applicants fills all the necessary inputs for Cost section")
    public void theApplicantsFillsAllTheNecessaryInputsForCostSection() {
        costPage.selectSalaryOption();
        costPage.selectNewItemButton();
        costPage.setName();
        costPage.setDesignation();
        costPage.setRoleInProject();
        costPage.setNoOfMonthsInvolvedInProject();
        costPage.setMonthlySalaryBillingCurrency();
        costPage.uploadSupportingDocuments();
        eligibilityPage.clickNextButton();
    }

    @And("the Applicants fills all the necessary inputs for Declare and Review section")
    public void theApplicantsFillsAllTheNecessaryInputsForDeclareAndReviewSection() {
        declarePage.selectNoOptionsForAllTheQuestions();
        declarePage.selectAcknowledgeCheckBox();
    }

    @When("the Applicant clicks the Review button in the Declare and Review section")
    public void theApplicantClicksTheReviewButtonInTheDeclareAndReviewSection() {
        declarePage.clickReviewButton();
    }

    @Then("the Applicant should be taken to {string} page containing all filled details")
    public void theApplicantShouldBeTakenToReviewYourApplicationPageContainingAllFilledDetails(String expectedHeaderMsg) {
        String actualHeaderMsg = reviewPage.getTheReviewPageHeader();
        Assert.assertTrue(expectedHeaderMsg.equalsIgnoreCase(actualHeaderMsg));
    }

    @Given("the Applicant is on Review Your Application Page")
    public void theApplicantIsOnReviewYourApplicationPage() {
        declarePage.clickReviewButton();
        System.out.println(reviewPage.getTheReviewPageHeader());
    }

    @When("the Applicant has checked the Consent and Acknowledgement checkbox")
    public void theApplicantHasCheckedTheConsentAndAcknowledgementCheckbox() {
        reviewPage.clickDeclarationCheckBox();
    }

    @Given("the Applicant has missed a mandatory input in a Business Impact section")
    public void theApplicantHasMissedAMandatoryInputInABusinessImpactSection() {
        businessImpactPage.clickBusinessImpactSection();
        businessImpactPage.clearNonTangibleBenefitsInputText();
        eligibilityPage.clickNextButton();
        eligibilityPage.clickNextButton();
    }

    @Then("a validation error should be triggered and the form should redirect to the section with the missing details")
    public void aValidationErrorShouldBeTriggeredAndTheFormShouldRedirectToTheSectionWithTheMissingDetails() {
        Assert.assertTrue(businessImpactPage.checkErrorMsg());
    }

    @And("an error number should be displayed in the sidebar next to the offending section")
    public void anErrorNumberShouldBeDisplayedInTheSidebarNextToTheOffendingSection() {
        int expectedCount = 1;
        String actualCountTxt = businessImpactPage.getErrorLabelWithCountIsDisplayed();
        int actualCount = Integer.parseInt(actualCountTxt);
        Assert.assertTrue(expectedCount == actualCount);
    }

    @And("the Applicant click on Submit button")
    public void theApplicantClickOnSubmitButton() {
        reviewPage.clickSubmitButton();
    }

    @Then("a Success message {string} should be displayed")
    public void aSuccessMessageYourApplicationHasBeenSubmittedShouldBeDisplayed(String expSuccessMsg) {
        String actSuccessMsg = reviewPage.getSuccessMsg();
        Assert.assertTrue(actSuccessMsg.equalsIgnoreCase(expSuccessMsg));
    }

    @And("the Success message box should contain an Application Ref ID")
    public void theSuccessMessageBoxShouldContainAnApplicationRefID() {
        refId = reviewPage.getReferenceId();
    }

    @And("the Agency details should display the receiving Agency as {string}")
    public void theAgencyDetailsShouldDisplayTheReceivingAgencyAsEnterpriseSingapore(String expectedMsg) {
        String actualMsg = reviewPage.getAgencyDetails();
        Assert.assertTrue(actualMsg.equalsIgnoreCase(expectedMsg));
    }

    @Then("the main My Grants dashboard should show the Application under the Processing tab")
    public void theMainMyGrantsDashboardShouldShowTheApplicationUnderTheProcessingTab() {
        reviewPage.clickBackToGrantAction();
        grantsHomePage.clickBackToMyGrants();
        String myGrantsPageRefId = grantsHomePage.getTheReferenceId();
        Assert.assertTrue(refId.equalsIgnoreCase(myGrantsPageRefId));
    }
}
