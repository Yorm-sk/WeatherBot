package weather_bot.enums;

public enum SupportedLanguages {
    RU("ru"), EN("en");

    private final String text;

    SupportedLanguages(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
