package by.vikhor.travelbot.handler;

import lombok.Getter;

@Getter
public enum Event {
    BASE_EVENT(""),
    START_COMMAND("/start"),
    ABOUT_CALLBACK(HandlersConstants.ABOUT_BUTTON),
    LIST_SUPPORTED_COUNTRIES_CALLBACK(HandlersConstants.SUPPORTED_PLACES_BUTTON),
    GENERIC_MESSAGE_INPUT(""),
    COUNTRY_MESSAGE_INPUT(""),
    GENERIC_CALLBACK_QUERY("");

    private final String command;

    Event(String command) {
        this.command = command;
    }


}
