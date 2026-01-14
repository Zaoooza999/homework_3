package tests;

import utils.RandomUtils;

import java.nio.file.Path;
import java.util.List;
import static utils.RandomUtils.*;

public class TestData {
    String firstName = RandomUtils.getRandomFirstName(),
            lastName = RandomUtils.getRandomLastName(),
            email = RandomUtils.getRandomEmail(),
            gender = RandomUtils.getRandomGender(),
            phoneNumber = RandomUtils.getRandomPhoneNumber(),
            day = RandomUtils.getRandomDay(),
            month = RandomUtils.getRandomMonth(),
            year = getRandomYear(),
            picture = getRandomPicture(),
            nameOfPicture = Path.of(picture).getFileName().toString(),
            address = RandomUtils.getRandomAddress(),
            state = RandomUtils.getRandomState(),
            city = RandomUtils.getRandomCityByState(state);
    public List<String> randomHobbies = getRandomHobbies(),
     randomSubjects = getRandomSubjects();
    String hobbiesExpected = String.join(", ", randomHobbies),
            subjectsExpected = String.join(", ", randomSubjects);
}
