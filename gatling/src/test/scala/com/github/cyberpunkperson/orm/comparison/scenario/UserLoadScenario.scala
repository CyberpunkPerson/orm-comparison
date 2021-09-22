package com.github.cyberpunkperson.orm.comparison.scenario

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

object UserLoadScenario {

  def apply(name: String): ScenarioBuilder = name match {
    case "getUsers" => getUsers()
    case "getUserById" => getUserById("f325dd43-e8cb-4aaf-9da2-b10ede8e42d0")
    case "putUser" => putUser()
  }

  def getUsers() =
    scenario("getUsers")
      .exec(toActionBuilder(http("Get all existing users")
        .get("/users")))

  def getUserById(id: String) =
    scenario("getUserById")
      .exec(toActionBuilder(http("Get user by id")
        .get("/users/" + id)))

  def putUser() =
    scenario("putUser")
      .exec(toActionBuilder(http("Save or update existing user")
        .put("/users")
        .body(StringBody(
          """
             {
                "payload": {
                              "id": "c8356372-432c-4f8e-9cfb-329d911817b1",
                              "name": "Petia",
                              "address": {
                                  "id": "d576fafc-8743-40a0-9685-fa5ac9c690c5",
                                  "country": "Russia",
                                  "city": "Moscow",
                                  "street": "Tverskaya 12",
                                  "zip": 12345
                              }
                }
              }
            """.stripMargin)).asJson))

}
