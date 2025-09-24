package pages;


import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;
import pages.components.ResultTable;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    public static SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    emailInput = $("#userEmail"),
    genderInput = $("#genterWrapper"),
    phoneNumberInput = $("#userNumber"),
    calendarInput = $("#dateOfBirthInput"),
    subjectInput = $("#subjectsInput"),
    hobbiesInput = $("#hobbiesWrapper"),
    pictureInput = $("#uploadPicture"),
    currentAddressInput = $("#currentAddress"),
    stateInput = $("#react-select-3-input"),
    cityInput = $("#react-select-4-input"),
    submitButton = $("#submit"),
    genderLabel = $(".custom-control-label");

    Calendar calendar = new Calendar();
    ResultTable resultTable = new ResultTable();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value){
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
        Calendar.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubject(String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
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
        stateInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setCity(String value){
        cityInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage clickSubmit(){
        submitButton.click();
        return this;
    }
    public RegistrationPage checkRegistrationResult(String key, String value){
        ResultTable.checkResult(key, value);
        return this;
    }
    public RegistrationPage checkInvalidLastname(){
        lastNameInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
        return this;
    }
    public RegistrationPage checkEmptyGender(){
        genderLabel.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
        return this;
    }
    public RegistrationPage checkInvalidPhoneNumber(){
        phoneNumberInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
        return this;
    }

}