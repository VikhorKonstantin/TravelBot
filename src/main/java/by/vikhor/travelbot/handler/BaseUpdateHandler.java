package by.vikhor.travelbot.handler;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

@Service
@Getter
public class BaseUpdateHandler implements UpdateHandler {
    private final Map<Event, UpdateHandler> handlerMap;

    @Autowired
    public BaseUpdateHandler(Map<Event, UpdateHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public BotApiMethod<?> handleUpdate(Update update) {
        if (update.hasCallbackQuery()) {
            return delegate(Event.GENERIC_CALLBACK_QUERY, update);
        } else {
            return delegate(Event.GENERIC_MESSAGE_INPUT, update);
        }
    }

    @Override
    public Event getResponsibleFor() {
        return Event.BASE_EVENT;
    }

    @Override
    public Map<Event, UpdateHandler> getHandlerMap() {
        return handlerMap;
    }
}
