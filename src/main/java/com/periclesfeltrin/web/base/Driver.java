package com.periclesfeltrin.web.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Driver{

    protected static WebDriver driver;

    public Driver() {
        driver = setChrome();
    }

    public static String getOS() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.indexOf("win") >= 0) {
            return "win";
        }else if (os.indexOf("mac") >= 0) {
            return "mac";
        }

        return "linux";
    }

    public static WebDriver setChrome() {
        switch (getOS()) {
            case "mac":
                System.setProperty("webdriver.chrome.driver","drivers//chromedriver_mac");
                break;
            case "linux":
                System.setProperty("webdriver.chrome.driver","drivers//chromedriver_linux");
                break;
            default:
                System.setProperty("webdriver.chrome.driver","drivers//chromedriver.exe");
                break;
        }
        return new ChromeDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void getHomePage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

    }

}
