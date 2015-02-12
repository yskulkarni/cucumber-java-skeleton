package skeleton;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class Stepdefs {

    private static final Gson GSON = new Gson();
    private MyServer myServer;
    private String actualJson;

    @Before
    public void startServer() throws Exception {
        myServer = new MyServer(9988);
        myServer.start();
    }

    @After
    public void stopServer() throws Exception {
        myServer.stop();
    }

    @When("^I GET (.*)$")
    public void i_GET_url(String path) throws Throwable {
        HttpResponse<JsonNode> jsonResponse = Unirest.get("http://localhost:9988" + path).asJson();
        actualJson = jsonResponse.getBody().toString();
    }

    @Then("^the result should be:$")
    public void the_result_should_be(String expectedJson) throws Throwable {
        Message expectedMessage = GSON.fromJson(expectedJson, Message.class);
        Message actualMessage = GSON.fromJson(actualJson, Message.class);
        assertEquals(expectedMessage, actualMessage);
    }
}
