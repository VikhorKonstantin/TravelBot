package by.vikhor.travelbot.handler;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;
import java.util.Map;

@Service
public class StartActionHandler implements UpdateHandler {

    @Override
    public BotApiMethod<?> handleUpdate(Update input) {
        Message message = input.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyMarkup(prepareKeyboard());
        sendMessage.setText(HandlersConstants.ON_START_MSG);
        return sendMessage;
    }

    @Override
    public Event getResponsibleFor() {
        return Event.START_COMMAND;
    }

    @NotNull
    private ReplyKeyboardMarkup prepareKeyboard() {
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

    /**
     * Leaf handler. Do not require handlers map.
     */
    @Override
    public Map<Event, UpdateHandler> getHandlerMap() {
        return null;
    }
}
