package weather_bot.enums;

public enum CommandType {
    START("/start"), HELP("/help"), COORDINATES("/coordinates"), NOW("/now"), CITIES("/cities"),
    NEXT24HOURS("/next24hours");

    private final String command;

    CommandType(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
