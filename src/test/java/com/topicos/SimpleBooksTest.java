package com.topicos;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SimpleBooksTest {

    String url = "https://simple-books-api.glitch.me";

    public String generarToken() {
        String endpoint = "/api-clients/";
        String accessToken;
        String requestBody = "{\n" +
                "   \"clientName\": \"JuanFernandez\",\n" +
                "   \"clientEmail\": \"juanf2124@example.com\"\n" + //CAMBIAR CORREO
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(url + endpoint)
                .then()
                .statusCode(201)
                .extract().response();

        accessToken = response.jsonPath().getString("accessToken");
        System.out.println("RESPONSE GENERATE TOKEN: " + response.asString());
        System.out.println("RESPONSE ACCESS TOKEN: " + accessToken);
        return accessToken;
    }

    @Test
    public void crearOrden() {
        String endpoint = "/orders";

        String requestBody = "{\n" +
                "  \"bookId\": 3,\n" +
                "  \"customerName\": \"JuanFernandez\"\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .auth().oauth2(generarToken())
                .body(requestBody)
                .when()
                .post(url + endpoint)
                .then()
                .statusCode(201)
                .extract().response();

        System.out.println("RESPONSE: " + response.asString());
    }
}