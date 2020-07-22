package by.vikhor.travelbot.handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
public class CallbackQueryHandler implements UpdateHandler<CallbackQuery> {
    @Override
    public BotApiMethod<Message> handleUpdate(CallbackQuery input) {
        return null;
    }
}
