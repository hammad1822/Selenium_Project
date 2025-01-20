package com.basics.TestNG;

import org.testng.annotations.*;

public class testNG_examples {

    @AfterSuite
    public void afterSuiteExample(){
        System.out.println("AfterSuite Example");
    }
    @BeforeTest
    public void beforeTestExample(){
        System.out.println("BeforeTest Example");
    }
    @Test(priority = 1)
    public void testExample(){
        System.out.println("Test Example");
    }
    @Test(priority = 0)
    public void testExample2(){
        System.out.println("Test Example 2");
    }
    @BeforeClass
    public void beforeClassExample(){
        System.out.println("BeforeClass Example");
    }
    @AfterClass
    public void afterClassExample(){
        System.out.println("AfterClass Example");
    }

    @BeforeMethod
    public void beforeMethodExample(){
        System.out.println("BeforeMethod Example");
    }
    @AfterMethod
    public void afterMethodExample(){
        System.out.println("AfterMethod Example");
    }

    @AfterTest
    public void afterTestExample(){
        System.out.println("AfterTest Example");
    }
    @BeforeSuite
    public void beforeSuiteExample(){
        System.out.println("BeforeSuite Example");
    }
}
