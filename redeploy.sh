echo delete stack
aws cloudformation delete-stack --stack-name ImageApiStack
echo run build
python build.py
echo deploy
aws cloudformation deploy --template-file output-sam.yaml --stack-name ImageApiStack --capabilities CAPABILITY_IAM
pause
