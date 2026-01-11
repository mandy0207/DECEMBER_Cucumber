package utils;

import org.hamcrest.Matcher;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateSpec {

	public static RequestSpecification makeRequestSpec(String baseURL, ContentType contentType) {
		RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseURL).setContentType(contentType)
				.build()
				.log().all();
		return req;
	}

	public static ResponseSpecification makeResponseSpec(int StatusCode) {
		 return new ResponseSpecBuilder().expectStatusCode(StatusCode).
				 build();
	}
}
