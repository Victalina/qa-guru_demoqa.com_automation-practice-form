package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

  @BeforeAll
  static void beforeAll(){
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
 //   Configuration.browser = "chrome";
 //   Configuration.timeout = 10000;
    Configuration.pageLoadStrategy = "eager";
//    Configuration.holdBrowserOpen = true;
  }

  @AfterEach
  void teardown(){
    closeWebDriver();
  }
}
