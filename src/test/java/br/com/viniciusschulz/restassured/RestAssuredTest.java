package br.com.viniciusschulz.restassured;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;

public class RestAssuredTest {

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = "https://swapi.dev/api/";
	}

	@Test
	public void testStartWarsCaracterName() {
		String retorno = given().get("people/1").then().assertThat().statusCode(HttpStatus.OK.value()).extract()
				.path("name");

		assertEquals("Luke Skywalker", retorno);
	}

	@Test
	public void testStartWarsFilmName() {
		String retorno = given().get("films/1").then().assertThat().statusCode(HttpStatus.OK.value()).extract()
				.path("title");

		assertEquals("A New Hope", retorno);
	}

	@Test
	public void testStartWarsPlanetName() {
		String retorno = given().get("planets/1").then().assertThat().statusCode(HttpStatus.OK.value()).extract()
				.path("name");

		assertEquals("Tatooine", retorno);
	}

	@Test
	public void testStartWarsStarShipName() {
		String retorno = given().get("starships/10/").then().assertThat().statusCode(HttpStatus.OK.value()).extract()
				.path("name");

		assertEquals("Millennium Falcon", retorno);
	}

	@Test
	public void testStartWarsStarShipNameNotFound() {
		assertEquals(HttpStatus.NOT_FOUND.value(), given().get("starships/1/").getStatusCode());
	}

}
