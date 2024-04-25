import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

public class SeleniumActivity4 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        Actions action = new Actions(driver);
        // Open the browser
        driver.get("https://v1.training-support.net/selenium/input-events");

        System.out.println(driver.getTitle());

        WebElement part = driver.findElement(By.id("wrapD3Cube"));
        action.click(part).pause(Duration.ofSeconds(2)).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement header = driver.findElement(By.className("active"));
        System.out.println(header.getText());
        action.doubleClick(part).pause(Duration.ofSeconds(2)).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement header2 = driver.findElement(By.className("active"));
        System.out.println(header2.getText());

        action.contextClick(part).pause(Duration.ofSeconds(2)).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement header3 = driver.findElement(By.className("active"));
        System.out.println(header3.getText());
        driver.quit();

    }
}







