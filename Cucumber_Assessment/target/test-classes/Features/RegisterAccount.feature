
Feature: Register account with valid and invalid data

    
    Scenario: Register account with valid data
    Given launch open cart site
    When Enter firstname,lastname,Email id,password,telephone and click continue
    Then Account has created successfully
    
    
 Scenario: Register account without mandatory of telephone field
    Given launch open cart site
    When Enter firstname,lastname,Email id,password and click continue
    Then Account has not created 
    
