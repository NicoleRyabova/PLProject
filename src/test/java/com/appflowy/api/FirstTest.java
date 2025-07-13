package com.appflowy.api;
import com.appflowy.core.BaseClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FirstTest extends BaseClass {
   @Test(description = "Проверка имен у шаблонов")
    public void testTemplateNAmes() {
        given()
                .baseUri(address.getApiStartAddress())
                .when()
                .get(address.getApiAddressForTemplates())
                .then()
                .statusCode(200)
                .body("data.children[0].children.name", containsInAnyOrder(dataForBody.templateNames.toArray()))
                .body("data.children[0].children.name.size()", equalTo(8));
    }
}