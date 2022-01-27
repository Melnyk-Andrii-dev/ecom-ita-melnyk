package rest;

import enums.CardColors;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import rest.dto.CardCover;
import rest.dto.CreatedCardDto;
import rest.dto.CreatedListDto;
import rest.requestSpecifications.RequestSpecifications;

import java.io.*;
import java.util.*;

import static io.restassured.RestAssured.given;

public class MyTrelloRestClient {

    private String boardId;
    private String listId;
    private String cardId;
    private Response cardInformationResponse;

    public void sendCreateBoardRequest(String name) {
        String url = "https://api.trello.com/1/boards/";
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", name);
        queryParams.put("key", "87ddaf6b5fe44a2f78ec305c4b2780fb");
        queryParams.put("token", "c9046ee9f62002304f2d002a5069d07e8b807c481ca7a23eeae962ca432985c9");
        Header header = new Header("Content-Type", "application/json");

        Response response = given()
                .contentType(ContentType.JSON)
                .header(header)
                .queryParams(queryParams)
                .post(url)
                .then().statusCode(200)
                .and().extract().response();
        response.prettyPrint();
        boardId = response.jsonPath().getString("id");
    }

    public void sendDeleteBoardRequest() {
        String url = String.format("https://api.trello.com/1/boards/%s", boardId);
        Map<String, String> queryParams = new HashMap<>();
//        queryParams.put("id", boardId);
        queryParams.put("key", "87ddaf6b5fe44a2f78ec305c4b2780fb");
        queryParams.put("token", "c9046ee9f62002304f2d002a5069d07e8b807c481ca7a23eeae962ca432985c9");
        Header header = new Header("Content-Type", "application/json");

        Response response = given()
                .contentType(ContentType.JSON)
                .header(header)
                .queryParams(queryParams)
                .delete(url)
                .then().statusCode(200)
                .and().extract().response();
    }


    public void sendCreateBoardRequestPojo(String name) {

        BoardInfo boardInfo = new BoardInfo();
        String url = "https://api.trello.com/1/boards/";
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", name);
        queryParams.put("key", "87ddaf6b5fe44a2f78ec305c4b2780fb");
        queryParams.put("token", "c9046ee9f62002304f2d002a5069d07e8b807c481ca7a23eeae962ca432985c9");
        Header header = new Header("Content-Type", "application/json");

        boardInfo = given()
                .contentType(ContentType.JSON)
                .header(header)
                .queryParams(queryParams)
                .when()
                .post(url).as(BoardInfo.class);

        File file = new File("data/BoardInfo18-12v2.dat");

        if (file.length() == 0) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/BoardInfo18-12v2.dat", true))) {
                oos.writeObject(boardInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (MyOutputStream mos = new MyOutputStream(new FileOutputStream("data/BoardInfo18-12v2.dat", true))) {
                mos.writeObject(boardInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendDeleteBoardRequestPojo(String name) {


        String id = BoardInfoUtils.getIdByNameFromFile(name);

        String deleteEndpoint = String.format("/1/boards/%s", id);
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("id", id);

        Response response = given()
                .spec(RequestSpecifications.basicSpec)
                .queryParams(queryParams)
                .when()
                .delete(deleteEndpoint)
                .then().statusCode(200)
                .and().extract().response();
//        return response.jsonPath().getString("id");
    }


    public void sendCreateListRequest(String listName, String boardName) {
        String id = BoardInfoUtils.getIdByNameFromFile(boardName);
        String createListEndpoint = String.format("/1/boards/%s/lists", id);

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", listName);

        Response response = given()
                .spec(RequestSpecifications.basicSpec)
                .queryParams(queryParams)
                .when()
                .post(createListEndpoint)
                .then().statusCode(200)
                .and().extract().response();

        CreatedListDto createdListDto = response.as(CreatedListDto.class);
        listId = createdListDto.getId();
        //      BoardInfoUtils.wtiteListToFile(createdListDto, new File("data/Lists"));
    }

    public void sendCreateCardRequest(String cardName) {
        String createCardEndpoint = "/1/cards";
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("name", cardName);
        queryParams.put("idList", listId);

        Response response = given()
                .spec(RequestSpecifications.basicSpec)
                .queryParams(queryParams)
                .when()
                .post(createCardEndpoint)
                .then().statusCode(200)
                .and().extract().response();

        cardId = response.as(CreatedCardDto.class).getId();
    }

    public Response sendChangeCardColorRequest(CardColors color) {
        String updateCardEndpoint = "/1/cards/" + cardId;
        CardCover.Cover cover = CardCover.Cover.builder().color(color.toString()).build();
        CardCover cardCover = new CardCover(cover);
        return given()
                .spec(RequestSpecifications.basicSpec)
                .body(cardCover)
                .log().all()
                .when()
                .put(updateCardEndpoint)
                .then().statusCode(200)
                .and().extract().response();

//        String body = "{\"cover\": {\n" +
//                "        \"idAttachment\": null,\n" +
//                "        \"color\": \"pink\",\n" +
//                "        \"size\": \"normal\",\n" +
//                "        \"brightness\": \"light\"" +
//                "    }}";
//        Response response = given()
//                .spec(RequestSpecifications.basicSpec)
//         //       .queryParams(queryParams)
//                .body(body)
//                .log().all()
//                .when()
//                .put(updateCardEndpoint)
//                .then().statusCode(200)
//                .and().extract().response();
    }

    public void sendCreateChecklistRequest(String idCard) {
        String checklistEndpoint = "/1/checklists";
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("idCard", idCard);
        given()
                .spec(RequestSpecifications.basicSpec)
                .queryParams(queryParams)
                .post(checklistEndpoint)
                .then().statusCode(200);
    }

    public void sendAddCommentRequest(String idCard, String comment) {
        String commentEndpoint = "/1/cards/" + idCard + "/actions/comments";
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("text", comment);
        given()
                .spec(RequestSpecifications.basicSpec)
                .queryParams(queryParams)
                .post(commentEndpoint)
                .then().statusCode(200);

    }

    public void sendDeleteCardRequest(String idCard) {
        String deleteCardEndpoint = "/1/cards/" + idCard;
        given()
                .spec(RequestSpecifications.basicSpec)
                .delete(deleteCardEndpoint)
                .then().statusCode(200);
    }
}
