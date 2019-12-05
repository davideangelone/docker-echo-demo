# Stage-1 Compiling executable jar
FROM jimschubert/8-jdk-alpine-mvn as build
WORKDIR /app
COPY src ./src
COPY pom.xml ./
RUN mvn -f pom.xml clean install

# Stage-2 dependencies
FROM openjdk:8-jdk-alpine as jdk8
EXPOSE 8080
COPY --from=build /app/target/EchoDemo.jar EchoDemo.jar
ENTRYPOINT java -jar EchoDemo.jar
