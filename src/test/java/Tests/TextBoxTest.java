package Tests;

import Pages.TextBoxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest {

    WebDriver driver;
    TextBoxPage textBoxPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setCapability("pageLoadStrategy", "eager");
        driver = new ChromeDriver(options);
        textBoxPage = new TextBoxPage(driver);
    }

    @Test
    public void CheckFullTextBox() {
        textBoxPage.open();
        textBoxPage.fillingField("Тест", "test@test.ru", "г.Тест, ул. Тестовая"
                , "г.Тест, ул. Тестовая, дом 111");
        Assert.assertEquals(textBoxPage.checkText(), textBoxPage.expectedText("Тест", "test@test.ru", "г.Тест, ул. Тестовая"
                , "г.Тест, ул. Тестовая, дом 111"), "В сообщении неверный текст");
    }

    @Test
    public void CheckNullTextBox() {
        textBoxPage.open();
        textBoxPage.fillingField("", "", "г.Тест"
                , "дом 222");
        Assert.assertEquals(textBoxPage.checkText(), textBoxPage.expectedText2("г.Тест"
                , "дом 222"), "В сообщении неверный текст");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

