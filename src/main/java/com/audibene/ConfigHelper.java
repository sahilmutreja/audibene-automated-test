package com.audibene;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ConfigHelper {
  private static final String CONFIG_FILE_NAME = "config.properties";
  public static final String API_BASE_URL = "apiBaseUrl";
  public static final String WEB_BASE_URL = "webBaseUrl";
  public static final String JOKES_PATH = "jokes";
  public static final String CATEGORIES_PATH = "categories";
  public static final String SEARCH_PATH = "search";
  private static final String LOGIN_PATH = "login";
  private static final String EXIT_INTENT_PATH = "exit_intent";
  private static final String DATA_TABLE_PATH = "data_table";
  private static final String WINDOW_TAB_PATH = "window_tab";
  private static final String DYNAMIC_CONTROL_PATH = "dynamic_controls";

  private static String getConfigValue(String key) {
    Config config = ConfigFactory.load(CONFIG_FILE_NAME);
    return config.getString(key);
  }

  public static String getApiBaseUrl() {
    return getConfigValue(API_BASE_URL);
  }

  public static String getWebBaseUrl() {
    return getConfigValue(WEB_BASE_URL);
  }

  public static String getJokesPath() {
    return getConfigValue(JOKES_PATH);
  }

  public static String getCategoriesPath() {
    return getConfigValue(CATEGORIES_PATH);
  }

  public static String getSearchPath() {
    return getConfigValue(SEARCH_PATH);
  }

  public static String getLoginPath() {
    return getConfigValue(LOGIN_PATH);
  }

  public static String getExitIntentPath() {
    return getConfigValue(EXIT_INTENT_PATH);
  }

  public static String getDataTablePath() {
    return getConfigValue(DATA_TABLE_PATH);
  }

  public static String getWindowTabPath() {
    return getConfigValue(WINDOW_TAB_PATH);
  }

  public static String getDynamicControlPath() {
    return getConfigValue(DYNAMIC_CONTROL_PATH);
  }
}
