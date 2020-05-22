FROM openjdk:8-jre-alpine
WORKDIR /app/kafka/producer/
# COPY ./ ./
COPY ./target/kafka-producer.jar ./
# RUN mvn clean install
ENTRYPOINT ["java","-jar","kafka-producer.jar"]
