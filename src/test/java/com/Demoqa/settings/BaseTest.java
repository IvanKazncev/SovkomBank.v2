package com.Demoqa.settings;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

abstract public class BaseTest {
    static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }

    @BeforeAll
    static void init() {
        setUp();
    }

    @AfterAll
    static void tearDown() {
        Selenide.closeWebDriver();
    }
}