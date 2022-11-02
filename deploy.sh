#!/bin/bash
# git
git config --global credential.helper store
git pull origin master

# npm
#cd xhub-admin
#npm run build:prod
#cd ..
#echo "Vue Success"

# maven
mvn clean package

# directory
if [ ! -d "build" ]; then
  mkdir build
fi

# stop
echo "Stop App"
pid=$(cat build/run.pid)
kill -9 $pid
echo "Stop Success"

# deploy
rm -rf build/xhub.jar
cp xhub-app/target/xhub*.jar build/xhub.jar

# start
cd build
echo "Start App"
nohup java -jar xhub.jar --spring.profiles.active=prod > run.log 2>&1 &
echo $! > run.pid
echo "Start Success"
cd ..
