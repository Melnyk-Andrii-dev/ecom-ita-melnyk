Feature: As registered user
  I want to login to the system with my credentials
  So that I can have access to store

  Scenario: Property File check
    Given User is logged in on Login Page

  @smoke
  Scenario:[ENUM] Store page is displayed after successful login
    Given Login page is opened in header dropdown
    When I enter to EMAIL_INPUT_FIELD field 'sajowi9588@epeva.com' value on Login Page
    And I enter to PASSWORD_INPUT_FIELD field '123123' value on Login Page
    And I click the Login button on Login Page
    Then My Account Page is displayed

  Scenario: Error message is displayed in response to invalid credentials
    Given Login page is opened
    When I enter to EMAIL_INPUT_FIELD field 'sajowi9588@epeva.com' value on Login Page
    And I enter to PASSWORD_INPUT_FIELD field '1231231' value on Login Page
    And I click the Login button
    Then The error message 'Warning: No match for E-Mail Address and/or Password.' is displayed

  Scenario:[DATA TABLE] Store page is displayed after successful login
    Given Login page is opened in header dropdown
    When I enter text into field on Login Page:
      | inputData            | fieldName |
      | sajowi9588@epeva.com | email     |
      | 123123               | password  |
    And I click the Login button on Login Page
    Then My Account Page is displayed
