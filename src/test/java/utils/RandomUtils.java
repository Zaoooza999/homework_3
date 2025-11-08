package utils;
import com.github.javafaker.Faker;
import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println();
    }

    private static final Faker faker = new Faker(new Locale("en-US"));

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomDay() {
        int day = faker.number().numberBetween(1, 29);
        return String.format("%02d", day);
    }

    public static String getRandomMonth() {
        int randomMonthNumber = faker.number().numberBetween(1, 12);
        String randomMonthName = Month.of(randomMonthNumber).name().toLowerCase();
        return randomMonthName.substring(0,1).toUpperCase() + randomMonthName.substring(1);
    }
    public static String getRandomYear() {
        int currentYear = Year.now().getValue();
        int randomYear = faker.number().numberBetween(currentYear-100, currentYear);
        return String.valueOf(randomYear);
    }

    public static List<String> getRandomSubjects() {
        String[] subjects = {"Maths","Accounting","Arts","Social Studies","Physics","Chemistry",
                "Computer Science","Commerce","Economics","Civics","English","Hindi","Biology","History"};
        int randomQuantityOfSubjects = faker.number().numberBetween(1, subjects.length + 1);
        List<String> subjectsList = new ArrayList<>(Arrays.asList(subjects));
        Collections.shuffle(subjectsList);
        return subjectsList.subList(0, randomQuantityOfSubjects);
    }

    public static List<String> getRandomHobbies() {
        String[] hobbies = {"Sports","Reading","Music"};
        int randomQuantityOfHobbies = faker.number().numberBetween(1, hobbies.length + 1);
        List<String> hobbiesList = new ArrayList<>(Arrays.asList(hobbies));
        Collections.shuffle(hobbiesList);
        return hobbiesList.subList(0, randomQuantityOfHobbies);
    }

    public static String getRandomPicture() {
        String[] pictures = {"picture.png","picture1.jpg"};
        return faker.options().option(pictures);
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        String[] states = {"NCR","Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(states);
    }

    public static String getRandomCityByState(String state) {
        String[] citiesOfNCR = {"Delhi","Gurgaon", "Noida"},
                citiesOfUttarPradesh = {"Agra", "Lucknow", "Merrut"},
                citiesOfHaryana = {"Karnal", "Panipat"},
                citiesOfRajasthan = {"Jaipur", "Jaiselmer"};

        if (state.equals("NCR")) return faker.options().option(citiesOfNCR);
        else if (state.equals("Uttar Pradesh")) return faker.options().option(citiesOfUttarPradesh);
        else if (state.equals("Haryana")) return faker.options().option(citiesOfHaryana);
        else return faker.options().option(citiesOfRajasthan);
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static String getRandomPhoneNumber() {
                StringBuilder sb = new StringBuilder();
        sb.append(getRandomInt(1, 9));
        for (int i = 0; i < 9; i++) {
            sb.append(getRandomInt(0, 9));
        }
        return sb.toString();
    }
    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }
}
