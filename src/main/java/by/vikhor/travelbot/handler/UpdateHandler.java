package by.vikhor.travelbot.handler;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

public interface UpdateHandler {

    BotApiMethod<?> handleUpdate(Update input);

    default BotApiMethod<?> delegate(Event event, Update delegatedInput) {
        UpdateHandler updateHandler = getHandlerMap().get(event);
        return updateHandler.handleUpdate(delegatedInput);
    }

    Event getResponsibleFor();

    Map<Event, UpdateHandler> getHandlerMap();
}
