Feature: Inputting Contact Details for Applicant

  As an Applicant,
  I should be able to input values for the Main Contact Person and Letter of Offer in the Contact Details page.

  Background:
    Given the Applicant should login to the Business Grants Portal
    And Applicant is on the Eligibility Page
    When the Applicant answers all questions with Yes option
    And applicant click on next button

    Scenario: Verify presence of Main Contact Person subsection inputs
      Given Given the Applicant is on the Contact Details page
      When the Applicant views the 'Main Contact Person' subsection
      Then the subsection should contain inputs for
        | Name *                        |
        | Job Title *                   |
        | Contact No. *                  |
        | Email *                      |
        | Alternate Contact Person's Email |

  Scenario: Verify Mailing Address input auto-population from valid postal code
    Given Given the Applicant is on the Contact Details page
    When the Applicant enters a valid postal code in the Mailing Address input
    Then the Blk or House No and Street details fields should auto-populate

  Scenario: Verify auto-population of Mailing Address from Company Profile
    Given Given the Applicant is on the Contact Details page
    When the Applicant selects the Same as registered address in Company Profile checkbox
    Then the Mailing Address details should be auto-populated from the Applicant’s Company Profile

  Scenario: Verify presence of Letter of Offer Addressee subsection inputs
    Given Given the Applicant is on the Contact Details page
    When the Applicant views the 'Letter of Offer Addressee' subsection
    Then the Letter of Offer Addressee subsection should contain inputs for
      | Name *      |
      | Job Title *   |
      | Email *       |

  Scenario: Verify option to populate Letter of Offer Addressee from Main Contact Person
    Given Given the Applicant is on the Contact Details page
    When the Applicant fills all necessary inputs for Main Contact Person
    And the Applicant selects Same as main contact person checkbox
    Then the details from the Main Contact Person subsection should populate the Letter of Offer Addressee subsection

  Scenario: Save inputs and ensure values are retained after page refresh
    Given Given the Applicant is on the Contact Details page
    When the Applicant fills all necessary inputs for Main Contact Person
    And the Applicant selects the Same as registered address in Company Profile checkbox
    And the Applicant also fills the Letter of Offer Adressee
    And Applicant click on save button and refreshes the page
    Then the saved values should be displayed in the respective fields
