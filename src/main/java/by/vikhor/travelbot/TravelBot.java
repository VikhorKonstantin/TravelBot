package by.vikhor.travelbot;

import by.vikhor.travelbot.botconfig.BotConfigurationProperties;
import by.vikhor.travelbot.handler.UpdateProcessor;
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
    private final UpdateProcessor updateProcessor;

    @Autowired
    public TravelBot(BotConfigurationProperties botConfigurationProperties, UpdateProcessor updateProcessor) {
        this.botConfigurationProperties = botConfigurationProperties;
        this.updateProcessor = updateProcessor;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return updateProcessor.processUpdate(update);
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
