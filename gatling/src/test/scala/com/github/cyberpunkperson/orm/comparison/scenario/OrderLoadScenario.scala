package com.github.cyberpunkperson.orm.comparison.scenario

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

object OrderLoadScenario {


  def apply(name: String): ScenarioBuilder = name match {
    case "getOrders" => getOrders()
    case "getOrderById" => getOrderById("0c25201f-c9a8-490f-8f5b-c22c799d337f")
    case "getOrdersByAddressId" => getOrdersByAddressId("a8b6deab-0962-4fe8-a19e-b1811cc71aff")
    case "getOrdersByItemsId" => getOrdersByItemsId()
    case "putOrder" => putOrder()
  }


  def getOrders() =
    scenario("getOrders")
      .exec(toActionBuilder(http("Get all existing orders")
        .get("/orders")))

  def getOrderById(id: String) =
    scenario("getOrderById")
      .exec(toActionBuilder(http("Get order by id")
        .get("/orders/" + id)))

  def getOrdersByAddressId(addressId: String) =
    scenario("getOrdersByAddressId")
      .exec(toActionBuilder(http("Get orders by addressId")
        .get("/orders/address/" + addressId)))

  def getOrdersByItemsId() =
    scenario("getOrdersByItemsId")
      .exec(toActionBuilder(http("Get orders by items id")
        .post("/orders/contain-items")
        .body(StringBody(
          """
            {
             "payload": ["68cdb740-323a-479b-aee2-948a5e9ec140", "ae3a5121-0bf3-40df-b867-dceb56f0bd3e"]
            }
            """.stripMargin)).asJson))

  def putOrder() =
    scenario("putOrder")
      .exec(toActionBuilder(http("Save or update existing order")
        .put("/orders")
        .body(StringBody(
          """
           {
              "payload": {
                  "id": "6c54237f-7092-4d63-9227-449ffde3586c",
                  "userId": "c8356372-432c-4f8e-9cfb-329d911817b1",
                  "address": {
                      "id": "d576fafc-8743-40a0-9685-fa5ac9c690c5",
                      "country": "Russia",
                      "city": "Moscow",
                      "street": "Tverskaya 12",
                      "zip": 12345
                  },
                  "items": [
                      {
                          "id": "ae3a5121-0bf3-40df-b867-dceb56f0bd3e",
                          "title": "Coolest backpack",
                          "description": "backpack",
                          "price": 20
                      },
                      {
                          "id": "68cdb740-323a-479b-aee2-948a5e9ec140",
                          "title": "Coffee",
                          "description": "drink",
                          "price": 2
                      }
                  ]
              }
          }
            """.stripMargin)).asJson))
}
