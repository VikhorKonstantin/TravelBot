package by.vikhor.travelbot.handler;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static by.vikhor.travelbot.handler.Command.ABOUT;

@Service
public class AboutCommandHandler implements UpdateHandler<SendMessage> {

    @Override
    public SendMessage handleUpdate(Update update) {
        return new SendMessage(update.getMessage().getChatId(), HandlersConstants.ABOUT_BOT_MSG);
    }

    @Override
    public Command responsibleFor() {
        return ABOUT;
    }
}
