Feature: Finance form submission

  Scenario: Submit finance form with ineligible income
    Given I open the finance form
    When I enter income "1400"
    And I enter commitment "3000"
    And I enter phone "0511111111"
    And I enter OTP "123456"
    Then I should see the ineligible page
