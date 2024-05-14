import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Activity9 {
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

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table")));

        WebElement table = driver.findElement(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody"));
        List<WebElement> allRows = table.findElements(By.tagName("tr"));

        // And iterate over them and get all the desired cells
        for(int i=0; i<10; i++) {
            WebElement row = allRows.get(i);

            List<WebElement> cells = row.findElements(By.tagName("td"));
            //Printing Name and user for first ten entries in the table
            System.out.println("Name: " + cells.get(2).getText() + ", " + "User: " + cells.get(7).getText());
        }

        //Close the browser
        driver.quit();
    }
}