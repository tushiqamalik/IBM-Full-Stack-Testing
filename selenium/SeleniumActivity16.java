// ACTIVITY 16:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/selects
// Get the title of the page and print it to the console.
// On the single select:
// Select the second option using the visible text.
// Select the third option using the index.
// Select the fourth option using the value.
// Get all the options and print them to the console.
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

public class SeleniumActivity16 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/selects");

        System.out.println(driver.getTitle());

        WebElement dropdown = driver.findElement(By.tagName("select"));
        Select select = new Select(dropdown);


        select.selectByVisibleText("Option 2");
        select.selectByIndex(2);
        select.selectByValue("4");

        List<WebElement> options = select.getOptions();
        for(WebElement option : options){
            System.out.println(option.getText());
        }
        driver.quit();
    }
}











