#!/bin/bash
echo delete stack
aws cloudformation delete-stack --stack-name TravelBotStack
echo run build
python3 build.py
echo deploy
aws cloudformation deploy --template-file "sam.yaml" --stack-name "TravelBotStack" --capabilities "CAPABILITY_IAM"
echo register telegram webhook
produrl=$(aws cloudformation describe-stacks --stack-name TravelBotStack --query "Stacks[0].Outputs[?OutputKey=='ProdDataEndpoint'].OutputValue" --output text)
curl https://api.telegram.org/bot1243361294:AAFk6iunCqkULr8z5D82dkidf2z3KPGJVYc/setWebhook?url=${produrl}