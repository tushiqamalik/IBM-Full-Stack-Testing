// ACTIVITY 17:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/selects
// Get the title of the page and print it to the console.
// On the Multi Select:
// Select the "JavaScript" option using the visible text.
// Select the 4th, 5th, 6th options using the index.
// Select the "NodeJS" option using the value.
// Deselect the 5th option using index.
// Close the browser.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SeleniumActivity17 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://v1.training-support.net/selenium/selects");

        System.out.println(driver.getTitle());

        WebElement dropdown = driver.findElement(By.id("multi-select"));
        Select select = new Select(dropdown);


        select.selectByVisibleText("Javascript");
        select.selectByIndex(3);
        select.selectByIndex(4);
        select.selectByIndex(5);
        select.selectByValue("node");

        select.deselectByIndex(4);

        driver.quit();
    }
}