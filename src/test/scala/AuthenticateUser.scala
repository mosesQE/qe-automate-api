import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.builder.{RequestSpecBuilder, ResponseSpecBuilder}
import io.restassured.filter.log.{RequestLoggingFilter, ResponseLoggingFilter}
import io.restassured.module.scala.RestAssuredSupport.AddThenToResponse
import io.restassured.specification.{RequestSpecification, ResponseSpecification}
import org.hamcrest.Matchers.{anything, containsString}
import org.scalatest.FunSuite

class AuthenticateUser extends FunSuite {
    private val url = "http://zbport-env.eba-igtuynai.us-east-1.elasticbeanstalk.com/api/zero/v2/"
    private val endpoint = "authorize"
    private var savedResponse = ""

    RestAssured.filters(new RequestLoggingFilter, new ResponseLoggingFilter)

     test("AuthenticateUserSunny200") {
        val response = given()
              .spec(RequestAsJson())
              .body(RequestBody200())
          .when()
              .post(url+endpoint)
          .Then()
              .spec(Response200())
          .and().assertThat()
              .body("authorization", anything())
          .and()
              .body("authorization", containsString("Bearer "))
          .and()
              .extract().response()
        savedResponse = response.asString()

    }

    test("AuthenticateUserRainy401") {
        val response = given()
              .spec(RequestAsJson())
              .body(RequestBody401())
          .when()
             .post(url+endpoint)
          .Then()
              .spec(Response401())
              .and().assertThat()
              .body("authorization", containsString("Bearer "))
              .and()
              .extract().response()
        savedResponse = response.asString()
    }


    def RequestBody200(): String = {
        val map = Map("username" -> "qe", "password" -> "nic&moloveqe")
        JsonUtil.toJson(map)
    }

    def RequestBody401(): String = {
        val map = Map("username" -> "qe", "password" -> "t0tallyWr0ng")
        JsonUtil.toJson(map)
    }

    def RequestAsJson(): RequestSpecification = {
        var builder = new RequestSpecBuilder
        builder.setBaseUri(url+endpoint)
        builder.setContentType("application/json")
        return builder.build()
    }

    def Response200(): ResponseSpecification = {
        val builder = new ResponseSpecBuilder
        builder.expectStatusCode(200)
        builder.expectStatusLine("HTTP/1.1 200 OK")
        builder.expectContentType("application/json")
        return builder.build
    }

    def Response401(): ResponseSpecification = {
        val builder = new ResponseSpecBuilder
        builder.expectStatusCode(401)
        builder.expectStatusLine("HTTP/1.1 401 Unauthorized")
        return builder.build
    }
}
