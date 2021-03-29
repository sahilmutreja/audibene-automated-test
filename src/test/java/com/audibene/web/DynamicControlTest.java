package com.audibene.web;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DynamicControlTest extends BaseTest {
  private static final String message = "Happy Easter Weekend - in advance :)";

  @Test()
  public void dynamicControlTest() {
    DynamicControlPage dynamicControlPage =
        new DynamicControlPage(driver)
            .open()
            .enableTextField()
            .waitForProgressBarToDisappear()
            .enterValue(message)
            .disableTextField()
            .waitForProgressBarToDisappear();
    assertThat(
        "Input field does not have the message",
        dynamicControlPage.getTextFieldValue(),
        is(message));
  }
}
