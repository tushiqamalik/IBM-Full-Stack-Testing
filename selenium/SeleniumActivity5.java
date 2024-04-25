// ACTIVITY 5:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/input-events.
// Get the title of the page and print it to the console.
// On the page, perform:
// Press the key of first letter of your name in caps.
// Press CTRL+A and the CTRL+C to copy all the text on the page.
// Paste the text in a text editor to verify results.
// Close the browser.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class SeleniumActivity5 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        Actions action = new Actions(driver);
        // Open the browser
        driver.get("https://v1.training-support.net/selenium/input-events");

        System.out.println(driver.getTitle());

        action.sendKeys("T").perform();

        action.keyDown(Keys.CONTROL).sendKeys("A").perform();
        action.keyDown(Keys.CONTROL).sendKeys("C").perform();

        driver.quit();

    }
}
