package stepDefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import enums.ApiResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Book;
import utils.CreateSpec;
import utils.JSONParser;
import utils.ScenarioContext;
import utils.UniqueGenerator;

public class AddBookStepDefinition {

	
	private ScenarioContext scenarioContext;

	public AddBookStepDefinition(ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext;
	}

	@When("user sends post request to add book with unique creds")
	public void user_sends_post_request_to_add_book_with_unique_creds() {
		// add Book
		Book book = new Book(UniqueGenerator.getBookName(), UniqueGenerator.getISbn(), UniqueGenerator.getAisle(),
				UniqueGenerator.getAuthorName());
		Response addBookResponse = given().spec(CreateSpec.makeRequestSpec(scenarioContext.getBaseURL(), ContentType.JSON))
				.body(book).when().post(ApiResources.postBook.getResource()).then().extract().response();

		scenarioContext.setResponse(addBookResponse);
		System.out.println(addBookResponse.asString());
		 String bookID=JSONParser.getJsonParser(scenarioContext.getResponse().asString()).get("ID");
		 System.out.println("Can you grab this bookID ? : "+ bookID);
		 scenarioContext.setBookID(bookID);;
		
	}

	@When("user sends post request to add book with {string} {string} {string} {string}")
	public void user_sends_post_request_to_add_book_with(String bookName, String isbn, String aisle, String author) {
		Book book = new Book(bookName, isbn, aisle, author);
		Response addBookResponse = given().spec(CreateSpec.makeRequestSpec(scenarioContext.getBaseURL(), ContentType.JSON))
				.body(book).when().post(ApiResources.postBook.getResource()).then().extract().response();
		scenarioContext.setResponse(addBookResponse);
		
	}

	@Then("response should contain message {string}")
	public void response_should_contain_message(String expectedKey) {
		String actualMsg = JSONParser.getJsonParser(scenarioContext.getResponse().asString()).get("Msg");
		Assert.assertEquals(actualMsg, expectedKey);
	}
}
