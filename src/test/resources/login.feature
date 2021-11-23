Feature: As registered user
  I want to login to the system with my credentials
  So that I can have access to store

  Scenario: Store page is displayed after successful login
    Given Login page is opened in header dropdown
    When I enter email 'sajowi9588@epeva.com' on Login page
    And I enter password '123123' on Login page
    And I click the Login button on Login Page
    Then My Account Page is displayed

  Scenario: Error message is displayed in response to invalid credentials
    Given Login page is opened
    When I enter unregistered email 'test01@mail.com'
    And I enter any password, e.g. '12345'
    And I click the Login button
    Then The error message 'Warning: No match for E-Mail Address and/or Password.' is displayed
