package todo.api.test.stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import todo.api.test.Helpers.PropertyHandler;
import todo.api.test.actions.ToDoActions;
import todo.api.test.actions.VerifyAPIData;

public class TodoAPIStepDef
{

    private PropertyHandler prop;
    private ToDoActions toDoActions;
    private VerifyAPIData verifyAPIData;
    private Response restAPIResponse;

    public TodoAPIStepDef()
    {
        prop = new PropertyHandler();
        toDoActions = new ToDoActions();
        verifyAPIData = new VerifyAPIData();
    }
    @Given("I send a valid request to Todo REST API to get all list")
    public void iSendAValidRequestToTodoRESTAPIToGetAllList()
    {
        restAPIResponse=toDoActions.getToDoList();
    }

    @Given("^I send a valid request to Todo REST API to get details for (.*?)$")
    public void sendRequestToRESTAPI(String toDoId){
        System.out.println("Sending request to API to get details for "+toDoId);
        restAPIResponse = toDoActions.getToDoDetails(toDoId);

    }

    @Then("^I a list of all Todo is returned successfully$")
    public void iGetAListOfAllToDosIsReturnedSuccessfully()
    {
        System.out.println("Verifying list data");
        verifyAPIData.verifyListData(restAPIResponse);
    }

    @Then("^I verify details for Todo (.*?) are returned successfully$")
    public void iGetADetailsForToDoId(String id)
    {
        System.out.println("Verifying to do data for id "+id);
        verifyAPIData.verifyDetailsForId(restAPIResponse,id);
    }

    @When("^I get valid response (.*?) from REST API$")
    public void iGetValidResponseFromRESTAPI(int responseCode)
    {
        System.out.println("Verifying API response code.");
        verifyAPIData.verifyResponseCode(restAPIResponse,responseCode);
    }

    @When("^I send a valid request to Todo REST API to add new data (.*?)$")
    public void iSendAValidRequestToTodoRESTAPIToAddNewDataId(String id)
    {
        System.out.println("Sending a valid request to Todo REST API to add new data with id"+ id);
        restAPIResponse = toDoActions.postToDoDetails(id);
    }


    @Given("^I send a valid request to Todo REST API to update existing (.*?)$")
    public void iSendAValidRequestToTodoRESTAPIToUpdateExistingId(String id)
    {
        System.out.println("Sending a valid request to Todo REST API o update existing to do id "+id);
        restAPIResponse = toDoActions.putToDoDetails(id);
        System.out.println(restAPIResponse.getStatusCode());
    }

    @Given("^I send a valid request to Todo REST API to delete existing (.*?)$")
    public void iSendAValidRequestToTodoRESTAPIToDeleteExistingId(String id)
    {
        System.out.println("Sending a valid request to Todo REST API to delete existing id "+id);
        restAPIResponse = toDoActions.deleteToDoDetails(id);
    }
}
