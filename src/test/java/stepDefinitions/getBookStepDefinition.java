package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.net.HttpURLConnection;

import enums.ApiResources;
import io.cucumber.java.en.Then;
import utils.JSONParser;

public class getBookStepDefinition {

	@Then("user sends get request to grab book using ID")
	public void user_sends_get_request_to_grab_book_using_id() {
		
		String bookID="";
		String getBookResponse= given().log().all().queryParam("ID", bookID).when().get(ApiResources.getBook.getResource())
				.then().log().all().extract().response().asString();
		
	}

	@Then("verify user is able to retrive same data sent while creating book")
	public void verify_user_is_able_to_retrive_same_data_sent_while_creating_book() {

		
	}
}
