#!/bin/bash

ID=111

mkdir -p data
cd data

GREETING_FILE=update_greeting.json
rm $GREETING_FILE
echo "{\"id\": ${ID}, \"content\": \"hello at `date`\"}" > $GREETING_FILE

curl -X PUT -d @${GREETING_FILE} \
http://localhost:5151/survey_jersey/rest/greetings/${ID} \
--header "Content-Type:application/json"

echo "wget result: $?"
echo "" 

cd .. 
echo ""
echo "Ready."
