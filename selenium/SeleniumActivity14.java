// ACTIVITY 14:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/dynamic-attributes
// Get the title of the page and print it to the console.
// Find the username and password input fields. Type in the credentials:
// username : admin
// password : password
// Wait for login message to appear and print the login message to the console.
// Close the browser


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumActivity14 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        System.out.println(driver.getTitle());

        WebElement userName = driver.findElement(By.xpath("//input[@placeholder = 'Username']"));
        userName.sendKeys("admin");

        WebElement passWord = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
        passWord.sendKeys("password");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
        System.out.println(loginMessage.getText());

        driver.quit();

    }

}









