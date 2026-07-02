FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /workspace

COPY . .

RUN chmod +x mvnw && ./mvnw -q -DskipTests package

FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=build /workspace/target/*.jar /app/app.jar

EXPOSE 10000

ENV PORT=10000

CMD ["sh", "-c", "java -jar /app/app.jar --server.port=${PORT}"]