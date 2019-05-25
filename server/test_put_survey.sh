#!/bin/bash

ID=302

mkdir -p data
cd data

SURVEY_FILE=update_survey.json

curl -X PUT -d @${SURVEY_FILE} \
http://localhost:5151/survey_jersey/rest/v1/surveys/${ID} \
--header "Content-Type:application/json"

echo "wget result: $?"
echo "" 

cd .. 
echo ""
echo "Ready."
