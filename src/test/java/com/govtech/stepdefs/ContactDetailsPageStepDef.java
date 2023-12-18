package com.govtech.stepdefs;

import com.govtech.factory.DriverFactory;
import com.govtech.pages.ContactDetailsPage;
import com.govtech.pages.EligibilityPage;
import com.govtech.pages.GetNewGrantsPage;
import com.govtech.pages.MyGrantsHomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ContactDetailsPageStepDef extends BaseStepDef {

    MyGrantsHomePage grantsHomePage = new MyGrantsHomePage(DriverFactory.getDriver());
    GetNewGrantsPage newGrantsPage = new GetNewGrantsPage(DriverFactory.getDriver());
    EligibilityPage eligibilityPage = new EligibilityPage(DriverFactory.getDriver());
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage(DriverFactory.getDriver());


    String postalCode = prop.getProperty("company_postalcode");
    String blockNo = prop.getProperty("company_block_no");
    String streetName = prop.getProperty("company_streetname");
    String offeree_name = prop.getProperty("offer_addressee_name");
    String offeree_designation = prop.getProperty("offer_addressee_designation");
    String offeree_emailId = prop.getProperty("offer_addressee_emailid");
    String contactPersonName = prop.getProperty("name");
    String contactPersonDesignation = prop.getProperty("job_title");
    String contactPersonContactNo = prop.getProperty("contact_no");
    String contactPersonEmailId = prop.getProperty("email_id");

    @And("Applicant is on the Eligibility Page")
    public void applicantIsOnTheEligibilityPage() {
        grantsHomePage.getMyGrantsHeaderMsg();
        grantsHomePage.selectGetNewGrantOption();
        newGrantsPage.selectRequiredGrantsOptions();
        newGrantsPage.clickApplyButton();
        newGrantsPage.clickProceedButton();
    }

    @And("applicant click on next button")
    public void applicantClickOnNextButton() {
        eligibilityPage.clickNextButton();
    }

    @Given("Given the Applicant is on the Contact Details page")
    public void givenTheApplicantIsOnTheContactDetailsPage() {
        String headerMsg = contactDetailsPage.getContactDetailsHeaderMsg();
        System.out.println(headerMsg);
    }

    @When("the Applicant views the {string} subsection")
    public void theApplicantViewsTheMainContactPersonSubsection(String expectedMsg) {
        String actualMsg = contactDetailsPage.getContactPersonSubHeader();
        if(actualMsg.equalsIgnoreCase(expectedMsg)){
            Assert.assertTrue(true);
        }
        else{
            String actualMsg1 = contactDetailsPage.getLetterOfOfferSubHeader();
            Assert.assertTrue(expectedMsg.equalsIgnoreCase(actualMsg1));
        }
    }

    @Then("the subsection should contain inputs for")
    public void theSubsectionShouldContainInputsFor(DataTable dataTable) {
        List<String> data = dataTable.asList(String.class);
        List<String> labelsText = contactDetailsPage.getWebEleLabelsText();
        int idx = 0;
        boolean match = true;
        for(String str : data) {
            match = str.equalsIgnoreCase(labelsText.get(idx));
            idx++;
        }
        Assert.assertTrue(match);
    }

    @When("the Applicant enters a valid postal code in the Mailing Address input")
    public void theApplicantEntersAValidPostalCodeInTheMailingAddressInput() {
        contactDetailsPage.setPostalCode(prop.getProperty("postalcode"));
    }

    @When("the Applicant selects the Same as registered address in Company Profile checkbox")
    public void theApplicantSelectsTheSameAsRegisteredAddressInCompanyProfileCheckbox() {
        contactDetailsPage.selectMailingAddressCheckBox();
    }

    @Then("the Mailing Address details should be auto-populated from the Applicant’s Company Profile")
    public void theMailingAddressDetailsShouldBeAutoPopulatedFromTheApplicantSCompanyProfile() {
        Assert.assertTrue(postalCode.equalsIgnoreCase(contactDetailsPage.getPopulatedPostalCode()));
        Assert.assertTrue(blockNo.equalsIgnoreCase(contactDetailsPage.getPopulatedBlockNumber()));
        Assert.assertTrue(streetName.equalsIgnoreCase(contactDetailsPage.getPopulatedStreetName()));
    }

    @Then("the Blk or House No and Street details fields should auto-populate")
    public void theBlkOrHouseNoAndStreetDetailsFieldsShouldAutoPopulate() {
        String blockNo = prop.getProperty("applicant_block_no");
        String streetName = prop.getProperty("applicant_streetname");
        Assert.assertTrue(blockNo.equalsIgnoreCase(contactDetailsPage.getPopulatedBlockNumber()));
        Assert.assertTrue(streetName.equalsIgnoreCase(contactDetailsPage.getPopulatedStreetName()));
    }

    @Then("the Letter of Offer Addressee subsection should contain inputs for")
    public void theLetterOfOfferAddresseeSubsectionShouldContainInputsFor(DataTable table) {
        List<String> data = table.asList(String.class);
        List<String> labelsText = contactDetailsPage.getOfficeAddressWebEleLabelsText();
        int idx = 0;
        for(String str : data) {
            Assert.assertFalse(!str.equalsIgnoreCase(labelsText.get(idx++)));
        }
        Assert.assertTrue(true);
    }

    @When("the Applicant selects Same as main contact person checkbox")
    public void theApplicantSelectsSameAsMainContactPersonCheckbox() {
        contactDetailsPage.selectSameAsMainPersonCheckBox();
    }

    @Then("the details from the Main Contact Person subsection should populate the Letter of Offer Addressee subsection")
    public void theDetailsFromTheMainContactPersonSubsectionShouldPopulateTheLetterOfOfferAddresseeSubsection() {
        Assert.assertTrue(contactPersonName.equalsIgnoreCase(contactDetailsPage.getPrePopulatedOffereeName()));
        Assert.assertTrue(contactPersonDesignation.equalsIgnoreCase(contactDetailsPage.getPrePopulatedOffereeDesignation()));
        Assert.assertTrue(contactPersonEmailId.equalsIgnoreCase(contactDetailsPage.getPrePopulatedOffereeEmailId()));
    }

    @When("the Applicant fills all necessary inputs for Main Contact Person")
    public void theApplicantFillsAllNecessaryInputsForMainContactPerson() {
        contactDetailsPage.fillTheContactPersonDetails();
    }

    @And("the Applicant also fills the Letter of Offer Adressee")
    public void theApplicantAlsoFillsTheLetterOfOfferAdressee() {
        contactDetailsPage.fillTheOfferAdresseeDetails();
    }

    @Then("the saved values should be displayed in the respective fields")
    public void theSavedValuesShouldBeDisplayedInTheRespectiveFields() {
        // Main contact Person Details
        Assert.assertTrue(contactPersonName.equalsIgnoreCase(contactDetailsPage.getContactPersonName()));
        Assert.assertTrue(contactPersonDesignation.equalsIgnoreCase(contactDetailsPage.getContactPersonDesignation()));
        Assert.assertTrue(contactPersonContactNo.equalsIgnoreCase(contactDetailsPage.getContactPersonContactNo()));
        Assert.assertTrue(contactPersonEmailId.equalsIgnoreCase(contactDetailsPage.getContactPersonEmailId()));
        //Address details
        Assert.assertTrue(postalCode.equalsIgnoreCase(contactDetailsPage.getPopulatedPostalCode()));
        Assert.assertTrue(blockNo.equalsIgnoreCase(contactDetailsPage.getPopulatedBlockNumber()));
        Assert.assertTrue(streetName.equalsIgnoreCase(contactDetailsPage.getPopulatedStreetName()));
        //Offer Adressee details
        Assert.assertTrue(offeree_name.equalsIgnoreCase(contactDetailsPage.getPrePopulatedOffereeName()));
        Assert.assertTrue(offeree_designation.equalsIgnoreCase(contactDetailsPage.getPrePopulatedOffereeDesignation()));
        Assert.assertTrue(offeree_emailId.equalsIgnoreCase(contactDetailsPage.getPrePopulatedOffereeEmailId()));
    }

}
