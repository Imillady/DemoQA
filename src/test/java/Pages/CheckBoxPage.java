package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CheckBoxPage {
    WebDriver driver;

    By uncheckAll = By.className("rct-icon-uncheck");
    By checkAll = By.className("rct-icon-check");
    By alltext = By.cssSelector("#result span");

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demoqa.com/checkbox");
    }

    public void booleanNotSelected() {
        boolean isNotSelectedHome = driver.findElement(uncheckAll).isSelected();
        Assert.assertFalse(isNotSelectedHome, "Чекбокс выбран изнчально");
    }

    public boolean clickBooleanSelected() {
        driver.findElement(uncheckAll).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(checkAll).isSelected();
    }

    public String checkMessage1() {
        List<WebElement> elements = driver.findElements(alltext);
        StringBuilder actualText = new StringBuilder();
        for (WebElement element : elements) {
            actualText.append(element.getText());
        }
        return actualText.toString();
    }

    public String expectedText1() {
        return "You have selected :" +
                "homedesktopnotescommandsdocumentsworkspacereactangularveuofficepublicprivateclassifiedgeneral"
                + "downloadswordFileexcelFile";
    }

    public String expectedText2() {
        return "You have selected :" +
                "classifiedexcelFile";
    }

    public void clickSelected() {
        driver.findElement(By.className("rct-icon-expand-all")).click();
        driver.findElement(By.xpath("(//span)[134]")).click();
        driver.findElement(By.xpath("(//span)[112]")).click();
    }

    public String checkMessage2() {
        List<WebElement> elements = driver.findElements(By.cssSelector("#result span"));
        StringBuilder actualText = new StringBuilder();
        for (WebElement element : elements) {
            actualText.append(element.getText());
        }
        return actualText.toString();
    }
}

