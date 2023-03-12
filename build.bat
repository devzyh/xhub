@echo off
cd xhub-admin
call npm run build:prod
echo Vue build succeeded!

cd ..
call mvn clean
call mvn package -Dmaven.test.skip=true
echo Java build succeeded!

echo Build succeeded, The file is located at in %cd%\xhub-app\target\xhub.latest.jar
