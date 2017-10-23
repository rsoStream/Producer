#!/bin/bash

echo "starting docker container from image tag producer"
docker run -d -p 8081:8081 -t producer

echo "container started, opened port 8081"

echo "Adding test movies"
curl -X POST 127.0.0.1:8081/v1/producer/create

echo "Exiting script"

exit 0
