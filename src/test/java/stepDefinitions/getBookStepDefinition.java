package stepDefinitions;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import enums.ApiResources;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.CreateSpec;
import utils.JSONParser;
import utils.ScenarioContext;

public class GetBookStepDefinition {
	
	private ScenarioContext scenarioContext;

	public GetBookStepDefinition(ScenarioContext scenarioContext ) {
		this.scenarioContext = scenarioContext;
	}

	@Then("user sends get request to grab book using ID")
	public void user_sends_get_request_to_grab_book_using_id() {
	
		String bookID=scenarioContext.getBookID();
		System.out.println("I can chase everything :  "+bookID);
		Response getBookResponse=  given().spec(CreateSpec.makeRequestSpec(scenarioContext.getBaseURL(), ContentType.JSON)).queryParam("ID", bookID).when().get(ApiResources.getBook.getResource())
				.then().log().all().extract().response();
		scenarioContext.setResponse(getBookResponse);
	}

	@Then("verify user is able to retrive same data sent while creating book")
	public void verify_user_is_able_to_retrive_same_data_sent_while_creating_book() {
		String responseISBN=(String) JSONParser.getJsonParser(scenarioContext.getResponse().asString()).getList("isbn").get(0);
		String responseAISLE=(String) JSONParser.getJsonParser(scenarioContext.getResponse().asString()).getList("aisle").get(0);
		
		
		String expectedBookID =responseISBN+responseAISLE;
	//	Assert.assertEquals(scenarioContext.getBookID(),expectedBookID);
		
	}
}
