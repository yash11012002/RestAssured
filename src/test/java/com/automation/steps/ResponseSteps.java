package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verify_status_code_is(int statusCode) {
        Assert.assertEquals(RestAssuredUtils.getStatusCode(statusCode),statusCode);
    }

    @When("get the data {string} from response and store")
    public void getTheDataFromResponseAndStore(String data) {
        String ID= RestAssuredUtils.getDataFromResponse(data);
        ConfigReader.setConfigProperty(data,ID);
    }
}
