// ACTIVITY 12:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/tables
// Get the title of the page and print it to the console.
// Using xpaths on the first table:
// Find the number of rows and columns in the table and print them.
// Find and print all the cell values in the third row of the table.
// Find and print the cell value at the second row second column.



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class SeleniumActivity12 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        Actions action = new Actions(driver);

        driver.get("https://v1.training-support.net/selenium/tables");

        System.out.println(driver.getTitle());

        List<WebElement> rows = driver.findElements(By.xpath("//table[@class = 'ui celled striped table']/tbody/tr"));
        System.out.println(rows.size());

        List<WebElement> columns = driver.findElements(By.xpath("//table[@class = 'ui celled striped table']/tbody/tr[1]/td"));
        System.out.println(columns.size());

        List<WebElement> thirdRow = rows.get(2).findElements(By.xpath(".//td"));
        for (WebElement cell : thirdRow) {
            System.out.print(cell.getText() + " ");
        }
        System.out.println();

        WebElement secondRow = rows.get(1).findElements(By.xpath(".//td")).get(1);
        System.out.println(secondRow.getText());

        driver.quit();
    }

}
