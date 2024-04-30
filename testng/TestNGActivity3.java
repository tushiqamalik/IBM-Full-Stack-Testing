// ACTIVITY 3:
//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//In the @BeforeClass method, create a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://v1.training-support.net/selenium/login-form
//In the @AfterClass method, use close() to close the browser once the test is done.
//
//Find the login input fields - username and password
//Enter the credentials - admin and password - and click the "Log in" button.
//Read the confirmation message and make and assertion to check if the correct message has been printed.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGActivity3 {
    // Declare the WebDriver object
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @Test
    public void exampleTestCase1() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("admin");
        password.sendKeys("password");

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/button"));
        loginButton.click();

        WebElement loginMessage = driver.findElement(By.id("action-confirmation"));
        Assert.assertEquals("Welcome Back, admin", loginMessage.getText());
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}