package testlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by massacre99 on 09.03.2018.
 */
public class DashboardPage {
    private WebDriver driver;
    private By profile = By.id("employee_infos");
    private By logout = By.id("header_logout");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logoutTest() throws InterruptedException {
        driver.findElement(profile).click();
        driver.findElement(logout).click();
    }

    // перебор по css локатору
//    public void testMenu_new(List<WebElement> elements) throws InterruptedException {
//        for (WebElement element : elements) {
//            Wait wait = new WebDriverWait(driver,500);
//            wait.until(ExpectedConditions.elementToBeClickable(element));
//            element.click();
//            Thread.sleep(1500);
//            String header = driver.findElement(By.tagName("h2")).getText();
//            // By.xpath("//h2[@class=\"page-title\"]")
//            System.out.println(header);
//
//            driver.navigate().refresh();
//            Thread.sleep(2000);
//            String newHeader = driver.findElement(By.tagName("h2")).getText();
//
//            if (header.equals(newHeader)) {
//                System.out.println("Equals!");
//            } else throw new UnsupportedOperationException("Not Equals!");
//            System.out.println("sleep");
//            Thread.sleep(3000);
//        }
//    }


    public void testMenu(String value) throws InterruptedException {
        String item = String.format("//li[@data-submenu=\"%s\"]", value);
        WebElement menuItem = driver.findElement(By.xpath(item));
        menuItem.click();

        String header = driver.findElement(By.tagName("h2")).getText();
        // By.xpath("//h2[@class=\"page-title\"]")
        System.out.println(header);

        driver.navigate().refresh();
        String newHeader = driver.findElement(By.tagName("h2")).getText();

        if (header.equals(newHeader)) {
            System.out.println("Equals!");
        } else throw new UnsupportedOperationException("Not Equals!");

    }
}
