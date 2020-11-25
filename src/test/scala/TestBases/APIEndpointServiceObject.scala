package TestBases

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification

abstract class APIEndpointServiceObject {
    var resource: String

    def Get() {}

    def Get(id: String): Unit = {
        var reqSpec = RestAssured.`given`();
        reqSpec.contentType(ContentType.JSON)

        var response = reqSpec.get(resource)
    }

    def Get(reqSpec: RequestSpecification) {}

    def Post() {}


}
