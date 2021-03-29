package com.audibene.web;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.audibene.ConfigHelper.getExitIntentPath;

@Slf4j
public class ExitIntentPage extends BasePage {
  private static final String EXIT_INTENT_PAGE_URL = getPageUrl(getExitIntentPath());
  private final By exitIntentHeader = By.cssSelector(".example>h3");

  public ExitIntentPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public ExitIntentPage open() {
    driver.get(EXIT_INTENT_PAGE_URL);
    return this;
  }

  public boolean isExitIntentVisible() {
    log.info("Checking if exit intent is visible");
    return driver.findElement(exitIntentHeader).isDisplayed();
  }
}
