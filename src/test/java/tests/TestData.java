package tests;

import java.nio.file.Path;
import java.time.Month;
import java.util.List;
import static utils.RandomUtils.*;

public class TestData {
    Integer randomMonthNumber = getRandomMonth();
    String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            email = getRandomEmail(),
            gender = getRandomGender(),
            phoneNumber = getRandomPhoneNumber(),
            day = getRandomDay(),
            year = getRandomYear(),
            picture = getRandomPicture(),
            nameOfPicture = Path.of(picture).getFileName().toString(),
            address = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCityByState(state),
            randomMonthName = Month.of(randomMonthNumber).name().toLowerCase(),
            formatedMonthName = randomMonthName.substring(0,1).toUpperCase() + randomMonthName.substring(1),
            formatedMonthNumber = String.format("%02d",randomMonthNumber);
    List<String> randomHobbies = getRandomHobbies(),
     randomSubjects = getRandomSubjects();
    String hobbiesExpected = String.join(", ", sortRandomHobbiesForAssertion(randomHobbies)),
            subjectsExpected = String.join(", ", randomSubjects);
}
