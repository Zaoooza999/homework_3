package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.Calendar;
import pages.components.ResultTable;
import java.util.List;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    emailInput = $("#userEmail"),
    genderInput = $("#genterWrapper"),
    phoneNumberInput = $("#userNumber"),
    calendarInput = $("#dateOfBirthInput"),
    subjectInput = $("#subjectsInput"),
    hobbiesInput = $("#hobbiesWrapper"),
    pictureInput = $("#uploadPicture"),
    currentAddressInput = $("#currentAddress"),
    stateOptionsCaller = $("#state"),
    cityOptionsCaller = $("#city"),
    submitButton = $("#submit"),
    pageTitle = $("H1"),
    submittingForm = $("#resultModal"),
            closeBannerButton = $("[aria-label='Close']"),
            warning = $("#formError");
    private final ElementsCollection stateCityOptionsSelector = $$(".state-city-option");
    private final Calendar calendar = new Calendar();
    private final ResultTable resultTable = new ResultTable();

    @Step("Открыть страницу /one-page-form/automation-practice-form.html")
    public void openPage() {
        open("/one-page-form/automation-practice-form.html");
        pageTitle.shouldHave(text("Practice Form"));
    }

    public RegistrationPage closeBanner() {
        closeBannerButton.click();
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }


    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPhoneNumber(String value){
        phoneNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year){
        calendarInput.click();
        calendar.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjects(List<String> subjects){
        for (String subject : subjects) {
            subjectInput.setValue(subject).pressEnter();
        }
        return this;
    }

    public RegistrationPage setHobbies(List<String> hobbies) {
        for (String hobby : hobbies) {
            hobbiesInput.$(byText(hobby)).click();
        }
        return this;
    }
    public RegistrationPage setPicture(String value){
        pictureInput.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value){
        stateOptionsCaller.click();
        stateCityOptionsSelector.findBy(text(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value){
        cityOptionsCaller.click();
        stateCityOptionsSelector.findBy(text(value)).click();
        return this;
    }
    @Step("Нажать подтвердить")
    public RegistrationPage clickSubmit(){
        submitButton.click();
        return this;
    }
    @Step("Проверить открытие формы подтверждения регистрации")
    public RegistrationPage shouldAppearSubmittingForm(){
        submittingForm.should(appear).shouldHave(text("Thanks for submitting the form"));
        return this;
    }
    public RegistrationPage checkRegistrationResult(String key, String value){
        resultTable.checkResult(key, value);
        return this;
    }
    public RegistrationPage checkAppearingWarningOfEmptyFields(){
        warning.shouldBe(visible).shouldHave(text("Please fill required fields and enter a valid 10-digit mobile number."));
        return this;
    }
}