package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationPageTests extends TestBase{


    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();

    @Test
    void fullAutorizationTest() {
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setPhoneNumber(data.phoneNumber)
                .setBirthDate(data.day, data.month, data.year)
                .setSubjects(data.randomSubjects)
                .setHobbies(data.randomHobbies)
                .setPicture(data.picture)
                .setCurrentAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .clickSubmit()
                .shouldAppearSubmittingForm()
                .checkRegistrationResult("Student Name", data.firstName+" "+data.lastName)
                .checkRegistrationResult("Student Email", data.email)
                .checkRegistrationResult("Gender", data.gender)
                .checkRegistrationResult("Mobile", data.phoneNumber)
                .checkRegistrationResult("Date of Birth", data.day+" "+data.month+"," +data.year)
                .checkRegistrationResult("Subjects", data.subjectsExpected)
                .checkRegistrationResult("Hobbies", data.hobbiesExpected)
                .checkRegistrationResult("Picture", data.nameOfPicture)
                .checkRegistrationResult("Address", data.address)
                .checkRegistrationResult("State and City", data.state + " " + data.city);
    }
    @Test
    void authorizationWithRequiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setPhoneNumber(data.phoneNumber)
                .clickSubmit()
                .checkRegistrationResult("Student Name", data.firstName+" "+data.lastName)
                .checkRegistrationResult("Gender", data.gender)
                .checkRegistrationResult("Mobile", data.phoneNumber);
    }
    @Test
    void negativeSubmitWithEmptyRequiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName(data.firstName)
                .clickSubmit()
                .checkInvalidLastname()
                .checkEmptyGender()
                .checkInvalidPhoneNumber();
    }
    }