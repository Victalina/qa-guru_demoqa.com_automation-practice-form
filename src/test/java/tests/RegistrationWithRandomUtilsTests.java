package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithRandomUtilsTests extends TestBase {
  RegistrationPage registrationPage = new RegistrationPage();
  TestData testData = new TestData();

  @Test
  void successFullRegistrationTest() {

    registrationPage.openPage()
            .removeBanners()
            .setFirstName(testData.firstName)
            .setLastName(testData.lastName)
            .setEmail(testData.email)
            .setGender(testData.gender)
            .setUserNumber(testData.userNumber)
            .setDateOfBirth(testData.day, testData.month, testData.year)
            .setSubjects(testData.subject)
            .setHobbies(testData.hobby)
            .setPicture(testData.picture)
            .setAddress(testData.address)
            .setState(testData.state)
            .setCity(testData.city)
            .submit()
            .checkFormAppears()
            .checkResultValue("Student Name", testData.firstName + " " + testData.lastName)
            .checkResultValue("Student Email", testData.email)
            .checkResultValue("Gender", testData.gender)
            .checkResultValue("Mobile", testData.userNumber)
            .checkResultValue("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
            .checkResultValue("Subjects", testData.subject)
            .checkResultValue("Hobbies", testData.hobby)
            .checkResultValue("Picture", testData.picture)
            .checkResultValue("Address", testData.address)
            .checkResultValue("State and City", testData.state + " " + testData.city);
  }

  @Test
  void successRegistrationRequiredFieldsTest() {

    registrationPage.openPage()
            .removeBanners()
            .setFirstName(testData.firstName)
            .setLastName(testData.lastName)
            .setEmail(testData.email)
            .setGender(testData.gender)
            .setUserNumber(testData.userNumber)
            .setDateOfBirth(testData.day, testData.month, testData.year)
            .setHobbies(testData.hobby)
            .setAddress(testData.address)
            .submit()
            .checkFormAppears()
            .checkResultValue("Student Name", testData.firstName + " " + testData.lastName)
            .checkResultValue("Student Email", testData.email)
            .checkResultValue("Gender", testData.gender)
            .checkResultValue("Mobile", testData.userNumber)
            .checkResultValue("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
            .checkResultValue("Hobbies", testData.hobby)
            .checkResultValue("Address", testData.address);
  }

  @Test
  void UnsuccessfulRegistrationWithoutRequiredFieldsTest() {

    registrationPage.openPage()
            .removeBanners()
            .setFirstName(testData.firstName)
            .setLastName(testData.lastName)
            .submit()
            .checkFormNotAppears();
  }
}
