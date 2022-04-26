#!/bin/bash
# git
git config --global credential.helper store
git pull origin master

# npm
cd admin
npm run build:prod
cd ..

# move
cp -r admin/dist/ build/admin/

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
rm -rf build/app.jar
cp app/target/app*.jar build/app.jar

# start
cd build
echo "Start App"
nohup java -jar app.jar --spring.profiles.active=prod > run.log &
echo $! > run.pid
echo "Start Success"
cd ..
