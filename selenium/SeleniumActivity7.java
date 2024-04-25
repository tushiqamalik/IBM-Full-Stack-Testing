// ACTIVITY 7:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/dynamic-controls
// Get the title of the page and print it to the console.
// On the page perform:
// Find the checkbox toggle button and click it.
// Wait till the checkbox disappears.
// Click the button again. Wait till it appears and check the checkbox.
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

public class SeleniumActivity7 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        Actions action = new Actions(driver);
        // Open the browser
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        System.out.println(driver.getTitle());

        action.pause(Duration.ofSeconds(2)).perform();

        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));
        toggleButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        action.click(toggleButton).pause(Duration.ofSeconds(2)).perform();

        WebElement clickCheckbox = driver.findElement((By.xpath("/html/body/div[3]/div/div[1]/div[1]/input")));
        clickCheckbox.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.close();

    }
}
