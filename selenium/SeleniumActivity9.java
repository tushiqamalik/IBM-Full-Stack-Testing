// ACTIVITY 9:
// Using Selenium:
// open a new browser to https://v1.training-support.net/selenium/dynamic-controls
// Get the title of the page and print it to console.
// On the page, perform:
// Find the checkbox inout element.
// check if it is visible on the page.
// Click the "Remove Checkbox" button.
// check if it is visible again and print the result.
// Close the browser.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class SeleniumActivity9 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        System.out.println(driver.getTitle());

        WebElement checkbox = driver.findElement(By.id("dynamicCheckbox"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicCheckbox")));
        if (checkbox.isDisplayed()){
            System.out.println("Checkbox is visible!");
        }

        WebElement createBox = driver.findElement(By.id("toggleCheckbox"));
        createBox.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));

        if (!checkbox.isDisplayed()){
            System.out.println("Checkbox is not visible!");
        }

        driver.quit();
    }

}