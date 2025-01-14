package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TextBoxPage {
    WebDriver driver;
    By submit = By.id("submit");
    By userName = By.id("userName");
    By userEmail = By.id("userEmail");
    By currentAddress = By.id("currentAddress");
    By permanentAddress = By.id("permanentAddress");

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demoqa.com/text-box");
    }

    public void fillingField(String Name, String Email, String curAddress, String perAddress) {
        driver.findElement(userName).sendKeys(Name);
        driver.findElement(userEmail).sendKeys(Email);
        driver.findElement(currentAddress).sendKeys(curAddress);
        driver.findElement(permanentAddress).sendKeys(perAddress);
        driver.findElement(submit).click();
    }

    public String expectedText(String Name, String Email, String curAddress, String perAddress) {
        return "Name:" + Name +
                "Email:" + Email +
                "Current Address :" + curAddress +
                "Permananet Address :" + perAddress;
    }

    public String expectedText2(String curAddress, String perAddress) {
        return "Current Address :" + curAddress +
                "Permananet Address :" + perAddress;
    }

    public String checkText() {
        List<WebElement> elements = driver.findElements(By.tagName("p"));
        StringBuilder actualText = new StringBuilder();
        for (WebElement element : elements) {
            actualText.append(element.getText());
        }
        return actualText.toString();
    }
}
