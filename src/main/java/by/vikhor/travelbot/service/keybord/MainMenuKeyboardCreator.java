package by.vikhor.travelbot.service.keybord;

import by.vikhor.travelbot.handler.HandlersConstants;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

@Service
public class MainMenuKeyboardCreator {

    public ReplyKeyboardMarkup createMainMenuKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);

        KeyboardRow firstRow = new KeyboardRow();
        firstRow.add(HandlersConstants.SUPPORTED_PLACES_BUTTON);
        KeyboardRow secondRow = new KeyboardRow();
        secondRow.add(HandlersConstants.ABOUT_BUTTON);
        replyKeyboardMarkup.setKeyboard(List.of(firstRow, secondRow));
        return replyKeyboardMarkup;
    }
}
