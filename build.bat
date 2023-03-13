@echo off
cd xhub-admin
call npm run build:prod
echo Vue build succeeded!

cd ..
call mvn clean
call mvn package -Dmaven.test.skip=true
echo Java build succeeded!

echo The build success file is located at %cd%\xhub-app\target\xhub.latest.jar