Feature: Veriy HTTP Requests

  Scenario: Verify get, post, update, delete request
    Given user set endpoint "/posts"
    And set header "Content-Type" to "application/json"
    And set body "CreateBody.json"
    When user perform post call
    Then verify status code is 201
    When get the data "id" from response and store

    Given user set endpoint "/posts/"
    And set body "UpdateBody.json"
    When user perform put call
    Then verify status code is 200

    Given user set endpoint "/posts/"
    When user perform delete call
    Then verify status code is 200

    Given user set endpoint "/posts/"
    When user perform get call
    Then verify status code is 404
