package by.vikhor.travelbot.appconfig;


import by.vikhor.travelbot.TravelbotApplication;
import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.serverless.proxy.spring.SpringBootProxyHandlerBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Instant;

import static com.amazonaws.serverless.proxy.internal.LambdaContainerHandler.getContainerConfig;

public class StreamLambdaHandler implements RequestStreamHandler {
    private static final SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> HANDLER;

    static {
        try {
            long startTime = Instant.now().toEpochMilli();
            getContainerConfig().setInitializationTimeout(200_000);
            HANDLER = new SpringBootProxyHandlerBuilder()
                    .defaultProxy()
                    .asyncInit(startTime)
                    .springBootApplication(TravelbotApplication.class)
                    .buildAndInitialize();
        } catch (ContainerInitializationException e) {
            throw new RuntimeException("Could not initialize Spring framework", e);
        }
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
        HANDLER.proxyStream(inputStream, outputStream, context);
    }
}