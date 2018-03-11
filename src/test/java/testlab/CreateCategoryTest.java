package testlab;

import org.openqa.selenium.WebDriver;
import testlab.pages.DashboardPage;
import testlab.pages.LoginPage;

/**
 * Created by massacre99 on 11.03.2018.
 */
public class CreateCategoryTest extends BaseSetup {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getConfiguredDriver();
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.openLoginPage();
        loginPage.loginTest();
        dashboardPage.waitForContentLoad();
        dashboardPage.createCategory(Constants.CATEGORY_NAME);
        dashboardPage.findCategory(Constants.CATEGORY_NAME);

        driver.quit();
    }

}
