Feature: Validate CreditDataReportApi

  Scenario Outline: verify respone payload when passing single valid requestIdentifier to CreditDatReportApi
    Given user has "<requestIdentifierList>" payload
    When user calls CreditDatReportApi with post http request
    Then the API call got success with status code 200
    And perform validation on the response payload
    
    

   
   
   
