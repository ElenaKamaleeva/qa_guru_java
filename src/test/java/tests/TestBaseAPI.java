package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseAPI {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://selenoid.qa.guru";
    }
}