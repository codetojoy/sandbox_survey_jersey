#!/bin/bash

PROJECT_DIR=$1
PROJECT_PREFIX=survey_jersey
TOMCAT_HOME=/Users/measter/tools/tomcat_8_5_32_5151

gradle clean war

wget http://localhost:5151 -o tmp.log -O tmp.html

if [ $? == 0 ]; then
    echo "shutting down"
    $TOMCAT_HOME/bin/shutdown.sh
else
    echo "Tomcat not running"
fi

rm tmp.log tmp.html

rm -rf $TOMCAT_HOME/webapps/${PROJECT_PREFIX}*
cp ./build/libs/$PROJECT_PREFIX.war $TOMCAT_HOME/webapps/

echo "starting up"
$TOMCAT_HOME/bin/startup.sh

echo ""
echo ""
echo "------------------"
echo "browse to: http://localhost:5151/survey_jersey/rest/survey"
echo "Ready."
