package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class WebTablesPage {
    WebDriver driver;

    By recordButton = By.id("addNewRecordButton");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By userEmail = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By department = By.id("department");
    By submit = By.id("submit");
    By buttDelete = By.id("delete-record-3");

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://demoqa.com/webtables");
    }

    public void fillingField(String Name, String SecName, String Email, String Age, String Salary, String Department) {
        driver.findElement(recordButton).click();
        driver.findElement(firstName).sendKeys(Name);
        driver.findElement(lastName).sendKeys(SecName);
        driver.findElement(userEmail).sendKeys(Email);
        driver.findElement(age).sendKeys(Age);
        driver.findElement(salary).sendKeys(Salary);
        driver.findElement(department).sendKeys(Department);
        driver.findElement(submit).click();
    }

    public void CheckTextField(String Name, String SecName, String Email, String Age, String Salary, String Department) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".rt-tr-group .rt-tr")));
        List<WebElement> rows = driver.findElements(By.cssSelector(".rt-tr-group .rt-tr"));
        WebElement fourthRow = rows.get(3);
        List<WebElement> cells = fourthRow.findElements(By.cssSelector(".rt-td"));

        String firstName = cells.get(0).getText();
        String lastName = cells.get(1).getText();
        String age = cells.get(2).getText();
        String email = cells.get(3).getText();
        String lary = cells.get(4).getText();
        String depr = cells.get(5).getText();

        Assert.assertEquals(Name, firstName);
        Assert.assertEquals(SecName, lastName);
        Assert.assertEquals(Age, age);
        Assert.assertEquals(Email, email);
        Assert.assertEquals(Salary, lary);
        Assert.assertEquals(Department, depr);
    }

    public int FieldDelete() {
        driver.findElement(buttDelete).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".rt-tr-group .rt-tr")));
        List<WebElement> rows = driver.findElements(By.cssSelector(".rt-tr-group .rt-tr"));
        List<WebElement> validRows = rows.stream()
                .filter(row -> !row.getText().trim().isEmpty())
                .collect(Collectors.toList());
        return validRows.size();
    }
}


