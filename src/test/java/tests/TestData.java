package tests;

import static utils.RandomUtils.*;

public class TestData {
  public static String firstName = getRandomFirstName(),
          lastName = getRandomLastName(),
          email = getRandomEmail(),
          gender = getRandomGender(),
          userNumber = getRandomNumber(),
          day = getRandomDateOfBirthDay(),
          mounth = getRandomDateOfBirthMounth(),
          year = getRandomDateOfBirthYear(),
          subject = getRandomSubject(),
          hobby = getRandomHobby(),
          picture = "test.png",
          address = getRandomAddress(),
          state = getRandomState(),
          city = getRandomCity(state);
}
