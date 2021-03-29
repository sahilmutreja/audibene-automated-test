package com.audibene.web;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static com.audibene.ConfigHelper.getDynamicControlPath;
import static com.audibene.ConfigHelper.getWindowTabPath;

@Slf4j
public class WindowTabPage extends BasePage {
  private static final String WINDOW_TAB_PAGE_URL = getPageUrl(getWindowTabPath());
  private final By newWindowLink = By.cssSelector("#content a");

  public WindowTabPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public WindowTabPage open() {
    driver.get(WINDOW_TAB_PAGE_URL);
    return this;
  }

  public WindowTabPage clickOpenNewWindowLink() {
    log.info("Clicking new window link");
    driver.findElement(newWindowLink).click();
    return this;
  }

  public int getTotalOpenWindows() {
    log.info("Waiting for new window/tab to be opened");
    BooleanSupplier expectedCondition =
        () -> new ArrayList<>(driver.getWindowHandles()).size() == 2;
    Supplier<String> errorMessage = () -> "New window/tab was not opened";
    waitForCondition(expectedCondition, errorMessage);
    return new ArrayList<>(driver.getWindowHandles()).size();
  }



}
