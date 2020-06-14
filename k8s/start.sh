#!/bin/bash
kubectl apply -f ingress/
kubectl apply -f volumes/
kubectl apply -f db/
kubectl apply -f kafka/zookeeper-cluster-ip-service.yml && kubectl apply -f kafka/zookeeper-deployment.yml
# sleep 15s
kubectl apply -f kafka/
kubectl apply -f app/


