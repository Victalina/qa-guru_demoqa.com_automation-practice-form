package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class RegistrationWithRandomUtilsTests extends TestBase {
  RegistrationPage registrationPage = new RegistrationPage();

  @Test
  void successFullRegistrationTest() {

    registrationPage.openPage()
            .removeBanners()
            .setFirstName(firstName)
            .setLastName(TestData.lastName)
            .setEmail(email)
            .setGender(gender)
            .setUserNumber(userNumber)
            .setDateOfBirth(day, mounth, year)
            .setSubjects(subject)
            .setHobbies(hobby)
            .setPicture(picture)
            .setAddress(address)
            .setState(state)
            .setCity(city)
            .submit()
            .checkFormAppears()
            .checkResultValue("Student Name", firstName + " " + lastName)
            .checkResultValue("Student Email", email)
            .checkResultValue("Gender", gender)
            .checkResultValue("Mobile", userNumber)
            .checkResultValue("Date of Birth", day + " " + mounth + "," + year)
            .checkResultValue("Subjects", subject)
            .checkResultValue("Hobbies", hobby)
            .checkResultValue("Picture", picture)
            .checkResultValue("Address", address)
            .checkResultValue("State and City", state + " " + city);
  }

  @Test
  void successRegistrationRequiredFieldsTest() {

    registrationPage.openPage()
            .removeBanners()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .setGender(gender)
            .setUserNumber(userNumber)
            .setDateOfBirth(day, mounth, year)
            .setHobbies(hobby)
            .setAddress(address)
            .submit()
            .checkFormAppears()
            .checkResultValue("Student Name", firstName + " " + lastName)
            .checkResultValue("Student Email", email)
            .checkResultValue("Gender", gender)
            .checkResultValue("Mobile", userNumber)
            .checkResultValue("Date of Birth", day + " " + mounth + "," + year)
            .checkResultValue("Hobbies", hobby)
            .checkResultValue("Address", address);
  }

  @Test
  void UnsuccessfulRegistrationWithoutRequiredFieldsTest() {

    registrationPage.openPage()
            .removeBanners()
            .setFirstName(firstName)
            .setLastName(lastName)
            .submit()
            .checkFormNotAppears();
  }
}
