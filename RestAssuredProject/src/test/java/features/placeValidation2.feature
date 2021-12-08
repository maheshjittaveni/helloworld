Feature: Validating Place API's

  Scenario Outline: verify if place is beeing successfully added using AppPlaceAPI
    Given add place payload "<name>" "<language>" "<address>"
    When user calls "addPlaceApi" with "Post" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    
Examples:
   |name    |language   |address  |
   |Laxman  |Hindi      |Hyderabad|
   |Ram     |Telugu     |Delhi    |
   |Mahesh  |English    |Mumbai   |
   
