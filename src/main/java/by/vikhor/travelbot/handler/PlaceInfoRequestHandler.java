package by.vikhor.travelbot.handler;

import by.vikhor.travelbot.dto.PlaceInfoDto;
import by.vikhor.travelbot.service.placeinfo.PlacesToVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

@Service
public class PlaceInfoRequestHandler implements UpdateHandler<Message, SendMessage> {
    private final PlacesToVisitService placesToVisitService;

    @Autowired
    public PlaceInfoRequestHandler(PlacesToVisitService placesToVisitService) {
        this.placesToVisitService = placesToVisitService;
    }

    @Override
    public SendMessage handleUpdate(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        Optional<PlaceInfoDto> infoDtoOptional = placesToVisitService.findPlaceInfoByName(message.getText());
        if (infoDtoOptional.isPresent()) {
            sendMessage.setText(prepareInfoMessage(infoDtoOptional.get()));
        } else {
            sendMessage.setText(HandlersConstants.PLACE_NOT_FOUND_MSG);
        }
        return sendMessage;
    }

    private String prepareInfoMessage(PlaceInfoDto placeInfoDto) {
        return String.format("Name: %s%nRating: %d%nDescription: %s", placeInfoDto.getName(),
                placeInfoDto.getRating(), placeInfoDto.getDescription());
    }
}
