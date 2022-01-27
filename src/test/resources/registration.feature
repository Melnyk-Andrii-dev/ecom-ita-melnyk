Feature: As an unregistered user
  I want the ability to register on the site
  So that I become a full-fledged user

  Scenario:[PARAM] The user is registered after providing valid information
    Given Registration Page is opened
    When The user inputs 'firstname' field with 'First'
    And The user inputs 'lastname' field with 'Last'
    #need to update the email every time before the test
#    And The user inputs 'email' field with 'test101@mail.com'
#   Random email format - 8 alphanumeric characters + @mail.com
    And The user inputs 'email' field with a random email
    And The user inputs 'telephone' field with '0970000000'
    And The user inputs 'password' field with 'test1234'
    #password confirmation field
    And The user inputs 'confirm' field with 'test1234'
    And The user chooses subscription - NO
    And The user selects Privacy Policy checkbox
    And The user clicks Continue button
    Then The user have a Logout option on Global Header

  Scenario:[ENUM] The user is registered after providing valid information
    Given Registration Page is opened
    When The user inputs enum FIRSTNAME field with 'First'
    And The user inputs enum LASTNAME field with 'Last'
    #need to update the email every time before the test
    #   Random email format - 8 alphanumeric characters + @mail.com
    And The user inputs enum EMAIL field with a random email
    And The user inputs enum TELEPHONE field with '0970000000'
    And The user inputs enum PASSWORD field with 'test1234'
    #password confirmation field
    And The user inputs enum PASSWORD_CONFIRMATION field with 'test1234'
    And The user chooses subscription - NO
    And The user selects Privacy Policy checkbox
    And The user clicks Continue button
    Then The user have a Logout option on Global Header

  Scenario:[TABLE] The user is registered after providing valid information
    Given Registration Page is opened
    When The user inputs text into field on Registration Page:
      | text             | field     |
      | First            | firstname |
      | Last             | lastname  |
      #   Email is random, format - 8 alphanumeric characters + @mail.com
      |                  | email     |
      | 0971111111       | telephone |
      | test1234         | password  |
      | test1234         | confirm   |
    And The user chooses subscription - NO
    And The user selects Privacy Policy checkbox
    And The user clicks Continue button
    Then The user have a Logout option on Global Header

  Scenario: The user cant register without accepting Privace Policy
    Given Registration Page is opened
    When The user inputs 'firstname' field with 'First'
    And The user inputs 'lastname' field with 'Last'
    And The user inputs 'email' field with 'test101@mail.com'
    And The user inputs 'telephone' field with '0970000000'
    And The user inputs 'password' field with 'test1234'
    #password confirmation field
    And The user inputs 'confirm' field with 'test1234'
    And The user chooses subscription - YES
    And The user clicks Continue button
    Then The user have a Login option on Global Header

  Scenario: The user cant register with invalid email
    Given Registration Page is opened
    When The user inputs 'firstname' field with 'First'
    And The user inputs 'lastname' field with 'Last'
    And The user inputs 'email' field with 'test101@mai@l.com'
    And The user inputs 'telephone' field with '0970000000'
    And The user inputs 'password' field with 'test1234'
    #password confirmation field
    And The user inputs 'confirm' field with 'test1234'
    And The user chooses subscription - YES
    And The user clicks Continue button
    Then The user have a Login option on Global Header

  Scenario Outline: Error message is shown when password confirmation field fail validation
    Given Registration Page is opened
    When The user inputs 'firstname' field with 'First'
    And The user inputs 'lastname' field with 'Last'
    And The user inputs 'email' field with 'test101@mail.com'
    And The user inputs 'telephone' field with '0970000000'
    And The user inputs 'password' field with 'test1234'
    #password confirmation field
    And The user inputs 'confirm' field with 'test12345'
    And The user chooses subscription - YES
    And The user selects Privacy Policy checkbox
    And The user clicks Continue button
    Then The error message '<error>' is displayed on field level
    And  The user have a Login option on Global Header
    Examples:
      | error                                          |
      | Password confirmation does not match password! |

  Scenario Outline: Error message is shown when an already registered user tries to register
    Given Registration Page is opened
    When The user inputs 'firstname' field with 'First'
    And The user inputs 'lastname' field with 'Last'
    And The user inputs 'email' field with 'sajowi9588@epeva.com'
    And The user inputs 'telephone' field with '0970000000'
    And The user inputs 'password' field with 'test1234'
    #password confirmation field
    And The user inputs 'confirm' field with 'test1234'
    And The user chooses subscription - YES
    And The user selects Privacy Policy checkbox
    And The user clicks Continue button
    Then The error message '<error>' is displayed on page level
    And  The user have a Login option on Global Header
    Examples:
      | error                                          |
      | Warning: E-Mail Address is already registered! |


