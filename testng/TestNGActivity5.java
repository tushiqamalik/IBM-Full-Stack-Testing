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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGActivity5 {
    // Declare the WebDriver object
    WebDriver driver ;

    @BeforeClass (alwaysRun = true)
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void exampleTestCase() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Target Practice", title);
    }

    @Test ( groups = { "HeaderTests" })
    public void headerTestCase1() {
        //Find third header and assert it
        WebElement header3 = driver.findElement(By.id("third-header"));
        String h3text = header3.getText();

        Assert.assertEquals("Third header", h3text);
    }

    @Test ( groups = { "HeaderTests" })
    public void headerTestCase2() {
        //fifth header text color
        WebElement header5 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        String h5color = header5.getCssValue("color");

        Assert.assertEquals("rgb(33, 186, 69)", h5color);
    }

    @Test ( groups = { "ButtonTests" })
    public void buttonTestCase1() {
        //Button test class olive and assert it
        WebElement Btn = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[1]/button[4]"));
        String btnText = Btn.getText();

        Assert.assertEquals("Olive", btnText);
    }

    @Test ( groups = { "ButtonTests" })
    public void buttonTestCase2() {
        //First btn in the third row
        WebElement btn2 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[1]"));
        String btn2Color = btn2.getCssValue("color");

        Assert.assertEquals("rgb(255, 255, 255)", btn2Color);
    }


    @AfterClass (alwaysRun = true)
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}