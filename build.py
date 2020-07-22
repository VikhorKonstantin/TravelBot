import boto3
import time
client = boto3.client(service_name='codebuild', region_name='us-east-2')
new_build = client.start_build(projectName='Build')
buildId = new_build['build']['id']

buildSucceeded = False

counter = 0
while counter < 70:   #capped this, so it just fails if it takes too long
    time.sleep(5)
    counter = counter + 1
    theBuild = client.batch_get_builds(ids=[buildId])
    buildStatus = theBuild['builds'][0]['buildStatus']

    if buildStatus == 'SUCCEEDED':
        buildSucceeded = True
        break
    elif buildStatus == 'FAILED' or buildStatus == 'FAULT' or buildStatus == 'STOPPED' or buildStatus == 'TIMED_OUT':
        break
print(buildStatus)