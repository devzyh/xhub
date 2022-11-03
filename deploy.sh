#!/bin/bash

# download
echo "Download"
wget http://cdn.devzyh.cn/xhub/xhub.jar -O xhub.latest.jar

# stop
echo "Stop App"
pid=$(cat run.pid)
kill -9 $pid
echo "Stop Success"

# deploy
rm -rf xhub.jar
mv xhub.latest.jar xhub.jar

# start
echo "Start App"
nohup java -jar xhub.jar --spring.profiles.active=prod > run.log 2>&1 &
echo $! > run.pid
echo "Start Success"
