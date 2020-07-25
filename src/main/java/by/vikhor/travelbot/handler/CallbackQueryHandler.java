package by.vikhor.travelbot.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import static by.vikhor.travelbot.handler.HandlersConstants.ABOUT_BUTTON;

@Service
public class CallbackQueryHandler implements UpdateHandler<CallbackQuery, AnswerCallbackQuery> {

    private final AboutCommandHandler aboutCommandHandler;
    private final ListSupportedPlacesCommandHandler listSupportedPlacesCommandHandler;

    @Autowired
    public CallbackQueryHandler(AboutCommandHandler aboutCommandHandler,
                                ListSupportedPlacesCommandHandler listSupportedPlacesCommandHandler) {
        this.aboutCommandHandler = aboutCommandHandler;
        this.listSupportedPlacesCommandHandler = listSupportedPlacesCommandHandler;
    }

    @Override
    public AnswerCallbackQuery handleUpdate(CallbackQuery callbackQuery) {
        String buttonData = callbackQuery.getData();
        if (buttonData.equals(ABOUT_BUTTON)) {
            return aboutCommandHandler.handleUpdate(callbackQuery.getId());
        } else {
            return listSupportedPlacesCommandHandler.handleUpdate(callbackQuery.getId());
        }
    }

}
