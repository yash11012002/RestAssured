Feature: Veriy HTTP Requests

  Scenario Outline: Verify get, post, update, delete request
    Given user set endpoint "/posts"
    And set header "Content-Type" to "application/json"
    And set body "<fileName>"
    When user perform post call
    Then verify status code is 201

    Examples:
    | fileName|
    |DDT.json       |
    |CreateBody.json|