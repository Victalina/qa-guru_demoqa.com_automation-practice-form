package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {
  RegistrationPage registrationPage = new RegistrationPage();

  @Test
  void successFullRegistrationTest() {

    registrationPage.openPage()
            .setFirstName("Victoria")
            .setLastName("Test")
            .setEmail("victoria@mail.com")
            .setGender("Female")
            .setUserNumber("7458521458")
            .setDateOfBirth("14", "April", "2000")
            .setSubjects("Accounting")
            .setHobbies("Sports")
            .setPicture("test.png")
            .setAddress("Some street 1")
            .setState("NCR")
            .setCity("Delhi")
            .submit()
            .checkFormAppears()
            .checkResultValue("Student Name", "Victoria Test")
            .checkResultValue("Student Email", "victoria@mail.com")
            .checkResultValue("Gender", "Female")
            .checkResultValue("Mobile", "7458521458")
            .checkResultValue("Date of Birth", "14 April,2000")
            .checkResultValue("Subjects", "Accounting")
            .checkResultValue("Hobbies", "Sports")
            .checkResultValue("Picture", "test.png")
            .checkResultValue("Address", "Some street 1")
            .checkResultValue("State and City", "NCR Delhi");
  }

  @Test
  void successRegistrationRequiredFieldsTest() {

    registrationPage.openPage()
            .setFirstName("John")
            .setLastName("Smith")
            .setEmail("john@mail.com")
            .setGender("Male")
            .setUserNumber("7458521000")
            .setDateOfBirth("05", "March", "1990")
            .setHobbies("Reading")
            .setAddress("Some street 2")
            .submit()
            .checkFormAppears()
            .checkResultValue("Student Name", "John Smith")
            .checkResultValue("Student Email", "john@mail.com")
            .checkResultValue("Gender", "Male")
            .checkResultValue("Mobile", "7458521000")
            .checkResultValue("Date of Birth", "5 March,1990")
            .checkResultValue("Hobbies", "Reading")
            .checkResultValue("Address", "Some street 2");
  }

  @Test
  void UnsuccessfulRegistrationWithoutRequiredFieldsTest() {

    registrationPage.openPage()
            .setFirstName("Mike")
            .setLastName("Green")
            .submit()
            .checkFormNotAppears();
  }
}
