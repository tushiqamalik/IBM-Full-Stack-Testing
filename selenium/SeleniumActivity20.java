// ACTIVITY 20:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/tab-opener
// Get the title of the page and print it to the console.
// Find the button to open a new tab and click it.
// Wait for the new tab to open.
// Print all the handles. **
// Switch to the newly opened tab, print it's title and heading.
// Repeat the steps by clicking the button in the new tab page.
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
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumActivity20 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://v1.training-support.net/selenium/tab-opener");

        System.out.println(driver.getTitle());

        String parentHandle = driver.getWindowHandle();

        WebElement newTab = driver.findElement(By.id("launcher"));
        newTab.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        System.out.println("Currently open windows: " + driver.getWindowHandle());

        Set<String> handles = driver.getWindowHandles();

        for(String handle : handles){
            if(!handle.equals(parentHandle)){
                driver.switchTo().window(handle);
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton")));
        System.out.println("Current tab: " + driver.getWindowHandle());
        System.out.println("Page title: " + driver.getTitle());
        String pageHeading = driver.findElement(By.className("content")).getText();
        System.out.println("Page Heading : " + pageHeading);

        WebElement newTabButtonInNewTab = driver.findElement(By.id("actionButton"));
        newTabButtonInNewTab.click();

        handles = driver.getWindowHandles();

        // Switch to the newly opened tab again
        for (String handle : handles) {
            driver.switchTo().window(handle);
        }
        driver.quit();
    }
}