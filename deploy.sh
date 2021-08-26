#!/bin/sh
set -e
[ -d "$HOME/java15" ] && export JAVA_HOME="$HOME/java15" 
./mvnw clean install
( cd zebrajs && npm run prepare )
cd zebra-demo
npm run test
npm run build:gh
npm run deploy
