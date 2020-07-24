package by.vikhor.travelbot.handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class AboutCommandHandler implements UpdateHandler<Long, SendMessage> {
    @Override
    public SendMessage handleUpdate(Long chatId) {
        return new SendMessage(chatId, HandlersConstants.ABOUT_BOT_MSG);
    }

}
