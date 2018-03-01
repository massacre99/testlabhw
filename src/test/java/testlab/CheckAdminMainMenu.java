package testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

/**
 * Created by massacre99 on 01.03.2018.
 */
public class CheckAdminMainMenu extends BaseSetup {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = getChromeDriver();

        loginTest(driver);

        List<String> values = Arrays.asList("1", "3", "9", "23", "27", "31", "42", "46", "52", "55", "58", "73", "95");

        for (String value : values) {
            testMenu(driver, value);
        }

        Thread.sleep(1500);
        driver.quit();

    }

    public static void testMenu(WebDriver driver, String value) throws InterruptedException {

        String item = String.format("//li[@data-submenu=\"%s\"]", value);
        WebElement menuItem = driver.findElement(By.xpath(item));
        menuItem.click();
        Thread.sleep(1500);

        String header = driver.findElement(By.tagName("h2")).getText();
        // By.xpath("//h2[@class=\"page-title\"]")
        System.out.println(header);

        driver.navigate().refresh();
        Thread.sleep(2000);
        String newHeader = driver.findElement(By.tagName("h2")).getText();

        if (header.equals(newHeader)) {
            System.out.println("Equals!");
        } else throw new UnsupportedOperationException("Not Equals!");

    }
}
