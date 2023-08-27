#! /bin/bash

java -jar --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.math=ALL-UNNAMED -Dspring.profiles.active=dev fudy-shop.jar