package todo.api.test.actions;

import io.restassured.response.Response;
import org.junit.Assert;

public class VerifyAPIData
{
    public VerifyAPIData(){}

    /**
     * This method compare response code returned in API response with expected response code
     * @param response API response
     * @param expectedResponseCode expected response code (200/201)
     */
    public void verifyResponseCode(Response response, int expectedResponseCode)
    {
        assert response != null;
        if (response.getStatusCode() != expectedResponseCode) {
            System.out.println("FAIL : API returns invalid response with response code " + response.getStatusCode());
            Assert.assertEquals("Fail : API returns invalid response with response", expectedResponseCode, response.getStatusCode());
        } else if (response.getStatusCode() == expectedResponseCode) {
            System.out.println("Pass : API returns valid response code " + response.getStatusCode());
        }
    }

    /**
     * This method veriy details returned in API response
     * @param response API response
     * @param expectedId expected To do ID
     */
    public void verifyDetailsForId(Response response, String expectedId)
    {
        try{
            if(response.getStatusCode() == 200){
                String actualId =  response.getBody().jsonPath().getString("id");
                int totalIds=response.getBody().jsonPath().getList("id").size();
                Assert.assertTrue("To do details are NOT returned in the response for id "+expectedId, (totalIds==1));
                Assert.assertTrue("Id returned in response "+actualId+" does not match with expected id "+expectedId,(actualId.equals(expectedId)));
                System.out.println("To do details are returned successfully.");
            }
        } catch (Exception e) {
            e.toString();
        }
    }

    /**
     * This method verify API returns 200 to dos in GET request
     * @param response API response
     */
    public void verifyListData(Response response)
    {
        try{
            verifyResponseCode(response,200);
            if (response.getStatusCode() == 200) {
                int totalIds=response.getBody().jsonPath().getList("id").size();
                Assert.assertTrue("All 200 To dos are NOT returned in the response. Only got "+totalIds+ "ids in the response.", (totalIds==200));
                System.out.println("Total Ids in API response : "+ totalIds);
            }
        } catch (Exception e) {
            e.toString();
        }
    }

}
