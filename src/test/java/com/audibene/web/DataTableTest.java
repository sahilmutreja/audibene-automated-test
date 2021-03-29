package com.audibene.web;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.audibene.web.data.Columns.FIRST_NAME;
import static com.audibene.web.data.Columns.LAST_NAME;
import static com.audibene.web.data.Tables.TABLE1;
import static com.audibene.web.data.Tables.TABLE2;
import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DataTableTest extends BaseTest {
  public static final String SORT_FAILURE_MESSAGE = "%s is not in sorted order by %s column";
  public static final String REVERSE_SORT_FAILURE_MESSAGE =
      "%s is not in reverse sorted order by %s column";

  @Test
  public void sortTable1Test() {
    DataTablePage dataTablePage = new DataTablePage(driver).open();
    List<String> oldColumnValues =
        dataTablePage.sortTable(TABLE1, FIRST_NAME).getColumnValues(TABLE1, FIRST_NAME);
    List<String> sortedValues = oldColumnValues;
    Collections.sort(sortedValues);
    assertThat(
        format(SORT_FAILURE_MESSAGE, TABLE1, FIRST_NAME), oldColumnValues, equalTo(sortedValues));
  }

  @Test
  public void reverseSortTable2Test() {
    DataTablePage dataTablePage = new DataTablePage(driver).open();
    List<String> oldColumnValues =
        dataTablePage.reverseSortTable(TABLE2, LAST_NAME).getColumnValues(TABLE2, LAST_NAME);
    List<String> reverseSortedValues = oldColumnValues;
    Collections.sort(reverseSortedValues, Comparator.reverseOrder());
    assertThat(
        format(REVERSE_SORT_FAILURE_MESSAGE, TABLE2, LAST_NAME),
        oldColumnValues,
        equalTo(reverseSortedValues));
  }
}
