
@tag
Feature: Error validation
  I want to use this template for my feature file

  
  @tag2
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page 
    When Logged in  with username <username> and Password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
           | username   										| password 			|
      	`	 | Kingofthepates@onepeice.com    | Strawhats@10  |
      