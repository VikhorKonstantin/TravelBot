package by.vikhor.travelbot.handler;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

@Service
@Getter
public class MessageHandler implements UpdateHandler {
    private final Map<Event, UpdateHandler> handlerMap;

    @Autowired
    public MessageHandler(Map<Event, UpdateHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }


    @Override
    public BotApiMethod<?> handleUpdate(Update input) {
        if (isStartCommand(input)) {
            return delegate(Event.START_COMMAND, input);
        } else {
            return delegate(Event.COUNTRY_MESSAGE_INPUT, input);
        }
    }

    @Override
    public Event getResponsibleFor() {
        return Event.GENERIC_MESSAGE_INPUT;
    }

    private boolean isStartCommand(Update input) {
        return input.getMessage().getText().equals(Event.START_COMMAND.getCommand());
    }
}
