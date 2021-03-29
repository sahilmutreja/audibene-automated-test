package com.audibene.web;

import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static com.audibene.ConfigHelper.getWebBaseUrl;

@NoArgsConstructor
public class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;

  protected BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(this.driver, 10000, 500);
  }

  protected static String getPageUrl(String path) {
    return getWebBaseUrl().concat(path);
  }

  public void clearAndFill(WebElement element, String text) {
    element.clear();
    element.sendKeys(text);
  }

  protected Boolean waitForCondition(
      BooleanSupplier expectedCondition, Supplier<String> errorMessage) {
    return (new WebDriverWait(this.driver, 5000, 500))
        .withMessage(errorMessage)
        .until((webDriver) -> expectedCondition.getAsBoolean());
  }
}
