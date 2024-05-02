// ACTIVITY 8:
// Using data provider, use 3 sets of data to fill up and submit simple form in one test class.
// Remove data provider part to a separate class and use that to populate the test cases in
// separate test classes using either subclassing or the import method.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class ChallengeActivity extends DataProviderr{
    // Declare the WebDriver object
    WebDriver driver ;

    @BeforeMethod (alwaysRun = true)
    public void beforeMethod() {
        // Set up the Firefox driver
        WebDriverManager.firefoxdriver().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://v1.training-support.net/selenium/simple-form");
    }

    @Test (dataProvider = "Information")
    public void TestCase(String fname, String lname, String email, String mnum, String message) {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title is: " + title);


        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(fname);

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys(lname);

        WebElement emailId = driver.findElement(By.id("email"));
        emailId.sendKeys(email);

        WebElement mobileNum = driver.findElement(By.id("number"));
        mobileNum.sendKeys(mnum);

        WebElement message1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[5]/textarea"));
        message1.sendKeys(message);

        WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[6]/div[1]/input"));
        submit.click();

        driver.switchTo().alert().accept();

        WebElement clear = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div/div[6]/div[2]/input"));
        clear.click();

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}