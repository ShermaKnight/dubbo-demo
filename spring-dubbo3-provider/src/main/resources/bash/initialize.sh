#!/bin/bash

# zookeeper部署
docker run -d --name zookeeper \
--restart always \
-v /etc/localtime:/etc/localtime \
-p 2181:2181 zookeeper:3.7.0

# mysql部署
docker run -d --name mysql \
--restart always \
-v /etc/localtime:/etc/localtime \
-p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=wproot \
mysql:8

