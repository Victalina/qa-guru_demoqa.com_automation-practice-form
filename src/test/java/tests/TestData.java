package tests;

import utils.RandomUtils;

public class TestData {
  RandomUtils randomUtils = new RandomUtils();
  public String firstName = randomUtils.getRandomFirstName(),
          lastName = randomUtils.getRandomLastName(),
          email = randomUtils.getRandomEmail(),
          gender = randomUtils.getRandomGender(),
          userNumber = randomUtils.getRandomNumber(),
          day = randomUtils.getRandomDateOfBirthDay(),
          month = randomUtils.getRandomDateOfBirthMonth(),
          year = randomUtils.getRandomDateOfBirthYear(),
          subject = randomUtils.getRandomSubject(),
          hobby = randomUtils.getRandomHobby(),
          picture = "test.png",
          address = randomUtils.getRandomAddress(),
          state = randomUtils.getRandomState(),
          city = randomUtils.getRandomCity(state);
}
