// ACTIVITY 11:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/dynamic-controls.
// Get the title of the page and print it to the console.
// On the page, perform:
// Find the text field.
// Check if the text field is enabled and print the result.
// Click the enable button.
// Check if the text field is enabled and print the result.

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

public class SeleniumActivity11 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        Actions action = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        System.out.println(driver.getTitle());

        WebElement textField = driver.findElement(By.xpath("//*[@id=\"input-text\"]"));
        if (textField.isEnabled()){
            System.out.println("Text Field is enabled!");
        }
        else{
            System.out.println("Text Field is not enabled!");
        }

        WebElement enableButton = driver.findElement(By.xpath("//*[@id=\"toggleInput\"]"));
        enableButton.click();

        if (textField.isEnabled()){
            System.out.println("Text Field is enabled!");
        }
        else{
            System.out.println("Text Field is not enabled!");
        }

        driver.quit();
    }

}
