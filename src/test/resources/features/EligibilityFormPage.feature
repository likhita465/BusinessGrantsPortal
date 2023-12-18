Feature: Eligibility Questions for Applicants
  As an Applicant,
  I should be able to answer a set of Yes/No Eligibility questions in the Eligibility page.

Background:
  Given the Applicant should login to the Business Grants Portal
  Then verify 'My Grants' header is displayed
  When the Applicant click on Get new grant
  And select the required sectors
  And the Applicant click on apply button
  Then verify Grant Actions header is displayed
  When the Applicant click on Proceed button
  Then verify Check Your Eligibility header is displayed

  Scenario: Answering eligibility questions with 'Yes'
    Given the Applicant is on the Eligibility page
    When the Applicant answers all questions with Yes option
    Then the questions should be answered with Yes option

  Scenario: Answering eligibility questions with 'No' for any question
    Given the Applicant is on the Eligibility page
    When the Applicant answers any question with No option
    Then a warning message should be displayed stating 'The applicant may not meet the eligibility criteria for this grant. Visit FAQ page for more information on other government grants.'

  Scenario: Redirect to FAQ page from warning message
    Given the Applicant is on the Eligibility page
    When the warning message about eligibility criteria is displayed
    And the Applicant clicks the link in the warning message
    Then a new tab should open with the URL 'https://www.gobusiness.gov.sg/business-grants-portal-faq/get-a-grant/'

  Scenario: Save and reload Applicant's inputs
    Given the Applicant is on the Eligibility page
    When the Applicant answers all questions with Yes option
    And Applicant click on save button and refreshes the page
    Then refreshing the page should reload the saved values

  Scenario: Saving answers and navigating away should maintain the saved values
    Given the Applicant is on the Eligibility page
    When the Applicant answers all questions and clicks Save button
    And Applicant navigate to contact details Page
    And returns to the Eligibility page
    Then the saved answers should persist and match the previously saved values
