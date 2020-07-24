package by.vikhor.travelbot.handler;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;

/**
 * Handles bot's events.
 *
 * @param <C> Consumed object's type
 * @param <P> Produced object's type
 */
@FunctionalInterface
public interface UpdateHandler<C, P extends BotApiMethod<?>> {
    P handleUpdate(C input);
}
