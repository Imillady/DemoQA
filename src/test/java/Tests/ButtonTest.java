package Tests;

import Pages.ButtonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonTest {
    WebDriver driver;
    ButtonPage buttonPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setCapability("pageLoadStrategy", "eager");
        driver = new ChromeDriver(options);
        buttonPage = new ButtonPage(driver);
    }

    @Test
    public void CheckDoubleClick() {
        buttonPage.open();
        Assert.assertEquals(buttonPage.DoubleClick(), "You have done a double click",
                "В сообщении неверный текст");
    }

    @Test
    public void CheckRightClick() {
        buttonPage.open();
        Assert.assertEquals(buttonPage.RightClick(), "You have done a right click",
                "В сообщении неверный текст");
    }

    @Test
    public void CheckDynamicClick() {
        buttonPage.open();
        Assert.assertEquals(buttonPage.DynamicClick(), "You have done a dynamic click",
                "В сообщении неверный текст");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
