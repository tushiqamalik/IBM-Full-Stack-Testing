//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://v1.training-support.net/selenium/target-practice
//In the @AfterClass method, use close() to close the browser once the test is done.
//Write tests for:
//Checking the page title
//Header Tests:
//Find the third header and assert the text in the h3 tag.
//Find and assert the colour of the fifth header tag element.
//Button Tests:
//Find the button with the class olive and assert it text.
//Find and assert the colour of the first button in the third row.
//Group the Header tests under a group, HeaderTests.
//Group the Button tests under a group, ButtonTests.

//Activity3
//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://v1.training-support.net/selenium/login-form
//In the @AfterClass method, use close() to close the browser once the test is done.
//Find the login input fields - username and password
//Enter the credentials - admin and password - and click the "Log in" button.
//Read the confirmation message and make and assertion to check if the correct message has been printed.
//In testng.xml:
//
//        Run all the tests from this activity.
//        Run only the tests that are in the HeaderTests group.
//        Run only the tests that are in the ButtonTests group.
//        Exclude the tests that are in the HeaderTests group.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGActivityPractice5 {
    // Declare the WebDriver object
    WebDriver driver ;

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("...before method");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("...before test");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("...before suite");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("...before groups");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("...before class");
    }

    @Test
    public void test1(){
        System.out.println("...test-1");
    }

    @Test ( groups = {"Group Tests"})
    public void test2(){
        System.out.println("...test-2");
    }

//    @AfterClass (alwaysRun = true)
//    public void afterMethod() {
//        //Close the browser
//        driver.close();
//    }

}