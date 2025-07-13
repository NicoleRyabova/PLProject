package com.appflowy.api;

import com.appflowy.core.BaseClass;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class AuthorizationTests extends BaseClass {
    @Test(description = "Проверка получения кода с корректной почтой")
    public void testEmailAddress() {
        given()
                .baseUri(address.getApiStartAddress())
                .contentType(ContentType.JSON)
                .body(dataForBody.requestBody)
                .log().all()
                .when()
                .post(address.getMagicLink())
                .then()
                .log().all()
                .statusCode(200)
                .body(equalTo("{}"));
    }

    @Test(description = "Проверка получения кода с некорректной почтой")
    public void testEmailAddressError() {
        given()
                .baseUri(address.getApiStartAddress())
                .contentType(ContentType.JSON)
                .body(dataForBody.invalidRequestBody)
                .log().all()
                .when()
                .post(address.getMagicLink())
                .then()
                .log().all()
                .statusCode(400).body("code", equalTo(400))
                .body("error_code", equalTo("validation_failed"))
                .body("msg", containsString("Unable to validate email address"));
    }

    @Test(description = "Проверка редиректа на страницу регистрации")
    public void testLoginPageRedirect() {
        given()
                .baseUri(address.getAddress())
                .queryParam("redirectTo", address.getRegistrationAddress())
                .queryParam("email", dataForBody.email)
                .queryParam("action", "checkEmail")
                .header("Referer", address.getRedirectTo() + address.getEncodedRedirectUrl() +
                        "&email=" + dataForBody.email + "&action=checkEmail")
                .log().uri()
                .when()
                .get("/login")
                .then()
                .log().ifValidationFails()
                .statusCode(200);
    }
}
