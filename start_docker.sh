#!/usr/bin/env bash
set -e

export PORT="8080"

mvn clean package -DskipTests && \
docker build -t helloworld-cicd:latest . && \
#docker run --name helloworld-cicd --rm -d -p 8080:$PORT/tcp helloworld-cicd:latest
docker run --name helloworld-cicd --rm -it -e PORT -p 8080:$PORT/tcp helloworld-cicd:latest