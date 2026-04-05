package com.fdmgroup.RealEstateApp;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.RequestOptions;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaywrightApiTest {
    static Playwright playwright;
    static APIRequestContext request;

    @BeforeAll
    static void setUp() {
        playwright = Playwright.create();
        request = playwright.request().newContext(
                new APIRequest.NewContextOptions()
                        .setBaseURL("http://localhost:8081/propertyProjectEstate"));
    }

    @AfterAll
    static void tearDown() {
        request.dispose();
        playwright.close();
    }

    @Test
    void actuatorHealthShouldBeUp() {
        APIResponse response = request.get("http://localhost:8081/propertyProjectEstate/actuator/health");

        assertEquals(200, response.status());
        assertTrue(response.text().contains("UP"));
    }
}