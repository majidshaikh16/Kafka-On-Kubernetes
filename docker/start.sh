#!/bin/bash
docker-compose -f docker-compose-app.yml up -d
docker-compose -f docker-compose-db.yml up -d
docker-compose -f docker-compose-kafka.yml up -d