import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestsSaudiArabia {

    WebDriver driver;

    By Subscription_type_Premium = By.cssSelector("div[data-test-id='PLUS_TIER-component'] > div[class='tier_header__BVwjg'] > [class='tier_title__sPVd1']");
    By Subscription_type_Basic = By.cssSelector("div[data-test-id='FREE_TIER-component'] > div[class='tier_header__BVwjg'] > [class='tier_title__sPVd1']");
    By Subscription_currency = By.cssSelector("div[data-test-id='tier-price'] > i");
    By Subscription_price = By.cssSelector("div[data-test-id='tier-price'] > b");
    By premium_button = By.cssSelector("div[data-test-id='PLUS_TIER-component'] > div[class='tier_features__BPje1']");
    By Basic_button = By.cssSelector("div[data-test-id='FREE_TIER-component'] > div[class='tier_features__BPje1']");


    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        maximize();
        String URL = "https://subscribe.stctv.com/sa-ar";
        NavigateTo(URL);

    }

    @Test
    public void ValidBasicSubscriptionTypeTC() {
        String subs_type = GetText(Subscription_type_Basic);
        Assert.assertEquals(subs_type, "بيسك");
    }

//    @Test
//    public void InValidBasicSubscriptionTypeTC() {
//        String subs_type = GetText(Subscription_type_Basic);
//        Assert.assertEquals(subs_type, "بريميوم");
//    }

    @Test
    public void ValidPremiumSubscriptionTypeTC() {
        String subs_type = GetText(Subscription_type_Premium);
        Assert.assertEquals(subs_type, "بريميوم");
    }

//    @Test
//    public void InValidPremiumSubscriptionTypeTC() {
//        String subs_type = GetText(Subscription_type_Basic);
//        Assert.assertEquals(subs_type, "بيسك");
//    }


    @Test
    public void ValidSubscriptionPrice() {
        String price = GetText(Subscription_price);
        Assert.assertEquals(price, "15");
    }

    @Test
    public void ValidSubscriptionCurrency() {
        String price = GetText(Subscription_currency);
        Assert.assertTrue(price.contains("ريال سعودي"));
    }

    @AfterClass
    public void teardown() {
        quit();
    }


    public void releaseall() {
        ((RemoteWebDriver) driver).resetInputState();
    }

    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public void clear(By locator) {
        driver.findElement(locator).clear();
    }

    public void quit() {
        driver.quit();
    }

    public void Type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    void NavigateTo(String URL) {
        driver.navigate().to(URL);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    public String GetText(By locator) {
        return driver.findElement(locator).getText();

    }

    // Get DOM attribute of an element (always returns the initial value of the attribute)
    public String GetDOMAttribute(By locator, String attribute) {
        return driver.findElement(locator).getDomAttribute(attribute);
    }

    // Get DOM property of an element (returns the current value of the property)
    public String Getproperty(By locator, String property) {
        return driver.findElement(locator).getDomProperty(property);
    }
}
