package by.vikhor.travelbot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bot")
@Data
public class BotConfigurationProperties {
    private String username;
    private String token;
    private Integer port;
}
