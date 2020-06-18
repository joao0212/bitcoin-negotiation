package br.com.alura;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BitcoinResourceTest {

	@Test
	public void testNegotiationEndpoint() {
		given().when().get("/negotiations").then().statusCode(200);
	}

	@Test
	public void testNegotiationSellEndPoint() {
		given().with().get("negotiations/sell").then().statusCode(200);
	}

	@Test
	public void testNegotiationBuyEndPoint() {
		given().when().get("negotiations/buy").then().statusCode(200);
	}
}