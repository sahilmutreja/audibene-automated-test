package com.audibene.web;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class WindowTabTest extends BaseTest {

  @Test
  public void windowTabTest() {
    int totalOpenWindows =
        new WindowTabPage(driver).open().clickOpenNewWindowLink().getTotalOpenWindows();
    assertThat("New window is not opened", totalOpenWindows, greaterThan(1));
  }
}
