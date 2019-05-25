#!/bin/bash

BASE_URI=http://localhost:5151/survey_jersey/rest

RESULT=survey
ID=302

mkdir -p data
cd data
touch $RESULT.json
rm $RESULT.json

wget -q $BASE_URI/v1/surveys/$ID -O $RESULT.json

echo "wget result: $?"
echo "" 

cat $RESULT.json

cd .. 
echo ""
echo "Ready."
