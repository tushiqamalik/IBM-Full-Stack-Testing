// ACTIVITY 6:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/drag-drop
// Get the title of the page and print it to the console.
// On the page perform:
// Find the ball and simulate a click and drag to move it into "Dropzone 1"
// Verify that the ball has entered Dropzone 1.
// Once verified, move the ball into "Dropzone 2".
// Verify that the ball has entered Dropzone 2.
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

public class SeleniumActivity6 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        Actions action = new Actions(driver);
        // Open the browser
        driver.get("https://v1.training-support.net/selenium/drag-drop");

        System.out.println(driver.getTitle());

        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        action.dragAndDrop(ball, dropzone1).pause(Duration.ofSeconds(2)).perform();

        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        action.dragAndDrop(ball, dropzone2).pause(Duration.ofSeconds(2)).perform();

        if(dropzone1.getText().contains("Dropped!")){
            System.out.println("Ball successfully dropped in Dropzone 1!");
        }
        if (dropzone2.getText().contains("Dropped!")){
            System.out.println("Ball successfully dropped in Dropzone 2!");
        }
        else{
            System.out.println("Ball not dropped!");
        }

        driver.quit();

    }
}
