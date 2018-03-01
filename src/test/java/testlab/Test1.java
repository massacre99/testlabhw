package testlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by massacre99 on 01.03.2018.
 */
public class Test1 extends BaseSetup {

    public static void main(String[] args) {

        WebDriver driver = getChromeDriver();

        driver.get("https://www.bing.com/");
        WebElement fieldSearch = driver.findElement(By.id("sb_form_q"));
        fieldSearch.sendKeys("selenium");

        WebElement button = driver.findElement(By.name("go"));
        button.click();

        List<WebElement> refers = driver.findElements(By.className("b_algo"));
        System.out.println(refers.size());

        driver.quit();
    }

}
