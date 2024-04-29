// ACTIVITY 21:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/popups
// Get the title of the page and print it to the console.
// Find the SignIn button and hover over it. Print the tooltip message.
// Click the button to open the Sign in form.
// Enter the credentials:
// username : admin
// password : password
// Click login and print the message on the page after logging in.
// Finally, close the browser.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumActivity21 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get("https://v1.training-support.net/selenium/popups");
        System.out.println(driver.getTitle());

        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/button"));
        String tooltipText = webElement.getAttribute("data-tooltip");
        System.out.println("Tooltip message: "+ tooltipText);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/button")).click();

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"username\"]")));

        new Actions(driver)
                .click(username)
                .sendKeys("admin")
                .sendKeys(Keys.TAB)
                .sendKeys("password")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        WebElement loginMessage = driver.findElement(By.id("action-confirmation"));
        System.out.println("Login Message: "+ loginMessage.getText());

        driver.quit();
    }
}