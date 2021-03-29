package com.audibene.web;

import org.testng.annotations.Test;

import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogOutTest extends BaseTest {

  @Test
  public void logOut() {
    new LoginPage(driver).open().login("tomsmith", "SuperSecretPassword!");
    new SecurePage(driver).logOut();
    assertThat("Logout was not successful", driver.getCurrentUrl().contains("login"), is(TRUE));
  }
}
