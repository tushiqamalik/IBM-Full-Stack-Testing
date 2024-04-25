// ACTIVITY 8:
// Open a new browser to https://v1.training-support/selenium/ajax
// Get the title of the page and print it to the console.
// On the page perform:
// Find and click the "Change content" button on the page.
// Wait for the text to say "HELLO!". Print the message that appears on the page.
// Wait for the text to change the content "I'm late!". Print the new message on the page.
// Close the browser.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class SeleniumActivity8 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the browser
        driver.get("https://v1.training-support.net/selenium/ajax");

        System.out.println(driver.getTitle());

        WebElement contentButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/button"));
        contentButton.click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        System.out.println(driver.findElement(By.id("ajax-content")).getText());

        driver.quit();

    }
}