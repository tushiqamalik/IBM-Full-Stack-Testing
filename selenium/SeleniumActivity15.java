// ACTIVITY 15:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/dynamic-attributes
// Get the title of the page and print it to the console.
// Find the username and password input fields. Type in the credentials:
// Find the input fields of the SignUp form.
// Fill in the details in the fields with your own data.
// Wait for success message to appear and print it to the console.
// Close the browser.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class SeleniumActivity15 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        System.out.println(driver.getTitle());

        WebElement userName = driver.findElement(By.xpath("//div[@class='ui form segment']//input[@placeholder='Username']"));
        userName.sendKeys();

        WebElement passWord = driver.findElement(By.xpath("//div[@class='ui form segment']//input[@placeholder='Password']"));
        passWord.sendKeys();

        WebElement confirmPassword = driver.findElement(By.xpath("//div[@class='ui form segment']//input[@placeholder='Password']"));
        confirmPassword.sendKeys();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit']")));

        if (passWord.equals(confirmPassword)){
            signUpButton.click();
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));
            System.out.println(successMessage.getText());
        }
        else{
            System.out.println("Password and Confirm Password do not match!");
        }

        driver.quit();

    }

}










