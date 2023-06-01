#!/bin/bash

docker run \
    --platform=linux/arm64 \
    -d \
    --name prometheus \
    -p 9090:9090 \
    -v $(pwd)/config:/etc/prometheus \
    -v $(pwd)/data:/prometheus:rw \
    prom/prometheus:v2.33.4
