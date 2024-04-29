// ACTIVITY 13:
// Using Selenium:
// Open a new browser to https://v1.training-support.net/selenium/tables
// Get the title of the page and print it to the console.
// Using xpaths on the second table:
// Find the number of rows and columns in the table and print them.
// Find and print the cell value at the second row second column.
// Click the header of the first column to sort by name.
// Find and print the cell value at the second row second column again.
// Print the cell values of the table footer.


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SeleniumActivity13 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/tables");

        System.out.println(driver.getTitle());

        // find rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'sortableTable']/tbody/tr"));
        System.out.println("Number of rows is " + rows.size());
        // number of columns
        List <WebElement> column = driver.findElements(By.xpath("//table[@id = 'sortableTable']/tbody/tr[1]/td"));
        System.out.println("Number of columns is " + column.size());

        // print value of second row second column
        WebElement value = driver.findElement(By.xpath("//table[@id = 'sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Value of 2nd row 2nd column is " + value.getText());

        // print value of second row second column
        WebElement header = driver.findElement(By.xpath("//table[@id = 'sortableTable']/thead/tr[1]/th[1]"));
        header.click();
        WebElement value2 = driver.findElement(By.xpath("//table[@id = 'sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Value of 2nd row 2nd column after sorting by name is " + value2.getText());

        WebElement footer = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/table/tfoot"));
        System.out.println(footer.getText());

        driver.quit();

    }

}









