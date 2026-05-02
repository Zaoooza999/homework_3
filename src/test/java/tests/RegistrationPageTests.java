package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import helpers.AdsBanners;
import static io.qameta.allure.Allure.step;

public class RegistrationPageTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();

    @Test
    @Feature("Registration")
    @Story("Registration form")
    @DisplayName("Successful Registration all fields")
    void fullAutorizationTest() {
        registrationPage.openPage();
        AdsBanners.hideBanners();
        step("Заполнить форму", () -> {
            registrationPage.setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setGender(data.gender)
                    .setPhoneNumber(data.phoneNumber)
                    .closeBanner()
                    .setBirthDate(data.day, data.formatedMonthName, data.year)
                    .setSubjects(data.randomSubjects)
                    .setHobbies(data.randomHobbies)
                    .setPicture(data.picture)
                    .setCurrentAddress(data.address)
                    .setState(data.state)
                    .setCity(data.city);
        });
        registrationPage.clickSubmit()
                .shouldAppearSubmittingForm();
        step("Проверить данные на форме подтверждения", () -> {
            registrationPage.checkRegistrationResult("Student Name", data.firstName + " " + data.lastName)
                    .checkRegistrationResult("Student Email", data.email)
                    .checkRegistrationResult("Gender", data.gender)
                    .checkRegistrationResult("Mobile", data.phoneNumber)
                    .checkRegistrationResult("Date of Birth", data.year + "-" + data.formatedMonthNumber + "-" + data.day)
                    .checkRegistrationResult("Subjects", data.subjectsExpected)
                    .checkRegistrationResult("Hobbies", data.hobbiesExpected)
                    .checkRegistrationResult("Picture", data.nameOfPicture)
                    .checkRegistrationResult("Address", data.address)
                    .checkRegistrationResult("State and City", data.state + " " + data.city);
        });
    }

    @Test
    void authorizationWithRequiredFieldsTest() {
        registrationPage.openPage();
        AdsBanners.hideBanners();
        registrationPage.setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setPhoneNumber(data.phoneNumber)
                .clickSubmit()
                .checkRegistrationResult("Student Name", data.firstName + " " + data.lastName)
                .checkRegistrationResult("Gender", data.gender)
                .checkRegistrationResult("Mobile", data.phoneNumber);
    }

    @Test
    void negativeSubmitWithEmptyRequiredFieldsTest() {
        registrationPage.openPage();
        AdsBanners.hideBanners();
        registrationPage.setFirstName(data.firstName)
                .clickSubmit()
                .checkAppearingWarningOfEmptyFields();
    }
}