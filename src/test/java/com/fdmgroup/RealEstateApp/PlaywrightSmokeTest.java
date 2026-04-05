package com.fdmgroup.RealEstateApp;

import java.nio.file.Paths;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlaywrightSmokeTest {

    static Playwright playwright;
    static Browser browser;

    @BeforeAll
    static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
                        .setSlowMo(500));
    }

    @AfterAll
    static void tearDown() {
        browser.close();
        playwright.close();
    }

    @Test
    void homePageLoads() {
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        page.navigate("http://localhost:8081/propertyProjectEstate");

        assertTrue(page.url().contains("propertyProjectEstate"));
        page.screenshot(
                new Page.ScreenshotOptions().setPath(Paths.get("screenshots/test.png")));
        context.close();
    }

    @Test
    void homePageLoads_withVideo() {
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions()
                        .setRecordVideoDir(Paths.get("videos/")));

        Page page = context.newPage();

        page.navigate("http://localhost:8081/propertyProjectEstate");
        context.close();
    }

}
