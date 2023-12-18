Feature: Review and Submit Grant Application

  As an Applicant,
  I should be able to review and submit my Grant Application after filling all mandatory fields in all form sections.

  Background:
    Given the Applicant should login to the Business Grants Portal
    When the Applicants fills all necessary inputs for Eligibility section
    And the Applicants fills all the necessary inputs for Contact Details section
    And the Applicants fills all the necessary inputs for Proposal section
    And the Applicants fills all the necessary inputs for Business Impact section
    And the Applicants fills all the necessary inputs for Cost section
    And the Applicants fills all the necessary inputs for Declare and Review section

  Scenario: Review after filling all mandatory inputs and click 'Review' button
    When the Applicant clicks the Review button in the Declare and Review section
    Then the Applicant should be taken to 'Review Your Application' page containing all filled details

  Scenario: Submission of the Application with final consent
    Given the Applicant is on Review Your Application Page
    When the Applicant has checked the Consent and Acknowledgement checkbox
    And the Applicant click on Submit button
    Then a Success message 'Your application has been submitted.' should be displayed
    And the Success message box should contain an Application Ref ID
    And the Agency details should display the receiving Agency as 'Enterprise Singapore'

  Scenario: Validation error for missing mandatory input
    Given the Applicant has missed a mandatory input in a Business Impact section
    When the Applicant clicks the Review button in the Declare and Review section
    Then a validation error should be triggered and the form should redirect to the section with the missing details
    And an error number should be displayed in the sidebar next to the offending section

  Scenario: Verify Application status in 'My Grants' dashboard after submission
    Given the Applicant is on Review Your Application Page
    When the Applicant has checked the Consent and Acknowledgement checkbox
    And the Applicant click on Submit button
    Then a Success message 'Your application has been submitted.' should be displayed
    And the Success message box should contain an Application Ref ID
    And the main My Grants dashboard should show the Application under the Processing tab
