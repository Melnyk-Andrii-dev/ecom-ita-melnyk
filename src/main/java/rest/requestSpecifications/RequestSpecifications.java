package rest.requestSpecifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import rest.dto.CardCover;

import java.util.HashMap;
import java.util.Map;

public class RequestSpecifications {
    private static final String baseUrl = "https://api.trello.com";


    public static RequestSpecification basicSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(baseUrl)
            .addHeader("Content-Type", "application/json")
            .addQueryParam("key", "87ddaf6b5fe44a2f78ec305c4b2780fb")
            .addQueryParam("token", "c9046ee9f62002304f2d002a5069d07e8b807c481ca7a23eeae962ca432985c9")
            .build();

//    public static RequestSpecification colorSpec = new RequestSpecBuilder()
//            .setContentType(ContentType.JSON)
//            .setBaseUri(baseUrl)
//            .addHeader("Content-Type", "application/json")
//            .addQueryParam("key", "87ddaf6b5fe44a2f78ec305c4b2780fb")
//            .addQueryParam("token", "c9046ee9f62002304f2d002a5069d07e8b807c481ca7a23eeae962ca432985c9")
//            .addQueryParam("cover", new CardCover("", "blue", false, "" , "light", false))
//            .setBody(new CardCover("", "green", false, "" , "light", false))
//            .build();

}
