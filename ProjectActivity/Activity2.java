import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager.*;


public class Activity2 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/crm/index.php?module=Home&action=index");

        System.out.println(driver.getTitle());

        WebElement headerURL = driver.findElement(By.xpath("/html/body/div[1]/div[1]/a"));
        String headerurl = headerURL.getAttribute("href");

        System.out.println(headerurl);

        driver.quit();

    }
}
