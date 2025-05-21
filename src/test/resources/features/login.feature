Feature: SauceDemo Login

  @positive
  Scenario: Successful login with valid credentials
    Given I am on the SauceDemo login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should see the inventory page

  @negative
  Scenario: Unsuccessful login with invalid credentials
    Given I am on the SauceDemo login page
    When I login with username "invalid_user" and password "wrong_password"
    Then I should see an error message
