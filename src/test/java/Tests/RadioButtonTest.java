package Tests;

import Pages.RadioButtonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest {
    WebDriver driver;
    RadioButtonPage radioButtonTest;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setCapability("pageLoadStrategy", "eager");
        driver = new ChromeDriver(options);
        radioButtonTest = new RadioButtonPage(driver);
    }

    @Test
    public void CheckRadioButtonYes() {
        radioButtonTest.open();
        Assert.assertEquals(radioButtonTest.messageYes(), "You have selected Yes",
                "В сообщении неверный текст");
    }

    @Test
    public void CheckRadioButtonImpressive() {
        radioButtonTest.open();
        Assert.assertEquals(radioButtonTest.messageImpressive(), "You have selected Impressive",
                "В сообщении неверный текст");
    }

    @Test
    public void CheckRadioButtonNo() {
        radioButtonTest.open();
        Assert.assertTrue(radioButtonTest.messageNo(), "Сообщения быть не должно");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
