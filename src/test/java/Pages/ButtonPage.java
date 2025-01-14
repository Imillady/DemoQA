package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ButtonPage {
    WebDriver driver;

    By ButtDoubleClick = By.id("doubleClickBtn");
    By ButtDynamicClick = By.xpath("//button[text()='Click Me']");
    By ButtRightClick = By.id("rightClickBtn");
    By MessageDoubleClick = By.id("doubleClickMessage");
    By MessageRightClick = By.id("rightClickMessage");
    By MessageDynamicClick = By.id("dynamicClickMessage");

    public ButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demoqa.com/buttons");
    }

    public String DoubleClick() {
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(ButtDoubleClick)).perform();
        return driver.findElement(MessageDoubleClick).getText();
    }

    public String RightClick() {
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(ButtRightClick)).perform();
        return driver.findElement(MessageRightClick).getText();
    }

    public String DynamicClick() {
        driver.findElement(ButtDynamicClick).click();
        return driver.findElement(MessageDynamicClick).getText();
    }

}
