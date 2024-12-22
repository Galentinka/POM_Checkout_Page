package com.tutorialsNinja.TestBase;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;
    public Properties prop;
    public FileInputStream ip;

    public TestBase() throws Exception {
        prop = new Properties();
        ip = new FileInputStream(
                "C:\\Users\\Admin\\IdeaProjects\\POM_CheckoutPage\\src\\test\\java\\com\\tutorialsNinja\\Properties\\testData.properties");
        prop.load(ip);
    }

    public WebDriver initializeBrowser() {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        //options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
        driver.get("https://tutorialsninja.com/demo/");

        return driver;
    }
}
