Feature: Login OrangeHRM
  Background: User login into OrangeHRM page
    Given Im in OrangeHRM page

    @verifyLoginSuccess @NeedLogout
    Scenario: Verify correct login
      Given I login with the following credentials
        |Admin|admin123|
      And I click on login button
      Then Url should be PIM page's

    @verifyLoginFailure
    Scenario Outline: Verify failed login
      Given I login with the following credentials
        |"<username>"|"<password>"|
      And I click on login button
      Then Url should be login page's
      Examples:
        |username|password|
        |Admin|           |
        |     |admin123   |



