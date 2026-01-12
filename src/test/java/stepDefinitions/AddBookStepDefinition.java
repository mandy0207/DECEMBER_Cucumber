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
import utils.UniqueGenerator;

public class AddBookStepDefinition {

	Response addBookResponse;

	@Given("library baseURL is available")
	public void library_base_url_is_available() {

	}

	@When("user sends post request to add book with unique creds")
	public void user_sends_post_request_to_add_book_with_unique_creds() {
		// add Book
		Book book = new Book(UniqueGenerator.getBookName(), UniqueGenerator.getISbn(), UniqueGenerator.getAisle(),
				UniqueGenerator.getAuthorName());
		addBookResponse = given().spec(CreateSpec.makeRequestSpec(ApiResources.baseUrl.getResource(), ContentType.JSON))
				.body(book).when().post(ApiResources.postBook.getResource()).then().extract().response();
		
		System.out.println(addBookResponse.asString());
	}

	@When("user sends post request to add book with {string} {string} {string} {string}")
	public void user_sends_post_request_to_add_book_with(String bookName, String isbn, String aisle, String author) {
		Book book = new Book(bookName, isbn, aisle, author);
		addBookResponse = given().spec(CreateSpec.makeRequestSpec(ApiResources.baseUrl.getResource(), ContentType.JSON))
				.body(book).when().post(ApiResources.postBook.getResource()).then().extract().response();
		
	}

	@Then("the status code should be {string}")
	public void the_status_code_should_be(String expectedStatusCode) {
		int actualStatusCode = addBookResponse.getStatusCode();
		Assert.assertEquals(Integer.toString(actualStatusCode), expectedStatusCode);

	}

	@Then("response should contain message {string}")
	public void response_should_contain_message(String expectedKey) {
		String actualMsg = JSONParser.getJsonParser(addBookResponse.asString()).get("Msg");
		Assert.assertEquals(actualMsg, expectedKey);
	}
}
