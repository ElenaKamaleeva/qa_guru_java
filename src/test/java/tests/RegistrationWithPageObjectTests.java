package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Registration form")
public class RegistrationWithPageObjectTests extends TestBase {

    @Test
    @DisplayName("Successful Registration")
    void successfulRegistrationTest() {
        step("Open registration page", () ->
                registrationPage.openPage());

        step("Fill registration form", () ->
                registrationPage
                        .setFirstName("Alex")
                        .setLastName("Egorov")
                        .setEmail("alex@egorov.com")
                        .setGender("Other")
                        .setUserNumber("1234567890")
                        .setDateOfBirth("30", "July", "2008")
                        .setSubject("Math")
                        .setHobby("Sports")
                        .uploadPicture("img/1.png")
                        .setAddress("Some address 1")
                        .setState("NCR")
                        .setCity("Delhi")
                        .submitForm());

        step("Check registration form results data", () ->
                registrationPage
                        .checkModalTitle("Thanks for submitting the form")
                        .checkResult("Student Name", "Alex Egorov")
                        .checkResult("Student Email", "alex@egorov.com"));
    }

    @Test
    @DisplayName("Broken Registration")
    void brokenRegistrationTest() {
        step("Open registration page", () ->
                registrationPage.openPage());

        step("Fill registration form", () ->
                registrationPage
                        .setFirstName("Alex")
                        .setLastName("Egorov")
                        .setGender("Other")
                        .setUserNumber("1234567890")
                        .submitForm());

        step("Check registration form results data", () ->
                registrationPage
                        .checkModalTitle("Thanks for submitting the form")
                        .checkResult("Student Name", "Alex Egorov")
                        .checkResult("Student Email", "alex111@egorov.com"));
    }
}