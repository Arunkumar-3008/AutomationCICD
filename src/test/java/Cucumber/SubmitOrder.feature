@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce Page 


  @tag2
  Scenario Outline: Positive Test for Submitting order.
  
    Given Logged in  with username <username> and Password <Password>
    When I add  the product <productname> to cart  
    And  Checkout <productname> and submit order 
    Then <Message> message is displayed on Confirmation Page.

    Examples: 
      | username   										| Password 			|	productname	  |		 Message								 |
      | Kingofthepirates@onepeice.com | Strawhats@10  | ZARA COAT 3	  |		 Thankyou for the order  |
      
