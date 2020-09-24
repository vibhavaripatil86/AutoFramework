package com.test.qa.testcases;

import com.test.qa.base.TestBase;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class APITest extends TestBase {

	public APITest() {
		super();
	}

	@Test(priority = 1)
	public void getAllCores() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.GET, "cores");
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		ValidatableResponse validateResponse = response.then();
		validateResponse.body("last_update", Matchers.equalTo("Landed on OCISLY as of Jan 7, 2020. "));
	}

	@Test(priority = 2)
	public void updateIDCore() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		int id = 123456;
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.PATCH, "cores/" + id);
		// we can create pojos and set and get the values in case of PUT, PATCH
		// and POST request
		// but due to time constraint I have put the data here only
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		ValidatableResponse validateResponse = response.then();
		validateResponse.body("id", Matchers.equalTo("123456"));
	}

	@Test(priority = 3)
	public void deleteIDCore() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		int id = 123456;
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.DELETE, "cores/" + id);
		// we can create pojos and set and get the values in case of PUT, PATCH
		// and POST request
		// but due to time constraint I have put the data here only
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		ValidatableResponse validateResponse = response.then();
		validateResponse.assertThat().body("id", Matchers.equalTo("435"));
		validateResponse.body("id", Matchers.equalTo("123456"));
	}

	@Test(priority = 4)
	public void verifyDeleteIDCore() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		int id = 123456;
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.DELETE, "cores/" + id);
		// we can create pojos and set and get the values in case of PUT, PATCH
		// and POST request
		// but due to time constraint I have put the data here only
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 400); // verify delete if ID gets
												// deleted or no,
		// this can return 204 or 400 according to the resonse code that has
		// been developed
	}

	@Test(priority = 5)
	public void getAllCapsules() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.GET, "capsules");
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

	@Test(priority = 6)
	public void getCrewMembers() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.GET, "crew");
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

	}

	@Test(priority = 7)
	public void getLaunches() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.GET, "launches/past");
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

	}

	@Test(priority = 7)
	public void dragonVersion() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.GET, "dragons");
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

	@Test(priority = 8)
	public void getLandingPadsAndShips() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.GET, "landpads");
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

	}

	@Test(priority = 9)
	public void getRockets() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.GET, "rockets");
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		Assert.assertTrue(responseBody.contains("SpaceX"));
		Assert.assertTrue(responseBody.contains("United States"));

	}

	@Test(priority = 10)
	public void getRoadster() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.GET, "roadster");
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		Assert.assertTrue(responseBody.contains("Elon Musk's Tesla Roadster"));

	}

	@Test(priority = 11)
	public void updateIDRoadster() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpRequest = RestAssured.given();
		int id = 123456;
		RestAssured.useRelaxedHTTPSValidation();
		Response response = httpRequest.request(Method.PATCH, "roadster/" + id);
		// we can create pojos and set and get the values in case of PUT, PATCH
		// and POST request but due to time constraint
		String responseBody = response.getBody().asString();
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

		ValidatableResponse validateResponse = response.then();
		validateResponse.body("id", Matchers.equalTo("123456"));
	}

	@Test(priority = 12)
	public void SuccessCreateCoreReturnsOk() {

		RestAssured.baseURI = prop.getProperty("apiurl");
		RequestSpecification httpSuccessRequest = RestAssured.given();
		Response response = httpSuccessRequest.request(Method.POST, "cores");

		Map<String, String> requestMap = new HashMap<String, String>();
		requestMap.put("block", "5");
		requestMap.put("reuse_count", "3");
		requestMap.put("rtls_attempts", "1");
		requestMap.put("rtls_landings", "1");
		requestMap.put("asds_attempts", "3");
		requestMap.put("asds_landings", "3");
		requestMap.put("last_update", "Landed on OCISLY as of Jan 29, 2020.");
		requestMap.put("launches", "5eb87d31ffd86e000604b379");
		requestMap.put("status", "active");
		requestMap.put("status", "5e9e28a6f35918c0803b265c");
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 201);

	}

}
