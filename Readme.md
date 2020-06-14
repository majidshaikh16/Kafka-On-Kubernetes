## Kubernetes Multi-container App.
# Tech Stack
* Java8
* Spring Cloud Kafka
* Kafka
* Zookeeper
* Kafka-Manager
* MySQL
* Angular 7
* Docker
* Docker Compose
* Kubernetes
* Azure(Updates coming soon with CI/CD WIP)

(K8's Note: I use secretes stored in Master Node, Just for this demo to run for anyone, I've user secrets as ENV)

## Starting the multi container App using only Docker.
- Switch to dir /docker
- ./start.sh
`
#!/bin/bash
docker-compose -f docker-compose-app.yml up -d
docker-compose -f docker-compose-db.yml up -d
docker-compose -f docker-compose-kafka.yml up -d

`