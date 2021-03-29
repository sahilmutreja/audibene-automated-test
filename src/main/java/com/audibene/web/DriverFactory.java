package com.audibene.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

  enum browserType {
    CHROME {
      public WebDriver getDriver() {
        WebDriver webDriver = null;
        if (System.getProperty("profileId").equals("local")) {
          WebDriverManager.chromedriver().setup();
          webDriver = new ChromeDriver();
        } else {
          try {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            webDriver = new RemoteWebDriver(new URL(System.getProperty("gridUrl")), chromeOptions);
          } catch (MalformedURLException e) {
            e.printStackTrace();
          }
        }
        return webDriver;
      }
    },
    FIREFOX {
      public WebDriver getDriver() {
        WebDriver webDriver = null;
        if (System.getProperty("profileId").equals("local")) {
          WebDriverManager.firefoxdriver().setup();
          webDriver = new FirefoxDriver();
        } else {
          try {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            webDriver =
                new RemoteWebDriver(new URL(System.getProperty("gridUrl")), new FirefoxOptions());
          } catch (MalformedURLException e) {
            e.printStackTrace();
          }
        }
        return webDriver;
      }
    };

    public abstract WebDriver getDriver();
  }

  public static WebDriver getDriver(String browserName) {
    return browserType.valueOf(browserName.toUpperCase()).getDriver();
  }
}
