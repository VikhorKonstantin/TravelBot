# TravelBot

Test task for the Java Junior Developer position

TravelBot provides information about different places. 
To obtain information, the bot uses TravelAPI - a separate application which provides RESTful API. Source code of TravelAPI project is stored in:
[TravelAPI GitHub repo](https://github.com/VikhorKonstantin/TravelApi)

## AWS infrastructure and deployment process
The `StreamLambdaHandler` object is the main entry point for Lambda.

The application can be deployed in an AWS account using the [Serverless Application Model](https://github.com/awslabs/serverless-application-model). The `sam.yaml` file in the root folder contains the application definition

I've configured AWS CodeBuild service to grab code from my GitHub repo, run Maven build and then upload artifacts to the S3 bucket.
To deploy new version of TravelBot I use simple redeploy.sh script, which by using AWS CLI deletes previous cloudformation stack version,
starts CodeBuild process, deploys new cloudformation stack (which contains API Gateway and AWS Lamda function) with updated sources,
and by using telegram API set new webhook url

### Bot name

 > @vikhor_travel_bot

### Bot token

 > 1243361294:AAFk6iunCqkULr8z5D82dkidf2z3KPGJVYc
