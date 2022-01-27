package rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import rest.dto.CreatedBoardDto;
import rest.requestSpecifications.RequestSpecifications;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TrelloRestClient {

    private final String boardEndpoind = "/1/boards/";
    Header header = new Header("Content-Type", "application/json");
    private String id;

    public void sendCreateBoardRequest() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", "B20Board6");

//        Response response = given()
//                .spec(SpecTrello.initSpec())
//                .contentType(ContentType.JSON)
//                .header(header)
//                .queryParams(queryParams)
//                .when()
//                .post(boardEndpoind)
//                .then()
//                .statusCode(200)
//                .and().extract().response();

        Response response = given()
                .spec(RequestSpecifications.basicSpec)
                .queryParams(queryParams)
                .log().all()
                .when()
                .post(boardEndpoind)
                .then()
                .statusCode(200)
                .and().extract().response();

        id = response.as(CreatedBoardDto.class).getId();
    }

    public void sendDeleteBoardRequest() {
        given()
                .spec(SpecTrello.initSpec())
                .header(header)
                .delete(boardEndpoind + id)
                .then().statusCode(200);
    }

    public void sendGetBoardRequest(int statusCode) {
        given()
                .spec(SpecTrello.initSpec())
                .header(header)
                .get(boardEndpoind + id)
                .then().statusCode(statusCode);
    }

    public void DeleteAllBoards(String userId) {
        Response response = given()
                .spec(SpecTrello.initSpec())
                .header(header)
                .get("/1/members/" + userId + "/boards")
                .then()
                .statusCode(200)
                .and()
                .extract().response();
        List<CreatedBoardDto> createdBoardDtoList = Arrays.asList(response.as(CreatedBoardDto[].class));

        for (CreatedBoardDto createdBoardDto : createdBoardDtoList) {
//            if (createdBoardDto.getIdOrganization().equals("610506ec0e99870a9d9c8f62")) {
//                given()
//                        .spec(SpecTrello.initSpec())
//                        .header(header)
//                        .delete(boardEndpoind + createdBoardDtos[i].getId())
//                        .then().statusCode(200);
//                //    System.out.println(createdBoardDtos[i]);
//            }
            if (createdBoardDto.getIdOrganization().equals("610506ec0e99870a9d9c8f62")) {
                given()
                        .spec(SpecTrello.initSpec())
                        .header(header)
                        .log().all()
                        .delete(boardEndpoind + createdBoardDto.getId())
                        .then().statusCode(200);
                //    System.out.println(createdBoardDtos[i]);
            }
        }
    }
}

