FROM openjdk:8-jre-alpine
WORKDIR /app/kafka/consumer/
# COPY ./ ./
COPY ./target/kafka-consumer.jar ./
# RUN mvn clean install
ENTRYPOINT ["java","-jar","kafka-consumer.jar"]
