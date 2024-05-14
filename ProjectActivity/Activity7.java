import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Activity7 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();
//
//      // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");

        String parentWindowHandler = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement login = driver.findElement(By.id("user_name"));
        login.sendKeys("admin");
        WebElement pwd = driver.findElement(By.id("username_password"));
        pwd.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_0")));
        WebElement activity = driver.findElement(By.id("grouptab_0"));

        Actions action = new Actions(driver);
        action.moveToElement(activity).build().perform();

        WebElement nav = driver.findElement(By.id("moduleTab_9_Leads"));
        nav.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"adspan_6af2edb0-bc40-46d1-7837-5fdc647a1061\"]")));

        WebElement addDetails = driver.findElement(By.xpath("//*[@id=\"adspan_6af2edb0-bc40-46d1-7837-5fdc647a1061\"]"));
        addDetails.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[7]")));

        WebElement num = driver.findElement(By.className("phone"));
        String numTxt = num.getText();
        System.out.println(numTxt);

        driver.quit();
    }
}