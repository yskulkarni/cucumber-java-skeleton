Feature: Belly

  Scenario: a few cukes
    Given I have 12 cukes in my belly
    When I wait 1 hour
    Then my belly should growl

  Scenario Outline: different cukes
    Given I have <cukes> cukes in my belly
    When I wait <hours> hour
    Then my belly growling would be <status>

    Examples:
      | cukes | hours | status |
      | 12    | 1     | true   |
      | 22    | 1     | false  |