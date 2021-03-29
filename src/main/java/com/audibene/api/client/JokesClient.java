package com.audibene.api.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import static com.audibene.ConfigHelper.getApiBaseUrl;
import static com.audibene.ConfigHelper.getCategoriesPath;
import static com.audibene.ConfigHelper.getJokesPath;
import static com.audibene.ConfigHelper.getSearchPath;
import static io.restassured.RestAssured.given;

@Slf4j
@NoArgsConstructor
public class JokesClient {

  public RequestSpecification getJokesSpecification() {
    return new RequestSpecBuilder().setBaseUri(getApiBaseUrl()).setBasePath(getJokesPath()).build();
  }

  public Response getCategories() {
    log.info("Requesting all the categories");
    return given().spec(getJokesSpecification()).get(getCategoriesPath());
  }

  public Response searchCategory(@NonNull String category) {
    log.info("Searching for category {}", category);
    return given()
        .spec(getJokesSpecification())
        .queryParams("query", category)
        .get(getSearchPath());
  }
}
