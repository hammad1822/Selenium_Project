package com.basics.tables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class FetchColumnValue {
    WebDriver driver;

    @BeforeSuite
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority = 0)
    public void openURL() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void FetchHeadingOfTable(){
        List<WebElement> numberOfRows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
        System.out.println("Number of Rows: " +numberOfRows.size());
        for(int i = 1; i <= numberOfRows.size(); i++){
            WebElement companyName = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td[1]/a"));
            String cellValue = companyName.getText();
            System.out.println(cellValue);
        }
    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}
