FROM openjdk:21

WORKDIR /app

COPY build/libs/ProductManagementSystem-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8001

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/product
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=password

ENTRYPOINT ["java", "-jar", "app.jar"]
