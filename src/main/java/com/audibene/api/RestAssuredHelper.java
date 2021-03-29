package com.audibene.api;

import lombok.NoArgsConstructor;
import org.hamcrest.Matcher;

import static lombok.AccessLevel.PRIVATE;
import static org.hamcrest.CoreMatchers.describedAs;
import static org.hamcrest.CoreMatchers.is;

@NoArgsConstructor(access = PRIVATE)
public class RestAssuredHelper {
    private static final String REQUEST_FAILED_MESSAGE =
            "assertion failed. %s request failed, please check the logs. Expected the HTTP status code <%s>";

    public static Matcher<Integer> statusMatcherFor(int httpCode, String requestDescription) {
        return describedAs(
                String.format(REQUEST_FAILED_MESSAGE, requestDescription, httpCode), is(httpCode));
    }
}
