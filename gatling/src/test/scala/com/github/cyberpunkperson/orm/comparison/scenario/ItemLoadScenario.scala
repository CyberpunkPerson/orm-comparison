package com.github.cyberpunkperson.orm.comparison.scenario

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

object ItemLoadScenario {

  def apply(name: String): ScenarioBuilder = name match {
    case "getItems" => getItems()
    case "getItemById" => getItemById("ae3a5121-0bf3-40df-b867-dceb56f0bd3e")
    case "putItem" => putItem()
  }

  def getItems() =
    scenario("getItems")
      .exec(toActionBuilder(http("Get all existing items")
        .get("/items")))

  def getItemById(id: String) =
    scenario("getItemById")
      .exec(toActionBuilder(http("Get item by id")
        .get("/items/" + id)))

  def putItem() =
    scenario("putItem")
      .exec(toActionBuilder(http("Save or update existing item")
        .put("/items")
        .body(StringBody(
          """
            {
              "payload": {
                            "id": "ae49f8c3-9b15-4ea8-9945-1ce1969e9884",
                            "title": "For whom the bell tolls",
                            "description": "books",
                            "price": 15.0
                          }
            }
            """.stripMargin)).asJson))
}
