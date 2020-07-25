package by.vikhor.travelbot.handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class AboutCommandHandler implements UpdateHandler<String, AnswerCallbackQuery> {
    @Override
    public AnswerCallbackQuery handleUpdate(String callbackQueryId) {
        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery();
        answerCallbackQuery.setText(HandlersConstants.ABOUT_BOT_MSG);
        answerCallbackQuery.setCallbackQueryId(callbackQueryId);
        return answerCallbackQuery;
    }

}
