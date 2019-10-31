#!/usr/bin/env bash
set -e

mvn clean package -DskipTests && \
docker build -t helloworld-cicd:latest . && \
docker run --name helloworld-cicd --rm -d -p 8080:8080/tcp helloworld-cicd:latest