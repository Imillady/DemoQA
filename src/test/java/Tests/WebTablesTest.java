package Tests;

import Pages.WebTablesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest {
    WebDriver driver;
    WebTablesPage webTablesPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setCapability("pageLoadStrategy", "eager");
        driver = new ChromeDriver(options);
        webTablesPage = new WebTablesPage(driver);
    }

    @Test
    public void CheckFullTubles() {
        webTablesPage.open();
        webTablesPage.fillingField("Тест", "Тестович", "test@test.ru", "45", "10000", "Department");
        webTablesPage.CheckTextField("Тест", "Тестович", "test@test.ru", "45", "10000", "Department");
    }

    @Test
    public void CheckDeleteTubles() {
        webTablesPage.open();
        Assert.assertEquals(String.valueOf(webTablesPage.FieldDelete()), "2",
                "Строк не верное кол-во");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}