FROM openjdk:8-jre-alpine
WORKDIR /app/kafka/producer/
COPY ./target/kafka-producer.jar ./
# RUN mvn clean install
# For this demo we are not building the maven for avoiding the re-download and build time etc
# Once Azure pipeline is set we will test maven and the build
ENTRYPOINT ["java","-jar","kafka-producer.jar"]
