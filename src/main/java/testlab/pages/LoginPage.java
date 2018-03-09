package testlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testlab.Constants;

/**
 * Created by massacre99 on 09.03.2018.
 */
public class LoginPage {

    private WebDriver driver;
    private By login = By.id("email");
    private By password = By.id("passwd");
    private By submitLoginPassButton = By.name("submitLogin");    // By.xpath("//button[@tabindex=4]")

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void openLoginPage() {
        driver.get(Constants.ADMIN_URL);
    }

    public void loginTest() throws InterruptedException {
        driver.findElement(login).sendKeys(Constants.ADMIN_LOGIN);
        driver.findElement(password).sendKeys(Constants.ADMIN_PASS);
        driver.findElement(submitLoginPassButton).click();
    }


}
