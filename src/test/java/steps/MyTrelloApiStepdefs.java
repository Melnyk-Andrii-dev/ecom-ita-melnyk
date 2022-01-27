package steps;

import enums.CardColors;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import properties.PropertyLoader;
import rest.MyTrelloRestClient;
import rest.TrelloRestClient;
import rest.dto.CardInfoDto;

public class MyTrelloApiStepdefs {
    TrelloRestClient trelloRestClient = new TrelloRestClient();
    MyTrelloRestClient myTrelloRestClient = new MyTrelloRestClient();
    String boardId;
    private Response cardResponse;


//    @When("I create a new board {string}")
//    public void iCreateANewBoard(String name) {
//                trelloRestClient.sendCreateBoardRequest();
//
//       myTrelloRestClient.sendCreateBoardRequest(name);
//        PropertyLoader.putProperty("BOARD_ID", boardId);
//        System.out.println("WRITTEN");
//    }

    @When("[POJO] I create a new board {string}")
    public void iCreateANewBoardPOJO(String name) {
        myTrelloRestClient.sendCreateBoardRequestPojo(name);
    }



    @When("I delete a board")
    public void iDeleteABoard() {
        myTrelloRestClient.sendDeleteBoardRequest();
    }

    @When("[POJO] I delete a board {string}")
    public void iDeleteABoardPOJO(String name) {
        myTrelloRestClient.sendDeleteBoardRequestPojo(name);
    }


    @When("[POJO] I send create a new board request")
    public void pojoISendCreateANewBoardRequest() {
        trelloRestClient.sendCreateBoardRequest();
    }

    @Then("I see {int} status code in get board request")
    public void iSeeStatusCodeInGetBoardRequest(int statusCode) {
        trelloRestClient.sendGetBoardRequest(statusCode);
    }

    @When("I send delete the board request")
    public void iSendDeleteTheBoardRequest() {
        trelloRestClient.sendDeleteBoardRequest();
    }

    @Given("I delete all boards on user's page")
    public void iDeleteAllBoardsOnUsersPage() {
        trelloRestClient.DeleteAllBoards("saomaster");
    }

    @When("I send create a list {string} on the board {string} request")
    public void iSendCreateAListOnTheBoardTestRequest(String listName, String boardName) {
        myTrelloRestClient.sendCreateListRequest(listName, boardName);
    }

    @And("I send create a card {string} on the list request")
    public void iSendCreateACardCardOnTheListListRequest(String cardName) {
        myTrelloRestClient.sendCreateCardRequest(cardName);
    }

    @And("I change the card color to {}")
    public void iChangeTheCardColorToGreen(CardColors color) {
       cardResponse = myTrelloRestClient.sendChangeCardColorRequest(color);
       cardResponse.prettyPrint();

    }

    @Then("I see in response that color is {}")
    public void iSeeInResponseThatColorIsGreen(CardColors color) {
        CardInfoDto cardInfoDto = cardResponse.as(CardInfoDto.class);
        String actualColor = cardInfoDto.getCover().getColor();
        Assertions.assertThat(actualColor).as("Color is different").isEqualTo(color.toString());
    }

    @And("I add checklist to the card")
    public void iAddChecklistToTheCard() {
        myTrelloRestClient.sendCreateChecklistRequest(cardResponse.as(CardInfoDto.class).getId());
    }

    @And("I add a comment {string} to the card")
    public void iAddACommentTestCommentToTheCard(String comment) {
        myTrelloRestClient.sendAddCommentRequest(cardResponse.as(CardInfoDto.class).getId(), comment);
    }

    @And("I send delete the card request")
    public void iSendDeleteTheCardRequest() {
        myTrelloRestClient.sendDeleteCardRequest(cardResponse.as(CardInfoDto.class).getId());
    }
}
