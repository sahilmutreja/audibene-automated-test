package com.audibene.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePage {
  private final By successMessage = By.cssSelector("[id='flash'][class*='success']");
  private final By btnLogOut = By.cssSelector("a[class*='button']");

  public SecurePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public boolean isSuccessMessageVisible() {
    return driver.findElement(successMessage).isDisplayed();
  }

  public LoginPage logOut() {
    driver.findElement(btnLogOut).click();
    return new LoginPage(driver);
  }
}
