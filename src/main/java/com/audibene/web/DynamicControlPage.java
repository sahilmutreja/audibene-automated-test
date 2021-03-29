package com.audibene.web;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static com.audibene.ConfigHelper.getDynamicControlPath;

@Slf4j
public class DynamicControlPage extends BasePage {
  public static final String DYNAMIC_CONTROL_PAGE_URL = getPageUrl(getDynamicControlPath());
  private final By inputExampleButton = By.cssSelector("#input-example>button");
  private final By inputExampleText = By.cssSelector("#input-example>input[type='text']");
  private final By progressBar = By.id("loading");

  public DynamicControlPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public DynamicControlPage open() {
    driver.get(DYNAMIC_CONTROL_PAGE_URL);
    return this;
  }

  public DynamicControlPage enableTextField() {
    log.info("Clicking enable button for text field if it is already disabled");
    WebElement textField = driver.findElement(inputExampleText);
    if (!textField.isEnabled()) driver.findElement(inputExampleButton).click();
    return this;
  }

  public DynamicControlPage waitForProgressBarToDisappear() {
    log.info("Waiting for text field to be enabled");
    BooleanSupplier expectedCondition = () -> !driver.findElement(progressBar).isDisplayed();
    Supplier<String> errorMessage = () -> "Text field display status not changed";
    waitForCondition(expectedCondition, errorMessage);
    return this;
  }

  public DynamicControlPage enterValue(String message) {
    driver.findElement(inputExampleText).sendKeys(message);
    return this;
  }

  public DynamicControlPage disableTextField() {
    log.info("Clicking disable button for text field");
    WebElement textField = driver.findElement(inputExampleButton);
    if (textField.isEnabled()) driver.findElement(inputExampleButton).click();
    return this;
  }

  public String getTextFieldValue() {
    return driver.findElement(inputExampleText).getAttribute("value");
  }
}
