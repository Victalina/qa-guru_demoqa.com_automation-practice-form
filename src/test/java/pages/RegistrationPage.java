package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultModelDialogComponent;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

  private final SelenideElement firstNameInput = $("#firstName"),
          lastNameInput = $("#lastName"),
          userEmailInput = $("#userEmail"),
          genterWrapper = $("#genterWrapper"),
          userNumberInput = $("#userNumber"),
          calendarInput = $("#dateOfBirthInput"),
          subjectsInput = $("#subjectsInput"),
          hobbiesWrapper = $("#hobbiesWrapper"),
          uploadPicture = $("#uploadPicture"),
          currentAddressInput = $("#currentAddress"),
          stateInput = $("#state"),
          stateCityWrapper = $("#stateCity-wrapper"),
          cityInput = $("#city"),
          submit = $("#submit"),
          modalDialog = $(".modal-dialog"),
          exampleModalSizesTitleLg = $("#example-modal-sizes-title-lg");

  CalendarComponent calendarComponent = new CalendarComponent();
  ResultModelDialogComponent resultModelDialogComponent = new ResultModelDialogComponent();


  public RegistrationPage openPage(){
    open("/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

    return this;
  }

  public RegistrationPage removeBanners(){
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");

    return this;
  }

  public RegistrationPage setFirstName(String value){
    firstNameInput.setValue(value);

    return this;
  }

  public RegistrationPage setLastName(String value){
    lastNameInput.setValue(value);

    return this;
  }

  public RegistrationPage setEmail(String value){
    userEmailInput.setValue(value);

    return this;
  }

  public RegistrationPage setGender(String value){
    genterWrapper.$(byText(value)).click();

    return this;
  }

  public RegistrationPage setUserNumber(String value){
    userNumberInput.setValue(value);

    return this;
  }

  public RegistrationPage setDateOfBirth(String day, String month, String year){
    calendarInput.click();
    calendarComponent.setDate(day,month,year);

    return this;
  }

  public RegistrationPage setSubjects(String value){
    subjectsInput.setValue(value).pressEnter();

    return this;
  }

  public RegistrationPage setHobbies(String value){
    hobbiesWrapper.$(byText(value)).click();

    return this;
  }

  public RegistrationPage setPicture(String img){
    uploadPicture.uploadFromClasspath(img);

    return this;
  }

  public RegistrationPage setAddress(String value){
    currentAddressInput.setValue(value);

    return this;
  }

  public RegistrationPage setState(String value){
    stateInput.click();
    stateCityWrapper.$(byText(value)).click();

    return this;
  }

  public RegistrationPage setCity(String value){
    cityInput.click();
    stateCityWrapper.$(byText(value)).click();

    return this;
  }

  public RegistrationPage submit(){
    submit.click();

    return this;
  }

  public RegistrationPage checkFormAppears(){
    modalDialog.should(appear);
    exampleModalSizesTitleLg.shouldHave(text("Thanks for submitting the form"));

    return this;
  }

  public RegistrationPage checkFormNotAppears(){
    modalDialog.shouldNot(appear);

    return this;
  }

  public RegistrationPage checkResultValue(String key, String value){

    resultModelDialogComponent.checkResultValue(key, value);

    return this;
  }

}
