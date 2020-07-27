package by.vikhor.travelbot.handler;

import by.vikhor.travelbot.service.placeinfo.PlacesToVisitService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static by.vikhor.travelbot.handler.Command.LIST_SUPPORTED_PLACES;

@Service
public class ListSupportedPlacesCommandHandler implements UpdateHandler<SendMessage> {

    private final PlacesToVisitService placesToVisitService;

    public ListSupportedPlacesCommandHandler(PlacesToVisitService placesToVisitService) {
        this.placesToVisitService = placesToVisitService;
    }

    @Override
    public SendMessage handleUpdate(Update update) {
        String message = String.join("\n", placesToVisitService.findListOfSupportedPlaces());
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(update.getMessage().getChatId());
        return sendMessage;
    }

    @Override
    public Command responsibleFor() {
        return LIST_SUPPORTED_PLACES;
    }
}
