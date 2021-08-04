FROM maven:3.8-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
COPY .open-codegen-ignore /home/app
RUN mvn -f /home/app/pom.xml package

FROM openjdk:17-jdk AS package
COPY --from=build /home/app/target/orm-comparison.jar /opt/app.jar
ENTRYPOINT ["java","-jar","/opt/app.jar"]