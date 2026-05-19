package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput   = $("#firstName"),
            lastNameInput    = $("#lastName"),
            userEmailInput   = $("#userEmail"),
            genderWrapper    = $("#genterWrapper"),
            userNumberInput  = $("#userNumber"),
            calendarInput    = $("#dateOfBirthInput"),
            subjectsInput    = $("#subjectsInput"),
            hobbiesWrapper   = $("#hobbiesWrapper"),
            uploadPicture    = $("#uploadPicture"),
            currentAddress   = $("#currentAddress"),
            stateDropdown    = $("#state"),
            cityDropdown     = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton     = $("#submit"),
            modalDialog      = $(".modal-dialog"),
            modalTitle       = $("#example-modal-sizes-title-lg"),
            tableResponsive  = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Open registration page /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("document.querySelector('#fixedban')?.remove()");
        executeJavaScript("document.querySelector('footer')?.remove()");
        return this;
    }

    @Step("Type first name \"{value}\"")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Type last name \"{value}\"")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Type email \"{value}\"")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Choose gender \"{value}\"")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Type phone number \"{value}\"")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Set date of birth: {day}.{month}.{year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    @Step("Set subject \"{value}\"")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Select hobby \"{value}\"")
    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Upload picture \"{fileName}\"")
    public RegistrationPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    @Step("Type address \"{value}\"")
    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    @Step("Select state \"{value}\"")
    public RegistrationPage setState(String value) {
        stateDropdown.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Select city \"{value}\"")
    public RegistrationPage setCity(String value) {
        cityDropdown.click();
        stateCityWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Submit form")
    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    @Step("Check modal appears with title \"{title}\"")
    public RegistrationPage checkModalTitle(String title) {
        modalDialog.should(appear);
        modalTitle.shouldHave(text(title));
        return this;
    }

    @Step("Check that field \"{key}\" has result \"{value}\"")
    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}