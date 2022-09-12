Feature: PIM OrangeHRM
  Background: PIM administration in OrangeHRM
    Given Im in OrangeHRM page

    @VerifyUserSearch @NeedLogout
    Scenario: Verify user search
      Given I login with the following credentials
        |Admin|admin123|
      And I click on login button
      Given I search for the user
        |Garry White|0099|
      And I press the search button
      Then The first result should be
        |Garry White|0099|

    @VerifyUserCreate @NeedLogout
    Scenario: Verify user create
      Given I login with the following credentials
        |Admin|admin123|
      And I click on login button
      And I click on add button
      And I fill the spaces with
        |Daniel|Santome|4199|
      And I click on save button
      And I click on PIM button
      Given I search for the user
        |Daniel Santome|4199|
      And I press the search button
      Then The first result should be
        |Daniel Santome|4199|



