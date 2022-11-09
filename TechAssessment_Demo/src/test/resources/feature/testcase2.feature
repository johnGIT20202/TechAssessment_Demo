@testcase2
Feature: testcase2

  Scenario Outline: testcase2
    Given user navigate to "https://jupiter.cloud.planittesting.com/#/"
    When browser is "Edge"
    Then run scenario testcase2 <user>

    Examples:
    |user|
    |John|
    |Mark|
    |Leithold|
    |Max|
    |September|