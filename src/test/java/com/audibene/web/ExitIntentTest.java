package com.audibene.web;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExitIntentTest extends BaseTest {

  @Test
  public void checkExitIntentIsVisible() {
    boolean isExitIntentVisible = new ExitIntentPage(driver).open().isExitIntentVisible();
    assertThat("Exit intent is not visible", isExitIntentVisible, is(Boolean.TRUE));
  }
}
