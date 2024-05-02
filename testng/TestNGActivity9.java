// ACTIVITY 9:
//Create a TestNG Class with the annotations
//@Test
//@BeforeMethod
//@BeforeTest
//@AfterTest
//Once the Class file is created, import
//By
//WebDriver
//FirefoxDriver
//Alert
//Reporter

//In the @BeforeTest method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://v1.training-support.net/selenium/javascript-alerts
//In the @AfterTest method, use close() to close the browser once the test is done.
//Make three @Test methods - simpleAlertTestCase(), confirmAlertTestCase(), promptAlertTestCase().
//
//Each @Test method will open a type of alert and getText() from it and print it in the console.
//
//Use driver.switchTo().alert() to switch focus to the alert.
//
//In the @BeforeMethod method, use driver.switchTo().defaultContent() to switch focus back to the page.

//Confirm and Prompt Alerts can be closed using alert.accept() and alert.dismiss().
//For the prompt alert, use alert().sendKeys() to type the text in the input box.
//Use the logger methods to add logging sentences.
//Add assertions statement in each test method.
//Run the test script as a TestNG Test.
//Observe results in the Console and the generated HTML file.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TestNGActivity9 {
    // Declare the WebDriver object
    WebDriver driver ;

    @BeforeClass (alwaysRun = true)
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTestCase(){
        driver.findElement(By.id("simple")).click();
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println(simpleAlert.getText());
        Reporter.log(simpleAlert.getText());
        simpleAlert.accept();
    }

    @Test
    public void confirmAlertTestCase(){
        driver.findElement(By.id("confirm")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println(confirmAlert.getText());
        Reporter.log(confirmAlert.getText());
        confirmAlert.dismiss();
    }

    @Test
    public void promptAlertTestCase(){
        driver.findElement(By.id("prompt")).click();
        Alert promptAlert = driver.switchTo().alert();
        System.out.println(promptAlert.getText());
        Reporter.log(promptAlert.getText());
        promptAlert.sendKeys("sample");
        promptAlert.accept();
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}