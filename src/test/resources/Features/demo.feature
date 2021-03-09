Feature: Scenarios feature file

  Scenario: Scenario Number One
    Given When User launches the app on <device>
    And User navigates to EchoBox
    And User enters a text and Saves it
    Then User is able to save the text

    Examples:
     | ios1 |
     | ios2 |
     | android1 |
     | android2 |




