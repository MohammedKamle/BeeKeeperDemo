Feature: Scenarios feature file

  Scenario Outline: Scenario Number One on <deviceName>
    Given When User launches the app on '<deviceName>'
    And User navigates to EchoBox
    And User enters a text and Saves it
    Then User is able to save the text

    Examples:
    |deviceName|
    |ios11|
    |androidPixel3|










