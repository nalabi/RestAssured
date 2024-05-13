package day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class HTTPRequests {
    @Test
    void getUser(){
        given()

                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("page",equalTo(2))
                .log().all();

    }

    @Test
  void createUser(){
        HashMap data = new HashMap();
        data.put("name","John");
        data.put("job","om");
        given()
                .contentType("application/json")
                .body(data)
                .when()
                        .post("https://reqres.in/api/users").
                then()
                .statusCode(201)
                .log().all();
  }

}

