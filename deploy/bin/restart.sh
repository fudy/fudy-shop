#!/bin/bash
SCRIPT_DIR=$(dirname "$0")
source $SCRIPT_DIR/env.sh
cd $TARGET_DIR
docker compose  restart

