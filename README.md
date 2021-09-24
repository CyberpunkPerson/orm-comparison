# Orm Comparison
### Project for ORM mechanics comparison purpose

Contains ready environment for comparison:
* Application (with three branches of three ORM implementations)
  * JPA
  * JDBC 2.0
  * Manual mapping
* Grafana + Prometheus for monitoring
* Gatling performance scripts

To build environment run in the **project root** directory: `docker-compose up -d --build`

To run performance test run in the **gatling** directory: `mvn clean gatling:test`
