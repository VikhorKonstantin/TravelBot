package by.vikhor.travelbot.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class BaseUpdateHandler implements UpdateHandler<Update, BotApiMethod<?>> {

    private final CallbackQueryHandler callbackQueryHandler;
    private final MessageHandler messageHandler;

    @Autowired
    public BaseUpdateHandler(CallbackQueryHandler callbackQueryHandler, MessageHandler messageHandler) {
        this.callbackQueryHandler = callbackQueryHandler;
        this.messageHandler = messageHandler;
    }

    @Override
    public BotApiMethod<?> handleUpdate(Update update) {
        if (update.hasCallbackQuery()) {
            return callbackQueryHandler.handleUpdate(update.getCallbackQuery());
        } else {
            return messageHandler.handleUpdate(update.getMessage());
        }
    }

}
