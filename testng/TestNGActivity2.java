//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//In the @BeforeClass method, create a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://v1.training-support.net/selenium/target-practice
//In the @AfterClass method, use close() to close the browser once the test is done.

//Add 4 @Test methods.
//In the first @Test method, use getTitle() to get and assert the title of the page.
//In the second @Test method, use findElement() to look for the black button. Make an incorrect assertion. (This test case is meant to throw an error)
//For the third @Test method, skip it by setting it's enabled parameter to false.
//The third method will be skipped, but will not be shown as skipped.
//For the fourth @Test method, skip it by throwing a SkipException inside the method.
//The fourth method will be skipped and it will be shown as skipped.
//Observe the result in the console.

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

public class TestNGActivity2 {
    // Declare the WebDriver object
    WebDriver driver;

    @BeforeClass
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/target-practice");
    }

    @Test
    public void exampleTestCase1() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Target Practice", title);
    }

    @Test
    public void exampleTestCase2() {

        WebElement blackButton = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[3]"));
        String bcolor = blackButton.getText();

        Assert.assertEquals("Blue", bcolor);

    }

    @Test(enabled = false)
    public void exampleTestCase3() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);

        //Assertion for page title
        Assert.assertEquals("Training Support", title);
    }

    @Test
    public void exampleTestCase4() throws SkipException {
        String condition = "Skip Test";
        if(condition.equals("Skip Test")){
            throw new SkipException("Skipping-This is not ready for testing!");
        }
    }


    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}