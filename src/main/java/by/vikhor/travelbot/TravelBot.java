package by.vikhor.travelbot;

import by.vikhor.travelbot.config.BotConfigurationProperties;
import by.vikhor.travelbot.handler.BaseUpdateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class TravelBot extends TelegramWebhookBot {

    private final BotConfigurationProperties botConfigurationProperties;
    private final BaseUpdateHandler baseUpdateHandler;

    @Autowired
    public TravelBot(BotConfigurationProperties botConfigurationProperties, BaseUpdateHandler baseUpdateHandler) {
        this.botConfigurationProperties = botConfigurationProperties;
        this.baseUpdateHandler = baseUpdateHandler;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return baseUpdateHandler.handleUpdate(update);
    }

    @Override
    public String getBotUsername() {
        return botConfigurationProperties.getUsername();
    }

    @Override
    public String getBotToken() {
        return botConfigurationProperties.getToken();
    }

    @Override
    public String getBotPath() {
        try {
            return String.format("https://%s:%d", InetAddress.getLocalHost().getHostName(),
                    botConfigurationProperties.getPort());
        } catch (UnknownHostException e) {
            return botConfigurationProperties.getUsername();
        }
    }
}
