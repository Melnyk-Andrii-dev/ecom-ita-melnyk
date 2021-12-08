Feature: As a user
  I want to select products
  So that to purchase them

  Scenario: The user can see popular items on the Your Store Page
    Given Your Store Page is opened
    Then The carousel is displayed

  Scenario: The user adds products to Cart
    Given Your Store Page is opened
    When The user clicks add to cart of first product
    And The user clicks add to cart of second product
    And The user opens minicart
    Then Two items are indicated on the minicart button
    And Sum of first and second products are indicated on the minicart button
    And First product is in the minicart
    And Second product is in the minicart

  Scenario: The user adds products to the WishList
    Given Your Store Page is opened
    When The user clicks add to wishlist for the Third product
    And The user clicks add to wishlist for the Forth product
    Then Successful add to wishlist message is displayed
    And 2 products are indicated in a Wishlist at the Header

  Scenario: The user selects products to compare
    Given Your Store Page is opened
    When The user clicks compare of the fisrt product
    Then First product was added to comparison
    When The user clicks compare of the second product
    Then Second product was added to comparison

    Scenario: The user is able to open PDP from Your Store Page
      Given Your Store Page is opened
      When The user clicks on the first product title
      Then The first product PDP is opened