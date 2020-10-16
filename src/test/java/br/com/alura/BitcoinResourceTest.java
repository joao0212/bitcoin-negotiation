package br.com.alura;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BitcoinResourceTest {

	@Test
	public void testarOrdensProcessadasEndpoint() {
		given().when().get("/bitcoins/processados").then().statusCode(200);
	}
}