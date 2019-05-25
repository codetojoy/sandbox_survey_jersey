#!/bin/bash

BASE_URI=http://localhost:5151/survey_jersey/rest

RESULT=surveys

mkdir -p data
cd data
touch $RESULT.json
rm $RESULT.json

wget -q $BASE_URI/v1/surveys -O $RESULT.json

echo "wget result: $?"
echo "" 

cat $RESULT.json

cd .. 
echo ""
echo "Ready."
