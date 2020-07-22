package by.vikhor.travelbot.handler;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

@FunctionalInterface
public interface UpdateHandler<T> {
    BotApiMethod<?> handleUpdate(T input);
}
