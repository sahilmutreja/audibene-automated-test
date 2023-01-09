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
                if (System.getProperty("profileId", "remote").equals("local")) {
                    System.out.println("Local Execution");
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                } else {
                    try {
                        System.out.println("Remote Execution");
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                        String hubHost = System.getProperty("HUB_HOST");
                        String gridURL = String.format("http://%s:4444/wd/hub", hubHost);
                        System.out.println("Grid URL for chrome = " + gridURL);
                        webDriver = new RemoteWebDriver(new URL(gridURL), chromeOptions);
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
                if (System.getProperty("profileId", "remote").equals("local")) {
                    System.out.println("Local Execution");
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                } else {
                    try {
                        System.out.println("Remote Execution");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                        String hubHost = System.getProperty("HUB_HOST");
                        String gridURL = String.format("http://%s:4444/wd/hub", hubHost);
                        System.out.println("Grid URL for firefox execution = " + gridURL);
                        webDriver = new RemoteWebDriver(new URL(gridURL), firefoxOptions);
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
