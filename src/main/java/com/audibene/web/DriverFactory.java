package com.audibene.web;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.audibene.ConfigHelper.getGridUrl;

public class DriverFactory {

  enum browserType {
    CHROME {
      public WebDriver getDriver() {
        RemoteWebDriver webDriver = null;
        try {
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
          webDriver = new RemoteWebDriver(new URL(getGridUrl()), chromeOptions);
        } catch (MalformedURLException e) {
          e.printStackTrace();
        }
        return webDriver;
      }
    },
    FIREFOX {
      public WebDriver getDriver() {
        RemoteWebDriver driver = null;
        try {
          FirefoxOptions firefoxOptions = new FirefoxOptions();
          firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
          driver = new RemoteWebDriver(new URL(getGridUrl()), new FirefoxOptions());
        } catch (MalformedURLException e) {
          e.printStackTrace();
        }
        return driver;
      }
    };

    public abstract WebDriver getDriver();
  }

  public static WebDriver getDriver(String browserName) {
    return browserType.valueOf(browserName.toUpperCase()).getDriver();
  }
}
