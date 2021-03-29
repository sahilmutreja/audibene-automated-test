package com.audibene.web;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
  protected WebDriver driver;

  @Parameters({"browser"})
  @BeforeMethod
  public void setUp(String browser) {
    driver = DriverFactory.getDriver(browser);
    driver.manage().window().maximize();
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
