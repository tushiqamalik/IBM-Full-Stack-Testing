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


public class Activity10 {
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

        //Entering credentials
        WebElement login = driver.findElement(By.id("user_name"));
        login.sendKeys("admin");
        WebElement pwd = driver.findElement(By.id("username_password"));
        pwd.sendKeys("pa$$w0rd");

        //Clicking the login button
        driver.findElement(By.id("bigbutton")).click();

        //waiting for dashlets to load properly
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("col_0_1")));

        //Getting the table of dashlets
        WebElement table = driver.findElement(By.xpath("//*[@id=\"pageNum_0_div\"]/table/tbody"));

        //Getting all rows
        List<WebElement> allRows = table.findElements(By.tagName("tr"));

        //Initial dashlets
        int totalDashlets = 0;

        for(int i=0; i< allRows.size(); i++) {
            List<WebElement> cells = allRows.get(i).findElements(By.tagName("td"));

            for(int j=0; j<cells.size(); j++){
                List<WebElement> dashLets = cells.get(j).findElements(By.tagName("ul"));

                for(int k=0; k<dashLets.size(); k++) {
                    List<WebElement> dash = cells.get(j).findElements(By.tagName("li"));
                    int flag = 0;

                    for(WebElement d : dash){
                        if(flag == 0){
                            flag = 1;
                            continue;
                        }
                        totalDashlets++;
                        System.out.println(d.getText());
                    }
                }
            }
        }

        System.out.println("Total Dashlets: " + totalDashlets);

        //Close the browser
        driver.quit();
    }
}