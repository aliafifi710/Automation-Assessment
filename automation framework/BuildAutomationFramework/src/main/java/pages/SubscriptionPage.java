package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubscriptionPage {

    private WebDriver driver;

    // Locators for Subscription Packages
    public static By Subscription_type_Premium = By.cssSelector("div[data-test-id='PLUS_TIER-component'] > div[class='tier_header__BVwjg'] > [class='tier_title__sPVd1']");
    public static By Subscription_type_Basic = By.cssSelector("div[data-test-id='FREE_TIER-component'] > div[class='tier_header__BVwjg'] > [class='tier_title__sPVd1']");
    public static By Subscription_currency = By.cssSelector("div[data-test-id='tier-price'] > i");
    public static By Subscription_price = By.cssSelector("div[data-test-id='tier-price'] > b");
    public static By premium_button = By.cssSelector("div[data-test-id='PLUS_TIER-component'] > div[class='tier_features__BPje1']");
    public static By Basic_button = By.cssSelector("div[data-test-id='FREE_TIER-component'] > div[class='tier_features__BPje1']");

}
