package com.audibene.web;

import org.testng.annotations.Test;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginTest extends BaseTest {

  @Test
  public void loginSuccess() {
    new LoginPage(driver)
            .open()
            .login("tomsmith", "SuperSecretPassword!");
    assertThat(
        "Login success message is not visible",
        new SecurePage(driver).isSuccessMessageVisible(),
        is(TRUE));
  }

  @Test
  public void loginFailure() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage
            .open()
            .login("tomsmith", "qwerty");
    assertThat(
        "Login failure message is not visible", loginPage.isErrorMessageDisplayed(), is(TRUE));
  }
}
