FROM eclipse-temurin:26-jdk

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/moodrecommendations-0.0.1-SNAPSHOT.jar"]