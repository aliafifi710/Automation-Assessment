
import Utils.WebDriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static Utils.WebDriverHelper.*;
import static pages.SubscriptionPage.*;

public class TestsBahrein {
    WebDriver driver;
    WebDriverHelper helper;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        helper = new WebDriverHelper(driver);
        helper.maximize();
        String URL = "https://subscribe.stctv.com/bh-ar";
        helper.NavigateTo(URL);

    }

    @Test
    public void ValidBasicSubscriptionTypeTC() {
        String subs_type = helper.GetText(Subscription_type_Basic);
        Assert.assertEquals(subs_type, "بيسك");
    }

//    @Test
//    public void InValidBasicSubscriptionTypeTC() {
//        String subs_type = GetText(Subscription_type_Basic);
//        Assert.assertEquals(subs_type, "بريميوم");
//    }

    @Test
    public void ValidPremiumSubscriptionTypeTC() {
        String subs_type = helper.GetText(Subscription_type_Premium);
        Assert.assertEquals(subs_type, "بريميوم");
    }

//    @Test
//    public void InValidPremiumSubscriptionTypeTC() {
//        String subs_type = GetText(Subscription_type_Basic);
//        Assert.assertEquals(subs_type, "بيسك");
//    }


    @Test
    public void ValidSubscriptionPrice() {
        String price = helper.GetText(Subscription_price);
        Assert.assertEquals(price, "3");
    }

    @Test
    public void ValidSubscriptionCurrency() {
        String price = helper.GetText(Subscription_currency);
        Assert.assertTrue(price.contains("دينار بحريني"));

    }

    @AfterClass
    public void teardown() {
        helper.quit();
    }


}
