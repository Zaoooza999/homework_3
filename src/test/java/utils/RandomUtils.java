package utils;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomCurrentAddress());
        System.out.println(getRandomInt(0, 13));
        System.out.println(getRandomPhoneNumber());
        System.out.println(getRandomGender());
    }

    public static String getRandomString(int length){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = rnd.nextInt(SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));}
        return result.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10)+"@qa.guru";
    }
    public static String getRandomCurrentAddress() {
        return getRandomString(10)+" "+getRandomString(10)+" "+getRandomString(10);
    }
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static String getRandomPhoneNumber() {
        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1,9), getRandomInt(100,999), getRandomInt(100,999), getRandomInt(10,99), getRandomInt(10,99));
    }
    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }
    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0,array.length - 1);
        return array[index];
    }

}
