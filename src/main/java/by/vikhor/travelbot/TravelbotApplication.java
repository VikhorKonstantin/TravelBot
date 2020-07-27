package by.vikhor.travelbot;

import by.vikhor.travelbot.botconfig.BotConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
@EnableConfigurationProperties(BotConfigurationProperties.class)
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class TravelbotApplication {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        SpringApplication.run(TravelbotApplication.class, args);
    }

}
