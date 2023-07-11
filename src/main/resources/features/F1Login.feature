Feature: Login to Oasissys Application

  @SmokeTest
  Scenario: Login to the system
    Given User login to Oasissys app with UserName and Password
            | testrcm | testrcm |
    Then  Click on the left side menu
    And   User select Manage Approvals from the menu
    And   Click on the data and select 01 jan 2022
    Then  Validate Posted label contains 94
    Then  User logout from the system
