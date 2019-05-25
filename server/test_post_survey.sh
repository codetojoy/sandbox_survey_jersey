#!/bin/bash

mkdir -p data
cd data

GREETING_FILE=new_survey.json

curl -X POST -d @${GREETING_FILE} \
http://localhost:5151/survey_jersey/rest/v1/surveys \
--header "Content-Type:application/json"

echo "wget result: $?"
echo "" 

cd .. 
echo ""
echo "Ready."
