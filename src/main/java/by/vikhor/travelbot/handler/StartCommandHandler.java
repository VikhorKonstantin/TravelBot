package by.vikhor.travelbot.handler;

import by.vikhor.travelbot.service.keybord.MainMenuKeyboardCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static by.vikhor.travelbot.handler.Command.START;

@Service
public class StartCommandHandler implements UpdateHandler<SendMessage> {

    private final MainMenuKeyboardCreator mainMenuKeyboardCreator;

    @Autowired
    public StartCommandHandler(MainMenuKeyboardCreator mainMenuKeyboardCreator) {
        this.mainMenuKeyboardCreator = mainMenuKeyboardCreator;
    }

    @Override
    public SendMessage handleUpdate(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setReplyMarkup(mainMenuKeyboardCreator.createMainMenuKeyboard());
        sendMessage.setText(HandlersConstants.ON_START_MSG);
        return sendMessage;
    }

    @Override
    public Command responsibleFor() {
        return START;
    }

}
