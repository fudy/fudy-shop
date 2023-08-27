#!/bin/bash

SCRIPT_DIR=$(dirname "$0")

source $SCRIPT_DIR/env.sh

## copy docker files to target dir
mkdir -p $TARGET_DIR
cd $SCRIPT_DIR
cp ../docker/* $TARGET_DIR
cp $TARGET_JAR $TARGET_DIR

## start docker container
cd $TARGET_DIR
docker compose --project-name="fudy-shop" up -d