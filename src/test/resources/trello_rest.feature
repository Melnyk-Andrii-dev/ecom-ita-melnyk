Feature:  Trello Api

  Background: Cleanup all boards


  Scenario: Create Board POJO Lesson
    Given I delete all boards on user's page
    When [POJO] I send create a new board request
    Then I see 200 status code in get board request
    When I send delete the board request
    Then I see 404 status code in get board request

  Scenario: Create Board
    When [POJO] I create a new board 'B20TestTest'

  Scenario: Delete a board
    When [POJO] I delete a board 'test44'
