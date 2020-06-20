## Kubernetes Multi-container App.
# Tech Stack
> Java8

> Spring boot

> Kafka

> Zookeeper

> Kafka-Manager

> MySQL

> Angular 7

> Docker

> Docker Compose

> Kubernetes

> Azure(Updates coming soon with CI/CD WIP)

> Google Cloud(GKE)

> Travis CI

> GitHub

> Shell Script

(K8's Note: I've used secretes stored in Master Node, Just for this demo to run for anyone, I've user secrets as ENV)

## K8's Multi-Container Arch
<img src='https://github.com/majidshaikh16/Kafka/blob/master/arch/Kubernetes-Multi-Cotnainer.jpg'/>

## Kafka helpful documents.
-   <a href='https://github.com/majidshaikh16/Kubernetes/tree/master/kafka-docs'>Kafka Docs</a>

## Setup Google Cloud Kubernetes (GKE) Cluster.
-   <a href='https://github.com/majidshaikh16/Kubernetes/blob/master/GKE-Steup.md'>Setup GKE</a>

## How to start locally using Docker?
- Switch to dir /docker
- run ./start.sh
```sh
#!/bin/bash
docker-compose -f docker-compose-app.yml up -d
docker-compose -f docker-compose-db.yml up -d
docker-compose -f docker-compose-kafka.yml up -d
```
## How to stop locally using Docker?
- Switch to dir /docker
- ./stop.sh [args optional db, kafka, app]
```sh
#!/bin/bash

if [ $# -gt 0 ]; then
    echo "Your command line contains $1 arguments"
    if [ "$1" == "db" ]; then
        docker-compose -f docker-compose-db.yml stop && docker-compose -f docker-compose-db.yml rm -f
    else
        echo "DB will keep running :)"
    fi
    if [ "$1" == "kafka" ]; then
        docker-compose -f docker-compose-kafka.yml stop && docker-compose -f docker-compose-kafka.yml rm -f
    else
        echo "Kafka will keep running :)"
    fi
    if [ "$1" == "app" ]; then
        docker-compose -f docker-compose-app.yml stop && docker-compose -f docker-compose-app.yml rm -f
    else
        echo "Apps will keep running"
    fi
else
    read -p "Are you sure you want to stop all the services y/n? " -n 1 -r
    echo # (optional) move to a new line
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        # do dangerous stuff
        echo "Stopping all the services [App, DB, Kafka]"
        docker-compose -f docker-compose-app.yml stop && docker-compose -f docker-compose-app.yml rm -f
        docker-compose -f docker-compose-db.yml stop && docker-compose -f docker-compose-db.yml rm -f
        docker-compose -f docker-compose-kafka.yml stop && docker-compose -f docker-compose-kafka.yml rm -f
        echo "Done Stopping services [App, DB, Kafka]"
    fi
fi

```
## How to start K8's cluster locally?
- Make sure you have minikube and virtual box installed
        - https://kubernetes.io/docs/tasks/tools/install-minikube/
- Make sure to install and enable the Nginx Ingress
        - https://kubernetes.github.io/ingress-nginx/deploy/#minikube 

- Also check <a href='https://github.com/majidshaikh16/Kubernetes/blob/master/kafka-docs/kubernetes-ingress-to-be-install-seperatly.png'> Ingress </a>
- Once you have the above setup ready follow the bellow steps to test locally
- Switch to dir /k8s
- run ./start.sh
```sh
#!/bin/bash
kubectl apply -f ingress/
kubectl apply -f volumes/
kubectl apply -f db/
kubectl apply -f kafka/
kubectl apply -f app/
```

## How to stop k8's cluster locally?
- Switch to dir /k8s
- run ./stop.sh [args optional db, kafka, app,i ngress, volumes]
```sh
#!/bin/bash

if [ $# -gt 0 ]; then
    echo "Your command line contains $1 arguments"
    if [ "$1" == "db" ]; then
        kubectl delete -f db/
    else
        echo "DB will keep running :)"
    fi
    if [ "$1" == "kafka" ]; then
        kubectl delete -f kafka/
    else
        echo "Kafka will keep running :)"
    fi
    if [ "$1" == "app" ]; then
        kubectl delete -f app/
    else
        echo "Apps will keep running"
    fi
    if [ "$1" == "ingress" ]; then
        kubectl delete -f ingress/
    else
        echo "Ingress will keep running"
    fi
    if [ "$1" == "volumes" ]; then
        kubectl delete -f volumes/
    else
        echo "Volumes will keep running"
    fi
else
    read -p "Are you sure you want to stop all the services y/n? " -n 1 -r
    echo # (optional) move to a new line
    if [[ $REPLY =~ ^[Yy]$ ]]; then
        # do dangerous stuff
        echo "Deleting all the pods and deployments [App, DB, Kafka, Ingress, Volumes]"
        kubectl delete -f db/
        kubectl delete -f kafka/
        kubectl delete -f app/
        kubectl delete -f ingress/
        kubectl delete -f volumes/
        echo "Done Deleting services [App, DB, Kafka, Ingress, Volumes]"
    fi
fi
```

