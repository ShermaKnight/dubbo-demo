#!/bin/bash

docker run -d --name zookeeper \
--restart always \
-v /etc/localtime:/etc/localtime \
-p 2181:2181 zookeeper:3.7.0