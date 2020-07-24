package by.vikhor.travelbot.handler;

import by.vikhor.travelbot.service.keybord.MainMenuKeyboardCreator;
import by.vikhor.travelbot.service.placeinfo.PlacesToVisitService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Service
public class ListSupportedPlacesCommandHandler implements UpdateHandler<Long, SendMessage> {

    private final PlacesToVisitService placesToVisitService;
    private final MainMenuKeyboardCreator mainMenuKeyboardCreator;

    public ListSupportedPlacesCommandHandler(PlacesToVisitService placesToVisitService,
                                             MainMenuKeyboardCreator mainMenuKeyboardCreator) {
        this.placesToVisitService = placesToVisitService;
        this.mainMenuKeyboardCreator = mainMenuKeyboardCreator;
    }

    @Override
    public SendMessage handleUpdate(Long chatId) {
        String message = String.join("\n", placesToVisitService.findListOfSupportedPlaces());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.setReplyMarkup(mainMenuKeyboardCreator.createMainMenuKeyboard());
        return sendMessage;
    }
}
