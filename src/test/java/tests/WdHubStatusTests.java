package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;

public class WdHubStatusTests extends TestBaseAPI {


    @Test
    public void unauthorizedStatusTest() {
        given()
                .log().all()
                .when()
                .get("/wd/hub/status")
                .then()
                .log().all()
                .statusCode(401)
                .header("WWW-Authenticate", containsString("Basic"))
                .body(containsString("401 Authorization Required"));
    }

    @Test
    public void wrongCredentialsTest() {
        given()
                .log().all()
                .auth().basic("wrongUser", "wrongPass")
                .when()
                .get("/wd/hub/status")
                .then()
                .log().all()
                .statusCode(401)
                .header("WWW-Authenticate", containsString("Basic"))
                .body(containsString("401 Authorization Required"));
    }

    @Test
    public void noAuthHeaderAtAllTest() {
        // явно проверяем поведение при полном отсутствии Authorization заголовка
        given()
                .log().all()
                .when()
                .get("/wd/hub/status")
                .then()
                .log().all()
                .statusCode(401)
                .header("WWW-Authenticate", equalTo("Basic realm=\"Selenoid\""));
    }

    @Test
    public void wrongAuthTypeTest() {
        // подменяем тип авторизации на Bearer вместо Basic
        given()
                .log().all()
                .header("Authorization", "Bearer sometoken123")
                .when()
                .get("/wd/hub/status")
                .then()
                .log().all()
                .statusCode(401)
                .header("WWW-Authenticate", startsWith("Basic"));
    }
}