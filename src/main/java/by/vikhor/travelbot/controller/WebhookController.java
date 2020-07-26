package by.vikhor.travelbot.controller;

import by.vikhor.travelbot.TravelBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebhookController {

    private final TravelBot travelBot;

    @Autowired
    public WebhookController(TravelBot travelBot) {
        this.travelBot = travelBot;
    }

    @PostMapping
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return travelBot.onWebhookUpdateReceived(update);
    }
}
