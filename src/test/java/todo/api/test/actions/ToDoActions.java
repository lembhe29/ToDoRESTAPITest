package todo.api.test.actions;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import todo.api.test.Helpers.PropertyHandler;

import java.util.HashMap;

public class ToDoActions
{

    private PropertyHandler prop;
    JsonPath apiToDoData;
    private VerifyAPIData verifyAPIData;

    public ToDoActions()
    {
        prop = new PropertyHandler();
        JsonPath apiToDoData = null;
        verifyAPIData = new VerifyAPIData();
    }

    /**
     *  This method sends GET request to get list of all To dos
     * @return API response
     */
    public Response getToDoList()
    {
        Response response = null;
        try {
            //get api endpoint
            RestAssured.baseURI = prop.getProperty("Todo-REST-API.properties","api.endpoint");
            //Send get request
            response = RestAssured.given()
                    .when()
                    .get(RestAssured.baseURI);
        } catch (Exception e) {
            e.toString();
        }
        return response;
    }

    /**
     * This method sends GET request to get To do details for specific id
     * @param toDoId To do ID
     * @return API response
     */
    public Response getToDoDetails(String toDoId)
    {
        Response response = null;
        try {
            //get api endpoint
            RestAssured.baseURI = prop.getProperty("Todo-REST-API.properties","api.endpoint");
            String resource = "/"+toDoId;
            System.out.println(RestAssured.baseURI +resource);
            //Send get request
            response = RestAssured.given()
                    .when()
                    .get(resource);
        } catch (Exception e) {
            e.toString();
        }
        return response;
    }

    /**
     * This method will POST request to add new To do
     * @param id To do id
     * @return API response
     */
    public Response postToDoDetails(String id)
    {
        Response response = null;
        try {
            //Request body
                String requestBody = "{\"title\": \"foo\",\n" +
                        "\"body\": \"bar\",\n" +
                        "\"id\": "+id+"\n" +
                        "}\n";
            // Building request by using requestSpecBuilder
            RequestSpecBuilder builder = new RequestSpecBuilder();
            //Set request Body
            builder.setBody(requestBody);
            //Setting content type as application/json
            builder.setContentType("application/json; charset=UTF-8");
            RequestSpecification requestSpec = builder.build();

            //Send post request
           RestAssured.baseURI = prop.getProperty("Todo-REST-API.properties","api.endpoint");
            //RestAssured.baseURI = "https://jsonplaceholder.typicode.com/todos/";
            response = RestAssured.given()
                    .spec(requestSpec)
                    .when()
                    .post(RestAssured.baseURI);

        } catch (Exception e) {
            e.toString();
        }
        return response;
    }

    /**
     * This method send PUT request to update specific To do id
     * @param id To do id
     * @return API response
     */
    public Response putToDoDetails(String id)
    {
        //Request body
        String requestBody = "{\"title\": \"foo\",\n" +
                "\"body\": \"bar\",\n" +
                "\"id\": "+id+"\n" +
                "}\n";
        Response response = null;
        try {
            //get api endpoint
            RestAssured.baseURI = prop.getProperty("Todo-REST-API.properties","api.endpoint");
            String resource = "/"+id;
            System.out.println(RestAssured.baseURI +resource);
            //Send get request
            response = RestAssured.given()
                    .body(requestBody)
                    .when()
                    .put(resource);
        } catch (Exception e) {
            e.toString();
        }
        return response;

    }

    /**
     * This method sends DELETE request to delete specific To do id
     * @param id to do id
     * @return API response
     */
    public Response deleteToDoDetails(String id)
    {
        Response response = null;
        try {
            //get api endpoint
            RestAssured.baseURI = prop.getProperty("Todo-REST-API.properties","api.endpoint");
            String resource = "/"+id;
            System.out.println(RestAssured.baseURI +resource);
            //Send get request
            response = RestAssured.given()
                    .when()
                    .delete(resource);
        } catch (Exception e) {
            e.toString();
        }
        return response;

    }

}
