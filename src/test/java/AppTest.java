import org.junit.Test;

import static org.hamcrest.Matchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import config.TestConfig;

import static io.restassured.RestAssured.*;


public class AppTest extends TestConfig {
   
@Test
public void testGetRequest() { // Get Information
    given()
    .when()
        .get("https://dummyjson.com/quotes")
        
    .then()
        .log().all()
        .assertThat()
            .statusCode(200)
            .time(lessThan(5000L)) // Response time less than 5 seconds
        .and()
            .header("Content-Type", containsString("application/json")) // Check content type header
        .and()
            .body("quotes", hasSize(greaterThan(0))); // Verify specific data fields
            
    
}

@Test
public void updateComment() { // Update Comment 
    int commentIdToUpdate = 1;
    String newBody = "This is an updated comment!";
    String commentJson = "{\n" +
                         "  \"body\": \"" + newBody + "\"\n" +
                         "}";

    given()
        .contentType("application/json")
        .body(commentJson)
    .when()
        .put("https://dummyjson.com/comments" + "/" + commentIdToUpdate)
    .then()
        .assertThat()
            .statusCode(200)
            .time(lessThan(5000L)) // Response time less than 5 seconds
        .and()
            .header("Content-Type", containsString("application/json")) // Check content type header
        .and()
            .body("body", equalTo(newBody)) // Verify specific data fields
            .log().all();
}

@Test
public void deleteComment() { // Delete Comment
    int commentIdToDelete = 100;

    given()
    .when()
        .delete("https://dummyjson.com/comments" + "/" + commentIdToDelete) //Delete commente ID 100
    .then()
        .assertThat()
            .statusCode(200)
            .time(lessThan(5000L)) // Response time less than 5 seconds
        .and()
            .header("Content-Type", containsString("application/json")) // Check content type header
            .log().all();
}

@Test
public void schemaValidation() { //We use the same get request for it 
    
    given()
       .when()
           .get("https://dummyjson.com/quotes")
       .then()
           .assertThat()
               .statusCode(200)
               .time(lessThan(5000L)) // Response time less than 5 seconds
           .and()
               .header("Content-Type", containsString("application/json")) // Check content type header
           .and()
               .body("quotes", hasSize(greaterThan(0))) // Verify specific data fields
               .body(matchesJsonSchemaInClasspath("QuoteSchema.json")) //Here its the test to see if the body matches the QuoteSchema
               .log().all();
       }

}





