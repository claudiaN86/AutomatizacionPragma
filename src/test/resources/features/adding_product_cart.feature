#Autor: Claudia Nieto
#Email: cmarce86@yahoo.es
#language: en

@AddingCart
Feature: Adding products to your shopping cart
  I as a customer
  want to add products
  to display them in the shopping cart

  Background: access the Demoblaze Home page
    Given that I access the home page


  @CaseOne
  Scenario Outline: Adding a product to the cart with the Add  To Cart button
    When I add a "<product>" to the cart
    Then the product should be displayed in the cart
    Examples:
      | product           |
      | Samsung galaxy s6 |


  @CaseTwo
  Scenario Outline: Adding many times the same product to the cart
    When I add several times the same "<product>" to the cart
    Then the product should be displayed many times in the cart
    Examples:
      | product           |
      | Samsung galaxy s6 |


  @CaseTree
  Scenario: Adding multiple products to cart
    When I add multiple products to the cart
      | product           |
      | Samsung galaxy s6 |
      | Nexus 6           |
      | Sony vaio i5      |
      | Iphone 6 32gb     |
    Then I should see all the different products in the cart


  @CaseFour
  Scenario: Remove products in the cart
    When I add multiple products to the cart
      | product           |
      | Samsung galaxy s6 |
      | Nexus 6           |
      | Sony vaio i5      |
      | Iphone 6 32gb     |
    And I remove the products from the cart
    Then I should not see the products


  @CaseFive
  Scenario Outline: The price must be the respective price of the selected product.
    When I add a "<product>" to the cart
    Then I should see the respective price of the product
    Examples:
      | product           |
      | Samsung galaxy s6 |


  @CaseSix
  Scenario: The total price of the cart must be the sum of the products.
    When I add multiple products to the cart
      | product           |
      | Samsung galaxy s6 |
      | Nexus 6           |
      | Sony vaio i5      |
      | Iphone 6 32gb     |
    Then I should see the corresponding total price of the products


