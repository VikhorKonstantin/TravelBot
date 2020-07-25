package by.vikhor.travelbot.handler;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Handles bot's events.
 *
 * @param <P> Produced object's type
 */
public interface UpdateHandler<P extends BotApiMethod<?>> {
    /**
     * Handles user's input
     *
     * @param update object which represents an incoming update.
     * @return object which represents bot's response
     */
    P handleUpdate(Update update);

    /**
     * Returns {@link Command} which is this handler responsible for.
     *
     * @return {@link Command} which is this handler responsible for.
     */
    Command responsibleFor();
}
