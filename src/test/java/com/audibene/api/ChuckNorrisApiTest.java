package com.audibene.api;

import com.audibene.api.client.JokesClient;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.audibene.api.RestAssuredHelper.statusMatcherFor;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class ChuckNorrisApiTest {
  private String[] categoryList;

  @Test(description = "Test to get all the categories")
  public void getCategoriesTest() {
    categoryList =
        new JokesClient()
            .getCategories()
            .then()
            .statusCode(statusMatcherFor(HttpStatus.SC_OK, "Get categories"))
            .and()
            .assertThat()
            .body("size()", greaterThanOrEqualTo(1))
            .extract()
            .as(String[].class);
  }

  @Test(description = "Test to search a specific category", dependsOnMethods = "getCategoriesTest")
  public void searchCategoriesTest() {
    String category = categoryList[0];
    new JokesClient()
        .searchCategory(category)
        .then()
        .statusCode(statusMatcherFor(HttpStatus.SC_OK, "Search category"))
        .and()
        .body("result.value", everyItem(containsStringIgnoringCase(category)));
  }
}
