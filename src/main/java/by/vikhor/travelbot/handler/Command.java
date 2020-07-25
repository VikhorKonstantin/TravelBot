package by.vikhor.travelbot.handler;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public enum Command {
    ABOUT(HandlersConstants.ABOUT_BUTTON),
    LIST_SUPPORTED_PLACES(HandlersConstants.SUPPORTED_PLACES_BUTTON),
    PLACE_INFO(HandlersConstants.PLACE_NOT_FOUND_MSG),
    START(HandlersConstants.START_COMMAND);

    private static final Map<String, Command> STRING_VALUE_MAP = new HashMap<>();

    static {
        for (Command v : Command.values()) {
            STRING_VALUE_MAP.put(v.stringRepresentation, v);
        }
    }

    private final String stringRepresentation;

    Command(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public static Optional<Command> findByStringRepresentation(String stringRepresentation) {
        return Optional.ofNullable(STRING_VALUE_MAP.get(stringRepresentation));
    }
}
