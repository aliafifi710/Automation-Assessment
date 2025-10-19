package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverHelper {
    private  WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }


    public  void releaseall() {
        ((RemoteWebDriver) driver).resetInputState();
    }

    public  boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public  void clear(By locator) {
        driver.findElement(locator).clear();
    }

    public  void quit() {
        driver.quit();
    }

    public  void Type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public  WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public  void maximize() {
        driver.manage().window().maximize();
    }

    public void NavigateTo(String URL) {
        driver.navigate().to(URL);
    }

    public  void click(By locator) {
        driver.findElement(locator).click();
    }

    public  boolean isEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    public  String GetText(By locator) {
        return driver.findElement(locator).getText();

    }

    // Get DOM attribute of an element (always returns the initial value of the attribute)
    public  String GetDOMAttribute(By locator, String attribute) {
        return driver.findElement(locator).getDomAttribute(attribute);
    }

    // Get DOM property of an element (returns the current value of the property)
    public  String Getproperty(By locator, String property) {
        return driver.findElement(locator).getDomProperty(property);
    }
}
