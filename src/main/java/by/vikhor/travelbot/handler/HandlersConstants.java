package by.vikhor.travelbot.handler;

public class HandlersConstants {
    public static final String START_COMMAND = "/start";
    public static final String SUPPORTED_PLACES_BUTTON = "Show list of supported places";
    public static final String ABOUT_BUTTON = "About";
    public static final String ON_START_MSG = "Please, choose an action";
    public static final String ABOUT_BOT_MSG =
            "This bot can provide you some information about place you are going to visit." +
                    " Please, enter name of required place";
    public static final String PLACE_NOT_FOUND_MSG = "Sorry, there is no info about this place, try to enter a place " +
            "from the list of supported places";

    private HandlersConstants() {
    }
}
