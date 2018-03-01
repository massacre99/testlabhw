package testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by massacre99 on 01.03.2018.
 */
public class LoginTest extends BaseSetup {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = getChromeDriver();
        loginTest(driver);
        logoutTest(driver);

    }
}
