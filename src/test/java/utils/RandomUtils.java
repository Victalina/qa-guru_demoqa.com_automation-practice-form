package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

  Faker faker = new Faker();

  public String getRandomFirstName() {

    return faker.name().firstName();

  }

  public String getRandomLastName() {

    return faker.name().lastName();

  }

  public String getRandomEmail() {

    return faker.internet().safeEmailAddress();

  }

  public int getRandomInt(int min, int max) {

    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  public String getRandomNumber() {

    return String.format("%s", getRandomInt(1111111111, Integer.MAX_VALUE - 1));

  }

  public String getRandomDateOfBirthDay() {

    Date fakerDateOfBirth = faker.date().birthday();
    SimpleDateFormat formatDay = new SimpleDateFormat("dd", Locale.ENGLISH);

    return formatDay.format(fakerDateOfBirth);

  }

  public String getRandomDateOfBirthMonth() {

    Date fakerDateOfBirth = faker.date().birthday();
    SimpleDateFormat formatMonth = new SimpleDateFormat("MMMMM", Locale.ENGLISH);

    return formatMonth.format(fakerDateOfBirth);

  }

  public String getRandomDateOfBirthYear() {

    Date fakerDateOfBirth = faker.date().birthday();
    SimpleDateFormat formatYear = new SimpleDateFormat("yyyy", Locale.ENGLISH);

    return formatYear.format(fakerDateOfBirth);

  }


  public String getRandomGender() {
    String[] genders = {"Male", "Female", "Other"};

    return faker.options().option(genders);

  }

  public String getRandomHobby() {
    String[] hobbies = {"Sports", "Reading", "Music"};

    return faker.options().option(hobbies);

  }

  public String getRandomSubject() {
    String[] subjects = {"Maths", "Accounting", "Arts", "Social Studies"};

    return faker.options().option(subjects);

  }

  public String getRandomState() {
    String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    return faker.options().option(states);

  }

  public String getRandomCity(String state) {

    return switch (state) {
      case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
      case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
      case "Haryana" -> faker.options().option("Karnal", "Panipat");
      case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
      default -> "";
    };
  }

  public String getRandomAddress() {

    return faker.address().streetAddress();

  }
}
