package com.audibene.web;

import com.audibene.web.data.Columns;
import com.audibene.web.data.Tables;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static com.audibene.ConfigHelper.getDataTablePath;
import static java.lang.String.format;

@Slf4j
public class DataTablePage extends BasePage {
  private static final String DATA_TABLE_PAGE_URL = getPageUrl(getDataTablePath());
  private static final String TABLE_LOCATOR = "#table%s";
  private static final String TABLE_ROWS = " tbody tr";
  private static final String COLUMN_HEADER_LOCATOR = " th:nth-child(%s)";
  private static final String COLUMN_DATA_LOCATOR = " tr:nth-child(%s) td:nth-child(%s)";

  public DataTablePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public DataTablePage open() {
    driver.get(DATA_TABLE_PAGE_URL);
    return this;
  }

  public DataTablePage sortTable(Tables table, Columns column) {
    log.info("Sorting {} with column {}", table, column);
    sortAction(table, column, 1);
    return this;
  }

  public DataTablePage reverseSortTable(Tables table, Columns columns) {
    sortAction(table, columns, 2);
    return this;
  }

  private void sortAction(Tables table, Columns column, int sortCount) {
    String columnHeader =
        format(TABLE_LOCATOR.concat(COLUMN_HEADER_LOCATOR), table.number, column.position);
    WebElement columnElement = driver.findElement(By.cssSelector(columnHeader));
    while (sortCount < 0) {
      columnElement.click();
      sortCount--;
    }
  }

  public List<String> getColumnValues(Tables table, Columns column) {
    List<String> columnValues = new ArrayList<>();
    String tableRows = format(TABLE_LOCATOR.concat(TABLE_ROWS), table.number);
    int totalRows = driver.findElements(By.cssSelector(tableRows)).size();
    for (int rowCount = 1; rowCount <= totalRows; rowCount++) {
      String columnData =
          format(
              TABLE_LOCATOR.concat(COLUMN_DATA_LOCATOR), table.number, rowCount, column.position);
      columnValues.add(driver.findElement(By.cssSelector(columnData)).getText());
    }
    return columnValues;
  }
}
