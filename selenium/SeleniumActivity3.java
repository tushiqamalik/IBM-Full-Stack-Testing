// ACTIVITY 3:
// Using selenium:
// Open a new browser to https://v1.training-support.net/selenium/target-practice
// Get the title of the page and print it to the console.
// Using xpath:
// Find the 3rd header of the page and print it's text to the console.
// Find the 5th header of the page and print it's color.
// Using any other locator:
// Find the violet button and print all its classes.
// Find the grey button and print its text.
// Close the browser.


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager.*;

public class SeleniumActivity3 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser7
        driver.get("https://v1.training-support.net/selenium/target-practice");

        System.out.println(driver.getTitle());

        WebElement thirdHeader = driver.findElement(By.xpath("//*[@id=\"third-header\"]"));
        System.out.println(thirdHeader.getText());


        WebElement fifthHeader = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[1]/h5"));
        System.out.println(fifthHeader.getCssValue("color"));


        WebElement violet = driver.findElement(By.cssSelector("button.ui.violet.button"));
        System.out.println(violet.getAttribute("class"));

        WebElement grey = driver.findElement(By.cssSelector("button.ui.grey.button"));
        System.out.println(grey.getText());


        driver.quit();
    }
}