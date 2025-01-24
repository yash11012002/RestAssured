package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {

    @Before
    public void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        ConfigReader.initiateProperties();
    }
}
