package rest;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.openqa.selenium.json.Json;

import java.io.*;
import java.util.*;

import static io.restassured.RestAssured.given;

public class MyTrelloRestClient {

    private String boardId;

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

        File file = new File("data/BoardInfo15.dat");

        if (file.length() == 0) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/BoardInfo15.dat", true))) {
                oos.writeObject(boardInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (MyOutputStream mos = new MyOutputStream(new FileOutputStream("data/BoardInfo15.dat", true))) {
                mos.writeObject(boardInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String sendDeleteBoardRequestPojo(String name) {
        Map<String, BoardInfo> boardInfoMap = new HashMap<>();
        //HashSet<BoardInfo> hashSet = new HashSet<>();

        BoardInfo boardInfo;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/BoardInfo15.dat"))) {
//            for (int i = 0; i < ois.; i++) {
//                boardInfo = (BoardInfo) ois.readObject();
//                boardInfoMap.put(boardInfo.getName(), boardInfo);
//               // hashSet.add(boardInfo);
//            }

            while ((boardInfo = (BoardInfo) ois.readObject()) != null) {
                boardInfoMap.put(boardInfo.getName(), boardInfo);
                // hashSet.add(boardInfo);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        String id = boardInfoMap.get(name).getId();
        if(id!=null){
            BoardInfoUtils.deleteBoardInfo(boardInfoMap.get(name));
        }
        String url = String.format("https://api.trello.com/1/boards/%s", id);
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("id", id);
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
        return response.jsonPath().getString("id");
    }


}
