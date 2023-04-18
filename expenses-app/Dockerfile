FROM eclipse-temurin:11

WORKDIR /app

COPY target/Expenses-App.jar /app/springboot-restful-expenses-app.jar

#ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "springboot-restful-expenses-app.jar"]
ENTRYPOINT ["java", "-jar", "springboot-restful-expenses-app.jar"]