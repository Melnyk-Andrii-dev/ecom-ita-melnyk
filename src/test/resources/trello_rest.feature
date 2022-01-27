Feature:  Trello Api

  Background: Cleanup all boards

  Scenario: Create Board POJO Lesson
    Given I delete all boards on user's page
    When [POJO] I send create a new board request
    Then I see 200 status code in get board request
    When I send delete the board request
    Then I see 404 status code in get board request

  Scenario: Create Board
    When [POJO] I create a new board 'testBoard3'

#  Scenario: Delete a board
#    When [POJO] I delete a board 'board1'

  Scenario: Create a list on the board
    When I send create a list 'list12' on the board 'testBoard3' request
    And I send create a card 'card12' on the list request
    And I change the card color to GREEN
    Then I see in response that color is GREEN
    And I add checklist to the card
    And I add a comment 'test comment' to the card
    And I send delete the card request
