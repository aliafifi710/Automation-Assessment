
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import APIUtils.ApiUtils;

public class ZippopotamTests {
    String country = "";
    String zipCode = "";

    @Test (priority = 1)
    public void testValidZipCodeUS() {
        country = "BE";
        zipCode = "1000";
        Response res = ApiUtils.getLocation(country, zipCode);
        Assert.assertEquals(res.statusCode(), HttpStatus.SC_OK, "Expected 200 OK");
        Assert.assertEquals(res.jsonPath().getString("country"), "Belgium");
    }

    @Test(priority = 2)
    public void testInvalidCountryCode() {
        country = "BU";
        zipCode = "1000";
        Response res = ApiUtils.getLocation(country, zipCode);
        Assert.assertEquals(res.statusCode(), HttpStatus.SC_NOT_FOUND, "Expected 404 Not Found");
    }

    @Test(priority = 2)
    public void testInvalidCountryCodeCaseSensitive() {
        country = "be";
        zipCode = "1000";
        Response res = ApiUtils.getLocation(country, zipCode);
        Assert.assertEquals(res.statusCode(), HttpStatus.SC_NOT_FOUND, "Expected 404 Not Found");
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
        country = "BE";
        zipCode = "1000";
        Response res = ApiUtils.getLocation(country, zipCode);
        Assert.assertTrue(res.time() < 2000, "Response took too long!");
    }

}

