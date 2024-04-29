// ACTIVITY 19:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/javascript-alerts
// Get the title of the page and print it to the console.
// Find the button to open a PROMPT alert and click it.
// Switch the focus from the main window to the Alert box and get the text in it and print it.
// Type "Awesome!" into the prompt.
// Close the alert by clicking Ok.
// Close the browser.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SeleniumActivity19 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/javascript-alerts");

        System.out.println(driver.getTitle());

        WebElement prompt = driver.findElement(By.id("prompt"));
        prompt.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Awesome!");
        alert.accept();

        driver.quit();
    }
}