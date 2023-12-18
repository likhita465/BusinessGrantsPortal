# BusinessGrantsPortal

Run Configuration in IDE
------------------------
<img width="775" alt="image" src="https://github.com/likhita465/BusinessGrantsPortal/assets/150339768/e6c117a7-bc5f-40e0-acbb-f43067b8cde1">

UserStory-2:
---------------
Negative scenario
-------------------
Background:
    Given the Applicant is on the Contact Details page (Notworking)

  Scenario: Attempt to save without filling required fields
    When the Applicant tries to save without filling in all required fields
    Then an error message should be displayed prompting to fill in all required fields

  Scenario: Enter an invalid postal code for Mailing Address
    When the Applicant enters an invalid postal code in the Mailing Address input
    Then the system should not auto-populate 'Blk/Hse No.' and 'Street details'

  Scenario: Select 'Same as registered address' without a registered address in Company Profile
    Given the Applicant's Company Profile does not have a registered address
    When the Applicant selects 'Same as registered address in Company Profile' checkbox
    Then the Mailing Address should not be populated

  Scenario: Provide incomplete Main Contact Person details
    When the Applicant fills incomplete details for the Main Contact Person:
      | Field        | Value        |
      | Name         | John         |
      | Job Title    |              |
      | Contact No   | +1234567890  |
    Then the system should not accept incomplete details and prompt to fill all required fields

  Scenario: Attempt to populate Letter of Offer Addressee without Main Contact Person details
    When the Applicant attempts to populate 'Letter of Offer Addressee' without filling 'Main Contact Person' details
    Then the 'Letter of Offer Addressee' section should not populate

  Scenario: Save inputs with invalid or incorrect data
    When the Applicant enters invalid or incorrect data in any field
    And clicks 'Save'
    Then the system should display appropriate error messages for the invalid fields

============================================================
UserStory-3:
--------------
Negative scenario
-----------------
 Background:
    Given the Applicant has filled all mandatory fields in all 6 form sections

  Scenario: Attempt to review without filling mandatory inputs
	Given the Applicant has filled all mandatory fields in all 6 form sections
    And the Applicant has not filled all mandatory inputs in a section
    When the Applicant tries to click 'Review'
    Then a validation error should be triggered, preventing the Applicant from proceeding to the summary page

  Scenario: Review after encountering validation error
	Given the Applicant has filled all mandatory fields in all 6 form sections
    And the Applicant encountered a validation error while attempting to review
    When the missing mandatory inputs are filled
    And the Applicant clicks 'Review' again
    Then the Applicant should be taken to the read-only summary page

  Scenario: Submit without confirming final 'Consent and Acknowledgement'
	Given the Applicant has filled all mandatory fields in all 6 form sections
    And the Applicant is on the read-only summary page
    When the Applicant tries to submit without checking the 'Consent and Acknowledgement' checkbox
    Then a validation error should prevent the submission, requesting to confirm the consent

  Scenario: Submit with incorrect or invalid data
	Given the Applicant has filled all mandatory fields in all 6 form sections
    And the Applicant has entered incorrect or invalid data in any field
    When the Applicant tries to submit the Application
    Then the system should display appropriate error messages for the invalid fields
    And prevent the submission until valid data is provided

  Scenario: Verify Application status in 'My Grants' dashboard after unsuccessful submission
	Given the Applicant has filled all mandatory fields in all 6 form sections
    And the Applicant encountered an error during submission
    Then the main 'My Grants' dashboard should not display the Application under the 'Processing' tab

  Scenario: Try to submit after previous successful submission
	Given the Applicant has filled all mandatory fields in all 6 form sections
    And the Applicant has already successfully submitted the Application
    When the Applicant attempts to submit the same Application again
    Then the system should prevent the duplicate submission and show an appropriate message

Test Report:
------------
<img width="959" alt="image" src="https://github.com/likhita465/BusinessGrantsPortal/assets/150339768/2aa66a92-6b42-492e-8de9-765262e2bb96">
