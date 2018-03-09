package testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testlab.pages.DashboardPage;
import testlab.pages.LoginPage;

import java.util.Arrays;
import java.util.List;

/**
 * Created by massacre99 on 01.03.2018.
 */
public class CheckAdminMainMenu extends BaseSetup {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = getConfiguredDriver();
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.openLoginPage();
        loginPage.loginTest();
        //By.xpath(.//li[contains(@class, "maintab")])
        List<WebElement> menuItems = driver.findElements(By.cssSelector(".menu .maintab"));

        List<String> values = Arrays.asList("1", "3", "9", "23", "27", "31", "42", "46", "52", "55", "58", "73", "95");
        for (String value : values) {
            dashboardPage.testMenu(value);
        }

        driver.quit();

    }


}
