#!/bin/bash
kubectl apply -f ingress/
kubectl apply -f volumes/
kubectl apply -f db/
kubectl apply -f kafka/
kubectl apply -f app/


