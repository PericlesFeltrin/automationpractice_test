package com.periclesfeltrin.web.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void preCondicao() {
        Driver driver = new Driver();
        driver.getHomePage("http://automationpractice.com/");
        this.driver = driver.getDriver();
    }

    @AfterMethod
    public void posCondicao() {
        driver.quit();
    }
}