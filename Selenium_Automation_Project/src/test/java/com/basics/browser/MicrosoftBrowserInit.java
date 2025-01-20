package com.basics.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MicrosoftBrowserInit {

    WebDriver driver;
    @BeforeSuite
    public void openBrowser(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void openURL() throws InterruptedException {
        driver.get("https://mvnrepository.com/");
        Thread.sleep(15000);
    }
    @AfterSuite
    public void closeBrowser(){
        driver.close();
    }
}
