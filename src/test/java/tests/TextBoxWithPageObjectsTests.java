package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
public class TextBoxWithPageObjectsTests extends TestBase{

  TextBoxPage textBoxPage = new TextBoxPage();

  @Test
  void fillFormTest() {
    textBoxPage.openPage()
            .setUserName("Victoria")
            .setEmailName("victoria@mail.com")
            .setCurrentAddress("Some street 1")
            .setPermanentAddress("Another street 1")
            .submit()
            .checkNameResultValue("Victoria")
            .checkEmailResultValue("victoria@mail.com")
            .checkCurrentAddressResultValue("Some street 1")
            .checkPermanentAddressResultValue("Another street 1");
  }
}
