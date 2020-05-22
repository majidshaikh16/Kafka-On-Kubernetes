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
