package by.vikhor.travelbot.handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

@Service
public class ListSupportedPlacesCommandHandler implements UpdateHandler {
    @Override
    public BotApiMethod<?> handleUpdate(Update input) {
        return null;
    }

    @Override
    public Event getResponsibleFor() {
        return Event.LIST_SUPPORTED_COUNTRIES_CALLBACK;
    }

    /**
     * Leaf handler. Do not require handlers map.
     */
    @Override
    public Map<Event, UpdateHandler> getHandlerMap() {
        return null;
    }
}
