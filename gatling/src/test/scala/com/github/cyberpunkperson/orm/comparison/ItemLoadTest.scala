package com.github.cyberpunkperson.orm.comparison

import com.github.cyberpunkperson.orm.comparison.scenario.ItemLoadScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration.DurationInt

class ItemLoadTest extends Simulation {

  val httpConf = http.baseUrl("http://localhost:8080")

  setUp(
    ItemLoadScenario("getItemById").inject(
      constantUsersPerSec(100).during(60.seconds)
    ).andThen(
      ItemLoadScenario("getItems").inject(
        constantUsersPerSec(100).during(60.seconds)
      ).andThen(
        ItemLoadScenario("putItem").inject(
          constantUsersPerSec(100).during(60.seconds)
        )
      )
    )
  ).protocols(httpConf)
}