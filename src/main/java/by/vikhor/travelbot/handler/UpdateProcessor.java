package by.vikhor.travelbot.handler;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Process user's updates by delegating it to one of the handlers.
 */

@Service
public class UpdateProcessor {

    private final Map<Command, UpdateHandler<?>> handlerMap;

    @Autowired
    public UpdateProcessor(List<UpdateHandler<?>> handlers) {
        handlerMap = handlers.stream().collect(Collectors.toMap(UpdateHandler::responsibleFor, Function.identity()));
    }

    public BotApiMethod<?> processUpdate(Update update) {
        String commandString = update.getMessage().getText();
        return handlerMap.get(getCommand(commandString)).handleUpdate(update);
    }

    @NotNull
    private Command getCommand(String command) {
        return Command.findByStringRepresentation(command).orElse(Command.PLACE_INFO);
    }

}
