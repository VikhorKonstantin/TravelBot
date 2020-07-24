package by.vikhor.travelbot.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static by.vikhor.travelbot.handler.HandlersConstants.START_COMMAND;

@Service
public class MessageHandler implements UpdateHandler<Message, SendMessage> {

    private final StartCommandHandler startCommandHandler;
    private final PlaceInfoRequestHandler placeInfoRequestHandler;

    @Autowired
    public MessageHandler(StartCommandHandler startCommandHandler, PlaceInfoRequestHandler placeInfoRequestHandler) {
        this.startCommandHandler = startCommandHandler;
        this.placeInfoRequestHandler = placeInfoRequestHandler;
    }

    @Override
    public SendMessage handleUpdate(Message message) {
        if (isStartCommand(message)) {
            return startCommandHandler.handleUpdate(message.getChatId());
        } else {
            return placeInfoRequestHandler.handleUpdate(message);
        }
    }

    private boolean isStartCommand(Message message) {
        return message.getText().equals(START_COMMAND);
    }
}
