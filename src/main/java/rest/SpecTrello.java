package rest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class SpecTrello {
    private static final String baseUrl = "https://api.trello.com";

    public static RequestSpecification initSpec(){

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("key", "87ddaf6b5fe44a2f78ec305c4b2780fb");
        queryParams.put("token", "c9046ee9f62002304f2d002a5069d07e8b807c481ca7a23eeae962ca432985c9");

        return RestAssured.given().baseUri(baseUrl).queryParams(queryParams);

    }
}
