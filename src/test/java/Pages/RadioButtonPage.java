package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage {
    WebDriver driver;

    By buttonYes = By.cssSelector("label[for='yesRadio']");
    By message = By.className("mt-3");
    By buttonImpressive = By.cssSelector("label[for='impressiveRadio']");
    By buttonNo = By.cssSelector("label[for='noRadio']");


    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demoqa.com/radio-button");
    }

    public String messageYes() {
        driver.findElement(buttonYes).click();
        return driver.findElement(message).getText();
    }

    public String messageImpressive() {
        driver.findElement(buttonImpressive).click();
        return driver.findElement(message).getText();
    }

    public boolean messageNo() {
        driver.findElement(buttonNo).click();
        return driver.findElements(message).isEmpty();
    }
}
