package by.vikhor.travelbot.botconfig;

import by.vikhor.travelbot.handler.Event;
import by.vikhor.travelbot.handler.UpdateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class TelegramBotConfig {

    @Bean
    public Map<Event, UpdateHandler> handlerMap(List<UpdateHandler> handlers) {
        return handlers.stream()
                .collect(Collectors.toMap(UpdateHandler::getResponsibleFor, Function.identity()));
    }
}
