// ACTIVITY 7:
//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//Once the Class file is created, import
//By
//WebDriver
//FirefoxDriver
//WebElement
//Parameters

//In the @BeforeMethod method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://v1.training-support.net/selenium/login-form
//In the @AfterMethod method, use close() to close the browser once the test is done.
//Add a @DataProviders method credentials() with the name parameter set to "Authentication".
//Set the return type of the method as Object[][].
//It should return two Objects with a username and a password each.
//Write a @Test method, with the parameter dataProvider set to name of the @DataProvider method.
//Add them as formal parameters for the test method.

//In the @Test method:
//Use findElements() to find the username and password text boxes and the login button.
//Use sendKeys() with the variable names as input.
//Click the login button.
//Run the test script as a TestNG Test.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGActivity7 {
    // Declare the WebDriver object
    WebDriver driver ;

    @BeforeClass (alwaysRun = true)
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test (dataProvider = "Authentication")
    public void TestCase(String username, String password) {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Login Form", title);

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(username);

        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys(password);

        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button"));
        login.click();

    }

    @DataProvider (name = "Authentication")
    public static Object[][] credentials(){
        return new Object[][]{
                {"admin", "password"}
        };
    }
    @AfterClass (alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}