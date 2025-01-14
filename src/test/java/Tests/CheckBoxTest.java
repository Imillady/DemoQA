package Tests;

import Pages.CheckBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest {
    WebDriver driver;
    CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setCapability("pageLoadStrategy", "eager");
        driver = new ChromeDriver(options);
        checkBoxPage = new CheckBoxPage(driver);
    }

    @Test
    public void CheckFullCheckBoxes() {
        checkBoxPage.open();
        checkBoxPage.booleanNotSelected();
        Assert.assertFalse(checkBoxPage.clickBooleanSelected(), "Чекбокс не был выбран");
        checkBoxPage.checkMessage1();
        Assert.assertEquals(checkBoxPage.checkMessage1(), checkBoxPage.expectedText1(), "В сообщении неверный текст");
    }

    @Test
    public void CheckSomeCheckBoxes() {
        checkBoxPage.open();
        checkBoxPage.booleanNotSelected();
        checkBoxPage.clickSelected();
        checkBoxPage.checkMessage2();
        Assert.assertEquals(checkBoxPage.checkMessage2(), checkBoxPage.expectedText2(), "В сообщении неверный текст");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
