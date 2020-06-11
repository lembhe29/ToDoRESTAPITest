@TodosRESTAPITest

Feature: To get details from To do REST API

  @getList
  Scenario: UI-Verify Todo REST API returns list of all todo (GET)
    Given I send a valid request to Todo REST API to get all list
    When I get valid response 200 from REST API
    Then I a list of all Todo is returned successfully


  @getSpecificData
  Scenario Outline: UI-Verify Todo REST API returns details for specific id
    Given I send a valid request to Todo REST API to get details for <id>
    When I get valid response 200 from REST API
    Then I verify details for Todo <id> are returned successfully
    Examples:
      | id  |
      | 25  |
      | 10  |


  @postData
  Scenario Outline: UI-Verify adding new data (POST)
    Given I send a valid request to Todo REST API to add new data <id>
    When I get valid response 201 from REST API
    Then I verify details for Todo <id> are returned successfully
    Examples:
      | id  |
      | 201 |


  @updateData
  Scenario Outline: UI-Verify update todo data (PUT)
    Given I send a valid request to Todo REST API to update existing <id>
    When I get valid response 200 from REST API
    Then I verify details for Todo <id> are returned successfully
    Examples:
      | id  |
      | 201 |

  @updateData
  Scenario Outline: UI-Verify delete todo data (DELETE)
    Given I send a valid request to Todo REST API to delete existing <id>
    Then I get valid response 200 from REST API
    Examples:
      | id  |
      | 201 |

