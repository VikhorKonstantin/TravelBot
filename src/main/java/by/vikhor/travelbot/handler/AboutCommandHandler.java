package by.vikhor.travelbot.handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Map;

@Service
public class AboutCommandHandler implements UpdateHandler {
    @Override
    public BotApiMethod<?> handleUpdate(Update input) {
        return new SendMessage(input.getMessage().getChatId(), HandlersConstants.ABOUT_BOT_MSG);
    }

    @Override
    public Event getResponsibleFor() {
        return Event.ABOUT_CALLBACK;
    }

    /**
     * Leaf handler. Do not require handlers map.
     */
    @Override
    public Map<Event, UpdateHandler> getHandlerMap() {
        return null;
    }
}
