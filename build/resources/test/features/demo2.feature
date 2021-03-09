Feature: Scenarios feature file

  Scenario Outline: Scenario Number One on <deviceName>
    Given When User launches the app on '<deviceName>'
    And User navigates to EchoBox

    Examples:
      |deviceName|
      |ios11|
      |androidPixel3|










