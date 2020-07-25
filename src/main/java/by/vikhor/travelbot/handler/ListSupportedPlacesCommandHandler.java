package by.vikhor.travelbot.handler;

import by.vikhor.travelbot.service.placeinfo.PlacesToVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;

@Service
public class ListSupportedPlacesCommandHandler implements UpdateHandler<String, AnswerCallbackQuery> {

    private final PlacesToVisitService placesToVisitService;

    @Autowired
    public ListSupportedPlacesCommandHandler(PlacesToVisitService placesToVisitService) {
        this.placesToVisitService = placesToVisitService;
    }

    @Override
    public AnswerCallbackQuery handleUpdate(String callbackQueryId) {
        String text = String.join("\n", placesToVisitService.findListOfSupportedPlaces());
        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery();
        answerCallbackQuery.setText(text);
        answerCallbackQuery.setCallbackQueryId(callbackQueryId);
        return answerCallbackQuery;
    }
}
