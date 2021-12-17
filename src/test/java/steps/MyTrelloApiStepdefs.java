package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import properties.PropertyLoader;
import rest.MyTrelloRestClient;
import rest.TrelloRestClient;

public class MyTrelloApiStepdefs {
    TrelloRestClient trelloRestClient = new TrelloRestClient();
    MyTrelloRestClient myTrelloRestClient = new MyTrelloRestClient();
    String boardId;


    @When("I create a new board {string}")
    public void iCreateANewBoard(String name) {
                trelloRestClient.sendCreateBoardRequest();

       myTrelloRestClient.sendCreateBoardRequest(name);
        PropertyLoader.putProperty("BOARD_ID", boardId);
        System.out.println("WRITTEN");
    //    myTrelloRestClient.sendCreateBoardRequestPojo(name);
    }

    @When("[POJO] I create a new board {string}")
    public void iCreateANewBoardPOJO(String name) {
//                trelloRestClient.sendCreateBoardRequest();

      //  boardId = myTrelloRestClient.sendCreateBoardRequest(name);
//        PropertyLoader.putProperty("BOARD_ID", boardId);
//        System.out.println("WRITTEN");
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
}
