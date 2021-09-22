package com.github.cyberpunkperson.orm.comparison

import com.github.cyberpunkperson.orm.comparison.scenario.UserLoadScenario
import io.gatling.core.Predef._
import io.gatling.http.Predef.http

import scala.concurrent.duration.DurationInt

class UserLoadTest extends Simulation {

  val httpConf = http.baseUrl("http://localhost:8080")

  setUp(
    UserLoadScenario("getUserById").inject(
      constantUsersPerSec(100).during(60.seconds),
    ).andThen(
      UserLoadScenario("getUsers").inject(
        constantUsersPerSec(100).during(60.seconds),
      ).andThen(
        UserLoadScenario("putUser").inject(
          constantUsersPerSec(100).during(60.seconds),
        )
      )
    )
  ).protocols(httpConf)
}
