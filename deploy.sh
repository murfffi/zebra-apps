#!/bin/sh
set -e
[ -d "$HOME/java14" ] && export JAVA_HOME="$HOME/java14" 
./mvnw clean install
cd zebra-demo
npm run test
npm run build:gh
npm run deploy
