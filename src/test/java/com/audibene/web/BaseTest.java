package com.audibene.web;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
  protected RemoteWebDriver driver;

  @Parameters({"browser"})
  @BeforeMethod
  public void setUp(String browser) {
    driver = (RemoteWebDriver) DriverFactory.getDriver(browser);
    driver.manage().window().maximize();
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
