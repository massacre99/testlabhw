package testlab;

import org.openqa.selenium.WebDriver;
import testlab.pages.DashboardPage;
import testlab.pages.LoginPage;

/**
 * Created by massacre99 on 01.03.2018.
 */
public class LoginTest extends BaseSetup {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getConfiguredDriver();
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.openLoginPage();
        loginPage.loginTest();
        dashboardPage.logoutTest();

        driver.quit();
    }
}
