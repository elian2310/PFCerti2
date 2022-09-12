Feature: Recruitment OrangeHRM
  Background: Recruitment administration in OrangeHRM
    Given Im in OrangeHRM page

    @verifyRecruitmentSearch @NeedLogout
    Scenario: Verify correct search
      Given I login with the following credentials
        |Admin|admin123|
      And I click on login button
      And I click on recruitment button
      Given I search for the vacancy
        |Jennifer Clinton|2022-07-12|2022-07-13|
      And I click on search button
      Then The first result needs to be
        |Jennifer Clinton|Software Engineer|

    @verifyRecruitmentCreate @NeedLogout
    Scenario: Verify correct create
      Given I login with the following credentials
        |Admin|admin123|
      And I click on login button
      And I click on recruitment button
      And I press add button
      And I fill the vacancy info with
        |Juan|Quispe|juanquispe@gmail.com|
      And I press the save button
      And I press the recruitment button
      Given I search for the new vacancy of "Juan Quispe"
      And I click on search button
      Then The first result needs to be "Juan Quispe"

