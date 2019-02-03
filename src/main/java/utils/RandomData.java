package utils;

import entity.Data;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.get;

public abstract class RandomData {

    @Step("Get random data from https://randomuser.me/api/")
    public static Data getRandomData() {
        Data randomData = new Data();
        JsonPath response = get("https://randomuser.me/api/").then()
                .assertThat().statusCode(200)
                .extract().body().jsonPath();
        randomData.setEmail(response.getString("results.email"));
        randomData.setTimeZoneOffset(response.getString("results.location.timezone.offset"));
        randomData.setTimeZoneDescr(response.getString("results.location.timezone.description"));
        return randomData;
    }
}