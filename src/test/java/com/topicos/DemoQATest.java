package com.topicos;

import com.topicos.pages.LoginPage;
import com.topicos.pages.ProfilePage;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoQATest {
    WebDriver driver;
    LoginPage loginPage;
    ProfilePage profilePage;

    private String endpointCreate="/Account/v1/User";
    private String username = "testingUser123";
    private String password = "TestingPass123!";

    @BeforeAll
    public static void setupClass() {
        baseURI = "https://demoqa.com";
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage= new ProfilePage(driver);
    }

    @AfterEach
    public void tearDown() {
        loginPage.closePage();
    }

    @Test
    public void testCreateUserAndLogin() {
        Response createResponse = given()
                .contentType("application/json")
                .body("{ \"userName\": \"" + username + "\", \"password\": \"" + password + "\" }")
                .post(baseURI+endpointCreate);

        assertEquals(201, createResponse.getStatusCode());
        System.out.println("Usuario creado exitosamente.");

        loginPage.openPage("https://demoqa.com/login");
        loginPage.loginUser(username,password);
        assertEquals(username, profilePage.getUserLogged());

        System.out.println("Logging exitoso del usuario "+username);

        profilePage.deleteAccount();
        System.out.println("Usuario eliminado desde la UI.");

        loginPage.loginUser(username,password);
        assertEquals("Invalid username or password!",loginPage.getInfoMessage());

        System.out.println("Validación correcta del mensaje de error.");
    }
}
