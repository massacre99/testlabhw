package testlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by massacre99 on 09.03.2018.
 */
public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By profile = By.id("employee_infos");
    private By logout = By.id("header_logout");
    private By spinnerLoader = By.id("ajax_running");
    private By menuCatalog = By.id("subtab-AdminCatalog");
    private By subMenuCategories = By.id("subtab-AdminCategories");
    /*
    Category
     */
    private By buttonAddCategory = By.id("page-header-desc-category-new_category");
    private By newCategoryName = By.id("name_1");
    private By saveNewCategory = By.id("category_form_submit_btn");
//    private By sucessCreateCategoryAlert = By.className("alert alert-success"); //TODO уточнить, почему не хочет работать через этот локатор
    private By sucessCreateCategoryAlert = By.xpath("//*[@class='alert alert-success']");
    private By filterCategory = By.name("categoryFilter_name");
    private By filterSearchButton = By.id("submitFilterButtoncategory");
    private String searchCategory = "//tbody/tr/td[contains(text(),'%s')]";




    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }

    public void logoutTest() throws InterruptedException {
        driver.findElement(profile).click();
        driver.findElement(logout).click();
    }

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

    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        openCategoryPage();
        driver.findElement(buttonAddCategory).click();
        waitForContentLoad();
        driver.findElement(newCategoryName).sendKeys(categoryName);
        driver.findElement(saveNewCategory).click();
        waitForContentLoad();
        wait.until(ExpectedConditions.visibilityOfElementLocated(sucessCreateCategoryAlert));
    }

    public void openCategoryPage() {
        new Actions(driver).moveToElement(driver.findElement(menuCatalog)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(subMenuCategories));
        driver.findElement(subMenuCategories).click();
        waitForContentLoad();
    }

    public void findCategory(String categoryName) {
        driver.findElement(filterCategory).sendKeys(categoryName);
        driver.findElement(filterSearchButton).click();
        waitForContentLoad();
        if (driver.findElements(By.xpath(String.format(searchCategory, categoryName))).size() > 0) {
            System.out.println("EXIST!");
        }
        else {
            throw new UnsupportedOperationException("Not Equals!");
        }
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad() {
//        WebDriverWait wait = new WebDriverWait(driver,4);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(spinnerLoader));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerLoader));
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
}
