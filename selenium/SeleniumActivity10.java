// ACTIVITY 10:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/dynamic-controls.
// Get the title of the page and print it to the console.
// On the page, perform:
// Find the checkbox input element.
// Check if the checkbox is selected and print the result.
// Click the checkbox to select it.
// Check if the checkbox is selected again and print the result.

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

public class SeleniumActivity10 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        Actions action = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        System.out.println(driver.getTitle());

        WebElement checkbox = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/input"));
        if (checkbox.isSelected()){
            System.out.println("Checkbox is selected!");
        }
        else{
            System.out.println("Checkbox is not selected!");
        }

        checkbox.click();

        if (checkbox.isSelected()){
            System.out.println("Checkbox is selected!");
        }
        else{
            System.out.println("Checkbox is not selected!");
        }

        driver.quit();
    }

}