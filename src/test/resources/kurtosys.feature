Feature: Kurtosys Validation

  Scenario: Download a white paper without providing email
    Given I am on the Kurtosys homepage
    When I navigate to White Papers & eBook from Resources
    And I click on a white paper titled UCITS Whitepaper
    And I fill in the personal information fields except email field
    And I click on Send me a copy
    Then I should see error messages regarding the necessary fields