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
        kubectl delete -f ./db/
        kubectl delete -f kafka/
        kubectl delete -f app/
        kubectl delete -f ingress/
        kubectl delete -f volumes/
        echo "Done Deleting services [App, DB, Kafka, Ingress, Volumes]"
    fi
fi
