#!/bin/bash

# zookeeper部署
docker run -d --name zookeeper \
--restart always \
-v /etc/localtime:/etc/localtime \
-p 2181:2181 zookeeper:3.7.0

# dubbo-admin部署
docker run -d --name dubbo-admin \
--restart always \
-v /etc/localtime:/etc/localtime \
-p 8080:8080 \
-e admin.registry.address=zookeeper://192.168.71.128:2181 \
-e admin.config-center=zookeeper://192.168.71.128:2181 \
-e admin.metadata-report.address=zookeeper://192.168.71.128:2181 \
apache/dubbo-admin

