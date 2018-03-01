package testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by massacre99 on 01.03.2018.
 */
public class BaseSetup {


    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

    public static void loginTest(WebDriver driver) throws InterruptedException {

        driver.get(Constants.ADMIN_URL);
        WebElement login = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement submitLoginPass = driver.findElement(By.name("submitLogin"));    // By.xpath("//button[@tabindex=4]")

        login.sendKeys(Constants.ADMIN_LOGIN);
        password.sendKeys(Constants.ADMIN_PASS);
        Thread.sleep(1500);
        submitLoginPass.click();
        Thread.sleep(2000);

    }

    public static void logoutTest(WebDriver driver) throws InterruptedException {
        WebElement profile = driver.findElement(By.id("employee_infos"));
        WebElement logout = driver.findElement(By.id("header_logout"));
        profile.click();
        Thread.sleep(1500);
        logout.click();
        Thread.sleep(1500);
        driver.quit();
    }
}
