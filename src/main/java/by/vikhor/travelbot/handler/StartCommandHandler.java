package by.vikhor.travelbot.handler;

import by.vikhor.travelbot.service.keybord.MainMenuKeyboardCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class StartCommandHandler implements UpdateHandler<Long, SendMessage> {

    private final MainMenuKeyboardCreator mainMenuKeyboardCreator;

    @Autowired
    public StartCommandHandler(MainMenuKeyboardCreator mainMenuKeyboardCreator) {
        this.mainMenuKeyboardCreator = mainMenuKeyboardCreator;
    }

    @Override
    public SendMessage handleUpdate(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(mainMenuKeyboardCreator.createMainMenuKeyboard());
        sendMessage.setText(HandlersConstants.ON_START_MSG);
        return sendMessage;
    }

}
