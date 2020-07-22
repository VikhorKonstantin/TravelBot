package by.vikhor.travelbot.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class MessageHandler implements UpdateHandler<Message> {
    @Override
    public BotApiMethod<Message> handleUpdate(Message input) {
        switch (input.getText()) {
            case "/start":
                return new SendMessage(input.getChatId(), "Hi, please enter some city");
            case "ls":
                return new SendMessage(input.getChatId(), "List");
            default:
                return new SendMessage(input.getChatId(), "Hi, please enter some city");
        }
    }
}
