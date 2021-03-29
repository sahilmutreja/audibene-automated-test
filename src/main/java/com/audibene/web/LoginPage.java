package com.audibene.web;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static com.audibene.ConfigHelper.getLoginPath;

@Slf4j
public class LoginPage extends BasePage {
  private static final String LOGIN_PAGE_URL = getPageUrl(getLoginPath());
  private final By txtUserName = By.id("username");
  private final By txtPassword = By.id("password");
  private final By btnSubmit = By.cssSelector("#login>button");
  private final By errorMessage = By.cssSelector("[id='flash'][class*='error']");

  public LoginPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public LoginPage open() {
    driver.get(LOGIN_PAGE_URL);
    return this;
  }

  public LoginPage fillUserName(String text) {
    clearAndFill(driver.findElement(txtUserName), text);
    return this;
  }

  public LoginPage fillPassword(String text) {
    clearAndFill(driver.findElement(txtPassword), text);
    return this;
  }

  public void submit() {
    driver.findElement(btnSubmit).click();
  }

  public void login(String userText, String passwordText) {
    fillUserName(userText).fillPassword(passwordText).submit();
  }

  public Boolean isErrorMessageDisplayed() {
    log.info("Waiting for error message to be displayed");
    BooleanSupplier expectedCondition = () -> driver.findElement(errorMessage).isDisplayed();
    Supplier<String> errorMessage = () -> "Error Message is not displayed";
    return waitForCondition(expectedCondition, errorMessage);
  }
}
