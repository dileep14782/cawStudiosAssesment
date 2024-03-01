Feature: Dynamic Data Table
  @Test
  Scenario: Dynamic Data Table Validation
    Given User navigates to Dynamic Table page
      | https://testpages.herokuapp.com/styled/tag/dynamic-table.html |
    When User click on Table Data button
    Then User insert data in Table Data Input field
    And User validates table data and json data