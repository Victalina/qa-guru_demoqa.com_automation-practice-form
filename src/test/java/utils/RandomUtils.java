package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

  static Faker faker = new Faker();

  public static String getRandomFirstName() {

    return faker.name().firstName();

  }

  public static String getRandomLastName() {

    return faker.name().lastName();

  }

  public static String getRandomEmail() {

    return faker.internet().safeEmailAddress();

  }

  public static int getRandomInt(int min, int max) {

    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  public static String getRandomNumber() {

    return String.format("%s", getRandomInt(1111111111, Integer.MAX_VALUE - 1));

  }

  public static String getRandomDateOfBirthDay() {

    Date fakerDateOfBirth = faker.date().birthday();
    SimpleDateFormat formatDay = new SimpleDateFormat("dd", Locale.ENGLISH);
    String day = formatDay.format(fakerDateOfBirth);

    return day;

  }

  public static String getRandomDateOfBirthMounth() {

    Date fakerDateOfBirth = faker.date().birthday();
    SimpleDateFormat formatMounth = new SimpleDateFormat("MMMMM", Locale.ENGLISH);
    String mouth = formatMounth.format(fakerDateOfBirth);

    return mouth;

  }

  public static String getRandomDateOfBirthYear() {

    Date fakerDateOfBirth = faker.date().birthday();
    SimpleDateFormat formatYear = new SimpleDateFormat("yyyy", Locale.ENGLISH);
    String year = formatYear.format(fakerDateOfBirth);

    return year;

  }


  public static String getRandomGender() {
    String[] genders = {"Male", "Female", "Other"};

    return getRandomItemFromArray(genders);

  }

  public static String getRandomItemFromArray(String[] array) {

    int index = getRandomInt(0, array.length - 1);

    return array[index];

  }

  public static String getRandomHobby() {
    String[] hobbies = {"Sports", "Reading", "Music"};

    return getRandomItemFromArray(hobbies);

  }

  public static String getRandomSubject() {
    String[] subjects = {"Maths", "Accounting", "Arts", "Social Studies"};

    return getRandomItemFromArray(subjects);

  }

  public static String getRandomState() {
    String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    return getRandomItemFromArray(states);

  }

  public static String getRandomCity(String state) {
    if (state.equals("NCR")) {

      String[] cities = {"Delhi", "Gurgaon", "Noida"};

      return getRandomItemFromArray(cities);

    } else if (state.equals("Uttar Pradesh")) {

      String[] cities = {"Agra", "Lucknow", "Merrut"};

      return getRandomItemFromArray(cities);

    } else if (state.equals("Haryana")) {

      String[] cities = {"Karnal", "Panipat"};

      return getRandomItemFromArray(cities);

    } else {

      String[] cities = {"Jaipur", "Jaiselmer"};

      return getRandomItemFromArray(cities);

    }
  }

  public static String getRandomAddress() {

    return faker.address().streetAddress();

  }
}
