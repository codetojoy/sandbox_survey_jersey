#!/bin/bash

gradle clean installDist
./staging/bin/client 

