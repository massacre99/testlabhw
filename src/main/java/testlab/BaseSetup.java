package testlab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by massacre99 on 01.03.2018.
 */
public class BaseSetup {

    public static WebDriver getDriver() {
        String browser = Constants.DEFAULT_BROWSER; //TODO code a method for calling browser
        switch (browser) {
            case "firefox":
                String ffPath = new File(BaseSetup.class.getResource("/geckodriver.exe").getFile()).getPath();
                System.setProperty("webdriver.gecko.driver",ffPath);
                return new FirefoxDriver();
            case "ie":
            case "internet explorer":
                String iePath = new File(BaseSetup.class.getResource("/IEDriverServer.exe").getFile()).getPath();
                System.setProperty("webdriver.ie.driver",iePath);
                return new InternetExplorerDriver();
            case "chrome":
            default:
                String chromePath = new File(BaseSetup.class.getResource("/chromedriver.exe").getFile()).getPath();
                System.setProperty("webdriver.chrome.driver",chromePath);
                return new ChromeDriver();
        }

    }

    public static WebDriver getConfiguredDriver() {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        EventFiringWebDriver webDriver = new EventFiringWebDriver(driver);
        webDriver.register(new EventLogger());
        return  webDriver;
    }

//    public static WebDriver getChromeDriver1() {
//
//        String chromePath = new File(BaseSetup.class.getResource("/chromedriver.exe").getFile()).getPath();
//        System.setProperty("webdriver.chrome.driver",chromePath);
////        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe"); //"src/main/resources/chromedriver.exe"
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        return new ChromeDriver(options);
//    }

}
