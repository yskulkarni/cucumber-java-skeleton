Feature: Hello

  Scenario: ask for hello
    When I GET /hello
    Then the result should be:
      """
      {
        "key": "hello",
        "value": "world"
      }
      """
