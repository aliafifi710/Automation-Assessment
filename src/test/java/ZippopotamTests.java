
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import APIUtils.ApiUtils;

public class ZippopotamTests {
    //data should be passed using data provider or config file
    //for simplicity I am using class variables
    String country = "";
    String zipCode = "";

    @Test (priority = 1)
    public void testValidZipCodeUS() {
        country = "BE";
        zipCode = "1000";
        Response res = ApiUtils.getLocation(country, zipCode);
        Assert.assertEquals(res.statusCode(), HttpStatus.SC_OK, "Expected 200 OK");
        Assert.assertEquals(res.jsonPath().getString("country"), "Belgium");
//        Assert.assertEquals(res.jsonPath().getString("places[0].'place name'"), "Bruxelles");
//        Assert.assertEquals(res.jsonPath().getDouble("places[0].latitude"), 50.8466);
//        Assert.assertEquals(res.jsonPath().getDouble("places[0].longitude"), 4.3528);
//        Assert.assertEquals(res.jsonPath().getString("places[0].state"), "Bruxelles-Capitale");

    }
    //this test should return 404 because there is no such country code BU
    //but the api returns 505 internal server error instead
    //this may depend on the api design
    @Test(priority = 2)
    public void testInvalidCountryCode() {
        country = "BU";
        zipCode = "1000";
        Response res = ApiUtils.getLocation(country, zipCode);
        Assert.assertEquals(res.statusCode(), HttpStatus.SC_NOT_FOUND, "Expected 404 Not Found");
    }
    //this test should return 404 because there is no such country code BU
    //but the api returns 505 internal server error instead
    //this may depend on the api design
    @Test(priority = 2)
    public void testInvalidCountryCodeWrongFormat() {
        country = "12345";
        zipCode = "1000";
        Response res = ApiUtils.getLocation(country, zipCode);
        Assert.assertEquals(res.statusCode(), HttpStatus.SC_NOT_FOUND, "Expected 404 Not Found");
    }


    //this test tests case sensitivity of country code
    //this depends also on the api design
    //for this website it is not case-sensitive so it will return 200 OK
    @Test(priority = 2)
    public void testInvalidCountryCodeCaseSensitive() {
        country = "be";
        zipCode = "1000";
        Response res = ApiUtils.getLocation(country, zipCode);
        Assert.assertEquals(res.statusCode(), HttpStatus.SC_OK, "Expected 404 Not Found");
    }

    @Test (priority = 3)
    public void testInvalidZipCode() {
        country = "BE";
        zipCode = "1234";
        Response res = ApiUtils.getLocation(country, zipCode);
        Assert.assertEquals(res.statusCode(), HttpStatus.SC_NOT_FOUND, "Expected 404 Not Found");
    }

    @Test (priority = 3)
    public void testInvalidEmptyArgs() {
        country = "";
        zipCode = "1234";
        Response res = ApiUtils.getLocation(country, zipCode);
        Assert.assertEquals(res.statusCode(), HttpStatus.SC_NOT_FOUND, "Expected 404 Not Found");
    }

    @Test (priority = 4)
    public void testResponseTime() {
        int timeThreshold = 2000; // 2 seconds
        country = "BE";
        zipCode = "1000";
        Response res = ApiUtils.getLocation(country, zipCode);
        Assert.assertTrue(res.time() < timeThreshold, "Response took too long!");
    }

}

