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

public class ReadHeading {
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
        List<WebElement> headings = driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));

        for(int i =0; i<headings.size(); i++){
            String cellValue = headings.get(i).getText();
            System.out.println("Name of the CellValue "+cellValue);
        }
    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}
