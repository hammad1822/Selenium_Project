package com.basics.browserCommand;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BrowserCommandExample {

    String url = "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";
    WebDriver driver;

    @BeforeSuite
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void getCurrentURL() throws InterruptedException {
        driver.get(url);
        Thread.sleep(6000);
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        if(url.equals(currentURL)){
            System.out.println("Current URL is same as Mentioned URL");
        }else{
            System.out.println("Not Same");
        }
    }

    @Test
    public void getPageSource(){
        System.out.println(driver.getPageSource());
    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }


}
