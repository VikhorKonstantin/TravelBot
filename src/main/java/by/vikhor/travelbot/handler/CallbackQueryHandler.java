package by.vikhor.travelbot.handler;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

@Service
@Getter
public class CallbackQueryHandler implements UpdateHandler {
    private final Map<Event, UpdateHandler> handlerMap;

    @Autowired
    public CallbackQueryHandler(Map<Event, UpdateHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public BotApiMethod<?> handleUpdate(Update input) {
        CallbackQuery callbackQuery = input.getCallbackQuery();
        String buttonData = callbackQuery.getData();
        if (buttonData.equals(Event.ABOUT_CALLBACK.getCommand())) {
            return delegate(Event.ABOUT_CALLBACK, input);
        } else {
            return delegate(Event.LIST_SUPPORTED_COUNTRIES_CALLBACK, input);
        }
    }

    @Override
    public Event getResponsibleFor() {
        return Event.GENERIC_CALLBACK_QUERY;
    }
}
