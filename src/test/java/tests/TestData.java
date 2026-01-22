package tests;

import java.nio.file.Path;
import java.util.List;
import static utils.RandomUtils.*;

public class TestData {
    String firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            email = getRandomEmail(),
            gender = getRandomGender(),
            phoneNumber = getRandomPhoneNumber(),
            day = getRandomDay(),
            month = getRandomMonth(),
            year = getRandomYear(),
            picture = getRandomPicture(),
            nameOfPicture = Path.of(picture).getFileName().toString(),
            address = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCityByState(state);
    List<String> randomHobbies = getRandomHobbies(),
     randomSubjects = getRandomSubjects();
    String hobbiesExpected = String.join(", ", randomHobbies),
            subjectsExpected = String.join(", ", randomSubjects);
}
