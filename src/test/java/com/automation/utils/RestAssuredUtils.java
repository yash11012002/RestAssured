package com.automation.utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestAssuredUtils {
    static RequestSpecification requestSpecification= RestAssured.given();
    static Response response;
    static String endpoint;

    public static void setEndpoint(String endpoint){
        RestAssuredUtils.endpoint=endpoint;
    }
    public static void setHeader(String key, String value){
        requestSpecification.header(key,value);
    }
    public static void setBody(String filepath){
        try {
            requestSpecification.body(getDataFromJsonFile(filepath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static String  getDataFromJsonFile(String filepath) throws FileNotFoundException {
        String jsonFolderPath="src/test/resources/data/";
        Scanner sc=new Scanner(new FileInputStream(jsonFolderPath+filepath));
        String  body=sc.useDelimiter("//Z").next();
        return body;
    }
    public static void post(){
        requestSpecification.log().all();
        response=requestSpecification.post(endpoint);
        response.then().log().all();
    }
    public static void put(){
        String id="1";
        requestSpecification.log().all();
        response=requestSpecification.put(endpoint+id);
        response.then().log().all();
    }
    public static void delete(){
        String id=ConfigReader.getConfigProperty("id");
        requestSpecification.log().all();
        response=requestSpecification.delete(endpoint+id);
        response.then().log().all();
    }
    public static void get(){
        String id=ConfigReader.getConfigProperty("id");
        requestSpecification.log().all();
        response=requestSpecification.get(endpoint+id);
        response.then().log().all();
    }
    public static int getStatusCode(int statusCode){
        return response.getStatusCode();
    }
    public static String getDataFromResponse(String key){
        JsonPath jsonresponse=response.jsonPath();
        String value=jsonresponse.getString(key);
        return value;
    }

}
