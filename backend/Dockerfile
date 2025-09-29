FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN apk add --no-cache maven && mvn -q -e -DskipTests clean package
RUN mkdir -p /app/dll-files
EXPOSE 8080
CMD ["java", "-jar", "target/respawn-backend-1.0.0.jar", "--spring.profiles.active=docker"]
