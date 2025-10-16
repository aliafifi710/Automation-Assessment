package APIUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {
    private static final String BASE_URL = "https://api.zippopotam.us";

    public static Response getLocation(String country, String postalCode) {
        return RestAssured
                .given().log().method().log().uri()
                .baseUri(BASE_URL)
                .when()
                .get("/" + country + "/" + postalCode)
                .then().log().status().log().body()
                .extract()
                .response();
    }
}
