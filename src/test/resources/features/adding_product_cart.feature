#Autor: Claudia Nieto
#Email: cmarce86@yahoo.es
#language: en

@AddingCart
Feature: Add products to cart
  I as a customer
  want to add products
  to display them in the shopping cart

  Background: Access the Demoblaze's homepage
    Given I am on the homepage

  @CaseOne @AddProduct
  Scenario Outline: Adding a product to the cart with the Add  To Cart button
    When I add a "<product>" to the cart "<quantity>"
    Then I should see the "<product>" in the cart
    Examples:
      | product           | quantity |
      | Samsung galaxy s6 | 1        |

  @CaseTwo @AddSameProduct
  Scenario Outline: Adding many times the same product to the cart
    When I add "<quantity>" times the same "<product>" to the cart
    Then the "<product>" should be displayed "<quantity>" times in the cart
    Examples:
      | product           | quantity |
      | Samsung galaxy s6 | 4        |

  @CaseTree @AddMultipleProducts
  Scenario: Adding multiple products to cart
    When I add multiple products to the cart
      | product           | quantity |
      | Samsung galaxy s6 | 1        |
      | Nexus 6           | 2        |
      | Sony vaio i5      | 3        |
      | Iphone 6 32gb     | 1        |
    Then I should see the products in the cart

  @CaseFour @RemoveCartProducts
  Scenario: Remove products in the cart
    When I add multiple products to the cart
      | product           | quantity |
      | Samsung galaxy s6 | 1        |
      | Nexus 6           | 1        |
      | Sony vaio i5      | 1        |
      | Iphone 6 32gb     | 1        |
    And I remove the products in the cart
    Then I should not see the products in the cart

  @CaseFive @PriceProduct
  Scenario Outline: The price must be the respective price of the selected product.
    When I add a "<product>" to the cart "<quantity>"
    Then I should see the respective "<price>" of the "<product>" in the cart
    Examples:
      | product           | quantity | price |
      | Samsung galaxy s6 | 1        | 360   |


  @CaseSix @PriceProducts
  Scenario: The total price of the cart must be the sum of the products.
    When I add multiple products to the cart
      | product           | quantity |
      | Samsung galaxy s6 | 1        |
      | Samsung galaxy s6 | 1        |
      | Nexus 6           | 1        |
      | Sony vaio i5      | 1        |
      | Iphone 6 32gb     | 1        |
    Then I should see the sum of the total price of the products in the cart


