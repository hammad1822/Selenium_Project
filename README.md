# Selenium Basic Automation Testing with Java

This repository is a practical guide to mastering Selenium WebDriver with Java, covering essential topics for automation testing, including browser setup, cross-browser testing, headless mode, locators, TestNG, assertions, handling alerts and frames, navigation commands, and the Page Object Model framework. Perfect for beginners and professionals aiming to enhance their test automation skills.

---

## Table of Contents

1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Topics Covered](#topics-covered)
    - [Introduction to Selenium WebDriver](#introduction-to-selenium-webdriver)
    - [Cross-Browser Testing and TestNG](#cross-browser-testing-and-testng)
    - [Locating and Interacting with Web Elements](#locating-and-interacting-with-web-elements)
    - [Assertions and Advanced User Actions](#assertions-and-advanced-user-actions)
    - [Handling Alerts, Waits, and Frames](#handling-alerts-waits-and-frames)
    - [Working with Windows, Tabs, and HTML Tables](#working-with-windows-tabs-and-html-tables)
    - [Page Object Model (POM)](#page-object-model-pom)
    - [Advanced Page Object Model](#advanced-page-object-model)
4. [How to Run](#how-to-run)
5. [References](#references)

---

## Introduction

This repository aims to provide a practical learning experience for beginners in Selenium automation testing. Each lecture introduces a new concept with hands-on examples, gradually building your expertise.

---

## Prerequisites

1. **Java Development Kit (JDK)** (version 8 or above).
2. **Maven** for dependency management.
3. **IDE** like IntelliJ IDEA or Eclipse.
4. **Supported Browsers**: Chrome, Firefox, Edge, Safari.
5. Add the following dependencies to your `pom.xml`:
   ```xml
   <dependencies>
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.x.x</version>
       </dependency>
       <dependency>
           <groupId>io.github.bonigarcia</groupId>
           <artifactId>webdrivermanager</artifactId>
           <version>5.x.x</version>
       </dependency>
       <dependency>
           <groupId>org.testng</groupId>
           <artifactId>testng</artifactId>
           <version>7.x.x</version>
           <scope>test</scope>
       </dependency>
   </dependencies>
   ```

---

## Topics
## Introduction to Selenium WebDriver

### Overview of Selenium WebDriver and its features
Selenium WebDriver is a powerful tool for automating web browsers. It provides APIs to control and interact with web elements, making it ideal for functional and regression testing.

### Setting up Selenium WebDriver Environment

To get started with Selenium WebDriver, we need to configure the environment for different browsers. Below are the necessary setups for Chrome, Firefox, and Edge.

## Chrome Browser Setup

### Start Chrome Browser
```
@BeforeSuite
public void startChromeBrowser(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}
```
Description: Initializes the Chrome browser before the suite begins, sets up the WebDriver, and maximizes the browser window.
```
@Test
public void openURL() throws InterruptedException {
    driver.get("https://mvnrepository.com/");
    Thread.sleep(15000);
}
```
Description: Opens the specified URL in the browser and waits for 15 seconds.

### Close Chrome Browser
```
@AfterSuite
public void closeChromeBrowser(){
    driver.close();
}
```
  - [Firefox Browser Setup](Selenium_Basics/src/test/java/com/basics/browser/FireFoxBrowserInit.java)
  - [Edge Browser Setup](Selenium_Basics/src/test/java/com/basics/browser/MicrosoftBrowserInit.java)
- **Launching Browsers:**
  - Run tests using Chrome, Firefox, Edge, and Safari.
- **Dependencies:**
  - [selenium-java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
  - [webdrivermanager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager)
  - [testng](https://mvnrepository.com/artifact/org.testng/testng)
---

## Cross Browser Testing and TestNG

### Cross Browser Testing
#### Dynamic Browser Configuration

```
@BeforeSuite
public void startBrowser(){
    String browser = System.getProperty("browser", "");

    if(browser.equals("chrome")){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    } else if(browser.equals("firefox")){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    } else {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }
}
```
Description: Configures the browser dynamically based on the system property passed (e.g., chrome, firefox, edge).

- [Cross Browser Configuration](Selenium_Basics/src/test/java/com/basics/browser/CrossBrowserInit.java)
  
### Headless Mode Testing
```
@BeforeSuite
public void openBrowser(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless=new");

    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
}
```
Description: Initializes Chrome browser in headless mode (without UI) to run tests without a graphical interface.

- [Headless Browser Testing](Selenium_Basics/src/test/java/com/basics/browser/HeadlessChrome.java)

### TestNG Lifecycle
**`@BeforeSuite: Runs before the entire suite starts.`**
```
@BeforeSuite
public void beforeSuiteExample(){
    System.out.println("BeforeSuite Example");
}
```
**`@BeforeTest: Runs before the first test method is invoked.`**
```
@BeforeTest
public void beforeTestExample(){
    System.out.println("BeforeTest Example");
}
```
**`@BeforeClass: Runs before the first method of the class is invoked.`**
```
@BeforeClass
public void beforeClassExample(){
    System.out.println("BeforeClass Example");
}
```
**`@BeforeMethod: Runs before each test method.`**
```
@BeforeMethod
public void beforeMethodExample(){
    System.out.println("BeforeMethod Example");
}
```
**`@Test: The actual test method.`**
```
@Test(priority = 1)
public void testExample(){
    System.out.println("Test Example");
}
```
**`@AfterMethod: Runs after each test method.`**
```
@AfterMethod
public void afterMethodExample(){
    System.out.println("AfterMethod Example");
}
```
**`@AfterClass: Runs after the last method of the class.`**
```
@AfterClass
public void afterClassExample(){
    System.out.println("AfterClass Example");
}
```
**`@AfterTest: Runs after all the test methods in the <test> tag are executed.`**
```
@AfterTest
public void afterTestExample(){
    System.out.println("AfterTest Example");
}
```
**`@AfterSuite: Runs after all tests in the suite have completed.`**
```
@AfterSuite
public void afterSuiteExample(){
    System.out.println("AfterSuite Example");
}
```
- [TestNG Code](Selenium_Basics/src/test/java/com/basics/TestNG/testNG_examples.java)

## Browser Commands
### Browser Command Example
```
@BeforeSuite
public void openBrowser(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}
```
Description: Initializes the Chrome browser before the suite begins, maximizes the window.
```
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
```
Description: Retrieves and prints the current URL of the browser, comparing it with the expected URL.
```
@AfterSuite
public void closeBrowser(){
    driver.quit();
}
```
Description: Closes the browser after the suite ends.

- [Full Code Here](Selenium_Basics/src/test/java/com/basics/browserCommand/BrowserCommandExample.java)

---

## Locating and Interacting with Web Elements

### **Locators in Selenium WebDriver**
**`ID`**
  ```
  WebElement element = driver.findElement(By.id("name"));
  element.sendKeys("Dabarjun Mazumdar");
  ```
Description: Locates an element by its unique id attribute.

- [Locate By ID Code](Selenium_Basics/src/test/java/com/basics/locators/LocateByID.java)

**`Name`**
```
WebElement element = driver.findElement(By.name("mobile"));
element.sendKeys("01881286434");
```
Description: Locates an element by its name attribute.

- [Locate By Name Code](Selenium_Basics/src/test/java/com/basics/locators/LocateByName.java)

**`Class Name`**
```
WebElement element = driver.findElement(By.className("btn"));
element.click();
```
Description: Locates an element by its class attribute.

- [Locate By Class Name Code](Selenium_Basics/src/test/java/com/basics/locators/LocateByClassName.java)

**`LinkText`**
```
WebElement element = driver.findElement(By.linkText("Home"));
element.click();
```
Description: Locates a link by its visible text.

- [Locate By LinkText Code](Selenium_Basics/src/test/java/com/basics/locators/LocateByLinkText.java)

**`Partial LinkText`**
```
WebElement element = driver.findElement(By.partialLinkText("Bad"));
element.click();
```
Description: Locates a link using part of its visible text.

- [Locate By Partial LinkText Code](Selenium_Basics/src/test/java/com/basics/locators/LocateByPartialLinkText.java)

**`Tag Name`**
```
List<WebElement> elements = driver.findElements(By.tagName("a"));
System.out.println(elements.size());
for (WebElement element : elements) {
    System.out.println(element.getText());
}
```
Description: Locates all elements with a specific HTML tag.

- [Locate By Tag Name Code](Selenium_Basics/src/test/java/com/basics/locators/LocateByTagName.java)

**`CSS Selector`**
```
WebElement element = driver.findElement(By.cssSelector("input[name='subjects']"));
element.sendKeys("Math");
```
Description: Locates an element using a CSS selector.

- [Locate By CSS Selector Code](Selenium_Basics/src/test/java/com/basics/locators/LocateBycssSelector.java)

**`XPath`**
```
WebElement element = driver.findElement(By.xpath("//input[@class='form-control']"));
element.sendKeys("Dabarjun Mazumdar");
```
Description: Locates an element using an XPath expression.

- [Locate By Xpath Code](Selenium_Basics/src/test/java/com/basics/locators/LocateByXPath.java)

### **Interacting with Web Elements**

#### **WebElement Commands**

**`sendKeys`**
  ```
  WebElement element = driver.findElement(By.xpath("//input[@class='form-control']"));
  element.sendKeys("Dabarjun Mazumdar");
  ```
Description: Sends input to a text field or text area.

- [Send Keys Method Code]()

 **`clear`**
 ```
WebElement element = driver.findElement(By.xpath("//input[@class='form-control']"));
element.sendKeys("Dabarjun Mazumdar");
element.clear();
```
Description: Clears the content of a text field.

- [Clear Method Code](Selenium_Basics/src/test/java/com/basics/webElementsCommands/clearMethod.java)

 **`getAttribute`**
```
WebElement element = driver.findElement(By.xpath("//input[@class='form-control']"));
element.sendKeys("Dabarjun Mazumdar");
System.out.println(element.getAttribute("placeholder"));
```
Description: Retrieves the value of a specified attribute.

- [Get Attribute Method Code](Selenium_Basics/src/test/java/com/basics/webElementsCommands/getAttributeMethod.java)

 **`getCssValue`**
```
WebElement element = driver.findElement(By.xpath("//input[@class='form-control']"));
element.sendKeys("Dabarjun Mazumdar");
System.out.println(element.getCssValue("color"));
```
Description: Retrieves a specific CSS property value.

- [Get CSS Value Method Code](Selenium_Basics/src/test/java/com/basics/webElementsCommands/getCSSValueMethod.java)

 **`isDisplayed`**
```
WebElement element = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
if (element.isDisplayed()) {
    System.out.println("Element is displayed.");
}
```
Description: Checks if the element is visible.

- [IS Displayed Method Code](Selenium_Basics/src/test/java/com/basics/webElementsCommands/isDisplayedMethod.java)

### **Navigation Commands**

**`Navigate to Another URL`**
```
driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
driver.navigate().to("https://www.daraz.com.bd/?m_station=page#?");
```
Description: Navigates to another URL after opening the initial page.

- [Navigate To Another URL Code](Selenium_Basics/src/test/java/com/basics/browserNavigation/openAnotherURL.java)

**`Navigate Back to the Previous URL`**
```
driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
driver.navigate().to("https://www.daraz.com.bd/?m_station=page#?");
driver.navigate().back();
```
Description: Returns to the previous page in the browser's history.

- [Navigate Back To The Previous URL Code](Selenium_Basics/src/test/java/com/basics/browserNavigation/backToPreviousURL.java)

**`Navigate Forward to the Next URL`**
```
driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
driver.navigate().to("https://www.daraz.com.bd/?m_station=page#?");
driver.navigate().back();
driver.navigate().forward();
```
Description: Moves forward to the next page in the browser's history after navigating back.

- [Navigate Forward To The Next URL Code](Selenium_Basics/src/test/java/com/basics/browserNavigation/ForwardToNextURL.java)

**`Reload/Refresh the Current Page`**
```
driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
driver.navigate().to("https://www.daraz.com.bd/?m_station=page#?");
driver.navigate().refresh();
```
Description: Reloads the current page.

- [Reload The Current Page Code](Selenium_Basics/src/test/java/com/basics/browserNavigation/reloadThePage.java)

---

### Lecture 4: Assertions and Advanced User Actions
- **Assertions**:
  - Hard Assertion and Soft Assertion.
- **Action & Select Classes**:
  - Mouse Hover, Select Class Methods, Scrolling.

---

### Lecture 5: Handling Alerts, Waits, and Frames
- **Handling Alerts**:
  - Simple Alert, Prompt Alert, Confirmation Alert.
- **Waits**:
  - Implicit and Explicit Waits, `Thread.sleep()`.
- **Handling Frames**:
  - Switching Between Frames, Interacting with Elements Inside Frames.

---

### Lecture 6: Working with Windows, Tabs, and HTML Tables
- **Working with Windows and Tabs**:
  - Create New Window/Tab, Switch Between Windows/Tabs, Close a Window/Tab.
- **HTML Tables**:
  - Extracting Data from Tables.

---

### Lecture 7: Page Object Model (POM)
- **Introduction to POM**:
  - Designing Page Object Classes.

---

### Lecture 8: Advanced Page Object Model
- **Advanced POM Techniques**:
  - Framework Enhancements (Details Coming Soon).

---

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Selenium_Project.git
   cd selenium-basic-automation
   ```
2. Open the project in your preferred IDE.
3. Configure the Maven dependencies.
4. Run the desired TestNG test cases.

---

## References

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [WebDriverManager Documentation](https://github.com/bonigarcia/webdrivermanager)
