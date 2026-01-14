Feature: Verify Add Book

@Amitha
Scenario: verify user is able to add single Book
Given library baseURL is available
When user sends post request to add book with unique creds
Then the status code should be "200"
And response should contain message "successfully added"

@Smoke  
Scenario Outline: Verify Book Addition using Data Parametrisation
     Given library baseURL is available
     When user sends post request to add book with "<bookName>" "<isbn>" "<aisle>" "<author>"
     Then the status code should be "200"
     And response should contain message "successfully added"
  Examples:
  |  bookName              |    isbn   | aisle  |  author      |
  | Rest Assured Solutions | surumi    | 12340  |  Jithu       |
  | Appium Solutions       | shabana   | 00980  |  Amitha      |
  | Tosca Challenges       | tosca     |000000  |  Thasleena   |        
        
        

