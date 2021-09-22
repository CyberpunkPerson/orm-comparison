package com.github.cyberpunkperson.orm.comparison

import com.github.cyberpunkperson.orm.comparison.scenario.OrderLoadScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt

class OrderLoadTest extends Simulation {

  val httpConf = http.baseUrl("http://localhost:8080")

  setUp(
    OrderLoadScenario("getOrderById").inject(
      constantUsersPerSec(100).during(60.seconds),
    )
      .andThen(
        OrderLoadScenario("getOrders").inject(
          constantUsersPerSec(100).during(60.seconds)
        ).andThen(
          OrderLoadScenario("getOrdersByAddressId").inject(
            constantUsersPerSec(100).during(60.seconds)
          ).andThen(
            OrderLoadScenario("getOrdersByItemsId").inject(
              constantUsersPerSec(100).during(60.seconds)
            ).andThen(
              OrderLoadScenario("putOrder").inject(
                constantUsersPerSec(100).during(60.seconds)
              )
            )
          )
        )
      )
  ).protocols(httpConf)
}
