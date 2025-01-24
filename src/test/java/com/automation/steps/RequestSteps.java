package com.automation.steps;

import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RequestSteps {
    @Given("user set endpoint {string}")
    public void user_set_endpoint(String endpoint) {
        RestAssuredUtils.setEndpoint(endpoint);
    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key,value);
       
    }

    @Given("set body {string}")
    public void set_body(String filepath) {
        RestAssuredUtils.setBody(filepath);
       
    }

    @When("user perform post call")
    public void user_perform_post_call() {
       RestAssuredUtils.post();
    }

    @When("user perform put call")
    public void userPerformPutCall() {
        RestAssuredUtils.put();
    }

    @When("user perform delete call")
    public void userPerformDeleteCall() {
        RestAssuredUtils.delete();
    }

    @When("user perform get call")
    public void userPerformGetCall() {
        RestAssuredUtils.get();
    }


}
