package by.vikhor.travelbot.service.keybord;

import by.vikhor.travelbot.handler.HandlersConstants;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

@Service
public class MainMenuKeyboardCreator {

    public InlineKeyboardMarkup createMainMenuKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        inlineKeyboardMarkup.setKeyboard(List.of(prepareButtonRow(HandlersConstants.ABOUT_BUTTON),
                prepareButtonRow(HandlersConstants.SUPPORTED_PLACES_BUTTON)));
        return inlineKeyboardMarkup;
    }

    private List<InlineKeyboardButton> prepareButtonRow(String buttonText) {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setCallbackData(buttonText);
        inlineKeyboardButton.setText(buttonText);
        return List.of(inlineKeyboardButton);
    }
}
