Feature: Verify Get Book


@Sanity
Scenario Outline: Verify user is able to retrive book using ID
Given library baseUrl is available
When user sends request to add book with unique creds
Then user sends get request to grab book using ID
Then the status code should be "200"
And verify user is able to retrive same data sent while creating book