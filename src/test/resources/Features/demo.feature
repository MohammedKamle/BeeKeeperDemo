Feature: Scenarios feature file

  Scenario Outline: Scenario Number One on <device>
    Given When User launches the app on '<device>'
    And User navigates to EchoBox
    And User enters a text and Saves it
    Then User is able to save the text

    Examples:
    |device|
    |iPhone 11|
    |iPhone 12|










