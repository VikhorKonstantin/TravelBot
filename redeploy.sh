#!/bin/bash
echo delete stack
aws cloudformation delete-stack --stack-name TravelBotStack
echo run build
python3 build.py
echo deploy
aws cloudformation deploy --template-file "sam.yaml" --stack-name "TravelBotStack" --capabilities "CAPABILITY_IAM"