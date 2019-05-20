#!/bin/bash

mkdir -p data
cd data

GREETING_FILE=new_greeting.json
echo "{\"content\": \"hello at `date`\"}" > $GREETING_FILE

curl -X POST -d @${GREETING_FILE} \
http://localhost:5151/survey_jersey/rest/greetings \
--header "Content-Type:application/json"

echo "wget result: $?"
echo "" 

cd .. 
echo ""
echo "Ready."
