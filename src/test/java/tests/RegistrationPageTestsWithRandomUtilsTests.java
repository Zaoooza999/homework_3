package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static utils.RandomUtils.*;

public class RegistrationPageTestsWithRandomUtilsTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullAutorisazionTest() {
        String firstName = getRandomString(10),
                lastName = getRandomString(10),
                email = getRandomEmail(),
                currentAddress = getRandomCurrentAddress();



        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .setBirthDate("28", "January", "1995")
                .setSubject("Arts")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setPicture("picture.png")
                .setCurrentAddress("California")
                .setState("Haryana")
                .setCity("Panipat")
                .clickSubmit()
                .checkRegistrationResult("Student Name", firstName+" "+lastName)
                .checkRegistrationResult("Student Email", email)
                .checkRegistrationResult("Gender", "Male")
                .checkRegistrationResult("Mobile", "1234567890")
                .checkRegistrationResult("Date of Birth", "28 January,1995")
                .checkRegistrationResult("Subjects", "Arts")
                .checkRegistrationResult("Hobbies", "Sports, Reading")
                .checkRegistrationResult("Picture", "picture.png")
                .checkRegistrationResult("Address", "California")
                .checkRegistrationResult("State and City", "Haryana Panipat");
    }


    @Test
    void authorizationWithRequiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setGender("Male")
                .setPhoneNumber("1234567890")
                .clickSubmit()
                .checkRegistrationResult("Student Name", "Ivan Ivanov")
                .checkRegistrationResult("Gender", "Male")
                .checkRegistrationResult("Mobile", "1234567890");
    }
    @Test
    void negativeSubmitWithEmptyRequiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName("Ivan")
                .clickSubmit()
                .checkInvalidLastname()
                .checkEmptyGender()
                .checkInvalidPhoneNumber();
    }
    }